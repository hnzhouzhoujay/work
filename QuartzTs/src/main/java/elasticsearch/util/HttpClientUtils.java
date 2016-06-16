package elasticsearch.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

}
