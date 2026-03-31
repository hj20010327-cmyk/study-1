package coupang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coupang.DTO.CoupangDTO;
import coupang.service.CoupangService;

@WebServlet("/coupang/control")
public class CoupangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		// DB에서 모든 목록 가져오기
		CoupangService coupangService = new CoupangService();
		List<CoupangDTO> list = coupangService.selectProduct();

		request.setAttribute("list", list);

		request.getRequestDispatcher("/coupanglist.jsp").forward(request, response);

	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		String cmd = request.getParameter("cmd");

		if (cmd.equals("insert")) {
			productInsert(request, response);
		} else if(cmd.equals("modify")) {
			productModify(request, response);
		} else if ("modifyForm".equals(cmd)) {
	        productModifySelect(request, response);
	    } else if ("delete".equals(cmd)) {
	        productDelete(request, response);
	    }

	}

	protected void productInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		String product_name = request.getParameter("product_name");
		String product_price = request.getParameter("product_price");
		int np_price = Integer.parseInt(product_price);

		CoupangDTO coupangDTO = new CoupangDTO();
		coupangDTO.setProduct_name(product_name);
		coupangDTO.setProduct_price(np_price);

		CoupangService coupangService = new CoupangService();
		int result = coupangService.insertProduct(coupangDTO);

		response.sendRedirect("/proj04_jsp/coupang/control");

	}
	protected void productModifySelect(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    String product_id = request.getParameter("product_id");
	    int nproduct_id = Integer.parseInt(product_id);

	    CoupangService coupangService = new CoupangService();
	    CoupangDTO dto = coupangService.selectOneProduct(nproduct_id);

	    request.setAttribute("dto", dto);
	    request.getRequestDispatcher("/coupangModify.jsp").forward(request, response);
	}

	protected void productModify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		String product_id = request.getParameter("product_id");
		int nproduct_id = Integer.parseInt(product_id);
		String product_name = request.getParameter("product_name");
		String product_price = request.getParameter("product_price");
		int nproduct_price = Integer.parseInt(product_price);
		
		CoupangDTO coupangDTO = new CoupangDTO();
		coupangDTO.setProduct_id(nproduct_id);
		coupangDTO.setProduct_name(product_name);
		coupangDTO.setProduct_price(nproduct_price);
		
		CoupangService coupangService = new CoupangService();
		
		int result = coupangService.modifyProduct(coupangDTO);
		
		
		response.sendRedirect("/proj04_jsp/coupang/control");
		
		
	}
	protected void productDelete(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    String product_id = request.getParameter("product_id");
	    int nproduct_id = Integer.parseInt(product_id);

	    CoupangService coupangService = new CoupangService();
	    int result = coupangService.deleteProduct(nproduct_id);

	    response.sendRedirect("/proj04_jsp/coupang/control");
	}
}
