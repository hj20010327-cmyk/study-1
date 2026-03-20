package todo.service;

import java.util.List;

import todo.DAO.TodoDAO;

public class TodoService {

	public List getList() {
		// TodoDAO의 selectAll을 호출하고
		// 그 List를 return 해주세요
		
		TodoDAO todoDAO = new TodoDAO();
		
		return todoDAO.selectAll();
		
	}
	
}
