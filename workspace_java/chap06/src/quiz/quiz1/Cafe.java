package quiz.quiz1;

public class Cafe {
	String name;
	int money;
	String menu1;
	String menu2;
	
	Cafe(String name, int money) {
		this.name = name;
		this.money = money;
		this.menu1 = "아아";
		this.menu2 = "따아";
	}
	
	void run() {
		System.out.println("상호명: "+ this.name + " 초기자본: " + money
				+ " 메뉴1: " + this.menu1 + " 메뉴2: " + this.menu2);
	}
	
}
