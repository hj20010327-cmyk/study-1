package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import emp.EmpDTO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/loginCheck")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 받아서
		String ename = request.getParameter("ename");
		String sEmpno = request.getParameter("empno");
		int empno = Integer.parseInt(sEmpno);
		
		// 넣어주세요
		EmpDTO dto = new EmpDTO();
		
		dto.setEname(ename);
		dto.setEmpno(empno);
		
		// DB에서 로그인한 DTO를 받는다
		// 단, 로그인 실패 시 null을 받는다
		LoginDAO loginDAO = new LoginDAO();
		EmpDTO resultDTO = loginDAO.selectMember(dto);
		
		// null이면
		//		로그인 페이지로 이동
		
			if(resultDTO == null) {
				response.sendRedirect("login.jsp?msg=1");
			} else {
				// null이 아니면
				// 		emp list 보여주는 서블릿으로 이동
				//		일단은 로그인 성공이라고 출력만
				System.out.println(resultDTO.getJob() +"님 환영함다");
				
				HttpSession session = request.getSession();
				session.setAttribute("resultDTO", resultDTO);
				response.sendRedirect(request.getContextPath() + "/emp/control?empno="+resultDTO.getEmpno());
			}
		
			
		
		
	
	}



}
