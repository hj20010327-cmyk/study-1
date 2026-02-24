package sec03._abstract;

public class AnimalExam {

	public static void main(String[] args) {

//		Animal animal = new Animal();
		
		Animal a = new Dog();
		a.sound();
		Dog dog = (Dog)a;
		
		System.out.println(dog.kind);
		
	}
	
		

}
