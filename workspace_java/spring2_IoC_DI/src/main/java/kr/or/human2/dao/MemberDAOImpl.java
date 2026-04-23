package kr.or.human2.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//@Repository
//@Repository("memberDAOImpl")
@Repository("dao")
//@Primary
public class MemberDAOImpl implements MemberDAO {

	@Override
	public List select() {
		List list = new ArrayList();

		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
	
		return list;
	}

	
	
}
