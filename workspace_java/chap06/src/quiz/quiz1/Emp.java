package quiz.quiz1;

public class Emp {
	
	int empno;
	String name;
	String job;
	int sal;
	int deptno;
	
	void setInfo(int empno, String name, String job, int sal, int deptno) {
		this.empno = empno;
		this.name = name;
		this.job = job;
		this.sal = sal;
		this.deptno = deptno;
	}
	void info() {
		System.out.println("사원번호: " +empno + 
						   " 사원이름: " + name +
						   " 직책: " +job + 
						   " 급여: " +sal + 
						   " 직속상관번호: " + deptno);
	}
}
