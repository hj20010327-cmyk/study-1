package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mypage")
public class MyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		// false의 경우
		// 기존에 세션이 없으면 null
		// 새로 만들지 않아 다시 접속해도 null
		// 예전게 있으면 그걸 가져옴
		HttpSession session = request.getSession(false);

		if (session == null) {
			response.getWriter().print("서버 켜진 이후에<br>");
			response.getWriter().print("여기로 처음 방문<br>");
			response.getWriter().print("당연히 로그인 안했음<br>");

//			response.sendRedirect("cookie/cookie.jsp");
		} else {
			System.out.println("처음 방문은 아닌 것");

//			(boolean)session.getAttribute("login");		
			Boolean login = (Boolean) session.getAttribute("login");
			if (login == null || login != true) {
				// 로그인 안함
				response.getWriter().print("세션은 있지만<br>");
				response.getWriter().print("로그인 안함<br>");
			} else {
				if((Integer)session.getAttribute("level") != 1) {
					response.getWriter().print("매우 사적이여서 로그인 해야만 볼 수 있는곳");
					response.getWriter().print("<br>");
					response.getWriter().print("userId : " + session.getAttribute("userId"));
				}
				
				if((Integer)session.getAttribute("level")== 1) {
					// level이 1인 경우에만
					response.getWriter().print("관리자");
				} 
			}

		}
	}

}
