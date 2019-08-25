package th.priisoft.crm.common.utils;

import java.text.SimpleDateFormat;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;

import th.priisoft.crm.common.date.DateControl;



public class JsonUtils {

	public static String genJsonString(Object obj) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.writeValueAsString(obj);
	}
	public static <T> T mapJsonString(String json,java.lang.Class<T> cls) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(json, cls);	
	}
	
	public static String genJsonLocal(Object obj) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.ALWAYS);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.enableDefaultTyping(DefaultTyping.JAVA_LANG_OBJECT,As.PROPERTY);
		return mapper.writeValueAsString(obj);
	}
	public static <T> T mapJsonLocal(String json,java.lang.Class<T> cls) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.ALWAYS);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.enableDefaultTyping(DefaultTyping.JAVA_LANG_OBJECT,As.PROPERTY);
		return mapper.readValue(json, cls);	
	}
	public static String mapJsonCondition(String jsonString) {
		String result = "";
		JSONObject object = (JSONObject) JSONValue.parse(jsonString);

	    // then
		if (object != null) {
		    @SuppressWarnings("unchecked")
		    Set<String> keySet = object.keySet();
		    for (String key : keySet) {
		        Object value = object.get(key);
		        if (key.toLowerCase().indexOf("date")>=0) {
		        	String dd = "";
		        	if (value instanceof Integer || value instanceof Long) {
			        	SimpleDateFormat sdfOut = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        	
						dd = DateControl.millisecondToStringDate((long)value, "yyyy-MM-dd HH:mm:ss");
		        	} else {
		        		dd = String.valueOf(value);
		        	}
					result += key + " = '" + dd + "' AND ";
		        	
		        } else 
		        if (value instanceof String) {
		        	result += key + " like '%" + value + "%' AND ";
		        	
		        } else if (value instanceof Integer || value instanceof Long) {
		        	result += key + " = " + value + " AND ";
		        	
		        } else if (value instanceof Double || value instanceof Float ) {
		        	result += key + " = " + value + " AND ";
		        	
		        } else if (value instanceof Boolean) {
		        	result += key + " = " + value + " AND ";
		        	
		        }
		        
		    }
		    System.out.println(" result before cut = " + result);
	        result = result.substring(0, result.lastIndexOf("AND"));
	        System.out.println(" result after cut = " + result);
		}
	    return result;
	}
	public static String mapConditionJsonArray(JSONObject jsonObj) throws org.json.simple.parser.ParseException {
		String result = "";
		try {
			JSONArray arrs = (JSONArray) jsonObj.get("condition");
			
			if (arrs != null) {
				for (Object arr : arrs ) {
					result += arr.toString() + ",";
				}
			}
			result = result.substring(0, result.lastIndexOf(","));
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return result;
	}
	public static String mapJsonCondNew(String jsonString) {
		String result = "";
		JSONObject object = (JSONObject) JSONValue.parse(jsonString);

	    // then
		if (object != null) {
		    @SuppressWarnings("unchecked")
		    Set<String> keySet = object.keySet();
		    for (String key : keySet) {
		    	JSONArray arrs = (JSONArray)object.get(key);
		        String cond = (String)arrs.get(0);
		        Object value1 = arrs.get(1);
		        Object value2 = new Object();
		        if ("between".equalsIgnoreCase(cond)) {
		        	value2 = arrs.get(2);
		        	if (key.toLowerCase().indexOf("date")>=0) {
			        	String dd1 = "";
			        	String dd2 = "";
			        	if ((value1 instanceof Integer || value1 instanceof Long) && (value2 instanceof Integer || value2 instanceof Long)) {
				        	SimpleDateFormat sdfOut = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				        	
							dd1 = DateControl.millisecondToStringDate((long)value1, "yyyy-MM-dd HH:mm:ss");
							dd2 = DateControl.millisecondToStringDate((long)value2, "yyyy-MM-dd HH:mm:ss");
			        	} else {
			        		dd1 = String.valueOf(value1);
			        		dd2 = String.valueOf(value2);
			        	}
						result += key +" "+ cond + " '" + dd1 + "' AND '" + dd2 + "' AND" ;
			        	
			        } else if (value1 instanceof String && value2 instanceof String) {
			        	result += key +" "+ cond + " '" + value1 + "' AND '" + value2 + "' AND";
			        	
			        } else if ((value1 instanceof Integer || value1 instanceof Long) && (value2 instanceof Integer || value2 instanceof Long)) {
			        	result += key +" "+ cond + " " + value1 + " AND " + value2 + " AND";
			        	
			        } else if ((value1 instanceof Double || value1 instanceof Float) && (value2 instanceof Double || value2 instanceof Float)) {
			        	result += key +" "+ cond + " " + value1 + " AND " + value2 + " AND";
			        	
			        } 
		        } else if ("in".equalsIgnoreCase(cond)){
		        	JSONArray ls1 = (JSONArray) value1;
					String str = "";
					if (ls1 != null) {
						for (Object arr : ls1 ) {
							if (arr instanceof String) {
								str += "'" +arr.toString() + "',";
							} else {
								str += arr.toString() + ",";
							}
						}
					}
					str = str.substring(0, str.lastIndexOf(","));
		        	result += key +" "+ cond + " (" + str + ") AND ";
		        } else {
			        if (key.toLowerCase().indexOf("date")>=0) {
			        	String dd = "";
			        	if (value1 instanceof Integer || value1 instanceof Long) {
				        	SimpleDateFormat sdfOut = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				        	
							dd = DateControl.millisecondToStringDate((long)value1, "yyyy-MM-dd HH:mm:ss");
			        	} else {
			        		dd = String.valueOf(value1);
			        	}
						result += key +" "+ cond + " '" + dd + "' AND ";
			        	
			        } else if (value1 instanceof String) {
			        	if ("like".equals(cond.toLowerCase())) {
			        		result += key +" "+ cond + " '%" + value1 + "%' AND ";
			        	} else {
			        		result += key +" "+ cond + " '" + value1 + "' AND ";
			        	}
			        } else if (value1 instanceof Integer || value1 instanceof Long) {
			        	result += key +" "+ cond + " " + value1 + " AND ";
			        	
			        } else if (value1 instanceof Double || value1 instanceof Float ) {
			        	result += key +" "+ cond + " " + value1 + " AND ";
			        	
			        } else if (value1 instanceof Boolean) {
			        	result += key +" "+ cond + " " + value1 + " AND ";
			        	
			        }
		        }
		    }
		    System.out.println(" result before cut = " + result);
	        result = result.substring(0, result.lastIndexOf("AND"));
	        System.out.println(" result after cut = " + result);
		}
	    return result;
	}
	
	
	public static String mapJsonCondNew2(String jsonString) {
		String result = "";
		
		if(jsonString!=null&&jsonString.trim().length()>0) {
			jsonString = jsonString.trim();
			if( jsonString.startsWith("{") ) {
				JSONObject object = (JSONObject) JSONValue.parse(jsonString);
				result = mapJsonCondMain(object,jsonString,"");
			}else if(jsonString.startsWith("[")) {
				result = mapJsonCondArrayNew(jsonString);
			}
		}
		
		return result;
	}
	
	public static String mapJsonCondArrayNew(String jsonString) {
		String result = "";
		JSONArray objectArray = (JSONArray) JSONValue.parse(jsonString);
		if(objectArray!=null) {
			 for (int i = 0 ; i < objectArray.size(); i++) { 
				JSONObject object = (JSONObject) objectArray.get(i);
				result += mapJsonCondMain(object,jsonString," AND ");
				System.out.println(" result mapJsonCondArrayNew = " + result);
			 }
			 
			 if((result.trim()).endsWith("AND")) {
				   result = result.substring(0, result.lastIndexOf("AND"));
			 }else  if((result.trim()).endsWith("OR")) {
				   result = result.substring(0, result.lastIndexOf("OR"));
			 }

		}
	    return result;
	}
	
	public static String mapJsonCondMain(JSONObject object,String jsonString,String condition) {
		String result = "";

	    // then
		if (object != null) {
		    @SuppressWarnings("unchecked")
		    
		    String[] keys = (String[]) object.keySet().toArray(new String[object.keySet().size()]);
		    
		    keys = sortKeySetByJsonString(keys ,jsonString);
		      
		    
		    for (int i = 0 ; i < keys.length; i++) {
		    	String key = keys[i];
		    	
		    	if("GROUPCOND".equalsIgnoreCase(key)) {
		    		JSONArray arrs = (JSONArray)object.get(key);
			        String cond = (String)arrs.get(0);
			        if(condition.trim().length()>0 && "OR".equalsIgnoreCase(cond))
			        	condition = " OR ";
		    		continue;
		    	}
		    		

		    	JSONArray arrs = (JSONArray)object.get(key);
		        String cond = (String)arrs.get(0);
		        Object value1 = arrs.get(1);
		        Object value2 = new Object();
		        String value3 = "";
		        String value4 = "";
		        String ORANDCON = " AND ";
		        
		        if ("between".equalsIgnoreCase(cond)&&arrs.size()>3) {
		        	value3=(String)arrs.get(3);
		        }else if(!"between".equalsIgnoreCase(cond)&&arrs.size()>2){
		        	value3=(String)arrs.get(2);
		        }
		        
		        if("OR".equalsIgnoreCase(value3)) {
	        		ORANDCON = " OR ";
	        	}
		        
		        if ("between".equalsIgnoreCase(cond)) {
		        	value2 = arrs.get(2);
		        	if (key.toLowerCase().indexOf("date")>=0) {
			        	String dd1 = "";
			        	String dd2 = "";
			        	if ((value1 instanceof Integer || value1 instanceof Long) && (value2 instanceof Integer || value2 instanceof Long)) {
				        	SimpleDateFormat sdfOut = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				        	
							dd1 = DateControl.millisecondToStringDate((long)value1, "yyyy-MM-dd HH:mm:ss");
							dd2 = DateControl.millisecondToStringDate((long)value2, "yyyy-MM-dd HH:mm:ss");
			        	} else {
			        		dd1 = String.valueOf(value1);
			        		dd2 = String.valueOf(value2);
			        	}
						result += key +" "+ cond + " '" + dd1 + "' AND '" + dd2 + "' "+ORANDCON ;
			        	
			        } else if (value1 instanceof String && value2 instanceof String) {
			        	result += key +" "+ cond + " '" + value1 + "' AND '" + value2 + "' "+ORANDCON;
			        	
			        } else if ((value1 instanceof Integer || value1 instanceof Long) && (value2 instanceof Integer || value2 instanceof Long)) {
			        	result += key +" "+ cond + " " + value1 + " AND " + value2 +ORANDCON;
			        	
			        } else if ((value1 instanceof Double || value1 instanceof Float) && (value2 instanceof Double || value2 instanceof Float)) {
			        	result += key +" "+ cond + " " + value1 + " AND " + value2 +ORANDCON;
			        	
			        } 
		        } else if ("in".equalsIgnoreCase(cond)){
		        	JSONArray ls1 = (JSONArray) value1;
					String str = "";
					if (ls1 != null) {
						for (Object arr : ls1 ) {
							if (arr instanceof String) {
								str += "'" +arr.toString() + "',";
							} else {
								str += arr.toString() + ",";
							}
						}
					}
					str = str.substring(0, str.lastIndexOf(","));
		        	result += key +" "+ cond + " (" + str + ") "+ORANDCON;
		        } else {
			        if (key.toLowerCase().indexOf("date")>=0) {
			        	String dd = "";
			        	if (value1 instanceof Integer || value1 instanceof Long) {
				        	SimpleDateFormat sdfOut = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				        	
							dd = DateControl.millisecondToStringDate((long)value1, "yyyy-MM-dd HH:mm:ss");
			        	} else {
			        		dd = String.valueOf(value1);
			        	}
						result += key +" "+ cond + " '" + dd + "' "+ORANDCON+" ";
			        	
			        } else if (value1 instanceof String) {
			        	if ("like".equals(cond.toLowerCase())) {
			        		result += key +" "+ cond + " '%" + value1 + "%' "+ORANDCON;
			        	} else {
			        		result += key +" "+ cond + " '" + value1 + "'"+ORANDCON;
			        	}
			        } else if (value1 instanceof Integer || value1 instanceof Long) {
			        	result += key +" "+ cond + " " + value1 + ORANDCON;
			        	
			        } else if (value1 instanceof Double || value1 instanceof Float ) {
			        	result += key +" "+ cond + " " + value1 + ORANDCON;
			        	
			        } else if (value1 instanceof Boolean) {
			        	result += key +" "+ cond + " " + value1 + ORANDCON;
			        	
			        }
		        }
		    }
		    System.out.println(" result before cut = " + result);
		    
		    if((result.trim()).endsWith("AND")) {
		    	result = result.substring(0, result.lastIndexOf("AND"));
		    }else  if((result.trim()).endsWith("OR")) {
		    	result = result.substring(0, result.lastIndexOf("OR"));
		    }
		    
	        System.out.println(" result after cut = " + result);
	        
	        if(result.trim().length()>0)
	        	result = " ( " +result+ " ) " + condition;
	        
	        System.out.println(" result finished cut and group = " + result);
		}
	    return result;
	}
	
	public static String[] sortKeySetByJsonString(String[] keys ,String JsonString) {
		//sort key
	    for(int i = 0; i<keys.length; i++) {
	         for (int j = i+1; j<keys.length; j++) {
	        	 int a1 =JsonString.indexOf(",\""+keys[i]+"\"");
	        	 if(a1==-1)
	        		 a1 =JsonString.indexOf("\""+keys[i]+"\"");
	        	 
	        	 int a2 =JsonString.indexOf(",\""+keys[j]+"\"");
	        	 if(a2==-1)
	        		 a2 =JsonString.indexOf("\""+keys[j]+"\"");
	        	 
	            if(a1>a2) {
	               String temp = keys[i];
	               keys[i] = keys[j];
	               keys[j] = temp;
	            }
	         }
	      }
		
		return keys;
	}
}
