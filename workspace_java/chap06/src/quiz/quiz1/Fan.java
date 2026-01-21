package quiz.quiz1;

public class Fan {
	
	// 전원 켜는 기능
	boolean power = false;
	void powerOn() {
		System.out.println("전원이 켜졌습니다");
		power = true;
	}
	
	// 전원 끄는 기능
	
	void powerOff() {
		System.out.println("전원이 꺼졌습니다");
		power = false;
	}
	
	// 약풍
	
	void weak() {
		if(power == true) {
			System.out.println("약풍 실행됩니다");
		} else {
			System.out.println("전원을 켜주세요");
		}
	}
	
	// 강풍
	
	void strong() {
		if(power == true) {
			System.out.println("강풍 실행됩니다");
		} else {
			System.out.println("전원을 켜주세요");
		}
	}
	
	// 전원이 켜져야만 바람이 나와야함
	
}
