package th.priisoft.crm.common.string;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Vector;

public class StringFunctionHelper  implements Serializable {
	private static final long serialVersionUID = 5112207407443997013L;
	private static final StringFunctionHelper me=new StringFunctionHelper();
	private static int SCALE = 2;
	private static int ROUNDING_MODE = BigDecimal.ROUND_UP;
	
	private StringFunctionHelper() {
	}
	
	public static StringFunctionHelper getInstance() {
		return me;
	}

	public String escQuote(String str) {
		if (str == null)
			return null;
		StringBuffer stb = new StringBuffer(str.length() + 5);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '"')
				stb.append("\"");
			if (str.charAt(i) == '\\')
				stb.append("\\");
			stb.append(str.charAt(i));
		}
		return stb.toString();
	}

	public void fill(StringBuffer stb, char fChar) {
		if (stb == null)
			return;
		stb.setLength(stb.capacity());
		for (int i = 0; i < stb.capacity(); i++) {
			stb.setCharAt(i, fChar);
		}
	}

	public int getTokenIndex(String arg, String table) {
		return getTokenIndex(arg, table, ',');
	}

	public int getTokenIndex(String arg, String table, char separator) {
		if (arg == null || table == null)
			throw new RuntimeException("table and/or argument cannot be null");
		StringTokenizer stk = new StringTokenizer(table, "" + separator);
		int ii = 0;
		while (stk.hasMoreTokens()) {
			String str = stk.nextToken();
			if (str.equals(arg))
				return ii;
			ii++;
		}
		return -1;
	}

	public String getToken(String source, int ind) {
		return getToken(source, ind, ',');
	}
	
	public int getTokenCount(String source) {
		return getTokenCount(source,',');
	}
	
	public int getTokenCount(String source, char separator) {
		StringTokenizer stk=new StringTokenizer(source,""+separator);
		return stk.countTokens();
	}

	public String getToken(String source, int ind, char separator) {
		if (source == null || ind < 0)
			return null;
		int i, j;
		i = j = -1;
		int k = ind - 1;
		if (k < 0)
			return "";
		// look for start position
		while (k > 0) {
			i = source.indexOf(separator, i + 1);
			if (i < 0 && k > 0)
				return "";
			k--;
		}
		i++;
		// look for end position
		if (i > source.length())
			return null;
		j = source.indexOf(separator, i);
		if (j == 0 && i == 0)
			return null;
		return (j >= 0) ? source.substring(i, j) : source.substring(i);
	}

	public int getArrayPosition(String[] arr, String key) {
		for (int i=0; i<arr.length; i++) 
			if (arr[i].equals(key)) return i;
		return -1;
	}

	public boolean isThai(String str) {
		if (str == null)
			return false;
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) > 0xe00 && str.charAt(i) < 0xe60)
				return true;
		return false;
	}

	public String replaceString(
		String oldString,
		String strFind,
		String strRepl) {
		StringTokenizer stk = new StringTokenizer(oldString, strFind);
		int cnt = stk.countTokens();
		String stmp = (cnt == 0) ? oldString : "";
		StringBuffer buf = new StringBuffer(); 	// Already FindBugs by Kaita D. - 20/07/2010
		buf.append(stmp);
		for (int i = 0; i < cnt; i++) {
			if (i + 1 == cnt)
				buf.append(stk.nextToken());
			else
				buf.append(stk.nextToken() + strRepl);
		}
		return buf.toString();
	}

	public String replaceString(String inDoc, Map<String, String> varTable) {
		return replaceString(inDoc,varTable,true);
	}
	
	public String addBack(String str, int len, String ch) {
	    int count = len - str.length();
	    StringBuffer buf = new StringBuffer();		
	    buf.append(checkNull(str));
	    for (int i = 0; i < count; i++) {
	    	buf.append(ch);
	    }

	    return buf.toString();
	  }

	  public String addFront(int n, int len, String ch) {
	    String str = Integer.toString(n);
	    str = addFront(str ,len ,ch);
	    return str;
	  }


	  public String addFront(String str, int len, String ch) {
	    int count = len - str.length();
	    str = checkNull(str);
	    for (int i = 0; i < count; i++) {
	      str = ch + str;
	    }
	    return str;
	  }
	
	  public String addFrontChar(String str, int count) {
		    String charKeyUp [] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R",
		    		             "S","T","U","V","W","X","Y","Z"};
		    String charKeyLow [] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s",
		                         "t","u","v","w","x","y","z"};
		   
		    str = checkNull(str);
		    int checkNo = 0;
		    try{
		    	checkNo = Integer.parseInt(str.substring(3));
		    }catch(Exception e){
		    	checkNo = 999;
		    }
		    
		    if(checkNo == 9){
		    	if(!str.substring(2,3).equals("Z")){
			    	for(int i = 0 ; i < charKeyUp.length ; i ++){
			    		if(str.substring(2,3).equals(charKeyUp[i])){
			    			str = str.substring(0,2) + charKeyUp[i+1] + "0";
			    			break;
			    		}
			    	}
		    	}else {
		    		str = str.substring(0,2) + "Aa";
		    	}
		    }else if(checkNo != 9 && checkNo != 999){
		    	if(count > 0 && checkNo != 9){
		    		str = 	str.substring(0,3) + (checkNo + 1);	
		    	}
		    }else if (checkNo == 999){
		       if(str.substring(3).equals("z")){
			    	for(int i = 0 ; i < charKeyUp.length ; i ++){
			    		if(str.substring(2,3).equals(charKeyUp[i])){
			    			str = str.substring(0,2) + charKeyUp[i+1] + "a";
			    			break;
			    		}
			    	}
		       }else{
		    	   for(int i = 0 ; i < charKeyLow.length ; i ++){
			    		if(str.substring(3).equals(charKeyLow[i])){
			    			str = str.substring(0,3) + charKeyLow[i+1];
			    			break;
			    		}
			       }
		       }
		    }
		    return str;
	  }
	  public String UnicodeToMS874(String value) {
		    StringBuffer strTemp = new StringBuffer(value);
		    for (int i = 0; i < value.length(); i++) {
		      int code = strTemp.charAt(i);
		      if (3585 <= code && code <= 3675) {
		        strTemp.setCharAt(i, (char) (code - 3424));
		      }
		    }
		    return strTemp.toString();
		  }
	  
	  public String MS874ToUnicode(String value) {
		    StringBuffer strTemp = new StringBuffer(value);
		    for (int i = 0; i < value.length(); i++) {
		      int code = strTemp.charAt(i);
		      if (161 <= code && code <= 251) {
		        strTemp.setCharAt(i, (char) (code + 3424));
		      }
		    }
		    return strTemp.toString();
		 // return value;
		  }
	  

	public String replaceString(String inDoc, Map<String, String> varTable,boolean forceSpace) {
		if (inDoc == null || varTable == null)
			throw new RuntimeException("table and/or argument cannot be null");
		int i, j, k;
		i = j = k = 0;

		// Locate and stripped out variable labels
		int docLng = inDoc.length();
		StringBuffer stb = new StringBuffer();
		while (true) {
			i = inDoc.indexOf("${", i);
			if (i < 0)
				break; // no more variable to replaced
			if (docLng < i + 2)
				throw new RuntimeException("Closing '}' not found");
			j = inDoc.indexOf("}", i + 2);
			if (j < 0)
				throw new RuntimeException("Closing '}' not found");
			if (j - i <= 2)
				throw new RuntimeException("Variable label cannot be empty");
			if (k < i) {
				stb.append(inDoc.substring(k, i));
				k = j + 1;
			}
			String key = inDoc.substring(i + 2, j);
			String val = (String) varTable.get(key);
			if (val == null && forceSpace)
				val = "";
			else if(val ==null && !forceSpace)
				val = "${" + key + "}";
			stb.append(val);
			i = j + 1;
			k = i;
		}

		if (k < docLng)
			stb.append(inDoc.substring(k));
		return new String(stb);
	}

	public String removeCharacters(String str, String charString) {
		StringBuffer stb=new StringBuffer(str);
		for (int i=0; i<stb.length(); i++) {
			if (charString.indexOf(stb.charAt(i))>=0)
				stb.deleteCharAt(i);
		}
		return stb.toString();
	}

	private static final String whiteSpaces="\t\r\n\f ";
	public String deblank(String str) {
		if (str==null) return null;
		StringBuffer stb=new StringBuffer();
		boolean deleted=false;
		for (int i=0; i<str.length(); i++) {
			if (whiteSpaces.indexOf(str.charAt(i))>=0) deleted=true;
			else {
				if (deleted) stb.append(' ');
				stb.append(str.charAt(i));
				deleted=false;
			}
		}
		return stb.toString(); 
	}
	
	public String changeToCsvStringWithEnclosingMark(Set<String> set,char encMark) {
		StringBuffer stb=new StringBuffer();
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()) {
			String str=(String)iter.next();
			if (stb.length()>0) stb.append(',');
			if (encMark!=0) stb.append(encMark);
			stb.append(str);
			if (encMark!=0) stb.append(encMark);
		}
		return stb.toString();
	}

	public String changeToCsvStringWithEnclosingMark(String str,char encMark) {
		StringBuffer stb=new StringBuffer();
		StringTokenizer stk=new StringTokenizer(str,",");
		while(stk.hasMoreTokens()) {
			String token=(String)stk.nextToken();
			if (stb.length()>0) stb.append(',');
			if (encMark!=0) stb.append(encMark);
			stb.append(token);
			if (encMark!=0) stb.append(encMark);
		}
		return stb.toString();
	}

	public String changeToCsvStringWithEnclosingMark(String[] str,char encMark) {
		StringBuffer stb=new StringBuffer();
		for (int i=0; i<str.length; i++) {
			String token=str[i];
			if (stb.length()>0) stb.append(',');
			if (encMark!=0) stb.append(encMark);
			stb.append(token);
			if (encMark!=0) stb.append(encMark);
		}
		return stb.toString();
	}

	@SuppressWarnings("unchecked")
	public String convToStr(Object val) {
		if(val instanceof String[]) {
			String[] str=(String[])val;
			StringBuffer stb=new StringBuffer();
			for (int i=0; i<str.length; i++) {
				String token=str[i];
				if (stb.length()>0) stb.append(',');
				stb.append(token);
			}			
			return stb.toString();
		}
		else if(val instanceof java.util.HashSet) {
			HashSet<String> set=(HashSet<String>)val;
			StringBuffer stb=new StringBuffer();
			Iterator<String> iter=set.iterator();
			while(iter.hasNext()) {
				String str=(String)iter.next();
				if (stb.length()>0) stb.append(',');
				stb.append(str);
			}			
			return stb.toString();
		}
		else 
			return val.toString();
	}

	public String[] sortKeys(String[] str) {
		String temp=null;
		String[] tstr=new String[str.length];
		System.arraycopy(str,0,tstr,0,tstr.length);
		for (int i=0; i<tstr.length-1; i++) {
			for (int j=i+1; j<tstr.length; j++) {
				if (tstr[i].compareTo(tstr[j])>0) {
					temp=tstr[i];
					tstr[i]=tstr[j];
					tstr[j]=temp;
				}
			}
		}
		return tstr;
	}

	public Set<String> changeArrayToSet(String[] str) {
		if (str==null) return null;
		HashSet<String> set=new HashSet<String>();
		for (int i=0; i<str.length; i++) set.add(str[i]);
		return set;
	}
		
	public String[] changeSetToArray(Set<String> set) {
		if (set==null) return null;
		Object[] obj=set.toArray();
		String[] str=new String[obj.length];
		for (int i=0; i<str.length; i++) str[i]=(String)obj[i];
		return str;
	}
		
	public String[] changeCsvToArray(String str) {
		StringTokenizer stk=new StringTokenizer(str,",");
		String[] strarr=new String[stk.countTokens()];
		for (int i=0; i<strarr.length; i++) strarr[i]=stk.nextToken();
		return strarr;
	}
	
	// Convert String in the form of <key0>=<val0>,..,<keyn>=<valn> to Properties
	public Properties convertToMap(String instr) {
		Properties map=new Properties();
		if (instr!=null && instr.trim().length()>1) {
			StringTokenizer stk=new StringTokenizer(instr,",");
			while(stk.hasMoreTokens()) {
				String token=stk.nextToken();
				if (token.length()!=0) {
					int i=token.indexOf('=');
					if (i<0) continue;
					String key=token.substring(0,i);
					String val=token.substring(i+1);
					map.put(key,val);
				}
			}
		}
		return map;
	}
	
	public Vector<String> tokenize(String str) {
		return tokenize(str,',');
	}
	
	public Vector<String> tokenize(String str,char del) {
		boolean escape=false;
		boolean qouted=false;
		Vector<String> vec=new Vector<String>();
		StringBuffer stb=new StringBuffer();
		for (int i=0; i<str.length(); i++) {
			char ch=str.charAt(i);
			if (escape) stb.append(ch);
			else {
				if (ch=='\\') {
					escape=true;
					continue;
				} else if (ch==del && !qouted) {
					vec.addElement(stb.toString());
					stb.setLength(0);
				} else if (ch=='"') {
					qouted=(qouted)?false:true;
				} else stb.append(ch);
			}
			escape=false;
		}
		vec.addElement(stb.toString());
		return vec;
	}

	public Iterator<String> sortValues(Map<String,String> map) {
		SortedSet<String> sorted=new TreeSet<String>();
		Set<Map.Entry<String, String>> set = map.entrySet();		// Already FindBugs by Kaita D. - 20/07/2010
	    for (Map.Entry<String, String> me : set) {
			sorted.add(me.getValue()+"^"+me.getKey());
	    }
		return sorted.iterator();
	}

	public Iterator<String> sortKeys(Map<String,String> map) {
		SortedSet<String> sorted=new TreeSet<String>();
		Iterator<String> iter=map.keySet().iterator();
		while(iter.hasNext()) {
			String key=(String)iter.next();
			sorted.add(key);
		}
		return sorted.iterator();
	}
	
	public  Iterator<String> sortValuesThai(Map<String,String> map)  {
		SortedSet<String> sorted=new TreeSet<String>();
		String val = "", tval = "";
		Set<Map.Entry<String, String>> set = map.entrySet();		
	    for (Map.Entry<String, String> me : set) {
			val=me.getValue();
			if (val.startsWith("เ")) {
				tval = val.substring(1,val.length());				
			} else if (val.startsWith("แ")) {
				tval = val.substring(1,val.length());
			} else if (val.startsWith("โ")) {				
				tval = val.substring(1,val.length());
			} else if (val.startsWith("ใ")) {
				tval = val.substring(1,val.length());
			} else if (val.startsWith("ไ")) {
				tval = val.substring(1,val.length());
			} else
				tval = val;
			sorted.add(tval.trim()+"^"+val.trim()+"^"+me.getKey());
	    }
		return sorted.iterator();
	}  

  	// This is for pre-SDK 1.4 fill-in
	public String[] split(String string, String regex) {
		StringTokenizer stk=new StringTokenizer(string,regex);
		String[] res=new String[stk.countTokens()];
		for (int i=0; i<res.length; i++) {
			res[i]=stk.nextToken();
		}
		return res;
	}
	//Ex: "|"
	public String[] splitHasBlank(String string, String regex) {
		String txt= string;
		int idx = 0;
		List<String> res = new ArrayList<String>();
		while (true) {
			idx = txt.indexOf(regex);
			if (idx > -1) {
				res.add(txt.substring(0,idx));
				txt = txt.substring(idx+1);
			} else {
				res.add(txt);
				break;
			} 
		}
		Object[] obj = res.toArray();
		String[] str=new String[obj.length];
		for (int i=0; i<str.length; i++) str[i]=(String)obj[i];

		return str;
	}
	
	public String convert874(String in) throws UnsupportedEncodingException {
		 char[] ch=in.toCharArray();
		 byte[] by=new byte[ch.length];
		 for (int i=0; i<ch.length; i++) { 
			 by[i]=(byte)ch[i];
		 }
		 String out=new String(by,"CP874");
		 return out;
	}	
	
	public double cnvStringtoDouble(String amountSt) {
		double dou = 0;
		try {

			java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
			if ((amountSt != null) && (amountSt != "")) {
				amountSt = amountSt.trim();
				if (amountSt.length() > 0) {
					if (amountSt.substring(amountSt.length() - 1, amountSt.length()).equals("-")) {
						dou = nf.parse(amountSt.substring(0, amountSt.length() - 1)).doubleValue();
						dou = dou * -1;
					} else {
						if (amountSt.substring(0, 1).equals("-")) {
							dou = nf.parse(amountSt.substring(1, amountSt.length())).doubleValue();
							dou = dou * -1;
						} else {
							dou = nf.parse(amountSt).doubleValue();
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dou;
	}
	public String cnvDoubletoString(double number) {
		String numberCommaFormat = "0.00";
		if (String.valueOf(number).trim().length() > 0)	{
			String decFirst = "";
			String decLast  = "";
			BigDecimal format1 = new BigDecimal(number);
			NumberFormat format = NumberFormat.getInstance(Locale.ENGLISH);
			String commaFormat = format.format(format1.setScale(2,BigDecimal.ROUND_HALF_UP));
			int indx = commaFormat.indexOf(".");
			if (indx != -1) {
				decFirst = commaFormat.substring(0, indx);
				decLast = commaFormat.substring(indx+1);
				if (decLast.length() == 1) {
					decLast = decLast + "0";
				}
				numberCommaFormat = decFirst + "." + decLast;
				
			} else {
				numberCommaFormat = commaFormat + ".00";
			}
		} //if
		return numberCommaFormat;
	}
	
	public float cnvStringtoFloat(String amountSt) {
		float flo = 0;
		try {

			java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
			if ((amountSt != null) && (amountSt != "")) {
				amountSt = amountSt.trim();
				if (amountSt.length() > 0) {
					if (amountSt.substring(amountSt.length() - 1, amountSt.length()).equals("-")) {
						flo = nf.parse(amountSt.substring(0, amountSt.length() - 1)).floatValue();
						flo = flo * -1;
					} else {
						if (amountSt.substring(0, 1).equals("-")) {
							flo = nf.parse(amountSt.substring(1, amountSt.length())).floatValue();
							flo = flo * -1;
						} else {
							flo = nf.parse(amountSt).floatValue();
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flo;
	}
	public String cnvFloattoString(float number) {
		String numberCommaFormat = "0.00";
		if (String.valueOf(number).trim().length() > 0)	{
			String decFirst = "";
			String decLast  = "";
			BigDecimal format1 = new BigDecimal(number);
			NumberFormat format = NumberFormat.getInstance(Locale.ENGLISH);
			String commaFormat = format.format(format1.setScale(2,BigDecimal.ROUND_HALF_UP));
			int indx = commaFormat.indexOf(".");
			if (indx != -1) {
				decFirst = commaFormat.substring(0, indx);
				decLast = commaFormat.substring(indx+1);
				if (decLast.length() == 1) {
					decLast = decLast + "0";
				}
				numberCommaFormat = decFirst + "." + decLast;
				
			} else {
				numberCommaFormat = commaFormat + ".00";
			}
		} //if
		return numberCommaFormat;
	}
	public String prefixAmt(double amt, String pattern) {
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(amt);
	}
    public String convertToThaiLang(String content) {
        try{
                if(content!=null) {
                        if (!this.isThai(content) ) 
                                return new String(content.getBytes("ISO-8859-1"),"TIS620").trim();
                        else return  content.trim();    
                }
                else
                        return "";
        }catch (Exception e){
                System.out.println(e +"");
        }
        return content;
    }
    
    public String cnvRunningFormat(int running, String pattern){
        return prefixAmt(running, pattern);
    }
	public String cnvBigDecimalToString(BigDecimal number) {
		return cnvBigDecimaltoToPattern(number, false, 0, BigDecimal.ROUND_HALF_UP);
	}
	public String cnvBigDecimaltoToCurrency(BigDecimal number) {
		return cnvBigDecimaltoToPattern(number, true);
	}
	public String cnvBigDecimaltoToPattern(BigDecimal number, boolean hasDecLast ) {
		return cnvBigDecimaltoToPattern(number, hasDecLast, SCALE, ROUNDING_MODE);
	}
	public String cnvBigDecimaltoToPattern(BigDecimal number, boolean hasDecLast, int scale, int roundType) {
		String numberCommaFormat = "0.00";
		if (number != null && number.toString().length() > 0) {
			String decFirst = "";
			String decLast  = "";
			NumberFormat format = NumberFormat.getInstance(Locale.ENGLISH);
			String commaFormat = format.format(number.setScale(scale,roundType));
			if (hasDecLast) {
				int indx = commaFormat.indexOf(".");
				if (indx != -1) {
					decFirst = commaFormat.substring(0, indx);
					decLast = commaFormat.substring(indx+1);
					if (decLast.length() == 1) {
						decLast = decLast + "0";
					}
					numberCommaFormat = decFirst + "." + decLast;
				} else {
					numberCommaFormat = commaFormat + ".00";
				}
			} else numberCommaFormat = commaFormat;
				
		}
		return numberCommaFormat;
	}
	
	public String cnvBigDecimaltoToString(BigDecimal number) {
		String numberCommaFormat = cnvBigDecimaltoToCurrency(number);
		numberCommaFormat = numberCommaFormat.substring(0,numberCommaFormat.lastIndexOf("."));
		return numberCommaFormat;
	}
	public BigDecimal cnvStringtoBigDecimal(String amountSt) {
		return new BigDecimal(cnvStringtoDouble(amountSt));
	}
	public String checkNull(String str) {
	    if (str == null) {
	      str = "";
	    }
	    if (str.replace('?', ' ').trim().equals("")) {
	    //  str = this.UnicodeToMS874(str);
	    }
	    return str.trim();
	  }

	public String addChar(String code,char c,int count){
		if(code != null) {
			int len = count-code.length();
			if(len < count){
				for(int i = 0;i<len ;i++){
					code = c+code;
				}
			}
		}
		return code;
	}
	public String addCharSuffix(String code,char c,int count){
		StringBuffer buf = new StringBuffer(); 	
		buf.append(code);
		if(code != null) {	
			int len = count-code.length();
			if(len < count){
				for(int i = 0;i<len ;i++){
					buf.append(c);
				}
			}
		}
		return buf.toString();
	}
	public boolean checkEngAndNum(String str){
		boolean allValid = false;
		String checkOK = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	  	int cnterr=0;
	  	for (int i=0;i<str.length();  i++)
	  	{
	    	char ch = str.charAt(i);
	    	if (checkOK.indexOf(String.valueOf(ch)) == -1){
	    		cnterr++;
	    	}	
	    }
	  	if (cnterr == 0){
        	allValid=true;
        }
	  	return allValid;
	}
    public String cnvStringToWord(String txt){
		String[] txt1 = StringFunctionHelper.getInstance().changeCsvToArray(txt);
		String outTxt = "";
		for (int i = 0; i < txt1.length; i++) {
		      outTxt += "'"+txt1[i]+"',";
		}
        return (outTxt.length() > 0) ? outTxt.substring(0, outTxt.length() - 1) : "";
    }	
    public String replace(String inputStr, String delimStr, String replaceStr){
		if(inputStr == null || delimStr == null || replaceStr == null){
			return null;
		}
		
		StringTokenizer tokenStr = new StringTokenizer(inputStr, delimStr, true);
		String returnStr = "";
		while(tokenStr.hasMoreTokens()){
			String buff = tokenStr.nextToken();
			if(buff.equalsIgnoreCase(delimStr)){
				buff = replaceStr;
			}
			returnStr = returnStr + buff;
		}
		
		try {

		}
		catch(StringIndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
		return returnStr;	
	}
    
	public boolean checkInt(String str){
		boolean allValid = false;
		String checkOK = "1234567890.";
	  	int cnterr=0;
	  	for (int i=0;i<str.length();  i++)
	  	{
	    	char ch = str.charAt(i);
	    	if (checkOK.indexOf(String.valueOf(ch)) == -1){
	    		cnterr++;
	    	}	
	    }
	  	if (cnterr == 0){
        	allValid=true;
        }
	  	return allValid;
	}
	
	public String getSpecialCharacterCount(String s) {
		boolean found = false;
	     String specialChars = "*!@#$%^&*\"{}_[]|\\?<>,'";
	     if (null != s && !"".equals(s.trim())) {
		     for (int i = 0; i < specialChars.length(); i++) {
		         if (s.indexOf(specialChars.charAt(i)) >= 0) {
		        	 found = true;
		             break;
		         }
		     }
	     }
	     return (found) ? specialChars : "";
	 }
	public String[] split(String str,int fixed_size){
		String[] txts = new String[(str.length()+fixed_size-1)/fixed_size];
		int cnt = 0;
		for (int pos = 0; pos < str.length(); pos += fixed_size) {
			txts[cnt++] = str.substring(pos,Math.min(str.length(),pos+fixed_size));
		}
		return txts;
	}    
	//Modify By Kaita D. - 12/11/2014 For: CC Noti
	public boolean isInteger(String str){
		boolean allValid = false;
		String checkOK = "1234567890";
	  	int cnterr=0;
	  	for (int i=0;i<str.length();  i++)
	  	{
	    	char ch = str.charAt(i);
	    	if (checkOK.indexOf(String.valueOf(ch)) == -1){
	    		cnterr++;
	    	}	
	    }
	  	if (cnterr == 0){
        	allValid=true;
        }
	  	return allValid;
	}
	public String[] split(String longDesc,int from,int to,int size,int count){
		String[] txts = new String[count];
		int countLoop = 0;
		while(countLoop != count){
			int lastpos = to+(countLoop*size);
			if (lastpos > longDesc.length()) lastpos = longDesc.length();
			String str = longDesc.substring(from+(countLoop*size),lastpos);
			if(str.trim().length() != 0)
				txts[countLoop] = str;
			countLoop++;
		}
		return txts;
	}
	
	public String randomString(int numChr){
		final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
		StringBuilder buf = new StringBuilder();
		SecureRandom sr = new SecureRandom();
		for (int i = 0; i < numChr; i++) {
			buf.append(AB.charAt(sr.nextInt(AB.length())));
		}
		return buf.toString();
	}
	
	public String strReplaceAll( String s1, String s2, String s ) 
	{
	    if((( s == null ) || (s.length() == 0 )) || (( s1 == null ) || (s1.length() == 0 )))
	     { return s; }

	   while( (s != null) && (s.indexOf( s1 ) >= 0) )
	    { s = s.replace( s1, s2 ); }
	  return s;
	}
}
