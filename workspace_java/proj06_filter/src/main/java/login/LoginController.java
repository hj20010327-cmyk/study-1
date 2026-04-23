package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pw = request.getParameter("pw");
		
		if("1234".equals(pw)) {
			// 비번이 1234인 경우만
			HttpSession session = request.getSession();
			session.setAttribute("login", "Y");
			response.sendRedirect("main");
		} else {
			// 그렇지 않은 경우
			// 로그인 페이지로 이동
			response.sendRedirect("login.jsp");
		}
		
	
		
	}

}
