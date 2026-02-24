package controller;

import java.util.List;

public class EmpController implements Servlet{

	EmpService empService = new EmpServiceImpl();
	
	@Override
	public String doGet() {
		List<Integer> list = empService.getEmpno();
		
		String html = "";
		
		/*
		 	<div>3333</div><div>4444</div><div>5555</div>
		 */
		
		for(int i=0; i<list.size(); i++) {
			html += "<div>" + list.get(i)+ "</div>";
		}
		
		
		return html;
	}

	@Override
	public String doPost() {
		return null;
	}

	
	
}
