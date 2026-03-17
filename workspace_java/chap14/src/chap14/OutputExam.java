package chap14;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputExam {

	public static void main(String[] args) {

		String path = "c:\\tmp";
		String fileName = "secret.txt";

//		String fullFileName = path +"\\"+ fileName;
		String fullFileName = path + System.getProperty("file.separator") + fileName;

		OutputStream os = null;
		try {
			// 스트림 열기
//			OutputStream os = new FileOutputStream(fullFileName);
			os = new FileOutputStream(fullFileName);

			// 파일에 쓸 데이터
			String data = "123\nEng\n한글2";
			byte[] datas = data.getBytes();

			// 쓰기(덮어쓰기)
			os.write(datas, 0, datas.length);

			// 버퍼에 남은 데이터 모두 출력
			os.flush();

			// 스트림 닫기
//			os.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	void saveText(String data) {
		String path = "c:\\tmp";
		String fileName = "secret.txt";
		
//		String fullFileName = path +"\\"+ fileName;
		String fullFileName = path + System.getProperty("file.separator") + fileName;
		
		// try-with-resource
		// close()를 자동으로 해줌
		
		try (
				OutputStream os = new FileOutputStream(fullFileName);
		) {
			
			byte[] datas = data.getBytes();

			// 쓰기(덮어쓰기)
			os.write(datas, 0, datas.length);

			// 버퍼에 남은 데이터 모두 출력
			os.flush();
			
		} catch(Exception e) {
			e.printStackTrace(); 
		}

	}

}
