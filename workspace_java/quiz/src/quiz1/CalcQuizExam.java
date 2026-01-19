package quiz1;

public class CalcQuizExam {

	public static void main(String[] args) {
		System.out.println("----------계산기------------");
		
		CalcQuiz calc = new CalcQuiz();
		
		
		calc.input();
		int result = 0;
		double result1 = 0;		// 나누기 double로 받고 싶어서 double 하나 더 저장
		int x1 = Integer.parseInt(calc.play.get(0));		// 배열이 String으로 저장 되어서
		int y1 = Integer.parseInt(calc.play.get(2));		// parseInt로 숫자로 형변환
		if(calc.play.get(1).equals("+")) {		// 더하기
			result = calc.plus(x1, y1);			// 더하기 하는 메소드를 result로 가져옴
			System.out.println(x1 + calc.play.get(1) + y1 + " = " + result);
		} else if(calc.play.get(1).equals("-")) {
			result = calc.minus(x1, y1);
			System.out.println(x1 + calc.play.get(1) + y1 + " = " + result);
		} else if(calc.play.get(1).equals("/")) {
			result1 = calc.divide(x1, y1);
			System.out.println(x1 + calc.play.get(1) + y1 + " = " + result1);
		} else if(calc.play.get(1).equals("*")) {
			result = calc.multi(x1, y1);
			System.out.println(x1 + calc.play.get(1) + y1 + " = " + result);
		}
		
		
	}

}
