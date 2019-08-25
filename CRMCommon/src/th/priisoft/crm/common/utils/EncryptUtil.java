package th.priisoft.crm.common.utils;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.util.ArrayList;
import java.util.Formatter;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import th.priisoft.crm.common.constant.Constants;

public class EncryptUtil implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private static EncryptUtil instance;
	
	private static String IV = "2520671908164181";
	
	public static EncryptUtil getInstance(){
		if (instance == null){
			instance = new EncryptUtil();
		}
		return instance;
	}
	
	private byte[] calculateHMAC(String data, String key, String algo)
			throws IllegalStateException, UnsupportedEncodingException,
			NoSuchAlgorithmException, InvalidKeyException {
		byte[] b = null;
		
		SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(Constants.ENCODE_UTF8), algo);
		Mac mac = Mac.getInstance(algo);
		mac.init(keySpec);
		
		b = mac.doFinal(data.getBytes(Constants.ENCODE_UTF8));
		
		return b;
	}
	
	public String calculateHMacSha256Base64(String data, String key) throws InvalidKeyException, IllegalStateException, UnsupportedEncodingException, NoSuchAlgorithmException{
		return toBase64(calculateHMAC(data, key, Constants.Encryption.HMAC_SHA256_ALGORITHM));
	}
	public String calculateHMacSha512Base64(String data, String key) throws InvalidKeyException, IllegalStateException, UnsupportedEncodingException, NoSuchAlgorithmException{
		return toBase64(calculateHMAC(data, key, Constants.Encryption.HMAC_SHA512_ALGORITHM));
	}
	public String calculateHMacSha256Hex(String data, String key) throws InvalidKeyException, IllegalStateException, UnsupportedEncodingException, NoSuchAlgorithmException{
		return toHexString(calculateHMAC(data, key, Constants.Encryption.HMAC_SHA256_ALGORITHM));
	}
	public String calculateHMacSha512Hex(String data, String key) throws InvalidKeyException, IllegalStateException, UnsupportedEncodingException, NoSuchAlgorithmException{
		return toHexString(calculateHMAC(data, key, Constants.Encryption.HMAC_SHA512_ALGORITHM));
	}
	
	public String calculateRFC2104HMAC(String data, String key)
			throws SignatureException, NoSuchAlgorithmException,
			InvalidKeyException, IllegalStateException,
			UnsupportedEncodingException {
		SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(),Constants.Encryption.HMAC_SHA1_ALGORITHM);
		Mac mac = Mac.getInstance(Constants.Encryption.HMAC_SHA1_ALGORITHM);
		mac.init(signingKey);

		return toHexString(mac.doFinal(data.getBytes(Constants.ENCODE_UTF8)));
	}
	
	public String deCryptRSA(String cipherData, String strModulus, String strPriExpo) 
			throws NoSuchAlgorithmException, InvalidKeySpecException, 
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, 
			BadPaddingException, IOException{
		
		System.out.println("modulus  : " + strModulus.length());
		System.out.println("exponent : " + strPriExpo.length());
		
		byte[] modulusBytes = fromBase64(strModulus);
		byte[] exponentBytes = fromBase64(strPriExpo);
		BigInteger modulus = new BigInteger(1,modulusBytes);
		BigInteger exponent = new BigInteger(1,exponentBytes);
		
		RSAPrivateKeySpec rsaPrivateKey = new RSAPrivateKeySpec(modulus, exponent);
		
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PrivateKey priKey = kf.generatePrivate(rsaPrivateKey);
		
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE, priKey);
		
		byte[] data = cipher.doFinal(fromBase64(cipherData));
		String planData = new String(data,Constants.ENCODE_UTF8);
		System.out.println("plan data : " + planData);
		
		return planData;
	}
	
	public String enCryptAES(String key, String data, String salt) throws GeneralSecurityException, UnsupportedEncodingException {
		SecretKeyFactory factory = SecretKeyFactory.getInstance(Constants.Encryption.PBKDF_HMAC_SHA1_ALGORITHM);
		KeySpec spec = new PBEKeySpec(key.toCharArray(), salt.getBytes(Constants.ENCODE_UTF8), 1000, 256);
		SecretKey tmp = factory.generateSecret(spec);
		SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
		
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secret, new IvParameterSpec(IV.getBytes(Constants.ENCODE_UTF8)));
		
		byte[] output = cipher.doFinal(data.getBytes(Constants.ENCODE_UTF8));
		String cipherText = toBase64(output);
		
		System.out.println("cipher : " + cipherText);
		System.out.println("cipher len : " + cipherText.length());
		
		return cipherText;
	}
	
	public String deCryptAES(String key, String cipherText,String salt) throws GeneralSecurityException, IOException {
		SecretKeyFactory factory = SecretKeyFactory.getInstance(Constants.Encryption.PBKDF_HMAC_SHA1_ALGORITHM);
		KeySpec spec = new PBEKeySpec(key.toCharArray(), salt.getBytes(Constants.ENCODE_UTF8), 1000, 256);
		SecretKey tmp = factory.generateSecret(spec);
		SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
		
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] cipherByte = fromBase64(cipherText);
		cipher.init(Cipher.DECRYPT_MODE, secret,new IvParameterSpec(IV.getBytes(Constants.ENCODE_UTF8)));
		
		byte[] output = cipher.doFinal(cipherByte);
		String data = new String(output, Constants.ENCODE_UTF8);
		
		System.out.println("data : " + data);
		
		return data;
	}
	
	//order data
	public String x(String s1, String s2, String s3){
		StringBuffer sb = new StringBuffer();
		sb.append(s1);
		sb.append(s3);
		sb.append(s2);
		return sb.toString();
	}
	
	public String signMD5WithPrivateKey(String md5, String strPriKey)throws Exception{
		
    	byte[] priKByte = fromBase64(strPriKey);
		KeyFactory keyFac = KeyFactory.getInstance("RSA");
		KeySpec privateKeySpec = new PKCS8EncodedKeySpec(priKByte);
		PrivateKey pvKey = keyFac.generatePrivate(privateKeySpec);
		
		byte[] md5byte = md5.getBytes(Constants.ENCODE_UTF8);
    	
		Signature signer = Signature.getInstance("SHA256withRSA");
    	signer.initSign(pvKey);
		signer.update(md5byte);
		
		byte[] md5signByte = signer.sign();
		
		return toBase64(md5signByte);
    }
    
    public String createMD5String(String inputData)throws Exception{
    	MessageDigest md = MessageDigest.getInstance("MD5");
    	byte[] dataByte = inputData.getBytes(Constants.ENCODE_UTF8);
		md.reset();
		md.update(dataByte);
		
		byte[] mdByte = md.digest();
		
		return toHexString(mdByte);
    }
	
	public String toHexString(byte[] bytes) {
		Formatter formatter = new Formatter();
		for (byte b : bytes) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
 
		return result;
	}
	
	public String toBase64(byte[] bytes){
		BASE64Encoder b64 = new BASE64Encoder();
		return b64.encode(bytes);
	}
	public byte[] fromBase64(String input) throws IOException{
		BASE64Decoder b64 = new BASE64Decoder();
		return b64.decodeBuffer(input);
	}

	public static void main(String[] args) {
		
		String strModulus = "0m8RKIvhSmHBjyEiFywvkYnkpdbCKgVqaf9reE09NOijP3+iXk5NSjY82S9+i0Pzq51QcpXGnx1N2VtoqKM1LstorOuWQj1w4K0fpXFJShJC7DGIdhwhOXupScTlfszW7fB59BvCG6ahoaUNwqKxdfH8MJKUbxnEyij5rnrCHx3vrmogdP+tK3GqLJNV3zoAQD2ovbVdkhDnWHUXnP8biwD6rKWC+wAc2nbjIZkkrrLAdQCmUmoWwDboSX1S1OTZCVNqnrljTOx64vfYwzqi1F4eVeVP7AXDQyFIqHb4tSFMYaUCKPsfxfeyIX8j797AbVwlSs7npl0+NjXVGdf7Ow==";
		String strPrivateExponent = "BShlwkRTcaWdv0AE/DkVXWWE2NpqXen4vBUKRvjrBCNORQiAK/w9Vrv87Scwhyyo3072zCgxpcVrxWUWgUj8ImPSnVJqQhYMGzsDEzoInYEpv2z4tvRk4r943G8FX6tDpVyx5d18T33bvlYzqnlJt5CxKWZJBG7G7Qbov8cQf6oKdDkoFMOWSXo6u586pcMUfH6ThNXm+5lIn2KnUir6b1bF6X/knsZRED0f09uCy4Cl+PxUCX/wiS1iFzHyUeIjdcUZTOaEKLunQ1uaXz9ngDZYjJiUTemLcHOFD0AV+yK4O3DsYBwSr8edKwXpFHgTQ6xjbkkI3GftDDZQZmd68Q==";
		String cipherData = "vJ+tc+4x6F4miKJB69PoOcvM6Rirf0zrRX1b4re10NYVlHXu53AvHy3JVjbn4ztplJBvAPcgijG28ha74g1RAP3F06NADkj29iTXI4kBs/Qx+j2fxAzKVrqwEIff/IUi4893M523/NHqAYbmmErCstYjC4p48EOLkQO+8Alx9oVjGD38r/3LCpcWuMCDgCe9VjNFDyQ7/6lpeochqfW0GzVptYlP8/jmvbEZRz1MfGscxbCVT0iYxnTF/prOCMtKVEduWOuAup8rkQeYTlpPn5qlSSB3GY8javfa9z+2rt15xoSy3FyN1kWsc4QAOfvV6ir+JStOti6wWS2mlEXZLw==";
		
		try {
			
			String data = "{\"data\":[300038,300039,300040,300041,300042,300043,300044]}";
			String md5 = EncryptUtil.getInstance().createMD5String(data);
			String priKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC9qAxJWYqyQPHYWtuHRrW5P58hlsED8PaL4Mc9p3jUdPucb3yzien58889u3r6z04tOQYEYriZVOliY1g5vDc0pvcDO4ywQ6NKm1wAYA4NUSZJvym1d31ym46086geaIHAcQkEQB5zAr0ihZLiKpJDnLK5UdRA8XJg1cFuTBczNhfYMy1pt+zay9pS8i/F8hKPUj4U2LLA9/AzIitHFLnO+AdLa8X+/YOsKmqxRUqMJqD8AKY/4pdZA/HpDY2MV7Py8tKaDy7KuSRGGWZ1UNoqlDNcf3HQ59zyxPZ3PbUjImvby+gLjKFjIFOqFS6yxbxuhjAcl6N6sw9iUkWXsOcfAgMBAAECggEALUfU/yI4wgxNcYlnxml0c7Ej7iIPHUDHrGfTSf4VFCyF8jiP/lGcIkg6n5OGbiFWmed2b0+eoUUrn4j2hHpSd+ixKv1pvp+3edWT5qcIU9efG5Zff+rycY2ASeWuquvqpqaWL4SbgHwT6g0YH5VobGoaJbLKyWKcG1CNqSbTly8WsuA40X7Nmq+eP5PR6l0iIUhBmZTZzM8nuTXFlEYxchRaUIVXiR/MGeACwCRBOlxQ/GRnc1GYKMdJa4GEP2UCdkq/SIDQL9QMUAGMvM1NZt0QIRdcY+HTKasHUggID75b6B1Cqwx517vbp8PH0RKOz8hU6oKmTAujW9w5q2gRIQKBgQDnsHpQOisLw1YwN++EnuN15mdKmVx39y9BqT9wcxSVDG8dSnLQTSmq9yWwUnKsQLvOqUNC888ptkwjaHghyIyAIpjlZv4Nh0442TrE2ehkMOfYuFqB0Qo3MsSBW7guHC9juB0FB9TDN1lYxDX3pZMvixjhty+aHj1WgdFSOYTMEQKBgQDRjoDEa3yZNb15TCyLaMc8wuzmZXCO2z3mPeGBlJKk7V8B2AKgzmvJfyw2kGFHpznhWOr423Zv3vfXGF2JMxwLVPhGYQX14UOnullvCTvPqEzCJjNAFbbN0UQqHlYCVZjltjN7vPuOzLGnB/fPqX4rLQee/pFFxscQbyD3PJ9sJohwLwKBgQDVFj94V/dNK0uyr09QBx4mSlEHkEM2ZpYE6tdY4c61QqlTJCyynbVL82CraTjkaekRKiWdh0UqFOqzyhpq39sw4iEDI5VW9fGgYVImyE9vDne9n9hF+u9NUxjd7HBZoDyJl0TBYrFxFg/LjzIfYR4cpO6ucd+K/HLnhB/zYslbMQKBgHWIHFaOBpsTlgpzG8Sw5pYAqcfq+v9UndoFuPXpc3oHHDM3iPnR7IhdyFluDvGWLBNkwJ0E0d+ayZydMNDjloYQiRNIFYS7bC++2Qn11d9Kd5Io25eCGF4bF5hFk/S6hROQgfKsgbMx995DrNzga5bUJnxhKYLhITcpjCynS/zHAoGBAJJZSwtwRmxpRtxRxgC4DPG1q7yqvmEaPzpXUyV2R/2cV7ogHIJJD/AqJL2bl/O9uEyEKfuekE/IkBs9wDEl0ToJGOhtxVTWrkGdpPOpvYLbmq6ju4Zn/HlEojCJ8GwqLiZ0zBq9lzvKuliroBOnVSZmZojpiG5UOy0CaTKfkSMN";
			                      
			String PriKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC9qAxJWYqyQPHYWtuHRrW5P58hlsED8PaL4Mc9p3jUdPucb3yzien58889u3r6z04tOQYEYriZVOliY1g5vDc0pvcDO4ywQ6NKm1wAYA4NUSZJvym1d31ym46086geaIHAcQkEQB5zAr0ihZLiKpJDnLK5UdRA8XJg1cFuTBczNhfYMy1pt+zay9pS8i/F8hKPUj4U2LLA9/AzIitHFLnO+AdLa8X+/YOsKmqxRUqMJqD8AKY/4pdZA/HpDY2MV7Py8tKaDy7KuSRGGWZ1UNoqlDNcf3HQ59zyxPZ3PbUjImvby+gLjKFjIFOqFS6yxbxuhjAcl6N6sw9iUkWXsOcfAgMBAAECggEALUfU/yI4wgxNcYlnxml0c7Ej7iIPHUDHrGfTSf4VFCyF8jiP/lGcIkg6n5OGbiFWmed2b0+eoUUrn4j2hHpSd+ixKv1pvp+3edWT5qcIU9efG5Zff+rycY2ASeWuquvqpqaWL4SbgHwT6g0YH5VobGoaJbLKyWKcG1CNqSbTly8WsuA40X7Nmq+eP5PR6l0iIUhBmZTZzM8nuTXFlEYxchRaUIVXiR/MGeACwCRBOlxQ/GRnc1GYKMdJa4GEP2UCdkq/SIDQL9QMUAGMvM1NZt0QIRdcY+HTKasHUggID75b6B1Cqwx517vbp8PH0RKOz8hU6oKmTAujW9w5q2gRIQKBgQDnsHpQOisLw1YwN++EnuN15mdKmVx39y9BqT9wcxSVDG8dSnLQTSmq9yWwUnKsQLvOqUNC888ptkwjaHghyIyAIpjlZv4Nh0442TrE2ehkMOfYuFqB0Qo3MsSBW7guHC9juB0FB9TDN1lYxDX3pZMvixjhty+aHj1WgdFSOYTMEQKBgQDRjoDEa3yZNb15TCyLaMc8wuzmZXCO2z3mPeGBlJKk7V8B2AKgzmvJfyw2kGFHpznhWOr423Zv3vfXGF2JMxwLVPhGYQX14UOvCTvPqEzCJjNAFbbN0UQqHlYCVZjltjN7vPuOzLGnB/fPqX4rLQee/pFFxscQbyD3PJ9sJohwLwKBgQDVFj94V/dNK0uyr09QBx4mSlEHkEM2ZpYE6tdY4c61QqlTJCyynbVL82CraTjkaekRKiWdh0UqFOqzyhpq39sw4iEDI5VW9fGgYVImyE9vDne9n9hF+u9NUxjd7HBZoDyJl0TBYrFxFg/LjzIfYR4cpO6ucd+K/HLnhB/zYslbMQKBgHWIHFaOBpsTlgpzG8Sw5pYAqcfq+v9UndoFuPXpc3oHHDM3iPnR7IhdyFluDvGWLBNkwJ0E0d+ayZydMNDjloYQiRNIFYS7bC++2Qn11d9Kd5Io25eCGF4bF5hFk/S6hROQgfKsgbMx995DrNzga5bUJnxhKYLhITcpjCynS/zHAoGBAJJZSwtwRmxpRtxRxgC4DPG1q7yqvmEaPzpXUyV2R/2cV7ogHIJJD/AqJL2bl/O9uEyEKfuekE/IkBs9wDEl0ToJGOhtxVTWrkGdpPOpvYLbmq6ju4Zn/HlEojCJ8GwqLiZ0zBq9lzvKuliroBOnVSZmZojpiG5UOy0CaTKfkSMN";
			String signData = EncryptUtil.getInstance().signMD5WithPrivateKey(md5, priKey);
			
			System.out.println("sign -> " + signData);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public byte[] removeEncrypt(byte[] decrypt) {
		int ind=0;
		ArrayList<Byte> newb = new ArrayList<Byte>();
	   for(byte b:decrypt) {
		   ind++;
		   if(ind >=decrypt.length-2) {
			   break;
			}else if(ind%2!=0) {
			   newb.add(b);
		   }
	   }
	   
	   Byte[] tmp = newb.toArray(new Byte[newb.size()]);
	   byte[] b = new byte[tmp.length];
	    for (int i = 0; i < tmp.length; i++) {
	        b[i] = tmp[i];
	    }
	 
	   return b;
	}
	
	public byte[] addEncrypt(byte[] decrypt) {
		int ind=0;
		ArrayList<Byte> newb = new ArrayList<Byte>();
	   for(byte b:decrypt) {
		   ind++;
		   newb.add(b);
		   byte[] a = new byte[] {0};
		   newb.add(a[0]);
	   }
	   
	   Byte[] tmp = newb.toArray(new Byte[newb.size()]);
	   byte[] b = new byte[tmp.length];
	    for (int i = 0; i < tmp.length; i++) {
	        b[i] = tmp[i];
	    }
	 
	   return b;
	}
	
    public byte[] decrypt(String ciphertext,String passport) {
        try {
        	
        	SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");            
        	PBEKeySpec pbeKeySpec = new PBEKeySpec(passport.toCharArray(), 
        			new byte[] { 0x49, 0x76, 0x61, 0x6e, 0x20, 0x4d, 0x65, 0x64, 0x76, 0x65, 0x64, 0x65, 0x76 },1000,384);
        	PBEKeySpec pbeKeySpec2 = new PBEKeySpec(passport.toCharArray(), 
        			new byte[] { 0x49, 0x76, 0x61, 0x6e, 0x20, 0x4d, 0x65, 0x64, 0x76, 0x65, 0x64, 0x65, 0x76 },1000,384);
            Key secretKey = factory.generateSecret(pbeKeySpec);
            Key secretKey2 = factory.generateSecret(pbeKeySpec2);
            byte[] key = new byte[32];
            byte[] iv = new byte[16];
            System.arraycopy(secretKey.getEncoded(), 0, key, 0, 32);
            System.arraycopy(secretKey2.getEncoded(),0, iv, 0, 16);
            SecretKeySpec secret = new SecretKeySpec(key,"AES");
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, secret,ivSpec);
            byte[] result = cipher.doFinal(base64(ciphertext));
    		return result;
        }catch (Exception e){
        	e.printStackTrace();
            return null;
        }
    }
    
    public String Encrypt(String ciphertext,String passport) {
        try {
        	SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");            
        	PBEKeySpec pbeKeySpec = new PBEKeySpec(passport.toCharArray(), 
        			new byte[] { 0x49, 0x76, 0x61, 0x6e, 0x20, 0x4d, 0x65, 0x64, 0x76, 0x65, 0x64, 0x65, 0x76 },1000,384);

            Key secretKey = factory.generateSecret(pbeKeySpec);
            byte[] key = new byte[32];
            byte[] iv = new byte[16];
            System.arraycopy(secretKey.getEncoded(), 0, key, 0, 32);
            System.arraycopy(secretKey.getEncoded(),0, iv, 0, 16);
           
            SecretKeySpec secret = new SecretKeySpec(key, "AES");
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secret, ivSpec);
            byte[] output = cipher.doFinal(ciphertext.getBytes("UTF-8"));
    		BASE64Encoder b64 = new BASE64Encoder();
    		String cipherText = b64.encode(output);
    		return cipherText;
        }catch (Exception e){
        	e.printStackTrace();
            return null;
        }
    }
    public String encryptGn(String ciphertext,String passport) {
        try {
        	SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");            
        	PBEKeySpec pbeKeySpec = new PBEKeySpec(passport.toCharArray(), 
        			new byte[] { 0x49, 0x76, 0x61, 0x6e, 0x20, 0x4d, 0x65, 0x64, 0x76, 0x65, 0x64, 0x65, 0x76 },1000,384);

            Key secretKey = factory.generateSecret(pbeKeySpec);
            byte[] key = new byte[32];
            byte[] iv = new byte[16];
            System.arraycopy(secretKey.getEncoded(), 0, key, 0, 32);
            System.arraycopy(secretKey.getEncoded(),0, iv, 0, 16);
           
            SecretKeySpec secret = new SecretKeySpec(key, "AES");
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secret, ivSpec);
            byte[] output = cipher.doFinal(addEncrypt(ciphertext.getBytes("UTF-8")));
    		BASE64Encoder b64 = new BASE64Encoder();
    		String cipherText = b64.encode(output);
    		return cipherText;
        }catch (Exception e){
        	e.printStackTrace();
            return null;
        }
    }
    
    public String decryptGn(String ciphertext,String passport) {
        try {
        	
        	SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");            
        	PBEKeySpec pbeKeySpec = new PBEKeySpec(passport.toCharArray(), 
        			new byte[] { 0x49, 0x76, 0x61, 0x6e, 0x20, 0x4d, 0x65, 0x64, 0x76, 0x65, 0x64, 0x65, 0x76 },1000,384);
        	PBEKeySpec pbeKeySpec2 = new PBEKeySpec(passport.toCharArray(), 
        			new byte[] { 0x49, 0x76, 0x61, 0x6e, 0x20, 0x4d, 0x65, 0x64, 0x76, 0x65, 0x64, 0x65, 0x76 },1000,384);
            Key secretKey = factory.generateSecret(pbeKeySpec);
            Key secretKey2 = factory.generateSecret(pbeKeySpec2);
            byte[] key = new byte[32];
            byte[] iv = new byte[16];
            System.arraycopy(secretKey.getEncoded(), 0, key, 0, 32);
            System.arraycopy(secretKey2.getEncoded(),0, iv, 0, 16);
            SecretKeySpec secret = new SecretKeySpec(key,"AES");
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, secret,ivSpec);
            byte[] result = cipher.doFinal(base64(ciphertext));
    		return new String(removeEncrypt(result),"UTF-8");
        }catch (Exception e){
        	e.printStackTrace();
            return null;
        }
    }
    
    private byte[] doFinal(int encryptMode, Key secretKey, String iv, byte[] bytes) throws NoSuchAlgorithmException, NoSuchPaddingException {
        try {
        	Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(encryptMode, secretKey, new IvParameterSpec(hex(iv)));
            return cipher.doFinal(bytes);
        }
        catch (InvalidKeyException
                | InvalidAlgorithmParameterException
                | IllegalBlockSizeException
                | BadPaddingException e) {
        	e.printStackTrace();
            return null;
        }
    }
    public String decodehex(byte[] str) {
        return Hex.encodeHexString(str);
    }
    
    
    public byte[] hex(String str) {
        try {
            return Hex.decodeHex(str.toCharArray());
        }
        catch (DecoderException e) {
            throw new IllegalStateException(e);
        }
    }
    public byte[] base64(String str) {
        return Base64.decodeBase64(str);
    }
    

}
