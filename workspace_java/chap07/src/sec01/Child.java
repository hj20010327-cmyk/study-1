package sec01;

public class Child extends Parent{
	
	void printName(){
		System.out.println("Child의 printName 실행");
		
		System.out.println("name: "+ name);
		
		System.out.println("this.name: "+ this.name);
		
		String name = "지역변수 선언 가능";
		
		System.out.println("super.name: "+ super.name);
	}
	
	// 지역변수(전달인자)가 필드를 가리는 현상
	// shadow 현상
	void setName(String name) {
		this.name = name;
	}
	
	// 자식 필드가 부모 필드를 가리는 현상
	// overshadow 현상
	String name = "Child의 name";
	
	
//	Child(){
//		this(2);
//	}
//
//	Child(int a){
//		
//	}
	
	// 상속이 있을 때
	// 기본 생성자
	Child(){
//		super();	// 부모의 생성자 호출(생략 가능)
					// 첫줄에 적어야 한다
		
//		this(2);	// super(), this()
					// 모두 첫 줄에 적어야 해서
					// 같이 사용할 수 없다
		
		super(3);	// 부모 생성자에 전달인자가 있는 경우
					// 생략 불가능
		System.out.println("Child 생성자 실행");
	}
	
	
}
