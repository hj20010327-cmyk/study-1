package chap14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputExam {

	public static void main(String[] args) {

		String fullPath = "c:\\tmp\\secret.txt";
		
		try(
			InputStream is = new FileInputStream(fullPath);
		){
			
			int BUFFER_SIZE = 1024 * 8;
//			int BUFFER_SIZE = 10;
//			int BUFFER_SIZE = 1;
			
			byte[] buffer = new byte[BUFFER_SIZE];
			
//			int result = is.read(buffer);
//			System.out.println("읽은 byte 수 : "+ result);
//			String data = new String(buffer, 0, result);
//			System.out.println("읽은 내용 : \n"+ data);
			
			int result = 0;
			String data = "";
			
//			result = is.read(buffer);
//			if(result != -1) {
//				data += new String(buffer, 0, result);
//			}
			
//			while(result != -1) {
//				result = is.read(buffer);
//				
//				if(result != -1) {
//					data += new String(buffer, 0, result);
//					System.out.println("--------------------");
//					System.out.println(data);
//				}
//			}
			
			while( (result = is.read(buffer)) != -1 ) {
				data += new String(buffer, 0, result);
			}
			
			System.out.println("읽은 내용 : \n"+ data);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
