package sec02.driver;

public class Driver {

	void drive(Car car) {
		car.start();
		
		if( car instanceof Maserati ) {
			System.out.println("오 마세라티네요?");
			Maserati mase = (Maserati)car;
			mase.autoRun();
		} else {
			car.run();
		}
		
		car.stop();
	}
	
	void driveMaserati(Maserati m) {
		System.out.println("오직 마세라티만!!");
		m.autoRun();
		m.run();
	}
	
}
