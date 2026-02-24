package chap08;

public class Tv extends Display implements RemoteControl, OTT{

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다");
	}

	int vol;
	
	@Override
	public void setVolume(int vol) {
//		if(vol > RemoteControl.MAX_VOLUME) {
//			vol = RemoteControl.MAX_VOLUME;
//		} else if (vol < RemoteControl.MIN_VOLUME) {
//			vol = RemoteControl.MIN_VOLUME;
//		}
		
		if(vol > RemoteControl.MAX_VOLUME) vol = RemoteControl.MAX_VOLUME;
		else if (vol < RemoteControl.MIN_VOLUME) vol = RemoteControl.MIN_VOLUME;
		
		
		this.vol = vol;
		System.out.println("TV 볼륨 변경: "+ this.vol);
	}
	
	@Override
	public void netflix() {
		System.out.println("넷플릭스 시청");
	}
	
	
}
