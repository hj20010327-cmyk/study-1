package emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.DTO.EmpDTO;
import emp.service.EmpService;

@WebServlet("/empcon")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/empcon의 doGet 실행");
		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		// DB에서 모든 목록 가져오기
		EmpService empService = new EmpService();
		List<EmpDTO> list = empService.getList();
		
		request.setAttribute("list", list);
		
	
		request.getRequestDispatcher("emplist.jsp").forward(request, response);
		
	}
	
	

}
