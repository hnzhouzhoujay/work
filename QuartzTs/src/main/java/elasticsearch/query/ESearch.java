package elasticsearch.query;

import com.google.gson.Gson;

import elasticsearch.service.ESsearchService;
import elasticsearch.util.HttpClientUtils;

public class ESearch {
	public static void main(String[] args) {
//		System.out.println(HttpClientUtils.httpGet("http://10.10.10.179:9200/megacorp/employee/_search"));
		System.out.println(HttpClientUtils.httpGet("http://10.10.10.179:9200/_cluster/health"));
		ESsearchService service = new ESsearchService();
		MemberInfo memberInfo = new MemberInfo (4531,"����",1,
				"���� ���飬�������θ�","ϲ������Ӱ��������, ����",
				"���Ϻ���","�������Ը�����");
		String jsonObj = new Gson().toJson(memberInfo);
//		service.createDocument("crm_allot", "MemberInfo", jsonObj);
	}

}
