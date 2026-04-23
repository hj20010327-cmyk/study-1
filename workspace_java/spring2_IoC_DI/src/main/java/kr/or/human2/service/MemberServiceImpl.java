package kr.or.human2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.or.human2.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Override
	public List getList(MemberDAO memberDAO) {
//		MemberDAO memberDAO = new MemberDAOImpl();
		
		
		return memberDAO.select();
		
	}

	
//	MemberDAO memberDAO;
	@Autowired
	@Qualifier("dao")
	
	MemberDAO dao;
	
	@Override
	public List getList2() {
		
//		MemberDAO memberDAO = new MemberDAOImpl();
		
		
		return dao.select();
	}
	
	

}
