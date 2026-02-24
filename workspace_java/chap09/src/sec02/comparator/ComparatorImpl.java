package sec02.comparator;

import java.util.Comparator;

public class ComparatorImpl implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		MemberDTO m1 = (MemberDTO)o1;
		MemberDTO m2 = (MemberDTO)o2;
		
		int result = m1.age - m2.age; // 오름차순
		
		return result;
	}

}
