package th.priisoft.crm.common.utils;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import sun.misc.BASE64Encoder;
import th.priisoft.crm.common.constant.Constants;



public class AesUtil {
	    private final int iterationCount;
	    private final Cipher cipher;
        public static final String AC_SECURE_SALT = "cbdac8403eefcc584d1b234dae5f9ccc";
        public static final String AC_SECURE_IV = "ee32877e2742e4f570133a66df926727";
        private static AesUtil instance;
        private static int keySize;
        
        public static AesUtil getACInstance(){
    		if (instance == null){
    			instance = new AesUtil(128, 1000);
    		}
    		return instance;
    	}
        
        public String acEncrypt(String key, String data) {
        	return  encrypt(AC_SECURE_SALT, AC_SECURE_IV, key, data);
        }
        
        public String acDecrypt(String key, String data) {
        	return  decrypt(AC_SECURE_SALT, AC_SECURE_IV, key, data);
        }
        
	    public String encrypt(String salt, String iv, String passphrase, String data) {
	        try {
	            SecretKey key = generateKey(salt, passphrase); 
	        	Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	    		cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(hex(iv)));
	    		
	    		byte[] output = cipher.doFinal(data.getBytes(Constants.ENCODE_UTF8));
	    		BASE64Encoder b64 = new BASE64Encoder();
	    		String cipherText = b64.encode(output);
	            
	    		return cipherText;
	        }
	        catch (UnsupportedEncodingException e) {
	        	e.printStackTrace();
	            return null;
	        }catch (Exception e){
	        	e.printStackTrace();
	            return null;
	        }
	    }
	    
	    public AesUtil(int keySize, int iterationCount) {
	        this.keySize = keySize;
	        this.iterationCount = iterationCount;
	        try {
	            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        }
	        catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
	            throw fail(e);
	        }
	    }
	    
	    public String decrypt(String salt, String iv, String passphrase, String ciphertext) {
	        try {
	            SecretKey key = generateKey(salt, passphrase);
	            byte[] decrypted = doFinal(Cipher.DECRYPT_MODE, key, iv, base64(ciphertext));
	            return new String(decrypted, "UTF-8");
	        }
	        catch (UnsupportedEncodingException e) {
	            return null;
	        }catch (Exception e){
	            return null;
	        }
	    }
	    
	    private byte[] doFinal(int encryptMode, SecretKey key, String iv, byte[] bytes) {
	        try {
	            cipher.init(encryptMode, key, new IvParameterSpec(hex(iv)));
	            return cipher.doFinal(bytes);
	        }
	        catch (InvalidKeyException
	                | InvalidAlgorithmParameterException
	                | IllegalBlockSizeException
	                | BadPaddingException e) {
	            return null;
	        }
	    }
	    
	    private SecretKey generateKey(String salt, String passphrase) {
	        try {
	            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	            KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), hex(salt), iterationCount, keySize);
	            SecretKey key = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
	            return key;
	        }
	        catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
	            return null;
	        }
	    }

	    public static byte[] base64(String str) {
	        return Base64.decodeBase64(str);
	    }
	    
	    public static byte[] hex(String str) {
	        try {
	            return Hex.decodeHex(str.toCharArray());
	        }
	        catch (DecoderException e) {
	            throw new IllegalStateException(e);
	        }
	    }
	    public static String decodehex(byte[] str) {
	        return Hex.encodeHexString(str);
	    }
	    
	    private IllegalStateException fail(Exception e) {
	        return null;
	    }

}

