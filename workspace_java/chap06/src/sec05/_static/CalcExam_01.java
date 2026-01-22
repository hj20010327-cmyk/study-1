package sec05._static;

public class CalcExam_01 {

	int a = 10;
	
	public static void main(String[] args) {

		// 언급 되는 순간
		// static을 모두 로딩한다(처리한다)
		double p = Calc.pi;
		
		Calc c1 = new Calc();
		Calc c2 = new Calc();
		
		c1.color = "하늘색";
		c2.color = "핫삥꾸";
		
		System.out.println(c1.color);
		System.out.println(c2.color);
		
		System.out.println(c1.pi);
		c1.pi = 3.141592653;
		System.out.println(c2.pi);
		
		System.out.println(Math.PI);
		
		Calc.test();
		
		
//		eat();
//		CalcExam_01 c = new CalcExam_01();
//		c.eat();
		
		// static에서는 static만 사용 가능하다
		
//		this.a = 10;
		// this는 new가 된 나 즉, 인스턴스를 뜻하므로
		// new 이전에 사용할 수 있는 static에서는 못쓴다
		
		
	}
	
	void eat() {
		System.out.println("먹는다");
	}

}












