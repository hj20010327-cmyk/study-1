package coupang.service;

import java.util.List;

import coupang.DAO.CoupangDAO;
import coupang.DTO.CoupangDTO;

public class CoupangService {
	
	public List<CoupangDTO> selectProduct(){
		
		CoupangDAO coupangDAO = new CoupangDAO();
		
		return coupangDAO.selectAll();
		
	}

	public int insertProduct(CoupangDTO coupangDTO) {
		CoupangDAO coupangDAO = new CoupangDAO();
		return coupangDAO.coupangInsert(coupangDTO);
	}
	
	public int modifyProduct(CoupangDTO coupangDTO) {
		CoupangDAO coupangDAO = new CoupangDAO();
		return coupangDAO.coupangModify(coupangDTO);
	}
	public CoupangDTO selectOneProduct(int product_id) {
	    CoupangDAO coupangDAO = new CoupangDAO();
	    return coupangDAO.selectOne(product_id);
	}

	public int deleteProduct(int product_id) {
	    CoupangDAO coupangDAO = new CoupangDAO();
	    return coupangDAO.coupangDelete(product_id);
	}
	
}
