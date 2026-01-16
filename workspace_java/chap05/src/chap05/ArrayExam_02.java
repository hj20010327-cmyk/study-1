package chap05;

import java.util.Scanner;

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
		
		
		// 문제 7
		// {3,4,7,5,1,4,6}
		// 여기서 두번째 큰 수 찾기
		System.out.println("-------문제7--------");
		int two = 0;
		for(i=0; i<big.length; i++) {
			if(big[i]<result && big[i]>two) {
				two = big[i];
			}
		}
		System.out.println("두번째 큰 수: " + two);
		// 문제 8
		// 오른쪽으로 한칸 씩 밀기 
		// (왼쪽은 0으로 채우기)
		// 예:
		// 1라운드: {3, 4, 7, 5, 1, 4, 6}
        // 2라운드: {0, 3, 4, 7, 5, 1, 4}	// 6을 0으로 만들고 big[0]으로 보냄
											// big[0]이 big[1]로 이동
        // 3라운드: {0, 0, 3, 4, 7, 5, 1}
		
		// 1라운드 3,4,7,5,1,4,6
		System.out.println("-------문제 8---------");
		for(j=1; j<=8; j++) {
			System.out.print(j+ "라운드: {");
			for(i=0; i<big.length; i++) {
				if(i == big.length-1) {
					System.out.print(big[i]);
				} else {
					System.out.print(big[i]+ ", ");
				}
			}
			System.out.println("}");
			for(i=big.length-1; i>0; i--) {   //big[0] = 0 big[1] = 3
				big[i] = big[i-1];
			}
			big[0] = 0;
		}
		
		// 문제 9
		// 오른쪽으로 한칸 씩 밀기
		// 맨 끝 값은 맨 처음으로 보내기
		// 예: 
        // 1라운드: {3, 4, 7, 5, 1, 4, 6}
        // 2라운드: {6, 3, 4, 7, 5, 1, 4}
        // 3라운드: {4, 6, 3, 4, 7, 5, 1}
		System.out.println("-------문제 9--------");
		int[] big1 = {3,4,7,5,1,4,6};
		int p;
		p=0;
		for(j=1; j<=8; j++) {
			System.out.print(j+ "라운드: {");
			for(i=0; i<big1.length; i++) {
				if(i == big1.length-1) {
					System.out.print(big1[i]);
				} else {
					System.out.print(big1[i]+ ", ");
				}
			}
			System.out.println("}");
			p = big1[big1.length-1];
			for(i=big1.length-1; i>0; i--) {   //big[0] = 0 big[1] = 3
				big1[i] = big1[i-1];
			}
			big1[0] = p;
		}
		
		
		// 문제 10
		// 임시 비밀번호 8자리
		// 10-1 : 숫자만
		System.out.println("--------문제10--------");
		int[] w = new int[8];
//		System.out.println(g);
		for(i=0; i<w.length; i++) {
			double u = Math.random();
			double u1 = u*10;
			int g = (int)u1;
			w[i] = g;
		}
		for(j=0; j<w.length; j++) {
			System.out.print(w[j]);
		} 
		System.out.println();
		// 10-2 : 소문자만
		char[] w1 = new char[8];
		
		for(i=0; i<w1.length; i++) {
			double o = Math.random();
			double o1 = o*26;
			int o12 = (int)o1+97;
			char v = (char)o12;
			w1[i]= v;
			System.out.print(w1[i]);
		}
		System.out.println();
		// 10-3 : 숫자2개 이상, 대/소문자 각 1개 이상 비밀번호 8자리
