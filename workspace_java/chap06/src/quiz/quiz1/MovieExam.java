package quiz.quiz1;

public class MovieExam {

	public static void main(String[] args) {

		Movie m1 = new Movie();
		
		m1.setTitle("기생충");
		String title1 = m1.getTitle();
		m1.setYear(2022);
		int year1 = m1.getYear();
		System.out.println("제목: " + title1 + " 개봉년도: " + year1);
		
//		Movie m2 = new Movie();
		m1.setTitle("귀멸의칼날");
		String title2 = m1.getTitle();
		m1.setYear(2025);
		int year2 = m1.getYear();
		System.out.println("제목: " + title2 + " 개봉년도: " + year2);
		
		String title3 = m1.getTitle2();
		System.out.println("제목: " + title3 + " 개봉년도: " + year2);
	}

}
