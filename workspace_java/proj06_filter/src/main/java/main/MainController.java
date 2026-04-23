package main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/main doGet 실행");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		HttpSession session = request.getSession();
		String login = (String)session.getAttribute("login");
		
		if(login != null) {
			request.setAttribute("passCode", "1234");
			request.setAttribute("암구호", "짜장면");
			
			request.getRequestDispatcher("/WEB-INF/view/secret.jsp").forward(request,response);
		} else {
			response.sendRedirect("login.jsp");
		}
		
	
	}


}
