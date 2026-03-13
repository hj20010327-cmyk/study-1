package chap11;

public class Member {

	String id;
	int num;
	
	Member(String id, int num){
		this.id = id;
		this.num = num;
	}
	
	@Override
	public boolean equals(Object obj) {
		Member mem1 = (Member)obj;
		return this.id.equals(mem1.id) && this.num == mem1.num;
	}
	
}