//		double uu = Math.random();
//		double uu1 = uu*5;			
//		int gg = (int)uu1+2;
//		int[] ww = new int[6];
//		for(i=0; i<ww.length; i++) {
//			double u = Math.random();
//			double u1 = u*10;
//			int g = (int)u1;
//			ww[i] = g;
//		}
//		for(j=0; j<ww.length; j++) {
//			if(ww.length>=2) {
//				System.out.print(ww[j]);
//			}
//		}
//		
////		double dd = Math.random();
////		double dd1 = dd*5;
////		int ii1 = (int)dd1+1;
//		char[] ch  = new char[1];
//		
//		for(i=0; i<ch.length; i++) {
//			double o = Math.random();
//			double o1 = o*26;
//			int o12 = (int)o1+97;
//			char v = (char)o12;
//			w1[i]= v;
//			System.out.print(w1[i]);
//		}
//		char[] bigch = new char[1];
//		for (i=0; i<bigch.length; i++) {
//			double oo = Math.random();
//			double oo1 =  oo*26;
//			int oo2 = (int)oo1+65;
//			char vv = (char)oo2;
//			bigch[i] = vv;
//			System.out.print(bigch[i]);
//		}
		
		char[] password = new char[8];
		int rand = 0;
		for(i=0; i<2; i++) {  // 숫자 두개 일단 생성
			password[rand] = (char)((int)(Math.random()*10) + 48);
			rand++;
		}
		password[rand]= (char)((int)(Math.random()*26)+97);  // 소문자 하나 생성
		rand++;
		password[rand] = (char)((int)(Math.random()*26)+65);  // 대문자 하나 생성
		rand++;
		
		for(j=rand; j<password.length; j++) {	// 남은 자리 랜덤 생성
			int tp = (int)(Math.random()*3);  // 0~2까지 랜덤으로 뽑아서
			
			if(tp == 0) {  			// tp가 0이면 숫자 생성
				password[j] = (char)((int)(Math.random() * 10) + 48);
			} else if (tp == 1) {	// tp가 1이면 소문자 생성
				password[j] = (char)((int)(Math.random() * 26) + 97);
			} else {				// tp가 2면 대문자 생성
				password[j] = (char)((int)(Math.random() * 26) + 65);
			}
		}
		
		for (i=0; i<password.length; i++) {		// 나온 배열들 섞기
			int k = (int)(Math.random()* password.length);	
			// 변수 k를 배열 수가 랜덤으로 나오게 저장
			char han = password[i];		// i일때 변수로 저장
			password[i] = password[k];	// 랜덤으로 나온 한개를 i번째로 저장
			password[k] = han;			// 변수로 저장했던 i번째를 k번째로 저장
		}
		
		System.out.print("임시 비밀번호: ");
		for (i=0; i<password.length; i++) {
			System.out.print(password[i]);
		}
		
		
		System.out.println();
		// 문제 11
		// 자리가 10개 있는 소극장 예약 시스템
		// 자리 번호는 1~10번까지 번호의 자리가 있다
		// 메뉴 : "1.예약 2.모든 좌석 현황 3.잔여 좌석 0.종료"
		// 조건1 : 예약이 가능하다면 "n번 자리 예약되었습니다"
		// 조건2 : 예약이 되어있다면 "이미 예약 되어 있습니다"
		System.out.println("--------문제 11----------");
		int[] small = new int[10];
		for(i=0; i<small.length; i++) {
			small[i] = i+1;
		}
		int[] small1 = new int[10];
		for(i=0; i<small1.length; i++) {
			small1[i] = i+1;
		}
		
		
		int x = 0;
		int x1 = 0;
		do {
			System.out.println("메뉴: 1.예약 2.모든 좌석 현황 3.잔여 좌석 0.종료");
			Scanner scan = new Scanner(System.in);
			x = scan.nextInt();
			int reser = 0;
			int seat = 0;
			if(x==1) {
				System.out.println("선택> " + x);
				for(i=0; i<small1.length; i++) {
				System.out.print("["+small1[i]+"] ");
				}
				System.out.println();
				Scanner scan1 = new Scanner(System.in);
				x1 = scan1.nextInt();
				for(i=0; i<small.length; i++) {
				if(x1==small1[i]) {
					if(small[i]!= reser) {
						System.out.print(x1 + "번 자리가 예약 되었습니다");
						small[i] = reser;
					} else {
						System.out.print("이미 예약된 자리입니다");
					}
					}
				}
				System.out.println();
			} else if (x==2) {
				System.out.println("선택> " + x + "\n 숫자가 0인 자리는 예약이 된 자리입니다");
				System.out.print("모든 좌석 현황: ");
				for(i=0; i<small.length; i++) {
				System.out.print("["+small[i]+"] ");
				}
				System.out.println();
			} else if (x==3) {
				System.out.print("잔여 좌석: ");
				for(i=0; i<small.length; i++) {
					if(small[i] != 0) {
						System.out.print("["+small[i]+"] ");
					}
				}
				System.out.println();
			}
		} while(x!=0);
		System.out.println("종료합니다");
		
		// 문제 12
		// 로또 번호 6개 배열에 저장
		// 단, 중복 없이!
		System.out.println("---------문제12----------");
		int[] lotto = new int[6];
		int result1 = lotto[0];
		for(i=0; i<lotto.length; i++) {
			double u = Math.random();
			double u1 = u*1000000;
			int g = (int)u1%46+1;
//			lotto[i] = g;   // 이게 중복이 안되야돼
//			for(j=0; j<lotto.length; j++) {
//				if(lotto[j] == l)
//			}
			int l = 0;
			boolean boo = true;
			while(boo) {
				if(g == lotto[l]) {
					u = Math.random();
					u1 = u*1000000;
					g = (int)u1%46+1;
//					System.out.print("걸림");
				} else {
					l++;
					
				}
				if(l == lotto.length-1) break;
			}
			lotto[i] = g;
			System.out.print(g + " ");
		}
		System.out.println();
		
		// 문제 13
		// 주차장에 
		// 0: 주차되어있음 
		// 1: 비어있음
		/*
		 * {
		 * 		{0, 0, 0, 0},	// 1층
		 * 		{0, 0, 0, 1},	// 2층
		 * 		{1, 0, 1, 0},
		 * 		{1, 0, 1, 1},
		 * 		{1, 1, 1, 1}
		 * }
		 */
		// 13-1 : 2층에 주차된 차량 수 출력
		System.out.println("---------문제13-1----------");
		int[] f1 = {0, 0, 0, 0};
		int[] f2 = {0, 0, 0, 1};
		int[] f3 = {1, 0, 1, 0};
		int[] f4 = {1, 0, 1, 1};
		int[] f5 = {1, 1, 1, 1};
		
		int cnt1 = 0;
		
		
		int[][] parking = {f1,f2,f3,f4,f5};
		for(i=0; i<parking.length; i++) {
			for(j=0; j<parking[i].length; j++) {
				if(i==1 && parking[i][j] == 0) {
					cnt1++;
				}
			}
		}
		System.out.println("2층에는 " + cnt1 + "대가 주차되어있습니다");
		// 13-2 : 전체 남은 자리 수 출력
		System.out.println("----------문제 13-2-----------");
		cnt1 =0;
		for(i=0; i<parking.length; i++) {
			for(j=0; j<parking[i].length; j++) {
				if(parking[i][j] == 1) {
					cnt1++;
				}
			}
		}
		System.out.println("모든 층에 주차자리가 "+ cnt1 + "자리 남았습니다");
		
		//문제 13 랜덤으로 돌려보기
		cnt1 = 0;
		int[][] plot = new int[5][4];
		for(i=0; i<plot.length; i++) {
			for(j=0; j<plot[i].length; j++) {
				double park1 = Math.random();
				double park3 = park1*2;
				plot[i][j] = (int)park3;
			}
		}
		for(i=0; i<plot.length; i++) {
			for(j=0; j<plot[i].length; j++) {
				System.out.print("{" + plot[i][j] + "}");
			}
			System.out.println();
		}
		System.out.println();
		for(i=0; i<plot.length; i++) {
			for(j=0; j<plot[i].length; j++) {
				if(plot[i][j] == 1) {
					cnt1++;
				}
			}
		}
		System.out.println(cnt1);
		
		
	}

}
