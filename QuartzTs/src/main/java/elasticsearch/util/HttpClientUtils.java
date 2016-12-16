package elasticsearch.util;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ·¢ËÍhttpÇëÇóµÄclient
 * @author zj
 * 2016/06/16
 */
public class HttpClientUtils {
	
	public static String httpGet(String url){
		CloseableHttpClient  client = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		StringBuilder sb =new StringBuilder();
		
		try {
			HttpResponse response=client.execute(httpget);
			System.out.println("×´Ì¬:"+response.getStatusLine());
			InputStream input = response.getEntity().getContent();
		    BufferedReader br =new BufferedReader( new InputStreamReader(input,"utf-8"));
		    String line = null;
		    while((line=br.readLine())!=null){
		    	sb.append(line).append("\n");
		    }
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return sb.toString();
	}
	
	public static String httpGet(String url, String param){
		CloseableHttpClient  client = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		StringBuilder sb =new StringBuilder();
		
		try {
			HttpResponse response=client.execute(httpget);
			System.out.println("×´Ì¬:"+response.getStatusLine());
			InputStream input = response.getEntity().getContent();
		    BufferedReader br =new BufferedReader( new InputStreamReader(input,"utf-8"));
		    String line = null;
		    while((line=br.readLine())!=null){
		    	sb.append(line).append("\n");
		    }
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return sb.toString();
	}
	
	public static String httpPost(String url,Map<String,String> param){
		CloseableHttpClient  client = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);
		StringBuilder sb =new StringBuilder();
		List<NameValuePair> list =new ArrayList<NameValuePair>();
		for(String key:param.keySet()){
			list.add( new BasicNameValuePair(key, param.get(key)));
		}
		
		try {
			httppost.setEntity(new UrlEncodedFormEntity(list));
			HttpResponse response=client.execute(httppost);
			System.out.println("×´Ì¬:"+response.getStatusLine());
			InputStream input = response.getEntity().getContent();
		    BufferedReader br =new BufferedReader( new InputStreamReader(input,"utf-8"));
		    String line = null;
		    while((line=br.readLine())!=null){
		    	sb.append(line).append("\n");
		    }
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return sb.toString();
	}
	public static void main(String[] args) {
		Map<String,String> map =new HashMap<String,String>();
		map.put("fromTime", "2016-06-20 00:00:00");
		System.out.println(HttpClientUtils.httpPost("http://10.10.10.175:18123/usernew/BlackListService/reloadBlackList",map));
	}

}
