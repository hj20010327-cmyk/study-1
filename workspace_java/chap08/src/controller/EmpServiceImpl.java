package controller;

import java.util.ArrayList;
import java.util.List;

public class EmpServiceImpl implements EmpService {
	
	EmpDAO empDAO = new EmpDAOImpl();
	
	@Override
	public List getEmpno() {

		List<Integer> list = empDAO.selectEmpno();
		List<Integer> result = new ArrayList();
 		
		for(int i = 0; i<list.size(); i++ ) {
			if( list.get(i)>=3000 ) {
				result.add(list.get(i));
			}
		}
		return result;
	}

}
