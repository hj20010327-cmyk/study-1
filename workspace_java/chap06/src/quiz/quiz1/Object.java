package quiz.quiz1;

import java.util.ArrayList;

public class Object {

	// 상품
	String name;
	int price;
	String info;
	
	String object(String name, int price, String info) {
		this.name = name;
		this.price = price;
		this.info = info;
		return "상품명: " + name + " 가격: " + price + " 정보: " + info;
	}
	
	
	
}
