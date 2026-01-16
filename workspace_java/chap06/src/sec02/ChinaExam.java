package sec02;

public class ChinaExam {

	public static void main(String[] args) {
		China one = new China();
		System.out.println("가게명: " + one.name);
		System.out.println("주소: " + one.address);
		System.out.print("메뉴: ");
		for(int i=0; i<one.menus.length; i++) {
			System.out.print((i+1)+". " + one.menus[i]);	
		}
		System.out.println();
		China two = new China();
		two.name = "용선생 평택점";
		System.out.println("가게명: " + two.name);
		two.address = "평택";
		System.out.println("주소: " + two.address);
		two.menus[0] = "팔보채";
		two.menus[1] = "잡채밥";
		two.menus[2] = "유린기";
		System.out.print("메뉴: ");
		for (int i=0; i<two.menus.length; i++) {
			System.out.print((i+1)+". " +two.menus[i]);
		}
		System.out.println();
		
		
		
	}

}
