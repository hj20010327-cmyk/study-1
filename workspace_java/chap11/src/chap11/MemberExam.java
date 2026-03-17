package chap11;

public class MemberExam {

	public static void main(String[] args) {

		Member m1 = new Member("이름", 3);
		Member m2 = new Member("이름", 3);
		
		System.out.println( m1 == m2 );
		System.out.println( m1.equals(m2) );
		
		System.out.println(m1.toString());
	}

}
