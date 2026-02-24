package chap08;

public class Audio implements RemoteControl{

	@Override
	public void turnOn() {
		System.out.println("오디오를 켭니다");
	}

	@Override
	public void turnOff() {	
		System.out.println("오디오를 끕니다");		
	}

	int vol;
	
	@Override
	public void setVolume(int vol) {

		if(vol > RemoteControl.MAX_VOLUME) vol = RemoteControl.MAX_VOLUME;
		else if (vol < RemoteControl.MIN_VOLUME) vol = RemoteControl.MIN_VOLUME;
		
		
		this.vol = vol;
	}

}
