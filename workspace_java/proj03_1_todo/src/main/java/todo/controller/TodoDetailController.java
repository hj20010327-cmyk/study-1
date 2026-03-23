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

/**
 * Servlet implementation class TodoDetailController
 */
@WebServlet("/todo/detail")
public class TodoDetailController extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/todo/detail doGet 실행");
		
		try {
			
			// "todo_id" 받아서 출력하기
			
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8;");
			
			String todo_id = request.getParameter("todo_id");
			int nTodo_id = Integer.parseInt(todo_id);
			
			String duedate = request.getParameter("duedate");
			String done = request.getParameter("done");
			String content = request.getParameter("content");
			String ctime = request.getParameter("ctime");
			
//			System.out.println(nTodo_id);
			
			// nTodo_id를 service --> DAO 까지 보낼거임
			TodoService todoService = new TodoService();
			TodoDTO todoDTO = todoService.getTodo(nTodo_id);
			
//			System.out.println(todoDTO);
			
			PrintWriter out = response.getWriter();
			
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("	<th>todo_id</th>");
			out.println("	<th>duedate</th>");
			out.println("	<th>done</th>");
			out.println("	<th>content</th>");
			out.println("	<th>ctime</th>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<td>"+todoDTO.getTodo_id()+"</td>");
			if(done == null) {		
			out.println("	<td>"+todoDTO.getDuedate()+"</td>");
			out.println("	<td>"+todoDTO.getDone()+"</td>");
			out.println("	<td>"+todoDTO.getContent()+"</td>");
			out.println("	<td>"+todoDTO.getCtime()+"</td>");
//			out.println("	<td>"+nTodo_id+"</td>");
			} else {
			out.println("	<td>"+duedate+"</td>");
			out.println("	<td>"+done+"</td>");
			out.println("	<td>"+content+"</td>");
			out.println("	<td>"+ctime+"</td>");
			}
			out.println("</tr>");
			out.println("</table>");
//			out.println("<a href=\"/proj03_1_todo/todo\">목록으로</a>");
			out.println("<a href=\"../todo\">목록으로</a>");
			out.println("<hr>");
			
			out.println("<a href='/proj03_1_todo/todo/modify?todo_id="+todoDTO.getTodo_id()+"'>수정하기</a>");
//			out.println("<input type='submit' value='수정하기'>");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
