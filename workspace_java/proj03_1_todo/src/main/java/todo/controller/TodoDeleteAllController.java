package todo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.DTO.TodoDTO;
import todo.service.TodoService;

@WebServlet("/todo/deleteall")
public class TodoDeleteAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] del = request.getParameterValues("delete");

		for (int i = 0; i < del.length; i++) {
			int ntodo_id = Integer.parseInt(del[i]);
			TodoDTO todoDTO = new TodoDTO();
			todoDTO.setTodo_id(ntodo_id);
			TodoService todoService = new TodoService();
			int result = todoService.deleteTodo(todoDTO);
		}
		response.sendRedirect("/proj03_1_todo/todo");

	}

}
