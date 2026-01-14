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
			q2[i] = q1[q1.length - 1 - i];
		}
		for(i=0; i<q2.length; i++) {
			System.out.println(q2[i]);
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
		int sum1 = 0;
		int sum2 = 0;
		int[] mar = {1,2,3,4,5};    // 두 배열중에 하나만 없으니까 두 배열에 있는 수 다 더해서 빼면 남은 수 나옴
		int[] mar1 = {2,4,5,1};
		for (i =0; i<mar.length; i++) {
			sum1 += mar[i];  // mar의 모든 수 더하기
		}
		for (i=0; i<mar1.length; i++) {
			sum2 += mar1[i]; // mar1의 모든 수 더하기
		}
		int answer = sum1 - sum2;    
		System.out.println("완주 하지 못한 선수 등번호: " + answer + "번");
		
		System.out.println("-------다른방법 이게 더 맞는듯..?-------");
		int j=0;
		for (i=0; i<mar.length; i++) { // mar에서 한 명씩 비교
			boolean x= false;		// x에다가 false를 한명씩 비교할 때마다 주고
			for (j=0; j<mar1.length; j++) { // mar의 한명과 mar1의 모든 인원 비교
				if (mar[i] == mar1[j]) { // mar[i]의 값과 mar1[j]의 값이 같으면
					x = true;			// boolean 타입인 변수 x를 참으로 변경
					break;
				}						// 같으면 x는 true가 되니 mar[i]에서 하나남은 3은 false
			}
			if (x != true) {  	// 그럼 x가 true가 아닌것은 3만 남으니 조건식 써서 mar[i] 출력 
				System.out.println("완주 하지 못한 선수 등번호: " +mar[i] + "번");  // 다른 수들은 같은게 있으니까 안나옴
			}
		}
		System.out.println("------문제5번 이름으로--------");
		String sum3 = "";
		String sum4 = "";
		String[] mar3 = {"용상", "령", "민호","세정","현일"};    // 두 배열중에 하나만 없으니까 두 배열에 있는 수 다 더해서 빼면 남은 수 나옴
		String[] mar4 = {"령","세정","현일","용상"};
		for (i=0; i<mar3.length; i++) { // mar3에서 한 명씩 비교
			boolean x= false;		// x에다가 false를 한명씩 비교할 때마다 주고
			for (j=0; j<mar4.length; j++) { // mar3의 한명과 mar4의 모든 인원 비교
				if (mar3[i].equals(mar4[j])) { // mar3[i]의 값과 mar4[j]의 값이 같으면
					x = true;			// boolean 타입인 변수 x를 참으로 변경
					break;
				}						// 같으면 x는 true가 되니 mar3[i]에서 하나남은 3은 false
			}
			if (x != true) {  	// 그럼 x가 true가 아닌것은 3만 남으니 조건식 써서 mar3[i] 출력 
				System.out.println("완주 하지 못한 선수: " +mar3[i]);  // 다른 수들은 같은게 있으니까 안나옴
			}
		}
		
		
		// 문제 6
		// {3,4,7,5,1,4,6}
		// 여기서 가장 큰 수 찾기
		System.out.println("--------문제 6 --------");
		// 하나하나 비교를 해야되나?
		int[] big = {3,4,7,5,1,4,6};
		// 하나씩 비교 해보면 big[0],big[1] 큰수 남기고
		// big[1]이 남고 big[1] big[2] 또 큰수가 남고
		// 이러면 big[i]  big[i+1] 둘 중에 큰게 남아야돼
		// if? big[1] < big[2] big[2]
//		int result = 0; // 이러면 그냥 0인데?
//		for(i=0; i<big.length; i++) {
//			if(big[i]>big[i+1]) {			
//				result = big[i];
//			}
//		}
//		System.out.println(result);
		
		
		int result = big[0];  //처음 값이랑 계속 비교할수 있네
		for(i=0; i<big.length; i++) {
			if(big[i]>result) {
				result = big[i]; // 앞에 값 보다 뒤에값이 크면 계속 덮어쓰기
			}
		}
		System.out.println("가장 큰 수: " + result);
		
	}

}
