package sec01.override;

public class Computer extends Calc {

	@Override
	public double areaCircle(double r) {
		System.out.println("Computer의 areaCircle 실행");
		return Math.PI * r * r;
	}
	
	@Override
	public int plus(int x, int y) {
		System.out.println("Computer의 plus 실행");
		
		int result = super.plus(x, y);
		return result;
	}
	
		
}
