package elasticsearch.query;

import com.google.gson.Gson;

import elasticsearch.service.ESsearchService;
import elasticsearch.util.HttpClientUtils;

public class ESearch {
	public static void main(String[] args) {
//		System.out.println(HttpClientUtils.httpGet("http://10.10.10.179:9200/megacorp/employee/_search"));
		System.out.println(HttpClientUtils.httpGet("http://10.10.10.179:9200/_cluster/health"));
		ESsearchService service = new ESsearchService();
		MemberInfo memberInfo = new MemberInfo (4531,"吴天",1,
				"开朗 热情，富有责任感","喜欢看电影，玩音乐, 看书",
				"湖南衡阳","善良，性格温柔");
		String jsonObj = new Gson().toJson(memberInfo);
//		service.createDocument("crm_allot", "MemberInfo", jsonObj);
	}

}
