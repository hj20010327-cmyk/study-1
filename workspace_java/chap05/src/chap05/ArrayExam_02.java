package chap05;

public class ArrayExam_02 {

	public static void main(String[] args) {
		
		/*
		 *  배열 array
		 *  
		 *  한번에 여러 변수를 만드는 방법
		 *  같은 타입만 선언할 수 있음
		 *  생성할 때 전체 크기를 지정해줘야 함
		 *  생성된 여러 변수들은 index로 관리한다
		 *  	 index는 0번부터 시작
		 */
		
		// 선언 방법
		int[] a1;   // java 스타일
		int [] a2;
		int a3 [];  // c 스타일
		
		// 배열 변수는 참조 타입이라서 null을 넣을 수 있다
		a1 = null;
		
		int score_0 = 90;
		int score_1 = 85;
		int score_2 = 70;
		
		/*
		 *  첫번째 [] : int[]
		 *  	 int만으로 구성된 배열 변수 타입이다
		 *  두번째 [] : new int[30]
		 *  	 배열의 크기 즉 한번에 만들 변수의 개수
		 *  세번째 [] : score[0]
		 *  	 만들어진 변수 중에서 몇번째인가?
		 *		 index는 0부터 시작한다
		 */
		
		// 배열을 선언하는 첫번째 방법
		int[] score = new int[30];
		score[0] = 90;
		score[1] = 85;
		score[2] = 70;
//		score[3] ]= null;
		
		System.out.println("score[0]: " + score[0]);
		
		// java.lang.ArrayIndexOutOfBoundsException: Index 50 out of bounds for length 30
		// 길이가 30이라서 0~29까지 가능한데 50은 범위를 벗어났다
//		score[50] = 2;
		
		String[] str = new String[3];
		System.out.println("str[0]: "+str[0]);
		System.out.println("score[5]: "+ score[5]);
		
//		int a;
//		System.out.println(a);
		
		// 배열 생성 후 기본값
		// 0, false, null로 초기화 됨
		
		// 배열을 선언하는 두번째 방법
		// 넣을 값을 모두 알고 있는 경우
		int[] i1 = new int[] {90, 85, 70};
		System.out.println("i1[1]: " + i1[1]);
		
		// 선언과 초기화를 따로 할 수 있다
		int[] i2 = null;
		i2 = new int[] {90, 85, 70};
		
		// 배열을 선언하는 세번째 방법
		// 선언가 동시에 초기화 하는 경우만 사용가능
		// new int[]를 생략할 수 있다
		int[] i3 = {90, 85, 70};
//		i3 = {90, 85, 70};
		
		int sum = 0;
//		sum = sum + i3[0];
//		sum = sum + i3[1];
		
//		for(int i=0; i<=2)
		for(int i=0; i<3; i++) {
			sum += i3[i];
		}
		System.out.println("총 합: "+ sum);
		System.out.println("평균: " + (sum/3.0));
		
		sum = 0;
		System.out.println("배열의 길이: "+ i3.length);
		for(int i=0; i<i3.length; i++) {
			sum += i3[i];
		}
		
		
		// 5개 변수를 한번에 만들기
		// 5개 크기의 int 배열 만들기
		int[] a5 = new int[5];
		// 첫번째 변수에 1 넣기
		a5[0] = 1;
		// 두번째 변수에 2 넣기
		a5[1] = 2;
		
		
		// 문제 1
		// 첫번째 반복문에서
		// 		10개의 변수에 각 1~10 값 담기
		// 두번째 반복문에서
		// 		모든 값을 순서대로 출력
		
		int[] a6 = new int[10];
		for (int i=0;i<a6.length;i++) {
			a6[i] = i+1;
		}
		for (int i=0;i<a6.length;i++) {
//			a6[i] = i+1;
			System.out.println(a6[i]);
		}
		
//		a10.length = 4; // 변경 불가
		
		// 혹시 몰라서 출력
		System.out.println("args: " +args);
		if(args != null) {
			System.out.println(args.length); // args의 개수 출력
			for (int i=0; i<args.length; i++) {
				System.out.println(args[i]); // args의 모든 내용 출력
			}
		}
		
		// 문제 2
		// 7,12,8을 순서대로 저장한 배열이 있을때
		// 다른 배열에도 7,12,8으로 저장되게 복사
		// 단 b = a 안됨
		System.out.println("------ 문제2-------");
		int[] q = {7,12,8};
		int i =0;
		for(i=0; i<q.length; i++) {
			System.out.println(q[i]);			
		}
		int[] q1 = new int[q.length];
		for(i =0; i<q.length; i++) {
			q1[i] = q[i];
			System.out.println(q1[i]);	
		}
		
		// 문제 3
		// 7,12,8을 순서대로 저장한 배열이 있을때 
		// 다른 배열에 거꾸로 8, 12, 7로 저장되게
		System.out.println("------ 문제3 -------");
		int[] q2 = new int[q.length];
		for(i=0; i<q.length; i++) {
			
		
		}
		
		
		
		
//		int[] q2 = new int[q.length];
//		for(i=q.length-1; i>=0; i--) {
//			q2[i] = q[i];
//			System.out.println(q2[i]);
//		}
		
		// 문제4
		// {3,4,7,5,1,4,6}
		// 4-1 배열에서 홀수의 개수 구하기
		System.out.println("-----문제4-1------");
		int[] a34 = {3,4,7,5,1,4,6};
		int cnt = 0;
		for(i=0; i<a34.length; i++) {
			if (a34[i]%2 == 1) {
				cnt++;
				System.out.println(a34[i]);
			}
		}
		System.out.println("개수: " + cnt);
		
		// 4-2 4보다 큰 수의 개수 구하기
		System.out.println("----- 문제4-2-------");
		int[] a33 = {3,4,7,5,1,4,6};
		cnt = 0;
		String str1 = "";
		for(i=0; i<a33.length; i++) {
			if(a33[i]>4) {
				cnt++;
				System.out.println(a33[i]);
			}
		}
		System.out.println("개수: " + cnt);
		
		// --- 응용(멘탈챙겨) ---
		// 문제 5
		/*
		 * 마라톤에 5명의 선수가 참여했음
		 * 선수들은 1번부터 5번까지 등번호가 있음
		 * 대회가 끝났을 때 완주하지 못한 선수를 찾으시오
		 * 완주 목록 {2,4,5,1}
		 */
		System.out.println("-----문제 5------");
		int[] mar = {1,2,3,4,5};
		int[] mar1 = {2,4,5,1};
		
		
		
		
		// 문제 6
		// {3,4,7,5,1,4,6}
		// 여기서 가장 큰 수 찾기
		
	}

}
