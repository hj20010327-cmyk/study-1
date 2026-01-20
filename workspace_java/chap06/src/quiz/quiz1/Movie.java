package quiz.quiz1;

public class Movie {
	
	String title;
	int year;
	
	void setTitle(String title) {
		this.title = title;
	}
	
	String getTitle() {
		return this.title;
	}
	
	void setYear(int year) {
		this.year = year;
	}
	int getYear() {
		return this.year;
	}
	
	String getTitle2() {
		return this.title+"2";
	}
	
	
//	@Override
//	public String toString() {
//		return "Movie [title=" + title + ", year=" + year + "]";
//	}
	
	
}
