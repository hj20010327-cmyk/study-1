package quiz.quiz1;

public class Song {
	
	String title;
	String singer;
	String where;
	String lyrics;
	int time;
	
	Song(String title, String singer, String where, String lyrics, int time) {
		this.title = title;
		this.singer = singer;
		this.where = where;
		this.lyrics = lyrics;
		this.time = time;
	}
	
	void run() {
		System.out.println("제목: "+this.title+" 가수: "+this.singer+" 소속사: "
							+this.where+" 가사: " + this.lyrics + " 시간: " + this.time);
	}
}
