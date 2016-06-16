package elasticsearch.query;

public class MemberInfo {
	private Integer memberId;
	private String name;
	private Integer sex;
	private String selfIntroduce;
	private String favorite;
	private String hometown;
	private String expect;
	public MemberInfo(){
		
	}
	public MemberInfo(Integer memberId, String name, Integer sex, String selfIntroduce, String favorite,
			String hometown, String expect) {
		this.memberId = memberId;
		this.name = name;
		this.sex = sex;
		this.selfIntroduce = selfIntroduce;
		this.favorite = favorite;
		this.hometown = hometown;
		this.expect = expect;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getSelfIntroduce() {
		return selfIntroduce;
	}
	public void setSelfIntroduce(String selfIntroduce) {
		this.selfIntroduce = selfIntroduce;
	}
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getExpect() {
		return expect;
	}
	public void setExpect(String expect) {
		this.expect = expect;
	}

}
