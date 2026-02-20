package sec01.override;

public class ComputerExam {

	public static void main(String[] args) {

		int r = 10;
		
		Calc calc = new Calc();
		System.out.println("넓이: " + calc.areaCircle(r));
		System.out.println();
		
		
		Computer computer = new Computer();
		System.out.println("넓이: " + computer.areaCircle(r));
		
		
		System.out.println(calc.plus(2, 3));
		System.out.println(computer.plus(1, 2));
		
	}
	

}
