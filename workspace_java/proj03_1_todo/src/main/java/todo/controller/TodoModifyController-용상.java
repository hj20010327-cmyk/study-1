package todo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.DTO.TodoDTO;
import todo.service.TodoService;

@WebServlet("/todo/modify")
public class TodoModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/todo/modify doGet 실행");

		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		String todo_id = request.getParameter("todo_id");
		int nTodo_id = Integer.parseInt(todo_id);
//		System.out.println(nTodo_id);

		// nTodo_id를 service --> DAO 까지 보낼거임
		TodoService todoService = new TodoService();
		TodoDTO todoDTO = todoService.getTodo(nTodo_id);
		
	

		System.out.println(todoDTO);
		
		PrintWriter out = response.getWriter();
		
		out.write("<form method='post' action='../todo/modify'><input type='date' name='duedate' value='"+ todoDTO.getDuedate() +"'><br>");
		out.write("<input type='text' name='done' value='"+ todoDTO.getDone() +"'><br>");
		out.write("<input type='text' name='content' value='"+ todoDTO.getContent() +"'><br>");
//		out.write("<input type='date' name='ctime' value='"+ todoDTO.getCtime() +"'><br>");
		out.write("<input type=\"hidden\" name=\"todo_id\" value=\""+ todoDTO.getTodo_id() +"\">");
		out.write("<input type='submit' value='수정'></form>");
		
		

	}
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/todo/modify의 doPost 실행");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		String todo_id = request.getParameter("todo_id");
		int ntodo_id = Integer.parseInt(todo_id);
		String duedate = request.getParameter("duedate");
		Date d_duedate = Date.valueOf(duedate);
		String done = request.getParameter("done");
		int n_done = Integer.parseInt(done);
		String content = request.getParameter("content");

		
		TodoDTO todoDTO = new TodoDTO();
		todoDTO.setTodo_id(ntodo_id);
		todoDTO.setContent(content);
		todoDTO.setDone(n_done);
		todoDTO.setDuedate(d_duedate);
		
		TodoService todoService = new TodoService();
		
		int result = todoService.modifyTodo(todoDTO);
		
		response.sendRedirect("/proj03_1_todo/todo/detail?todo_id="+ntodo_id);
	}

}
