package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/session의 doGet 실행");
		
		// 세션의 생명주기
		// 접속하면 30분짜리가 생김(갱신)
		// 30분 후에 사라짐
		
		// 기존에 세션이 없으면 새로 만들어 주고
		// 있으면 그걸 가져옴
		HttpSession session = request.getSession();
		
//		// 기존에 세션이 없으면 null
//		// 있으면 그걸 가져옴
//		HttpSession session = request.getSession(false);
		
		session.setAttribute("k", "v");
		
		String id = session.getId();
		System.out.println("getId() : " + id);
		
		boolean isNew = session.isNew();
		System.out.println("isNew(): "+ isNew);
		
//		request.setAttribute("req", "req_v");
		
//		response.sendRedirect("session.jsp");
		
		String id2 = request.getParameter("id2");
		if("lys010327".equals(id2)) {
			session.setAttribute("login", true);
			session.setAttribute("userId", id2);
			session.setAttribute("level", 5);
		} else if("admin".equals(id2)) {
			session.setAttribute("login", true);
			session.setAttribute("userId", id2);
			session.setAttribute("level", 1);
		}
		
	}


}













