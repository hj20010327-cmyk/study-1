package todo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.DTO.TodoDTO;
import todo.service.TodoService;

@WebServlet("/todo")
public class TodoController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/todo doGet 실행");

		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		// DB에서 모든 목록 가져오기
		TodoService todoService = new TodoService();
		List<TodoDTO> list = todoService.getList();
		
		
		// html로 출력하기
		PrintWriter out = response.getWriter();
		
		out.println("<table border=1>");
		out.println("<tr>");
		out.println("	<th>todo_id</th>");
//		out.println("	<th>duedate</th>");
//		out.println("	<th>done</th>");
		out.println("	<th>content</th>");
		out.println("	<th>ctime</th>");
		out.println("</tr>");
		
		for(int i=0; i<list.size(); i++) {
//			Map map = (Map)list.get(i);
//			
//			
//			out.println("<tr>");
//			out.println("	<td>"+map.get("todo_id")+"</td>");
////			out.println("	<td>"+map.get("duedate")+"</td>");
////			out.println("	<td>"+map.get("done")+"</td>");
//			out.println("	<td>"+map.get("content")+"</td>");
//			out.println("	<td>"+map.get("ctime")+"</td>");
//			out.println("</tr>");
			
			TodoDTO todoDTO = list.get(i);
			
			out.println("<tr>");
			out.println("	<td>"+todoDTO.getTodo_id()+"</td>");
//			out.println("	<td>"+todoDTO.getDuedate()+"</td>");
//			out.println("	<td>"+todoDTO.getDone()+"</td>");
			out.println("	<td><a href=\"/proj03_1_todo/todo/detail?todo_id=" +todoDTO.getTodo_id()+ "\">"+todoDTO.getContent()+"</td> </a>");
			out.println("	<td>"+todoDTO.getCtime()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
