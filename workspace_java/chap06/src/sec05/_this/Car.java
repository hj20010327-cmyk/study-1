package sec05._this;

public class Car {
	
	String model;
	
	
	
	void setModel(String model) {
//		String model;
//		model = model;
		
//		int a = 10;
//		a = a;
		
		// this
		// new 된 나를 뜻한다
		this.model = model;  // 필드에 있는 변수를 가리킬 때 this.을 붙힌다
	}
	
	Car(String model){
		this.model = model;
	}

}
