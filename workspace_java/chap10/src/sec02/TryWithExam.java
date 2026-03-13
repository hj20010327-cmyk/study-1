package sec02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithExam {

	public static void main(String[] args) {

		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("c:\\test.txt");
			
			// 뭔가 할꺼야
			// 하다가 예외 발생할 수 있다
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		try(
			FileInputStream fis2 = new FileInputStream("c:\\test.txt");
		) {
			System.out.println("뭔가 함");
			System.out.println(fis2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
