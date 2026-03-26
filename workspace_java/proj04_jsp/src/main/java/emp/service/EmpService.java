package emp.service;

import java.util.List;

import emp.DAO.EmpDAO;

public class EmpService {

	public List getList() {
		
		EmpDAO empDAO = new EmpDAO();
		
		return empDAO.selectAll(); 
		
	}
	
	public List getOrderList() {
		EmpDAO empDAO = new EmpDAO();
		
		return empDAO.orderByempno();
	}
}
