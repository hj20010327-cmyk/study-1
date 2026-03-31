package emp;

import java.util.List;

public class EmpService {

public List<EmpDTO> getList() {
		
		EmpDAO empDAO = new EmpDAO();
		
		return empDAO.selectAll(); 
		
	}
	
}
