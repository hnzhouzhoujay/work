package elasticsearch.test;

import com.google.gson.Gson;

import junit.framework.TestCase;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import elasticsearch.query.MemberInfo;
import elasticsearch.service.ESsearchService;
import elasticsearch.util.HttpClientUtils;

public class Test extends TestCase{
	ESsearchService service = null;
	
	public void testCreate(){
		MemberInfo memberInfo = new MemberInfo (1,"����",1,
				"���� ���飬�������θ�","ϲ������Ӱ��������, ����",
				"���Ϻ���","�������Ը�����");
		String jsonObj = new Gson().toJson(memberInfo);
		service.createDocument("crm_allot", "MemberInfo", memberInfo.getMemberId().toString(),jsonObj);
		
		memberInfo = new MemberInfo (2,"linlin",0,
				"���� ���飬�������θ�","���Σ��������",
				"������̶","������:���ռ������TA:���ʡ����С��ǻۡ���Ĭ������Ȥ"); 
		jsonObj = new Gson().toJson(memberInfo);
		service.createDocument("crm_allot", "MemberInfo", memberInfo.getMemberId().toString(),jsonObj);
		
	}
	
	public void testSearch(){
		SearchRequestBuilder  search=service.builderSearch("crm_allot", "MemberInfo");
//		search.setQuery(QueryBuilders.termQuery("favorite", "��Ӱ ����"));
		search.setQuery(QueryBuilders.matchQuery("favorite", "��Ӱ ����"));
		service.doSearch(search);
//		String url="http://10.10.10.179:9200/crm_allot/MemberInfo/_search?q=favorite:����";
//		System.out.println(url);
//		System.out.println(HttpClientUtils.httpGet(url));
	}
	
	public void test(){
		String url="http://10.10.10.179:9200/crm_allot/_mapping/MemberInfo";
		System.out.println(HttpClientUtils.httpGet(url));
	}
	
	public void testReg(){
//		Pattern pattern = Pattern.compile("������ʽ");
//		Matcher matcher = pattern.matcher("������ʽ Hello World,������ʽ Hello World ");
//		StringBuffer sbr = new StringBuffer();
//		while (matcher.find()) {
//		    matcher.appendReplacement(sbr, "Java");
//		}
//		matcher.appendTail(sbr);
//		System.out.println(sbr.toString());
		
		
		Pattern pattern = Pattern.compile("hometown\\s*=\\s*'([0-9]+)'\\s*,");
		Matcher matcher = pattern.matcher("body='10', constellation='4', fondMusic='17028', drinking='2', finishSchool='', house='3', lastModTime='2016-07-17 14:37:33.0', hideType='100', stock='1', height='170', nickName='��ʨ', family='2', verifyTime='2016-07-17 19:25:16.0', salary='7', memberStatus='0', occupation='1502', animals='2', hometown='10126083', belief='3', sp='901004', introduceContent=' �ڴ�Ѱ��һ����Ը��Ϊ��дʫ���ˡ�ϣ������ׯ�ϻۣ�Ư���󷽣��Ȱ��˶������޶񼲡����ܽ�������֣����š��������������͵�Ů�������ʡ�rn Being excellent����ѡ���ԭ����Ϊ���ܶ�ô���㣬�����и�������ˡ���Ice Age�����Manny˵��I want us to be together not because we have to-we want to����Being special������һ���ԭ�����ԣ�������������Ҫ�����໥���磬�������ʵ�ʱ���ܺ���Υ�ĵ�˵����Ը�⡱��rn ϲ����˶�Ĺ���м��⻹�Ǻ����ģ����ǲ�Ҫ̫�����⣩����ò�Ҫ̫�ݣ����вˡ�����Ҫ��Ϊ������˿��׼����������ϣ���Ǹ��������������º���ȥ�ɹŲ�ԭ������rn ������û��̫�����ʲƸ���������������ҵ��Ǹ�������Ů�����۽������ܴﵽʲô���ĸ߶ȣ��ҵ����ж�����ġ�û���򳵣�����ֻҪ�㲻���������������򳵣�������������rn Ů��������ֻ�ܽ���������߼�����ƸС�����бȽ�ǿ֮��ģ���������Ȧ������˵���������е�С��񱣬�е���òЭ�ᡪ�������ܶ�һ���ཷ��������˿�ٳԲ��ᡪ������������ˣ���Ҳ�ܶ�һ�ݴ��ҵİ������겻�塣rn ϣ���������飬������ġ������Ҿ������ƶ��ˣ���ô�õ�С�����զ��û�˿��ö��أ�', orderNum='1', loginCount='596', health='640', memberCategory='1513234', assessor='��ȫ��', bloodType='1', wantChildren='2', fondPlace='1165059', corpType='6', lastModIP='180.171.242.52', subSiteID='-1', birthday='1985-05-24 22:28:23.0', createTime='2016-05-21 01:02:11.0', sex='0', �Ϻ������ weight='70', trueName='�߳�', vehicle='2', children='1', memberType='1', education='6', tongueGift='0', fondProgram='74660', smoking='2', fondFood='2081', infoPercent='5', memberCredit='17', memberID='92034200', objKind='0', lastLoginTime='2016-07-20 13:05:10.0', keywordorder='3466339', fondSport='8992', fondAction='23131745', marriage='1', photo='0', mobileMemberType='1404', hitCount='0', ifOnline='1', defaultPhoto='1463764495735.jpg', verifyStatus='9' ");
		//�滻��һ���������������
		if(matcher.find())
			System.out.println(matcher.group(1));
		System.out.println(matcher.replaceAll("hometown='�̶�'"));

	}

	@Override
	protected void setUp() throws Exception {
		service= new ESsearchService();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
