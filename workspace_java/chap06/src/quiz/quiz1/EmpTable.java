package quiz.quiz1;

import java.util.ArrayList;

public class EmpTable {
	
	// ArrayList를 필드로 가지고 있어라
	ArrayList<Emp> list = new ArrayList();
//	ArrayList list = new ArrayList();
	Emp emp = new Emp();
	// EmpExam에 있는 emp를 가져와서
	
	void add(Emp emp) {
		this.list.add(emp);
	}
	// 여기에 있는 ArrayList에 넣어야된다?
	
	// 출력해야돼
//	void info() {
//		System.out.println("사원번호: " +emp.empno + 
//						   " 사원이름: " + emp.name +
//						   " 직책: " +emp.job + 
//						   " 급여: " +emp.sal + 
//						   " 직속상관번호: " + emp.deptno);
//	}
	
	void hs() {
        System.out.println("===== 연봉 2000 이상 사원 =====");
        for (Emp e : list) {
            if (e.sal >= 2000) {
                e.info();
            }
        }
    }
	
	void mg(Emp emp) {
        for (Emp e : list) {
            if (e.empno == emp.mgr) { // mgr과 empno 비교
                System.out.println("===== " + emp.name + "의 상사 =====");
                e.info();
                return; // 상사는 하나뿐이므로 찾으면 바로 종료
            }
        }
        System.out.println(emp.name + "의 상사를 찾을 수 없습니다.");
    }
	
//	EmpExam empExam = new EmpExam();
//	
//	
	
}
