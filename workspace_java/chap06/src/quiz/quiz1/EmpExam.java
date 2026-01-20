package quiz.quiz1;

import java.util.ArrayList;

public class EmpExam {

	public static void main(String[] args) {

		Emp emp = new Emp();
		emp.empno = 30;
		emp.name = "이용상";
		emp.job = "개발자";
		emp.sal = 4000;
		emp.deptno = 20;
		
		Emp emp1 = new Emp();
		emp1.empno = 20;
		emp1.name = "윈터";
		emp1.job = "가수";
		emp1.sal = 8000;
		emp1.deptno = 10;
		
		Emp emp2 = new Emp();
		emp2.empno = 40;
		emp2.name = "카리나";
		emp2.job = "와이프";
		emp2.sal = 3000;
		emp2.deptno = 30;
		
//		emp.info();
//		emp1.info();
//		emp2.info();
		
		ArrayList list = new ArrayList();
		list.add(emp);
		list.add(emp1);
		list.add(emp2);
		
		for (int i=0; i<list.size(); i++) {
			Emp emps = (Emp) list.get(i);
			emps.info();
		}
		
		EmpTable empTable = new EmpTable();
		empTable.setList(emp);
//		emp.info(); 
		
		
	}

}
