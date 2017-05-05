package elasticsearch.query;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import elasticsearch.util.HttpClientUtils;

public class QueryLocation {
	private static final String API_URL="https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?cb=jQuery110206685050699649432_1486523965213&resource_name=guishudi&query=";
	public static void main(String[] args) {
		String result = HttpClientUtils.httpGet(API_URL+"18692912825");
		System.out.println(result);
		int start = result.indexOf("(");
		int end = result.indexOf(")");
		String json=result.substring(start+1, end);
		 JSONObject jsonObject = new JSONObject(json).getJSONArray("data").getJSONObject(0);
		  String city = jsonObject.getString("city");
		  String prov = jsonObject.getString("prov");
		  String type = jsonObject.getString("type");
		System.out.println(city+"\t"+prov+"\t"+type);
//		Map<String,String> map = toMap(json);
//		System.out.println(json);
	}
	
//	public static  Map<String,String> toMap(String jsonString) throws JSONException {
//        JSONObject jsonObject = new JSONObject(jsonString);
//        Map<String,String> result = new HashMap<String,String>();
//        Iterator iterator = jsonObject.keys();
//        String key = null;
//        String value = null;
//        while (iterator.hasNext()) {
//            key = (String) iterator.next();
//            if(key)
//            value = jsonObject.get(key);
//            result.put(key, value);
//
//        }
//        return result;
//
//    }

}
