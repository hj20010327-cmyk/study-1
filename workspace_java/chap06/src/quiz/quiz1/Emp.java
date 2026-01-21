package quiz.quiz1;

public class Emp {
	
	int empno;
	String name;
	String job;
	int sal;
	int mgr;
	
	void setInfo(int empno, String name, String job, int sal, int mgr) {
		this.empno = empno;
		this.name = name;
		this.job = job;
		this.sal = sal;
		this.mgr = mgr;
	}
	void info() {
		System.out.println("사원번호: " +this.empno + 
						   " 사원이름: " + this.name +
						   " 직책: " +this.job + 
						   " 급여: " +this.sal + 
						   " 직속상관: " + this.mgr);
	}
//	void info1() {
//		if (sal >= 2000) {
//			System.out.println("사원번호: " +empno + 
//					   " 사원이름: " + name +
//					   " 직책: " +job + 
//					   " 급여: " +sal + 
//					   " 직속상관번호: " + mgr);
//		}
//	}
}
