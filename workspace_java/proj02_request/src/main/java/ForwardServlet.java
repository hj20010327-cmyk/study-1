

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("/foward의 doGet 실행");
		
		request.setCharacterEncoding("utf-8");
		// 응답의 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");
		
		request.setAttribute("item", "롱소드");
		
		String text = request.getParameter("text");
		System.out.println("text: "+ text);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("another");
		dispatcher.forward(request, response);
		
		// 어차피 이동한 곳에서 응답하느라
		// 지금 넣어봐야 소용 없다
		response.getWriter().println("/forward의 응답 [GET]");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/foward의 doPost 실행");
		
		request.setCharacterEncoding("utf-8");
		// 응답의 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");
		
		String text = request.getParameter("text");
		System.out.println("text: "+ text);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("another");
		dispatcher.forward(request, response);
		
		
	}

}
