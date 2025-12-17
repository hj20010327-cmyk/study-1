
--문제1
SELECT * FROM emp
WHERE lower(ename) LIKE '%s';

--문제2
SELECT empno, ename, job, sal, deptno
FROM EMP
WHERE
	deptno = 30
	AND lower(job) = 'salesman';

--문제3
SELECT empno, ename, job, sal, deptno
FROM emp
WHERE
	deptno IN (20,30) AND sal > 2000;
--문제 3-1
SELECT empno, ename, job, sal, deptno
FROM emp
WHERE
 	deptno = 20 AND sal > 2000
UNION ALL
SELECT empno, ename, job, sal, deptno
FROM emp
WHERE
	deptno = 30 AND sal > 2000
ORDER BY empno;

--문제4
SELECT * 
FROM emp
WHERE
	NOT (sal >= 2000 AND sal <=3000);

--문제5
SELECT ename, empno, sal, deptno
FROM emp
WHERE 
	ename LIKE '%E%'
	AND deptno = 30
	AND sal NOT BETWEEN 1000 AND 2000;

--문제6
SELECT *
FROM emp
WHERE
	comm IS NULL
	AND mgr IS NOT NULL
	AND lower(job) IN ('manager','clerk')
	AND ename NOT LIKE '_L%';

SELECT * FROM emp
WHERE deptno = 30;

/* 내가 내는 문제
추가 수당이 있고 사원번호가 30인 사람 중에서 월급이 1000이상이고 이름에 R이 들어가는
사람을 출력하라
 */

SELECT *
FROM emp
WHERE
	comm IS NOT NULL
	AND deptno = 30
	AND sal >= 1000
	AND ename LIKE '%R%';

--지피티가 내준 문제

-- 문제 1 모든 사원의 사원번호, 사원명, 급여를 조회하시오.
SELECT empno, ename, sal FROM emp;

-- 문제 2 사원들의 부서번호를 중복없이 조회하시오
SELECT distinct deptno FROM emp;

-- 문제 3 급여가 3000 이상인 사원의 사원명과 급여를 조회하시오.
SELECT ename, sal
FROM emp
WHERE 
	sal >= 3000;

--문제 4 부서번호가 10번 또는 20번인 사원의 사원명과 부서번호를 조회하시오.
SELECT ename, deptno
FROM emp
WHERE 
 deptno IN (10,20);

--문제 5 급여가 2000 이상 3000 이하인 사원의 사원명과 급여를 조회하시오.
SELECT ename, sal
FROM emp
WHERE
	sal BETWEEN 2000 AND 3000;

-- 문제 6 이름에 S가 포함된 사원의 사원명과 직무를 조회하시오.
SELECT ename, job
FROM emp
WHERE 
	ename LIKE '%S%';

--문제 7 커미션을 받지 않는 사원의 사원명과 커미션을 조회하시오.
SELECT ename, comm
FROM EMP
WHERE 
	comm IS NULL;

--문제 8 직무가 CLERK이 아닌 사원의 사원명과 직무를 조회하시오.
SELECT ename, job
FROM EMP
WHERE
	job != 'CLERK';

--문제 9 부서번호가 30번인 사원을 급여 기준으로 내림차순 정렬하여 사원명과 급여를 조회
SELECT ename, sal
FROM emp
WHERE 
	deptno = 30
ORDER BY sal DESC;

--문제 10 사원명과 급여를 조회하되 급여 컬럼명을 **"월급"**으로 
--표시하고 급여가 높은 순으로 정렬하시오.
SELECT ename, sal AS "월급"
FROM EMP
ORDER BY sal;

--1
SELECT ename, deptno, sal
FROM emp
WHERE 
	deptno IN (10,20)
	AND sal >= 2000;
--2
SELECT ename, job, comm
FROM EMP
WHERE
	job IN ('MANAGER','SALESMAN')
	AND comm IS NOT NULL;

--3
SELECT ename, sal, deptno
FROM emp
WHERE 
	sal BETWEEN 1500 AND 3000
	AND deptno != 30;

--4
SELECT ename, job
FROM emp
WHERE ename NOT LIKE 'S%';

--5
SELECT ename, sal, comm
FROM emp
WHERE
	comm IS NULL
	AND sal < 3000;

--6
SELECT ename, job, deptno
FROM emp
WHERE
	deptno NOT IN (10,20)
	AND job != 'CLERK';

--7
SELECT ename, sal
FROM emp
WHERE 
	sal >= 2000
	AND ename LIKE '%A%'
ORDER BY sal;




-- 1
SELECT ename FROM emp
WHERE 
	length(ename) >= 5;

-- 2
SELECT ename, job FROM EMP
WHERE
	lower(job) LIKE lower('manager');

-- 3
SELECT ename, sal, nvl(comm,0), (nvl(comm,0)+sal)
	 AS 실제급여
FROM emp;

-- 4
SELECT ename, hiredate, to_char(hiredate) FROM emp;


-- 5
SELECT ename, deptno FROM emp
WHERE
	deptno NOT IN (10,20);

--6
SELECT ename, deptno, job, sal FROM emp
WHERE 
	(deptno = 30 OR job = 'SALESMAN')
	AND sal >= 1500;

-- 7
SELECT ename, sal, 
	CASE 
 		WHEN sal >= 3000 THEN 'A'
 		WHEN sal >= 2000 THEN 'B'
		ELSE 'C'
		END AS "급여등급"
 FROM emp
 ORDER BY 급여등급, sal desc;

--문제 8
SELECT ename, RPAD(substr(ename,1,2), length(ename), '*')
FROM emp;


-- 문제 9
SELECT * FROM emp
WHERE mgr IS NULL;

-- 문제 10
SELECT ename, job, sal,
	CASE job
		when 'MANAGER' THEN sal*0.2
		WHEN 'SALESMAN' THEN sal*0.3
		ELSE sal*0.1
		END AS 보너스
		FROM emp;












