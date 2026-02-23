package sec02;

public class ParentExam {

	public static void main(String[] args) {
		
		// 자식이 부모가 될 때
		Parent1_1_1 p111 = new Parent1_1_1();

		Parent1_1 p11 = null;
		p11 = (Parent1_1)p111;
		p11 = p111; // 자식이 부모타입으로 변할 때
					// 형 변환 연산자 생략 가능
		
		Parent1 p1 = null;
		p1 = p11;
		p1 = p111;
		
		Parent1 p = new Parent1_1_1();
		
		////////////////////////////////////////
		
		// 부모가 자식이 될 때
		
		Parent1_2 p12 = new Parent1_2();
		
		Parent1 pp1 = p12;
		
		// 부모가 자식이 될 때는
		// 형 변환 연산자 생략 불가능
		Parent1_2 pp12 = (Parent1_2)pp1;
		
		// 런타임 runtime 오류 : 실행해봐야 아는 것
		Parent1_1 pp11 = (Parent1_1)pp1; 
		
		String a = null;
		System.out.println( a.length() );
		
	}

}
