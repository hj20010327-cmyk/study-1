package todo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.DTO.TodoDTO;
import todo.service.TodoService;

@WebServlet("/todo/insert")
public class TodoInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/todo/insert doGet 실행");

		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
//		String todo_id = request.getParameter("todo_id");
//		int nTodo_id = Integer.parseInt(todo_id);
		
		PrintWriter out = response.getWriter();
		
		out.write("<form method='post' action='../todo/insert'>");
		out.write("할일: <input type='text' name='content' placeholder='할일을 적어주세요'><br>");
		out.write("<input type='submit' value='추가'></form>");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		String content = request.getParameter("content");
		
		TodoDTO todoDTO = new TodoDTO();
		
		todoDTO.setContent(content);
		
		TodoService todoService = new TodoService();
		int result = todoService.insertTodo(todoDTO);
		
		response.sendRedirect("/proj03_1_todo/todo");
	}

}
