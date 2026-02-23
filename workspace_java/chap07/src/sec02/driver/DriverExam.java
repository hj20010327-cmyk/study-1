package sec02.driver;

public class DriverExam {

	public static void main(String[] args) {

		Driver driver = new Driver();
		
		Car car = new Car();
		driver.drive(car);
		
		
		Maserati m = new Maserati();
		driver.driveMaserati(m);
		
		System.out.println("-------------------------------");
		driver.drive(m);
		
		System.out.println("-------------------------------");
		PorscheTaycan pt = new PorscheTaycan();
		driver.drive(pt);
		
	}

}
