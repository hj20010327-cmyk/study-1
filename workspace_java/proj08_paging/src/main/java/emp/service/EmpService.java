package emp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import emp.DAO.EmpDAO;
import emp.DTO.EmpDTO;

public class EmpService {
	EmpDAO empDAO = new EmpDAO();

	public Map getList(EmpDTO empDTO) {
		
		int size = empDTO.getSize();
		int page = empDTO.getPage();
		
		int start = 0, end = 0;
		
		end = page*size;
		start = end-(size-1);
		empDTO.setEnd(end);
		empDTO.setStart(start);
		
		List list = empDAO.selectAll(empDTO);
		int totalCount = empDAO.selectEmpTotal();
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("totalCount", totalCount);
		
		return map;
		
	}
	
	public List getOrderList() {
		
		return empDAO.orderByempno();
	}
}
