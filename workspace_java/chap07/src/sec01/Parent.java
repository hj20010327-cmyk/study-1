package sec01;

public class Parent {

	String name = "Parent의 name";
	
	String getName() {
		System.out.println("Parent의 getName 실행");
		return this.name;
	}
	
	Parent(int a){
		System.out.println("Parent의 생성자");
	}
	
}

