package chap05;

public class 다차원배열Exam_03 {

	public static void main(String[] args) {
		
		int a0 = 5;
		int a1 = 15;
		int a2 = 34;
		
		// int를 여러개 만들기
		int[] b0 = new int[3];
		// b의 첫번째 변수에 a0 넣기
		// 두번째 변수에 a1 넣기
		b0[0] = a0;
		b0[1] = a1;
		b0[2] = a2;
		
		int[] b1 = new int[3];
		b1[0] = a0+1;
		b1[1] = a1+1;
		b1[2] = a2+1;
		
		// b0와 b1을 배열로 만들기
		int[][] c0 = new int[2][3];
		c0[0] = b0;
		c0[1] = b1;
		
		System.out.println( c0[0][1]);
		
		System.out.println("c0.length: " + c0.length);
		System.out.println("b1의 길이: " + c0[1].length);
		
		// b1이 10개짜리라도 c0[1]에서 잘 동작한다??
		
		int[][] c1 = new int[][] { {1,2,3}, new int[] {4,5,6}}; 
		int[][] c2 = {
						{1,2,3},
						{4,5,6,7}
					};
		int[][] arr = new int[2][];
		// 가장 바깥 차원은 꼭 있어야 한다
		// heap에 공간은 만들어야 해서
		// 모두 null로 초기화
		// 		참조 공간만 만들고 실제 배열은 나중에 만들기
		// 가변(비정형) 배열
		// 공간을 연속으로 잡지 않아서 고성능에서는 불리할 수 있다
		System.out.println(c0);
		System.out.println(c0[0]);
		System.out.println(c0[0][0]);
		
		///////////////////////////////////
		System.out.println("---------------------------");
		
		int k1 = 10;
		int k2 = k1;
		System.out.println("k2: " +k2);
		k1 = 5;
		System.out.println("k2: " +k2);
		
		int[] d1 = {1,2,3};
		// 얕은 복사 ( call by reference )
		// = 기호는 stack의 값(또는 주소)만 복사
		// 값을 변경하는 경우 원본도 바뀐다
		int[] d2 = d1;
		
		System.out.println("d2[0]: "+ d2[0]);
		d1[0] = 4;
		System.out.println("d2[0]: "+ d2[0]);
		
		System.out.println("d1[2]: "+ d1[2]);
		d2[2] = 40;
		System.out.println("d1[2]: "+ d1[2]);
		
		// 깊은 복사 ( call by value )
		int[] d3 = new int[d1.length];
		for(int i=0; i<d1.length; i++) {
			d3[i] = d1[i];
		}
		
		// 문제 1
		// 꼭 반복문 쓰기
		// 1~5, 11~15, 101~105 를 저장하는 2차원 배열을 만드시오
		// 그리고 거기말고 다른 반복문으로 모두 출력하시오
		
		int[] x = new int[5];
		int[] y = new int[5];
		int[] z = new int[5];
		int i;
		int j;
		int h;
//		{1,2,3,4,5},{11,12,13,14,15},{101,102,103,104,105}
		for(i=0; i<x.length; i++) {
			x[i] = i+1;
		}
		for(j=0; j<y.length; j++) {
			y[j] = j+11;
		}
		for(h=0; h<z.length; h++) {
			z[h] = h+101;
		}
		int[][] x1 = new int[3][5];
		x1[0] = x;
		x1[1] = y;
		x1[2] = z;
		for(int t=0; t<x1.length; t++) {
			for(i=0; i<x1[t].length; i++) {
				System.out.println(x1[t][i]);
			}
		}
				
//      gpt 연습문제: 3차원 배열 기본 사용
//      다음 조건을 만족하는 자바 프로그램을 작성하세요.
//      조건
//      크기가 [2][3][4] 인 3차원 정수 배열을 선언한다.
//      배열의 모든 요소에 1부터 시작하는 정수를 순서대로 저장한다.
//      (예: 1, 2, 3, 4, …)
//      3중 반복문을 사용하여 배열에 저장된 모든 값을 출력한다.
//      출력 형식은 다음과 같이 한다.
//      [0][0][0] = 1
//      [0][0][1] = 2
//      ...
//      [1][2][3] = 24
		
		int[][][] p = new int[2][3][4];
		int n = 1;
		for(i=0; i<p.length; i++) {
			for (j=0; j<p[i].length; j++) {
				for (h=0; h<p[i][j].length; h++) {
					p[i][j][h] = n;
					System.out.printf("[%d][%d][%d] = %d" , i, j, h, n);
					System.out.println();
					n++;
				}
			}
		}
		
		
	}

}
