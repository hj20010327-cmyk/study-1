package emp.controller;

import java.io.IOException;
import java.util.Map;

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
		
		int size = 10; // 페이지당 표시 수
		int page = 1; // 현재 페이지
		
		String sSize = request.getParameter("size");
		String sPage = request.getParameter("page");
		
		try {
			size = Integer.parseInt(sSize);
		} catch (Exception e){
			e.printStackTrace();
		}
		// 같이 있으면 처음꺼 오류 시 두번째도 안되니까 분리
		try {
			page = Integer.parseInt(sPage);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		EmpDTO empDTO = new EmpDTO();
		empDTO.setSize(size);
		empDTO.setPage(page);
		
		// DB에서 모든 목록 가져오기
		EmpService empService = new EmpService();
		Map map = empService.getList(empDTO);
		map.put("size", size);
		map.put("page", page);
		request.setAttribute("map", map);
		
		
	
		request.getRequestDispatcher("emplist.jsp").forward(request, response);
		
	}
	
	

}
