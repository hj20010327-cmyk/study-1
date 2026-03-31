package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/set")
public class SetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		// 쿠키 생성
		Cookie c1 = new Cookie("name","이용상");
		
		// 만료일이 있는 쿠키
		c1.setMaxAge( 60*60*24 ); // 초
//		c1.setMaxAge( 10 ); // 초
		
		response.addCookie(c1);

		// 만료일이 없는 쿠키
		// 세션쿠키
		// setMaxAge를
		// 		설정하지 않거나
		//		명시적으로 -1등의 음수로 설정한다
		// 브라우저 메모리에만 저장된다
		// 즉, 모든 탭을 끄면 사라지는 쿠키
		Cookie c2 = new Cookie("dinner","국밥");
		c2.setMaxAge(-1);
		response.addCookie(c2);
		
		
		Cookie c3 = new Cookie("popup","N");
		c3.setMaxAge(15);
		response.addCookie(c3);
		
	}

}
