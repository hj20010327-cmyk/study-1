package sec02;

public class KeyboardImpl implements Keyboard{

	@Override
	public String press(int keyCode) {
		if(keyCode == 13) {
			return "Enter";
		}
		return "뭔가 눌림";
	}

}
