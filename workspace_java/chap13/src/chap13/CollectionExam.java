package chap13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionExam {

	public static void main(String[] args) {

		List list = new ArrayList();
		System.out.println(list.isEmpty());
		
		list.add(123);
		list.add("글씨");
		System.out.println(list);
		
		list.add(1,"삽입");
		System.out.println(list);
		
		// 검색
		System.out.println(list.contains("글씨"));
		
		System.out.println( list.get(0) );
		
		// 벗어나면
		// IndexOutOfBoundsException
//		System.out.println( list.get(100) );
		
		list.remove(1);
		System.out.println(list);
		
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		
		System.out.println("---------------------------");
		
		Map map = new HashMap();
		// 추가
		map.put("k1", "v1");
		map.put("k2", 123);
		map.put("k3", list);
		
		map.put("k2", 1234); 	// key가 없는 경우
								//		key 추가
								// key가 있는 경우
								// 		값 덮어쓰기
		
		String v = (String)map.get("k1");
		
		// 없으면 null
		System.out.println(map.get("가사"));
		
		System.out.println(map);
		
		System.out.println("---------------------------");
		
		list = new ArrayList();
		map = new HashMap();
		
//		map.put("한로로", "사랑하게 될거야");
		map.put("가수명", "한로로");
		map.put("제목", "사랑하게 될 거야");
		
		// 얕은 복사로 들어간다
		list.add(map);
		System.out.println(list);
		
		System.out.println(":+:+:+:+:+:+:+:+:+:+:+:+:");
		
		map.put("가수명", "kiiikiii");
		
		System.out.println(list);
		
		// 제네릭
		// 10점 짜리 설명 : 노란줄 없애기
		// 60점 짜리 설명 : 추가할 자료형을 제한한다
		// 100점 짜리 설명 : 전달인자나 리턴타입의 자료형을 동적으로 변경한다
		// 원시타입 (int, double 등)은 사용할 수 없고
		// wrapper 클래스(Integer, Double 등)을 사용해야 한다
		Map<String, Integer> map2 = new HashMap<String, Integer>();
//		map2.put("k", "abc");
		map2.put("k", 123);
		int a = map2.get("k") ;
		
		
		
		
		
		
	}

}
