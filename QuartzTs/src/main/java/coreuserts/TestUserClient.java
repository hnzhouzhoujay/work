package coreuserts;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.util.List;

import com.coola.core.user.share.UserClient;
import com.coola.core.user.share.UserInfo2;

public class TestUserClient {
	static long[] memberIds={
			98573126,98573117,98573109,98573068,98573063,98573019,98572997,98572991,98572986,98572996,98572974,98572954,98572931,98572906,98572893,98572795,98572773,98572745,98572735,98572730,98572626,98572620,98572611,98572583,98572571,98572566,98572492,98572487,98572493,98572433,98572383,98572325,98572300,98572289,98572257,98572183,98572115,98572103,98572086,98572071,98572028,98572015,98571894,98571893,98571875,98571867,98571715,98571685,98571684,98571667,98571627,98571624,98571623,98571612,98571603,98571601,98571594,98571528,98571522,98571354,98571264,98571247,98571242,98571223,98571212,98571191,98571179,98571163,98571129,98571105,98571093,98571085,98571055,98571049,98571045,98570997,98570966,98570952,98570928,98570900,98570851,98570787,98570782,98570776,98570773,98570760,98570740,98570733,98570725,98570691,98570680,98570626,98570614,98570596,98570591,98570568,98570565,98570543,98570518,98570491};
	static long[] memberIds2 = {
			98425697,98425696,98425587,98425566,98425545,98425541,98425501,98425487,98425456,98425455,98425448,98425437,98425399,98425378,98425353,98425322,98425321,98425303,98425264,98425238,98425183,98425134,98425130,98425106,98425094,98425056,98425040,98425029,98425023,98425018,98425007,98425002,98425001,98424982,98424970,98424938,98424925,98424922,98424921,98424902,98424881,98424809,98424731,98424719,98424716,98424651,98424638,98424582,98424514,98424493,98424488,98424400,98424392,98424376,98424295,98424244,98424241,98424235,98424195,98424142,98424112,98424035,98424034,98423996,98423984,98423950,98423948,98423878,98423873,98423839,98423825,98423810,98423760,98423726,98423635,98423611,98423607,98423599,98423549,98423545,98423511,98423507,98423487,98423470,98423436,98423364,98423346,98423326,98423277,98423248,98423177,98423173,98423169,98423168,98423143,98423070,98423033,98422974,98422886,98422884};
	static long[] memebrIds3 = {
			98422454,98422453,98422432,98422400,98422380,98422303,98422262,98422222,98422221,98422216,98422180,98422149,98422136,98422132,98422050,98422002,98421999,98421924,98421904,98421867,98421863,98421860,98421804,98421771,98421726,98421703,98421677,98421653,98421579,98421508,98421500,98421433,98421365,98421364,98421363,98421356,98421338,98421307,98421297,98421209,98421127,98421096,98421048,98421013,98420860,98420834,98420833,98420811,98420743,98420651,98420626,98420597,98420582,98420568,98420555,98420549,98420548,98420524,98420479,98420401,98420399,98420390,98420295,98420287,98420277,98420262,98420254,98420247,98420232,98420209,98420127,98420089,98420084,98420057,98420047,98420046,98419957,98419940,98419916,98419870,98419854,98419824,98419810,98419796,98419778,98419773,98419770,98419766,98419760,98419759,98419679,98419669,98419649,98419620,98419609,98419598,98419588,98419581,98419500,98419347
	};
	public static void main(String[] args) {
/*		try {
			UserClient client = new UserClient();
//			List<UserInfo2> info2 = client.getList(memberIds, UserInfo2.class);
//			System.out.println(info2.size());
//			for(long id :memberIds){
//				UserInfo2 info2 = client.get(id, UserInfo2.class);
//				info2.setMsn("1321121");
//				client.update(info2);
//			}
			UserInfo2 info2 = client.get(98572931, UserInfo2.class);
			System.out.println(info2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		System.out.println(read("menu.txt"));
		/*try {
			UserClient client = new UserClient();
			System.out.println(client.getPhoneClient().encodePhone("13037396062"));
			System.out.println(client.getPhoneClient().decodePhone("310C3DF7C586223AF1C16305CE57F5B9"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	
	public static Object readObjects(){
		byte[] bytes = null;
		try {
			FileInputStream fis = new FileInputStream("testWriteObject.txt");
			bytes = new byte[fis.available()];
			fis.read(bytes);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ByteArrayInputStream bas = new ByteArrayInputStream(bytes);
		try {
			ObjectInputStream ois = new ObjectInputStream(bas);
			return ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void writeObjects(Object obj){
	
/*		try {
			FileOutputStream fos = new FileOutputStream("testWriteObject.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} */
		System.out.println(read("menu.txt"));
		
	}
	
	private static String read(String name){
		InputStream is = TestUserClient.class.getClassLoader().getResourceAsStream(name);
		BufferedReader br = new BufferedReader(new InputStreamReader(is,Charset.forName("utf-8")));
		StringBuilder data = new StringBuilder();
		String line = null;
		try {
			while((line=br.readLine())!=null){
				data.append(line); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data.toString();
	}

}
