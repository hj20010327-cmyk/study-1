package chap08;

public class RemoconExam {

	public static void main(String[] args) {

		Tv tv = new Tv();
		tv.setVolume(50);
		System.out.println(tv.vol);
		
		RemoteControl rc1 = (RemoteControl)tv;
		RemoteControl rc2 = tv;
		RemoteControl rc3 = new Tv();
		
		powerOn(tv);
		
	}
	
	static void powerOn(RemoteControl rc) {
		rc.turnOn();
	}

}
