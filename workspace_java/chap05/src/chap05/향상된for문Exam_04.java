package chap05;

public class 향상된for문Exam_04 {

	public static void main(String[] args) {
		
		int[] scores = {1,2,3,4,5};
		
		int s1 = scores[0];
		
		// 향상된 for문
		// 하나씩 꺼내서 담을 변수 : 반복할 수 있는 것
		for(int s : scores) {
			System.out.println(s);
		}
		
		// 전통적인 for문
		for(int i=0; i<scores.length; i++) {
			int s = scores[i];
			System.out.println(s);
		}
		
	}

}
