package sec04.method02;

public class CalcExam {

	public static void main(String[] args) {
		
		Calc calc = new Calc();
		calc.powerOn();
		
		int a = calc.plus(5, 7);
		System.out.println("a: " + a);
		
		// 호출할 때 이름과 전달인자를 꼭 맞춰야 실행된다
//		calc.plus();
		
		int i = 4;
		a = calc.plus(i,  8);
		System.out.println("-------------------------------");
		double b = calc.divide(8,3);
		System.out.println("b: " + b);
	}

}
