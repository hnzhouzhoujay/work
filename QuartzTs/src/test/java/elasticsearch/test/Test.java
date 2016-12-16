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
		MemberInfo memberInfo = new MemberInfo (1,"吴天",1,
				"开朗 热情，富有责任感","喜欢看电影，玩音乐, 看书",
				"湖南衡阳","善良，性格温柔");
		String jsonObj = new Gson().toJson(memberInfo);
		service.createDocument("crm_allot", "MemberInfo", memberInfo.getMemberId().toString(),jsonObj);
		
		memberInfo = new MemberInfo (2,"linlin",0,
				"开朗 热情，富有责任感","旅游，购物，音乐",
				"湖南湘潭","关于我:在日记里关于TA:健朗、高尚、智慧、幽默、有情趣"); 
		jsonObj = new Gson().toJson(memberInfo);
		service.createDocument("crm_allot", "MemberInfo", memberInfo.getMemberId().toString(),jsonObj);
		
	}
	
	public void testSearch(){
		SearchRequestBuilder  search=service.builderSearch("crm_allot", "MemberInfo");
//		search.setQuery(QueryBuilders.termQuery("favorite", "电影 音乐"));
		search.setQuery(QueryBuilders.matchQuery("favorite", "电影 音乐"));
		service.doSearch(search);
//		String url="http://10.10.10.179:9200/crm_allot/MemberInfo/_search?q=favorite:音乐";
//		System.out.println(url);
//		System.out.println(HttpClientUtils.httpGet(url));
	}
	
	public void test(){
		String url="http://10.10.10.179:9200/crm_allot/_mapping/MemberInfo";
		System.out.println(HttpClientUtils.httpGet(url));
	}
	
	public void testReg(){
//		Pattern pattern = Pattern.compile("正则表达式");
//		Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World ");
//		StringBuffer sbr = new StringBuffer();
//		while (matcher.find()) {
//		    matcher.appendReplacement(sbr, "Java");
//		}
//		matcher.appendTail(sbr);
//		System.out.println(sbr.toString());
		
		
		Pattern pattern = Pattern.compile("hometown\\s*=\\s*'([0-9]+)'\\s*,");
		Matcher matcher = pattern.matcher("body='10', constellation='4', fondMusic='17028', drinking='2', finishSchool='', house='3', lastModTime='2016-07-17 14:37:33.0', hideType='100', stock='1', height='170', nickName='大狮', family='2', verifyTime='2016-07-17 19:25:16.0', salary='7', memberStatus='0', occupation='1502', animals='2', hometown='10126083', belief='3', sp='901004', introduceContent=' 期待寻到一个我愿意为她写诗的人。希望她端庄聪慧，漂亮大方，热爱运动，身无恶疾——总结成两个字：优雅——这是我最欣赏的女生的特质。rn Being excellent不是选择的原因，因为不管多么优秀，都会有更优秀的人——Ice Age里面的Manny说，I want us to be together not because we have to-we want to——Being special才是在一起的原因，所以，最最最最最重要的是相互来电，扪心自问的时候能毫不违心地说“我愿意”。rn 喜欢健硕的姑娘（有肌肉还是很美的，但是不要太多肉肉），最好不要太瘦，会切菜——主要是为做土豆丝而准备，哈哈。希望那个她能陪我上天下海，去蒙古草原上遛马。rn 我现在没有太多物质财富，但是如果你是我的那个真命天女，不论将来我能达到什么样的高度，我的所有都是你的。没有买车，但是只要你不想坐公交，请随便打车，费用我来负责。rn 女生的首饰只能接受玉镯或者极富设计感、整体感比较强之类的，比如银项圈，可以说审美方面有点小洁癖，有点外貌协会——所以能对一道青椒麻辣土豆丝百吃不厌——不过正因如此，我也能对一份打动我的爱情忠贞不渝。rn 希望遇到爱情，地老天荒。——我就纳了闷儿了，这么好的小伙儿，咋就没人看得懂呢？', orderNum='1', loginCount='596', health='640', memberCategory='1513234', assessor='王全安', bloodType='1', wantChildren='2', fondPlace='1165059', corpType='6', lastModIP='180.171.242.52', subSiteID='-1', birthday='1985-05-24 22:28:23.0', createTime='2016-05-21 01:02:11.0', sex='0', 上海虹口区 weight='70', trueName='高超', vehicle='2', children='1', memberType='1', education='6', tongueGift='0', fondProgram='74660', smoking='2', fondFood='2081', infoPercent='5', memberCredit='17', memberID='92034200', objKind='0', lastLoginTime='2016-07-20 13:05:10.0', keywordorder='3466339', fondSport='8992', fondAction='23131745', marriage='1', photo='0', mobileMemberType='1404', hitCount='0', ifOnline='1', defaultPhoto='1463764495735.jpg', verifyStatus='9' ");
		//替换第一个符合正则的数据
		if(matcher.find())
			System.out.println(matcher.group(1));
		System.out.println(matcher.replaceAll("hometown='程度'"));

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
