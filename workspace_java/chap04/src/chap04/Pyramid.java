package chap04;

import java.util.Scanner;

public class Pyramid {

	public static void main(String[] args) {
		// 피라미드 만들기
//		---*---  1           4줄일땐  3 1   5줄일땐  4 1
//		--***--  3 * =2*line-1        2 2			 3 2
//		-*****-  5                    1 3			 2 3
//	    *******  7					  0 4			 1 4
//											         0 5 						
//	         										얘네 둘 합 = 줄 개수	minus + line = n	
//		이걸 어떻게 만들까					4줄이라면       첫번쨰줄일때		3  +  1 = 4	 minus는 3개
//		4줄이 반복  															 2  +  2 = 4   minus가 n-line일때 멈춰야됨
//		- 가 반복 되는데 그다음 줄에는 *가 늘어남 (2개씩) 2n-1 
//		- 반복되고 * 쓰고 - 다시 반복 => 반복문 3개 써야됨	
//		
//		
//		
		int line;
		int star;
		int minus;
		int n = 4;
		star = 1;
		for (line= 1; line<= n; line++) {
			for (minus =1; minus <= n - line ; minus++ ) {
				System.out.print("-");
			}
			for (star = 1; star <= 2*line -1; star++ ) {
				System.out.print("*");
			}
			for (minus =1; minus <= n - line ; minus++ ) {
				System.out.print("-");
			}
			System.out.println();
		}
		for (line= n-1; line>= 1; line--) {
			for (minus =1; minus <= n - line ; minus++ ) {
				System.out.print("-");
			}
			for (star = 1; star <= 2*line -1; star++ ) {
				System.out.print("*");
			}
			for (minus =1; minus <= n - line ; minus++ ) {
				System.out.print("-");
			}
			System.out.println();
		}
		
		
		// border 치기
		// line  minus  n
		// 피라미드랑 비슷?
//		
		// ***** <  세로= border1 가로= border2 
		// *   *
		// *   *
		// *   *
		// *****
		//
		int border1;
		int border2;
		border1= 5;
		border2= 5;
		for (line= 1; line <= border1; line++) {
			for (star = 1; star <= border2; star++) {
				if (star%border1 == 0) {
				System.out.println("*");
				} else {
					System.out.print("*");
				}
				
			}
			
		}
		System.out.println("--------------------");
		for (line= 1; line <= border1; line++) {
			for (star = 1; star <= border2; star++) {
				if (line == 1 || line == border1 || star == 1 || star == border2 ) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
				
			}
			System.out.println();  // ** 한줄 끝나면 줄바꿈 계속 빼먹음
		}
		 // 1단계
        // +++++
        System.out.println("----1단계----");
		int x;
		int u = 5;
        for (x=1; x<=u; x++) {
        	System.out.print("+");
        }
        System.out.println();
        // 2단계
        // +_+_+_+_+_
        System.out.println("----2단계----");
        int y;
        for (x=1; x<=u; x++) {
        	System.out.print("+");
        	for(y=1; y<=1; y++) {
        		System.out.print("-");
        	}
        }
        System.out.println();
        // 3단계
        // +++++
        // +++++
        // +++++
        System.out.println("----3단계----");
        
        for (x=1; x<=3; x++) {
        	for (y=1; y<=5; y++) {
        		System.out.print("+");
        	}
        	System.out.println();
        }
        	
        // 4단계
        // 11111
        // 22222
        // 33333
        // 44444
        // 55555
        System.out.println("----4단계----");
        
        for (x=1; x<=u; x++) {
        	for (y=1; y<=5; y++) {
        		System.out.print(x);
        	}
        	System.out.println();
        }
        
        
        // 5단계
        // 1
        // 22
        // 333
        // 4444
        // 55555
        System.out.println("----5단계----");
        y=1;
        for (x=1; x<=u; x++) {
        	for (y=1; y<=x; y++) {
        		System.out.print(x);
        	}
        	System.out.println();
        }
        
        // 6단계
        // +
        // ++
        // +++
        // ++++
        // +++++
        System.out.println("----6단계----");
        for (x=1; x<=u; x++) {
        	for (y=1; y<=x; y++) {
        		System.out.print("+");
        	}
        	System.out.println();
        }
        
        
        // 7단계
        // 11111
        // 2222
        // 333
        // 44
        // 5
        System.out.println("----7단계----");
        for (x=1; x<=u; x++) {
        	for(y=u; y>=x; y--) {
        		System.out.print(x);
        	}
        	System.out.println();
        }
        // x+1  y-1
        // 8단계
        // +____
        // ++___
        // +++__
        // ++++_
        // +++++
        System.out.println("----8단계----");
        int z;
        for (x=1; x<=5; x++) {
        	for (y=1; y<=x; y++) {
        		System.out.print("+");
        	}
        	for (z=0; z<=5-y; z++) {
        		System.out.print("_");
        	}
        	System.out.println();
        }
        
        // 9단계
        // ____+
        // ___++
        // __+++
        // _++++
        // +++++
        System.out.println("----9단계----");
        for (x=1; x<=u; x++) {
        	for (y=1; y<=u-x; y++) {
        		System.out.print("_");
        	}
        	for (z=0; z<=u-y; z++) {
        		System.out.print("+");
        	}
        	System.out.println();
        }
        
        // 10단계
        // ____+
        // ___+++
        // __+++++
        // _+++++++
        // +++++++++
        System.out.println("----10단계----");
        u=5;
        for (x=1; x<=u; x++) {
        	for (y=1; y<=u-x; y++) {
        		System.out.print("_");
        	}
        	for (z=1; z<=2*x-1; z++) {
        		System.out.print("+");
        	}
        	System.out.println();
        }
        // 11단계
        // ____+____
        // ___+++___
        // __+++++__
        // _+++++++_
        // +++++++++
        System.out.println("----11단계----");
        for (x=1; x<=u; x++) {
        	for (y=1; y<=u-x; y++) {
        		System.out.print("_");
        	}
        	for (z=1; z<=2*x-1; z++) {
        		System.out.print("+");
        	}
        	for (y=1; y<=u-x; y++) {
        		System.out.print("_");
        	}
        	System.out.println();
        }
        
        // 12단계
        // 입력 받은 줄 수 대로 출력
        System.out.println("----12단계----");
        
        Scanner scan=new Scanner(System.in);
        System.out.print("수를 입력해주세요 =>");
        int w = scan.nextInt();
        for (x=1; x<=w; x++) {
        	for (y=1; y<=w-x; y++) {
        		System.out.print("_");
        	}
        	for (z=1; z<=2*x-1; z++) {
        		System.out.print("+");
        	}
        	for (y=1; y<=w-x; y++) {
        		System.out.print("_");
        	}
        	System.out.println();
        }
        
        
        
	}

}
