package quiz.quiz1;

public class Tv {
	
	boolean boo = false;
	int volume;
	int channel;
	
	void powerOn() {
		System.out.println("전원이 켜졌습니다");
		boo = true;
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다");
		boo = false;
	}
	
	void volUp() {
		if(boo) {
			if(volume == 10) {
				System.out.println("최대 볼륨입니다");
			} else {
				volume++;
				System.out.println("현재볼륨: " + volume);
			}
		}
	}
	
	void volDown() {
		if(boo) {
			if(volume == 0) {
				System.out.println("볼륨을 더 낮출 수 없습니다");
			} else {
				volume--;
				System.out.println("현재볼륨: " + volume);
			}
		}
	}
	
	void Chan() {
		if(boo) {
			System.out.println(channel+"번 채널입니다");
		}
	}
	void current() {
		if(boo) {
			System.out.println("현재 상태: 전원이 켜져있습니다 현재 볼륨: "+ volume+ " 채널: "+ 
					channel+"번 입니다");
		} else {
			System.out.println("전원이 꺼져있습니다");
		}
	}
	
	
}
