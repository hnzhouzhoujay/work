package elasticsearch.service;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class ESsearchService {
	
	private Client client;
	
	public ESsearchService(){
		this("10.10.10.179",9200);
	}
	public ESsearchService(String hostname,int port){
		
		//使用设定
		Settings settings = Settings.settingsBuilder()
		        .put("cluster.name", "nora").build();
		
		/*//开启动态监测功能
		Settings settings = Settings.settingsBuilder()
		        .put("client.transport.sniff", true).build();
		TransportClient client = TransportClient.builder().settings(settings).build();*/
		
		try {
			client = TransportClient.builder().settings(settings).build()
			        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(hostname), 9200));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public void createDocument(String indexName,String typeName ,String jsonObj){
		//通过.setCreate(true) 只许创建，不许更新存在的文档
	    //client.prepareIndex(_index, _type,id)
		IndexResponse  indexResponse=client.prepareIndex(indexName, typeName).setSource(jsonObj).get();
		System.out.println("_index:"+indexResponse.getIndex());
		System.out.println("_type:"+indexResponse.getType());
		System.out.println("_id:"+indexResponse.getId());
		System.out.println("_verson:"+indexResponse.getVersion());
		System.out.println("isCreate:"+indexResponse.isCreated());
	}

}
