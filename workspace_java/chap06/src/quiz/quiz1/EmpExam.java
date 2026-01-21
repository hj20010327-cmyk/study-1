package quiz.quiz1;

import java.util.ArrayList;

public class EmpExam {

	public static void main(String[] args) {

//		Emp emp = new Emp();
//		emp.empno = 30;
//		emp.name = "이용상";
//		emp.job = "개발자";
//		emp.sal = 4000;
//		emp.mgr = 20;
//		
//		Emp emp1 = new Emp();
//		emp1.empno = 20;
//		emp1.name = "윈터";
//		emp1.job = "가수";
//		emp1.sal = 1000;
//		emp1.mgr = 10;
//		
//		Emp emp2 = new Emp();
//		emp2.empno = 40;
//		emp2.name = "카리나";
//		emp2.job = "와이프";
//		emp2.sal = 3000;
//		emp2.mgr = 30;
		
//		emp.info();
//		emp1.info();
//		emp2.info();
		
//		EmpTable empTable = new EmpTable();
////		ArrayList list = new ArrayList();
//		empTable.add(emp);
//		empTable.add(emp1);
//		empTable.add(emp2);
		
//		empTable.add(emp);
//		
//		for (int i=0; i<list.size(); i++) {
//			Emp emps = (Emp) list.get(i);
//			emps.info();
//		}
		
//		for (int i=0; i<list.size(); i++) {
//			Emp emps = (Emp) list.get(i);
//			if(emps.sal >= 2000 ) {
//				emps.info();
//			} 
//			if(emp1.sal >= 2000) {
//				emps.info();
//			} 
//			if(emp2.sal >= 2000) {
//				emps.info();
//			}
//		}
//		for (int i=0; i<list.size(); i++) {
//			Emp emps = (Emp) list.get(i);
//			Emp emps1 = emps;
//			for(int j=0; j<list.size(); j++) {
//				if(emps1.deptno == emps.empno) {
//					emps.info();
//				}
//			}
//		}
		
		System.out.println("------------------------");
//		Emp emp = new Emp();
//		emp.setInfo(30, "이용상", "개발자", 4000, 20); // 상사 = emp1
//		
//		Emp emp1 = new Emp();
//		emp1.setInfo(20, "윈터", "가수", 1000, 0); // mgr=0이면 상사 없음
//		
//		Emp emp2 = new Emp();
//		emp2.setInfo(40, "카리나", "와이프", 3000, 30); // 상사 = emp
		
		 Emp emp1 = new Emp();
	        emp1.setInfo(7369, "SMITH", "CLERK", 800, 7902);

	        Emp emp2 = new Emp();
	        emp2.setInfo(7499, "ALLEN", "SALESMAN", 1600, 7698);

	        Emp emp3 = new Emp();
	        emp3.setInfo(7521, "WARD", "SALESMAN", 1250, 7698);

	        Emp emp4 = new Emp();
	        emp4.setInfo(7566, "JONES", "MANAGER", 2975, 7839);

	        Emp emp5 = new Emp();
	        emp5.setInfo(7654, "MARTIN", "SALESMAN", 1250, 7698);

	        Emp emp6 = new Emp();
	        emp6.setInfo(7698, "BLAKE", "MANAGER", 2850, 7839);

	        Emp emp7 = new Emp();
	        emp7.setInfo(7782, "CLARK", "MANAGER", 2450, 7839);

	        Emp emp8 = new Emp();
	        emp8.setInfo(7788, "SCOTT", "ANALYST", 3000, 7566);

	        Emp emp9 = new Emp();
	        emp9.setInfo(7839, "KING", "PRESIDENT", 5000, 0); // 상사 없음

	        Emp emp10 = new Emp();
	        emp10.setInfo(7844, "TURNER", "SALESMAN", 1500, 7698);

	        Emp emp11 = new Emp();
	        emp11.setInfo(7876, "ADAMS", "CLERK", 1100, 7788);

	        Emp emp12 = new Emp();
	        emp12.setInfo(7900, "JAMES", "CLERK", 950, 7698);

	        Emp emp13 = new Emp();
	        emp13.setInfo(7902, "FORD", "ANALYST", 3000, 7566);

	        Emp emp14 = new Emp();
	        emp14.setInfo(7934, "MILLER", "CLERK", 1300, 7782);
		
		
		EmpTable empTable = new EmpTable();
//		empTable.add(emp);
//		empTable.add(emp1);
//		empTable.add(emp2);
		
		empTable.add(emp1);
        empTable.add(emp2);
        empTable.add(emp3);
        empTable.add(emp4);
        empTable.add(emp5);
        empTable.add(emp6);
        empTable.add(emp7);
        empTable.add(emp8);
        empTable.add(emp9);
        empTable.add(emp10);
        empTable.add(emp11);
        empTable.add(emp12);
        empTable.add(emp13);
        empTable.add(emp14);
		
		
		 // 각 사원 정보 출력
        for (Emp e : empTable.list) {
            e.info();
        }

        // 연봉 2000 이상 사원 출력
        empTable.hs();
        
        // 상사 출력
        empTable.mg(emp1);               
        empTable.mg(emp9);
//        empTable.mg(emp2);
//        empTable.mg(emp); // 상사 없음
	}

}
