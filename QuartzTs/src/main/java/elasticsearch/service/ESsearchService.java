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
		
		//ʹ���趨
		Settings settings = Settings.settingsBuilder()
		        .put("cluster.name", "nora").build();
		
		/*//������̬��⹦��
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
		//ͨ��.setCreate(true) ֻ������������´��ڵ��ĵ�
	    //client.prepareIndex(_index, _type,id)
		IndexResponse  indexResponse=client.prepareIndex(indexName, typeName).setSource(jsonObj).get();
		System.out.println("_index:"+indexResponse.getIndex());
		System.out.println("_type:"+indexResponse.getType());
		System.out.println("_id:"+indexResponse.getId());
		System.out.println("_verson:"+indexResponse.getVersion());
		System.out.println("isCreate:"+indexResponse.isCreated());
	}

}
