
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/req")
public class RequestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/req doGet 실행");

		// 요청의 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		// 응답의 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");

		String id = request.getParameter("id");
		System.out.println("id : " + id);
		String pw = request.getParameter("pw");
		System.out.println("pw : " + pw);

		// 없으면 null
		System.out.println(request.getParameter("pw2"));

		// 여러개가 있어도 하나만 가져온다
		System.out.println("item : " + request.getParameter("item"));
		System.out.println("-------------------------------");
		String[] items = request.getParameterValues("item");
		if (request.getParameter("item") != null) {
			for (String item : items) {
				System.out.println("item: " + item);
			}
		}

		System.out.println("none: " + request.getParameter("none"));
		System.out.println("hidden: " + request.getParameter("hidden"));

		System.out.println("btn1: " + request.getParameter("btn1"));
		System.out.println("btn2: " + request.getParameter("btn2"));

		// select는 단 하나만 와서 getParameter로 하는데
		// 한개짜리 배열로도 온다는거 연습
		String[] selects = request.getParameterValues("select");
		for (String select : selects) {
			System.out.println("select: " + select);
		}

		System.out.println("radio : " + request.getParameter("radio1"));
		System.out.println("ta : " + request.getParameter("ta"));
		System.out.println("date1 : " + request.getParameter("date1"));

		response.getWriter().println("{\"key\": 1234}");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/req doPost 실행");

		// 요청의 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		// 응답의 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");

		System.out.println("id: " + request.getParameter("id"));

	}

}
