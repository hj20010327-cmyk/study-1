package chap11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeExam {

	public static void main(String[] args) {

		// timestamp, UNIX time
		long before = System.currentTimeMillis();
		System.out.println(before);
		
		for(int i=0; i<100000000; i++) {
			
		}
		
		long after = System.currentTimeMillis();
		System.out.println("걸린시간 : " + (after-before));
		
		System.out.println(Long.MAX_VALUE);
		
		
		Date date = new Date();
		System.out.println(date);
		
		String format = "yyyy년 MM월 dd일 HH:mm:ss.SSS";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String strDate = sdf.format(date);
		System.out.println(strDate);		
		
	}

}
