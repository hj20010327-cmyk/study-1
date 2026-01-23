package test1;

import java.util.Scanner;

public class CafeExam {

	public static void main(String[] args) {

		// 생산하려는 커피 종류를 선택할 수 있게
		
		int menu = -1;
		int coffee = -1;
		int noncoffee = -1;
		int pay = 0;
		int count = 0;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		String cof1 = "아아";
		int cof1p = 3500;
		String cof2 = "따아";
		int cof2p = 3000;
		String noncof1 = "아이스티";
		int noncof1p = 3000;
		String noncof2 = "에이드";
		int noncof2p = 4000;
		
		do {
			System.out.println("메뉴를 고르세요");
			System.out.println("1. 커피 2. 논커피 0.종료");
			Scanner scan = new Scanner(System.in);
			menu = scan.nextInt();
			if(menu == 1) {
				System.out.println("커피를 선택하셨습니다 종류를 골라주세요");
				System.out.println("1."+ cof1 + ": " + cof1p + "원 "
						+ "2. "+cof2 + ": " + cof2p + "원 0. 처음메뉴로");
				coffee = scan.nextInt();
				do {
					if (coffee == 1) {
						System.out.println(cof1 + "를 선택하셨습니다"+cof1p +"원입니다");
						pay += cof1p;
						count++;
						break;
					} else if (coffee == 2) {
						System.out.println(cof2 + "를 선택하셨습니다"+cof2p +"원입니다");
						pay += cof2p;
						count1++;
						break;
					} else if (coffee == 0) {
						System.out.println("처음메뉴로 돌아갑니다");
					} else {
						System.out.println("다시 선택해주세요");
						break;
					}
				} while (coffee != 0);
			} else if (menu == 2) {
				System.out.println("논커피를 선택하셨습니다 종류를 골라주세요");
				System.out.println("1."+ noncof1 + ": " + noncof1p + "원 "
						+ "2. "+noncof2 + ": " + noncof2p + "원 0. 처음메뉴로");
				noncoffee = scan.nextInt();
				do {
					if (noncoffee == 1) {
						System.out.println(noncof1 + "를 선택하셨습니다 "+noncof1p +"원입니다");
						pay += noncof1p;
						count2++;
						break;
					} else if (noncoffee == 2) {
						System.out.println(noncof2 + "를 선택하셨습니다 "+noncof2p +"원입니다");
						pay += noncof2p;
						count3++;
						break;
					} else if (noncoffee == 0) {
						System.out.println("처음메뉴로 돌아갑니다");
					} else {
						System.out.println("다시 선택해주세요");
						break;
					}
				} while (noncoffee != 0);
			}
			
			
		} while(menu != 0);
		System.out.println(cof1+ " "+ count + "잔 "
				+cof2+ " "+ count1 + "잔 "
				+noncof1+ " "+ count2 + "잔 "
				+noncof2+ " "+ count3 + "잔 "
				+"총 "+ pay + "원입니다");
	}

}
