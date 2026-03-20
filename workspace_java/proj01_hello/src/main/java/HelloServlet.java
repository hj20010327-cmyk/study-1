

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloServlet() {
        super();
        System.out.println("HelloServlet 생성자 실행");
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.getWriter().append("<h1>Hello Servlet</h1>");
    	
    	PrintWriter out = response.getWriter();
    	out.println("<h1>");
    	out.print("Hello servlet");
    	out.println("</h1>");
    	
    	for(int i=0; i<10; i++) {
    		if(Math.random() < 0.5) {
    			out.println(i);
    			out.println("<br>");
    		}
    	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
