package elasticsearch.service;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

public class ESsearchService {
	
	private Client client;
	
	public ESsearchService(){
		this("10.10.10.179",9300);
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
			        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(hostname), port));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public void createDocument(String indexName,String typeName ,String id,String jsonObj){
		//通过.setCreate(true) 只许创建，不许更新存在的文档
	    //client.prepareIndex(_index, _type,id)
		IndexResponse  indexResponse=client.prepareIndex(indexName, typeName ,id).setSource(jsonObj).get();
		System.out.println("_index:"+indexResponse.getIndex());
		System.out.println("_type:"+indexResponse.getType());
		System.out.println("_id:"+indexResponse.getId());
		System.out.println("_verson:"+indexResponse.getVersion());
		System.out.println("isCreate:"+indexResponse.isCreated());
	}
	
	public void getDocument(String indexName,String typeName ,String id){
		GetResponse getResponse = client.prepareGet(indexName, typeName, id).get();
		System.out.println(getResponse.getSourceAsString());
	}
	
	public void delDocument(String indexName,String typeName ,String id){
		DeleteResponse delResponse = client.prepareDelete(indexName, typeName, id).get();
		System.out.println("fonund:"+delResponse.isFound());
	}
	
	public void updateDocument(String indexName,String typeName ,String id,String jsonObj){
		UpdateRequest updateRequest = new UpdateRequest (indexName, typeName, id);
		updateRequest.doc(jsonObj);
		try {
			 UpdateResponse response = client.update(updateRequest).get();
			 System.out.println(response.getVersion());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	public void doSearch(SearchRequestBuilder builder){
		SearchResponse response = builder .execute().actionGet();
		Iterator<SearchHit> iterator = response.getHits().iterator();
		while(iterator.hasNext()){
			SearchHit hit = iterator.next();
			System.out.println("高亮:"+hit.getHighlightFields());
			System.out.println(hit.getSourceAsString());
		}
		
	}
	public SearchRequestBuilder builderSearch(String indexName ,String ...typeName){
		return client.prepareSearch(indexName).setTypes(typeName).setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
	}
	

}
