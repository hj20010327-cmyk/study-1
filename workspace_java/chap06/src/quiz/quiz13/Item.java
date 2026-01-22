package quiz.quiz13;

public class Item {

	// 제품을 관리 하는곳
	// 필드에 제품 이름
	// 생성자 = 이름 필수
	// 메소드 : 이름 리턴
	
	String item;
	
	Item (String it) {
		this.item = it;
	}
	
	String name() {
		return this.item;
	}
	
	
	
	
}
