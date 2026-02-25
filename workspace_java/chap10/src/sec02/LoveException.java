package sec02;

public class LoveException extends Exception{

	LoveException(){
		System.out.println("LoveException 생성");
	}
	
	LoveException(String message) {
		super(message);
		System.out.println("LoveException(String) 생성");
	}
}
