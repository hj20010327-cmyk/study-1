SELECT * FROM emp;

SELECT empno, ename, deptno FROM emp;

select
	sal,
	ename,
	FROM emp;

SELECT empno, deptno FROM emp;

SELECT deptno FROM emp;

SELECT DISTINCT deptno FROM emp;
SELECT DISTINCT job FROM emp;
SELECT ename, sal, sal*12+comm, comm FROM emp;

SELECT ename, sal, sal*12+comm AS annsal, comm FROM emp;
SELECT ename, sal, sal*12+comm AS "annsal", comm FROM emp;
SELECT ename, sal, sal*12+comm annsal, comm FROM emp;
-- 별칭 붙힐때 AS를 쓴다 (AS는 생략 가능)  별칭에 띄어쓰기를 하고싶을때 ""를 이용한다
SELECT ename name FROM emp;
SELECT ename as name FROM emp;

SELECT * FROM emp
ORDER BY sal;
-- order by는 그 열을 오름차순 또는 내림차순으로 정리하고싶을때
-- 오름차순은 asc를 쓰고 생략가능
-- 내림차순은 desc를 쓴다
SELECT * FROM emp
ORDER BY sal DESC;

SELECT * FROM emp 
ORDER BY empno DESC;

SELECT * FROM EMP
ORDER BY deptno, sal, empno;


SELECT * FROM EMP
ORDER BY deptno asc, sal desc, empno;

SELECT distinct job FROM emp;
--distinct는 특정 행을 제외한 나머지 열(칼럼)을 보고싶을때
SELECT 
	empno as employee_no, 
	ename as employee_name
FROM emp
ORDER BY deptno DESC, ename; 
--where은 필요한 데이터를 보고싶을때 쓴다.
SELECT *
FROM emp
WHERE deptno = 30;
--AND OR
--AND는 앞뒤 조건이 모두 참인 것이 참으로 나온다
--OR은 앞뒤 조건 중 하나만 참이여도 참으로 나온다

SELECT *
	FROM emp
	WHERE deptno = 30
	AND job = 'SALESMAN';

SELECT * FROM emp
WHERE empno = 7499
AND deptno = 30;

SELECT * FROM emp
WHERE mgr = 7839
AND deptno = 20;

SELECT * FROM emp
WHERE deptno = 30 OR job = 'CLERK';

-- 한줄 주석

/* 
 	범위주석 
 */
SELECT * FROM emp
WHERE (deptno = 30 OR deptno = 20) AND job = 'CLERK';
-- 괄호 먼저
-- and or 같이 나올때는 and 먼저 연산
-- and(논리곱) or(논리합)
SELECT * FROM emp
WHERE sal >= 3000;

SELECT * FROM emp
WHERE sal >=2500
AND job = 'ANALYST';

SELECT * FROM emp 
WHERE sal != 3000;

SELECT * FROM emp
WHERE sal <> 3000;
-- (!= <>) 뒤에 나오는 값이 아닌 값을 출력하고싶을때 사용
SELECT * FROM emp 
WHERE NOT sal <= 3000;
-- (<= >=) 이상 이하를 나타낼때 쓰이는 표현 
--문제1
SELECT * FROM EMP
WHERE sal >= 1500 and sal < 3000;
--    1500 <= sal도됨
--문제2
SELECT * FROM EMP
	WHERE 
	job = 'CLERK' 
	OR (sal > 2000 AND deptno = 10);

--문제3
SELECT * FROM emp
WHERE deptno = 10 OR deptno = 20;

--문제4
SELECT * FROM EMP
WHERE 
	(deptno = 20 OR deptno = 30) 
	AND (sal >= 2000 AND sal <= 3000)
ORDER BY sal, ename;

SELECT * FROM EMP
WHERE 
	deptno IN (10, 20);
-- IN >> 뒤에 있는 값을 나타내는 행만을 보고싶을때
SELECT * FROM EMP
WHERE 
	deptno NOT IN (10, 20);
-- NOT IN을 쓰면 뒤에 나오는 값을 나타내는 행을 제외한 나머지 행을 보여준다
SELECT * FROM emp
WHERE 
	(sal BETWEEN 2000 AND 3000);
-- between은 초과와 미만은 표현 불가
-- between을 쓸때의 and와 그냥 and는 다르다

--2000 미만이거나 3000 초과
--not (2000 >= sal and sal <=3000)
--2000 < sal or sal >3000

SELECT * FROM EMP 
WHERE (sal NOT BETWEEN 2000 AND 3000)
AND deptno = 30;

SELECT * FROM EMP
WHERE ename LIKE 'S%';
/*   %, _  <-- 와일드카드 
     예) 'S%'는 맨 앞 글자가 S이고 뒤에는 어느 문자가 들어가도된다.
     예) '_L%' 두번쨰 글자가 L이고 뒤에는 어느 문자가 들어가도된다.
	 예) %N <-- 맨 뒷글자가 N인 것들 찾을때
*/
SELECT * FROM EMP
WHERE ename LIKE '%N';

SELECT * FROM emp
WHERE ename LIKE '_L%';

SELECT * FROM emp
WHERE ename LIKE '_____';

SELECT * FROM emp
WHERE ename LIKE '%AM%';

SELECT * FROM emp
WHERE ename NOT LIKE '%AM%';

SELECT * FROM emp
WHERE comm = NULL;
/*  NULL은 아무것도 없음을 의미 
	NULL은 연산자 중 아무것도 통하지 않음
	NULL이 있는 열을 나타내고 싶을땐 = NULL이 아닌 IS NULL을 쓴다.
	마찬가지로 NULL이 아닌것을 출력하고 싶을땐 IS NOT NULL을 쓴다.
*/	    
SELECT comm FROM emp;

SELECT * FROM EMP
WHERE comm IS NULL;

SELECT * FROM EMP
WHERE comm IS NOT NULL;

SELECT * FROM emp
WHERE mgr IS NOT NULL;

SELECT * FROM emp WHERE deptno = 10;--3명
SELECT * FROM emp WHERE deptno = 20;--5명

UNION
SELECT * FROM EMP WHERE deptno = 20;

SELECT empno, ename, sal, deptno
FROM EMP
WHERE deptno = 10
UNION 
SELECT sal, job, deptno, sal
FROM EMP
WHERE deptno = 20;

SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno = 10
UNION 
SELECT empno, ename, sal, deptno
FROM EMP
WHERE deptno = 10;

SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno = 10
UNION ALL 
SELECT empno, ename, sal, deptno
FROM EMP
WHERE deptno = 10;

SELECT * --Q1
FROM EMP
WHERE ename LIKE '%S' ;

SELECT empno, ename, job, sal, deptno --Q2
FROM emp
WHERE job LIKE 'SALESMAN' ;

SELECT empno, ename, job, sal, deptno --Q3-1
FROM EMP
WHERE DEPTNO = 20 AND SAL > 2000
UNION all 
SELECT empno, ename, job, sal, deptno
FROM EMP
WHERE DEPTNO = 30 AND SAL > 2000 ;

SELECT empno, ename, job, sal, deptno --Q3-2
FROM EMP
WHERE 
	DEPTNO IN(20,30) AND sal > 2000;

SELECT * --Q4
FROM EMP
WHERE 
	SAL < 2000 OR SAL > 3000 ;

SELECT ENAME, EMPNO, SAL, DEPTNO --Q5
FROM EMP
WHERE 
	ENAME LIKE '%E%' 
	AND DEPTNO = 30 
	AND SAL NOT BETWEEN 1000 AND 2000 ;

SELECT * --Q6
FROM EMP
WHERE 
	COMM IS NULL AND MGR IS NOT NULL
	AND (JOB = 'MANAGER' OR JOB = 'CLERK')
	AND ENAME NOT LIKE '_L%';

/* 함수 */

--upper(컬럼명), lower(컬럼명)
SELECT ename, upper(ename), lower(ename), initcap(ename)
FROM emp;

SELECT 1 FROM dual;

SELECT upper('aBc') AS 대문자
, lower('aDFGcDdfdc') AS 소문자 
FROM dual;

SELECT * FROM EMP
WHERE lower(ename) LIKE lower('%aM%');

--length
SELECT ename, length(ename)
	FROM emp;

SELECT * FROM emp
WHERE length(ename) = 5;

SELECT LENGTH('a'), length('한'), lengthb('한'), lengthb('a') FROM dual;

--SUBSTR(대상, 시작하는 곳, 몇 개) 

SELECT 
	job,
	substr(job,1,2),
	substr(job,3,2),
	substr(job,5) 
FROM emp;

SELECT 
	job,
	substr(job,2,3),
	substr(job,3),
	substr(job,3,4)
FROM emp;

--사원 이름을 두번째부터 세글자만 출력
SELECT 
	ename,
	substr(ename,2,3)
FROM emp;
	
SELECT 
	ename,
	substr(ename,2,30)
FROM emp;      --마지막 숫자가 커도 끝까지만 출력
   
SELECT 
	ename,
	substr(ename,23,3)
FROM emp;      -- 실제 길이보다 시작이 크면 null


SELECT ename, substr(ename, -3, 2) FROM emp;
SELECT ename, substr(ename, -30, 2) FROM emp;


-- replace(대상, 바뀔 문자, 바꿀 문자)
-- "모든" 바뀔 문자를 바꿀 문자로 변경
SELECT 
	'a-b-c',
	REPLACE('a-b-c','-',' '),
	replace('a-b-c', '-'),
	REPLACE('a-b-c', '-', '+')
FROM dual;

-- 사원 이름에 A를 모두 'abc'로 교체

SELECT
	ename,
	replace(ename,'A','abc')
	FROM emp
WHERE ename like '%A%';

-- LPAD, RPAD (대상, 길이, 대체문자)

-- lpad, rpad는 모자르면 채우고, 넘치면 자른다.
-- 즉, 두번째 값의 길이로 만들어준다.
SELECT LPAD(ename, 10, '#'), LPAD(ename, 5, '#') FROM emp;

/* 문제1
 ename에서 앞에 두글자만 출력
substr, lpad, replace
*/ 
/* 문제2
 	ename의 앞 두글자만 원본을 출력하고
 	나머지는 4개의 *로 표시
 */
/* 문제3
 ename의 앞 두글자만 원본을 출력하고
 나머지는 *로 출력
 단, 전체 길이는 원래 이름의 길이만큼
 */

--문제1-1
SELECT ename, substr(ename, 1, 2) FROM emp;

--문제1-2
SELECT ename, lpad(ename, 2, ' ') FROM emp;

--문제1-3
SELECT ename, replace(ename, substr(ename,3), ' ') FROM emp;

--문제 2
SELECT ename, rpad(substr(ename, 1,2), 6, '*') FROM emp;

--문제 3
SELECT ename, rpad(substr(ename,1,2), LENGTH(ename),'*') FROM emp;

--문제 4 앞 두글자만 *처리
SELECT ename, '**' || substr(ename,3) FROM emp;

SELECT ename, lpad(substr(ename,3), length(ename),'*') FROM emp;
--trim
SELECT 
 '[' || '  _ _oracle_ _  ' || ']',
 '[' || trim('  _ _oracle_ _  ') || ']'
 FROM dual;

SELECT 
	round(14.46),
	round(14.46, 0),
	round(14.46, 1),  --14
	round(14.46, -1)  --10
FROM emp;





SELECT 'ab' || 'cd' || 'efg' FROM dual;

SELECT empno || ':' || ename FROM emp;


SELECT 
	trunc(14.46),
	trunc(14.46, 0),
	trunc(14.46, 1),
	trunc(14.46, -1),
	trunc(-14.46)
FROM emp;

SELECT 
	ceil(3.14),
	floor(3.14),
	ceil(-3.14), --  -3
	floor(-3.14), --  -4
	trunc(-3.14)  --  -3
	FROM EMP ;

SELECT mod(15, 6)
FROM dual;

SELECT 15/6, 
	15/0 --error
FROM dual;

SELECT MOD(15,0)
FROM dual;
--나머지 구하기 (mod)
SELECT 
	mod(6, 3),
	mod(7, 3),
	mod(8, 3),
	mod(9, 3)
FROM dual;

SELECT sysdate FROM dual;

SELECT 
	TO_char(sysdate, 'YYYY/MM/DD HH24:MI:SS') AS 현재날짜시간
FROM dual;

SELECT to_char(
	sysdate,
	'yyyy"년" mm"월" dd"일" hh24"시" mi"분" ss "초"')
FROM dual;

SELECT * FROM emp
WHERE hiredate > TO_date('1981/06/01', 'yyyy/mm/dd');

SELECT sal, comm,
	nvl(comm,0),
	sal+nvl(comm, 0),
	sal+comm,
	nvl(TO_char(comm),'N/A')
	FROM EMP;

SELECT job, sal,
	decode(job,                      --job이
			'MANAGER', sal*1.1,      --정확히 MANAGER라면  
			'SALESMAN', sal*1.05,
			'ANALYST', sal,
			sal* 1.03
			) AS upsal               --위 조건에 없다면         
FROM emp; 

SELECT job, sal,
	CASE job
		WHEN 'MANAGER' THEN sal*1.1
		WHEN 'SALESMAN' THEN sal*1.05
		WHEN 'ANALYST' THEN sal
		ELSE sal*1.03
	END AS upsal
FROM emp;

SELECT comm,
	CASE
		WHEN comm IS NULL THEN '해당 사항 없음'
		WHEN comm = 0 THEN '수당 없음'
		WHEN comm > 0 THEN '수당 : ' || comm
	END AS comm_text
	FROM emp;
	
--문제1
SELECT 
	TO_char(empno),
	rpad(substr(empno,1,2),4,'*') AS MASKING_EMPNO,
	ename,
	rpad(substr(ename,1,1),5,'*') AS MASKING_ENAME
	FROM emp
WHERE length(ename) = 5;

--문제2
--empno, ename, sal
--하루급여, 시급

SELECT TO_CHAR(empno) empno, 
	ename, 
	TO_CHAR(sal) sal,
	trunc(sal/21.5, 2) AS day_pay,
	round(sal/21.5/8, 1) AS time_pay
FROM emp;

--문제 4
SELECT to_char(empno) as empno,
	ename, 
	to_char(mgr) as mgr,
	CASE
		WHEN mgr IS NULL THEN '0000'
		WHEN substr(mgr,1,2) = '75' THEN '5555'
		WHEN substr(mgr,1,2) = '76' THEN '6666'
		WHEN substr(mgr,1,2) = '77' THEN '7777'
		WHEN substr(mgr,1,2) = '78' THEN '8888'
		ELSE to_char(mgr)
		END AS chg_mgr
FROM emp;

SELECT ename, length(ename) FROM emp;

SELECT sum(comm) FROM emp;

SELECT sum(sal) FROM emp;
--SELECT sum(sal), sal FROM emp;

SELECT count(sal) FROM emp;
SELECT count(comm) FROM emp;
SELECT count(*) FROM emp;

SELECT count(*) FROM emp
WHERE deptno = 30;

SELECT max(sal) FROM emp;
SELECT min(sal) FROM emp;

SELECT 
	max(sal), min(sal), min(hiredate), min(comm), 
	count(*), SUM(sal)
	FROM emp;

SELECT avg(sal) FROM emp;

-- 이름에 a가 들어가는 사람은 몇명?
--'a'
SELECT count(*) FROM emp
WHERE upper(ename) like upper('%a%');

SELECT DISTINCT deptno FROM emp;

----------------------
-- group by
/*
 * 제약 1. select에는 group by에 적은 컬럼 명만 가능하다
 * 제약 2. select에 집계 함수는 가능하다
 */
SELECT deptno
FROM emp
group BY deptno;

SELECT deptno, count(*), sum(sal)
FROM emp
group BY deptno;

SELECT deptno, job
FROM emp
GROUP BY deptno, job;

SELECT deptno, job, count(*)
FROM emp
GROUP BY deptno, job;

--SELECT * FROM emp
--WHERE avg(sal) < sal;

SELECT deptno, job
FROM emp
WHERE deptno = 10
GROUP BY deptno, job; 

SELECT deptno, job
FROM emp
--WHERE deptno = 10
GROUP BY deptno, job 
HAVING deptno = 10;

SELECT deptno, job, avg(sal)
FROM emp
GROUP BY deptno, job;

SELECT deptno, job, avg(sal)
FROM emp
GROUP BY deptno, job
	HAVING avg(sal) > 2000;
-- having만 존재할 수 없다(group by랑 같이 써야함)

-- job별로 3명 이상인 job과 count(*)를 표시
SELECT job, count(*) cnt
FROM emp
--WHERE cnt >= 3; 	--  as를 써도 where에 못씀
--WHERE count(*) >= 3; -- 집계함수는 where에 못씀
WHERE sal > 1000
group BY job
	HAVING count(*) >= 3; 

-- 실행 순서
/* 5 */SELECT job, 1 AS cnt
/* 1 */FROM emp
/* 2 */WHERE sal > 1000
/* 3 */GROUP BY job
/* 4 */HAVING count(*) >= 3
/* 6 */ORDER BY cnt DESC;

SELECT * FROM dept;
SELECT * FROM emp;
-- 모든 조합 뽑기
SELECT * FROM emp, dept;

SELECT * FROM emp, dept
ORDER BY empno;

SELECT deptno FROM emp
WHERE ename = 'SMITH';

SELECT * FROM dept
WHERE deptno = 20;

SELECT *
FROM emp, dept
WHERE emp.deptno = dept.deptno;

SELECT *
FROM emp e, dept d
--WHERE emp.deptno = d.deptno;
WHERE e.deptno = d.deptno;

--SELECT ename, * FROM emp; --이거 안됨
SELECT ename, emp.* FROM emp;

SELECT scott1_11.emp.ename, emp.* FROM scott1_11.emp;
-- scheme

-- ambiguously error
SELECT ename, deptno
FROM emp e, dept d
WHERE e.deptno = d.deptno;

SELECT ename, e.deptno, e.*
FROM emp e, dept d
WHERE e.deptno = d.deptno;

SELECT * FROM salgrade;

--800
SELECT sal FROM emp
WHERE ename = 'SMITH';

SELECT ename, sal, grade, losal, hisal
FROM emp e, salgrade s
where e.sal >= s.losal AND e.sal <= s.hisal;

-- 7902
SELECT mgr FROM emp
WHERE ename = 'SMITH';

SELECT * FROM emp WHERE empno = 7902;

-- king은 mgr이 null이어서 결과에서 빠졌다
SELECT e1.empno , e1.ename, e1.mgr
	, e2.empno, e2.ename, e2.mgr
	FROM emp e1, emp e2
WHERE e1.mgr = e2.empno;

SELECT *
FROM emp e NATURAL join dept d;

SELECT deptno
FROM emp e NATURAL join dept d;

SELECT deptno, e.empno, dname
FROM emp e JOIN dept d using(deptno);

SELECT d.deptno, d.*
FROM emp e JOIN dept d ON(e.deptno = d.deptno)
WHERE sal <= 2000;

SELECT *
FROM emp e1 JOIN emp e2 on(e1.mgr = e2.empno);

SELECT *
FROM emp e1 LEFT OUTER JOIN emp e2 on(e1.mgr = e2.empno);

SELECT *
FROM emp e1 right OUTER JOIN emp e2 on(e1.mgr = e2.empno);

SELECT *
FROM emp e1 full OUTER JOIN emp e2 on(e1.mgr = e2.empno);

-- 퀴즈 
-- 각 부서별로 
-- 가장 높은 급여,
-- 가장 낮은 급여,
-- 급여 차액,
-- 부서 번호
-- HINT : 결과는 총 3줄

SELECT max(sal), min(sal), max(sal)-min(sal), deptno
FROM emp
GROUP BY deptno;

--226p q1
SELECT e.deptno, d.dname, e.empno, e.ename, e.sal
FROM emp e, dept d
WHERE e.deptno = d.deptno 
AND e.sal>2000
GROUP BY e.deptno, d.dname, e.empno, e.ename, e.sal
ORDER BY deptno;

--q2
SELECT d.deptno, d.dname, floor(avg(sal)) avg_sal,
max(sal) max_sal, min(sal) min_sal, count(*) cnt
FROM emp e, dept d
WHERE e.deptno = d.deptno
GROUP BY d.deptno, d.dname;

--q3
SELECT d.deptno, d.dname, e.empno, e.ename, e.job, e.sal
FROM dept d LEFT OUTER JOIN emp e on(e.deptno = d.deptno)
ORDER BY deptno, ename;
--WHERE d.deptno = e.deptno
--GROUP BY d.deptno, d.dname, e.empno, e.ename, e.job, e.sal;

-- q4
-- 모든 부서정보 사원정보 급여 등급 정보
-- 각 사원의 직속상관 정보를 부서번호 사원번호 순서로 정렬

SELECT d.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e1.sal
,e1.deptno deptno_1, sg.losal, sg.hisal, sg.grade,
e2.empno mgr_empno, e2.ename mgr_ename  
--FROM emp e, dept d, salgrade sg
FROM dept d 
	LEFT OUTER JOIN emp e1 on(e1.deptno = d.deptno)
	LEFT OUTER JOIN emp e2 ON(e1.mgr = e2.empno)
	LEFT OUTER JOIN salgrade sg 
		on(e1.sal >= sg.losal AND e1.sal <= sg.hisal)
ORDER BY d.deptno, e1.empno;

-----------------------------
----- 서브 쿼리
-----------------------------

SELECT *
FROM emp
--WHERE sal > 2975;
WHERE sal > (SELECT SAL 
			  FROM EMP e 
			  WHERE ename = 'JONES');

SELECT *
FROM EMP
WHERE hiredate < (SELECT HIREDATE
				  FROM emp
				  WHERE ename = 'SCOTT');

SELECT *
FROM emp
WHERE sal > (SELECT avg(sal)
			 FROM emp);

SELECT max(sal)
FROM EMP
GROUP BY deptno;

SELECT * FROM emp
WHERE sal IN (2850, 3000, 5000);

SELECT * FROM emp
WHERE sal IN (SELECT max(sal)
			  FROM EMP
			  GROUP BY deptno);

SELECT *
FROM (SELECT * 
	  FROM EMP  
	  WHERE deptno = 10) e10, dept d
WHERE e10.deptno = d.deptno;

SELECT *
FROM (SELECT deptno, ename 
	  FROM EMP  
	  WHERE deptno = 10) e10, dept d
WHERE e10.deptno = d.deptno;
		
SELECT job, count(*)
FROM emp
GROUP BY job
HAVING count(*) >= 3;

-- cnt는 select에서 동작하고
-- where는 그 전에 실행된다
SELECT job, count(*) cnt
FROM emp
WHERE cnt >= 3
GROUP BY job;


SELECT * 
FROM (
	SELECT job, count(*) cnt
	FROM emp 
	GROUP BY job)
WHERE cnt >= 3;

-- rownum = 줄번호
SELECT rownum, e.*
FROM emp e;

SELECT rownum, e.*
FROM emp e
ORDER BY sal;

SELECT rownum, e.*
FROM (
	SELECT * FROM emp
	ORDER BY sal) e;

SELECT rownum, e.*
FROM (
	SELECT * FROM emp
	ORDER BY sal) e
WHERE rownum = 6; -- rownum 자체가 의미가 있다

SELECT rownum rnum, e.*
FROM (
	SELECT * FROM emp
	ORDER BY sal) e
WHERE rnum = 6;

SELECT *
FROM (
	SELECT rownum rnum, e.*
	FROM (
		SELECT * FROM emp
		ORDER BY sal) 	
		e)
WHERE rnum >= 6 AND rnum <= 10;	

WITH e10 AS (
	SELECT * FROM emp WHERE deptno = 10
)
SELECT * FROM e10;

SELECT 
	sal,
	ename,
	(SELECT 
		grade
	FROM SALGRADE
	WHERE e.sal BETWEEN losal AND hisal) grade
FROM emp e;

-- 문제 1
-- comm이 null인 사원을 급여 내림차순으로 정렬

SELECT ename, comm, sal
FROM emp
WHERE comm IS NULL
ORDER BY sal DESC;


-- 문제 2
-- 급여 등급 별 사원 수를 등급 오름차순으로 정렬
-- 출력 등급, 몇명

SELECT s.grade, count(*)
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal
GROUP BY s.grade
ORDER BY s.grade;

-- 문제 3
-- 출력: 이름, 급여, 급여 등급, 부서 이름
-- 급여 등급 3 이상, 급여 등급 내림차순
-- 급여 등급이 같은 경우 급여 내림차순

SELECT e.ename, e.sal, s.grade, d.dname
FROM emp e, dept d, salgrade s
WHERE e.sal BETWEEN s.losal AND s.HISAL
	AND e.deptno = d.deptno 
	AND s.grade >= 3
ORDER BY grade DESC, sal DESC;

-- 문제 4
-- 부서명이 SALES인 사원중
-- 급여 등급이 2 또는 3인 사원의 급여를 내림차순으로

SELECT e.ename, d.dname, s.grade, e.sal
FROM emp e, dept d, salgrade s
WHERE e.deptno = d.DEPTNO
	 AND e.sal BETWEEN s.losal AND s.HISAL
	 AND d.dname = 'SALES'
	 AND (s.grade = 2 OR s.grade = 3)
ORDER BY sal;

-- 249p q1

SELECT e.job, e.empno, e.ename, e.sal, e.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno
	AND e.job = (SELECT job FROM emp WHERE ename = 'ALLEN')
ORDER BY sal DESC, ename;


-- q2

SELECT e.empno, e.ename, d.dname, e.hiredate, d.loc, e.sal, s.grade
FROM emp e, dept d, salgrade s
WHERE e.deptno = d.deptno
	AND e.sal BETWEEN s.losal AND s.hisal
	AND e.sal > (SELECT avg(sal)
				FROM emp)
ORDER BY sal DESC, empno;

-- q3

SELECT e.empno, e.ename, e.job, e.deptno, d.dname, d.loc
FROM EMP e, dept d
WHERE e.deptno = d.deptno
	AND e.deptno = 10
	AND e.job NOT in(
			SELECT job
			FROM emp
			WHERE deptno = 30);

--q4

SELECT e.empno, e.ename, e.sal, s.grade
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal
	AND e.sal > (SELECT max(sal) FROM emp WHERE job = 'SALESMAN');

SELECT e.empno, e.ename, e.sal, s.grade
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal
	AND e.sal > (SELECT max(sal) FROM emp WHERE job = 'SALESMAN');
	
-- 지피티 문제1
SELECT e.ename, d.dname, e.sal
FROM emp e, dept d
WHERE e.deptno = d.deptno
	AND d.loc = 'NEW YORK'
	AND e.sal >= 3000
ORDER BY e.sal DESC;

-- 지피티 문제2
SELECT count(*), round(avg(sal),1), max(sal), min(sal), deptno
FROM emp
GROUP BY deptno;

-- 지피티 문제 3
SELECT *
FROM emp
WHERE mgr IS NULL;

-- 지피티 문제 4

SELECT  e.ename, e.job, e.deptno
FROM EMP e, dept d
WHERE e.deptno = d.deptno
	AND e.deptno = 10
	AND e.job NOT in(
			SELECT job
			FROM emp
			WHERE deptno = 30);

--지피티문제 5
SELECT e1.ename, e1.deptno, e1.sal
FROM emp e1
WHERE sal > (SELECT avg(sal) FROM emp e2 WHERE e2.deptno = e1.deptno);



-------------------------
-- 12장
-------------------------

DESC emp; -- dbeaver에서 안된다(근데 원래 되야함)
SELECT * FROM emp;

CREATE TABLE emp_ddl (
	empno number(4),
	ename varchar2(10),
	job varchar2(9),
	mgr number(4),
	hiredate DATE,
	sal number(7,2),
	comm number(7,2),
	deptno number(2)
);

SELECT * FROM emp_ddl;

CREATE TABLE dept_dd1
AS SELECT * FROM dept;

SELECT * FROM dept_dd1;

CREATE TABLE emp_ddl_30
AS SELECT * FROM emp WHERE deptno = 30;

SELECT * FROM emp_ddl_30;

CREATE TABLE empdept_ddl
AS SELECT empno, ename, job job2, d.deptno, dname
FROM emp e, dept d
WHERE 1 <> 1;

SELECT * FROM empdept_ddl;
	

CREATE TABLE emp_alter
AS SELECT * FROM emp;


SELECT * FROM emp_alter;

ALTER TABLE emp_alter
ADD hp varchar2(20); -- 테이블에 열 추가


ALTER TABLE emp_alter
RENAME COLUMN hp TO tel;	-- 열 이름 변경

SELECT * FROM emp_alter;

ALTER TABLE emp_alter
MODIFY empno number(5); -- 크기는 늘어나는 경우만 가능. 줄어들지 못함
						-- 다른 타입으로 변경할 경우 모든 값이 null일 때 가능하다
ALTER TABLE emp_alter 	
DROP COLUMN tel;		-- 행을 지운다

SELECT * FROM emp_alter;

RENAME emp_alter TO emp_rename; -- table의 이름을 바꾼다

SELECT * FROM emp_rename;

TRUNCATE TABLE emp_rename;

DROP TABLE emp_rename;

---------------------
-- 10장
---------------------

CREATE TABLE dept_temp
AS SELECT * FROM dept;

SELECT * FROM dept_temp;

INSERT INTO dept_temp (deptno, dname, loc)
		VALUES (50,'MAPLESTORY','PYEONGTAEK');

SELECT * FROM dept_temp;

INSERT INTO dept_temp
		VALUES (60,'NETWORK', 'BUSAN');

INSERT INTO dept_temp
		VALUES (70,'WEB',null);

INSERT INTO dept_temp
		VALUES (80,'MOBILE','');

INSERT INTO dept_temp (deptno, loc)
		VALUES (90,'INCHEON');

SELECT * FROM dept_temp;

CREATE TABLE emp_temp
AS SELECT * FROM emp WHERE 1<>1;
SELECT * FROM emp_temp;

INSERT INTO EMP_temp (empno, ename, hiredate)
VALUES (9999,'홍길동','2026/01/27');
SELECT * FROM emp_temp;

INSERT INTO emp_temp (empno, ename, hiredate)
VALUES (7051, '최민수', to_date('2026-01-27', 'yyyy-mm-dd'));

INSERT INTO emp_temp (empno, ename, hiredate)
VALUES (3111, '심청이', sysdate);

SELECT * FROM emp_temp;

INSERT INTO emp_temp
SELECT * FROM emp where deptno = 10;

SELECT * FROM emp_temp;

INSERT ALL
INTO EMP_TEMP (empno, ename, hiredate)
	VALUES (3112, '심청이2', sysdate)
INTO EMP_TEMP (empno, ename, hiredate)
	VALUES (3113, '심청이3', sysdate)
SELECT * FROM dual;

SELECT * FROM emp_temp;

------------
-- update --
------------

CREATE TABLE dept_temp2
AS SELECT * FROM dept;

SELECT * FROM dept_temp2;

UPDATE dept_temp2
SET loc = 'SEOUL';

SELECT * FROM dept_temp2;

ROLLBACK;

SELECT * FROM dept_temp2;

SELECT * FROM bonus;

-- update, delete 실행 하기 전에
-- where를 무조건 검증해보기
SELECT * FROM dept_temp2
WHERE deptno = 40;

UPDATE dept_temp2
SET dname = 'DATABASE', loc = 'SEOUL' 
WHERE deptno = 40;

SELECT * FROM dept_temp2;

UPDATE dept_temp2
SET dname = (SELECT dname
			 FROM DEPT
			 WHERE deptno = 40),
	loc = (SELECT loc
			 FROM DEPT
			 WHERE deptno = 40)		 
WHERE deptno = 40;

SELECT * FROM dept_temp2;

CREATE TABLE emp_tmp
AS SELECT * FROM emp;

SELECT * FROM emp_tmp;

SELECT sal, sal * 10 FROM EMP_TMP
WHERE sal < 1000;

UPDATE emp_tmp
SET sal = sal * 10
WHERE sal < 1000;

UPDATE EMP_Tmp
SET ename = '이용상'
WHERE ename = 'JAMES';

SELECT * FROM EMP_Tmp
WHERE ename IN ('SMITH','이용상');

CREATE TABLE emp_temp2
	AS SELECT * FROM emp;

SELECT * FROM emp_temp2;

DELETE FROM emp_temp2
 WHERE job = 'MANAGER';

SELECT * FROM emp_temp2;

DELETE FROM emp_temp2;

ROLLBACK;

SELECT * FROM emp_temp2;

DELETE FROM emp_temp2
 WHERE job = 'MANAGER';

COMMIT;

SELECT * FROM emp_temp2;

ROLLBACK;

-----------------------
-- 13장
-----------------------

SELECT * FROM dict;
SELECT * FROM USER_tables;

-----------
-- index --
-----------

CREATE INDEX idx_emp_sal
ON emp (sal asc);

SELECT * FROM user_indexes;
SELECT * FROM USER_ind_columns;

SELECT /*+ index(e idx_emp_sal)  */ -- 강제 hint
	ename, sal
FROM EMP e
WHERE sal = 3000;

CREATE VIEW vw_emp20
AS (SELECT empno, ename, job, deptno
	FROM emp
	WHERE deptno = 20);

SELECT * FROM vw_emp20;

SELECT * FROM vw_emp20
WHERE job = 'CLERK';

CREATE TABLE dept_seq
	AS SELECT *
		FROM dept
		WHERE 1 != 1;

SELECT * FROM dept_seq;

CREATE SEQUENCE seq_dept;

SELECT * FROM user_sequences;

-- 다음 값
SELECT seq_dept.nextval FROM dual;
SELECT seq_dept.nextval FROM dual;

-- 현재 값
-- 생성 후에 nextval을 한번은 실행하고 나서
-- currval 사용 가능
SELECT seq_dept.currval FROM dual;

CREATE SEQUENCE seq_dept_10
START WITH 10
INCREMENT BY 10;

SELECT seq_dept_10.nextval FROM dual;
SELECT seq_dept_10.currval FROM dual;


INSERT INTO dept_seq (deptno, dname, loc)
VALUES (seq_dept_10.nextval, 'DATABASE', 'SEOUL');

INSERT INTO dept_seq (deptno, dname, loc)
VALUES (seq_dept_10.nextval, 'DATABASE2', 'SEOUL2');

SELECT * FROM dept_seq;

---------------------------
-- 제약 조건
---------------------------

-- 방법1
-- primary key를 두개 이상 줄 수 없다
CREATE TABLE table_pk (
	login_id varchar2(20) PRIMARY KEY,
	login_pw varchar2(20) NOT NULL,
	tel varchar2(20)
);

SELECT * FROM table_pk;

-- pk를 지정하면 index 자동 생성
SELECT * FROM user_indexes;

INSERT INTO table_pk
VALUES ('id1','pw1',null);

-- id 중복
INSERT INTO table_pk
VALUES ('id1','pw1',null);

-- not null에 null 추가해서 에러
INSERT INTO table_pk
VALUES ('id2', null, null);

INSERT INTO table_pk (login_id)
VALUES ('id3');

INSERT INTO table_pk (login_id)
VALUES (null);

SELECT * FROM table_pk;
-- pk나 not null을 null 로 변경해서 에러
UPDATE table_pk
SET login_id = NULL
WHERE login_id = 'id1';

INSERT INTO table_pk
VALUES ('id2','pw2',null);

SELECT * FROM table_pk;

-- pk를 중복되는 값으로 변경해서 에러
UPDATE table_pk
SET login_id = 'id1'
WHERE login_id = 'id2';

-- 방법2
-- pk 하나 이상 지정 가능
CREATE TABLE table_pk2 (
	login_id varchar2(20),
	login_pw varchar2(20),
	tel varchar2(20),
	PRIMARY KEY (login_id, login_pw)
);

SELECT * FROM table_pk2;

-- 방법3
CREATE TABLE table_pk3 (
	login_id varchar2(20),
	login_pw varchar2(20),
	tel varchar2(20)
);
ALTER table table_pk3
ADD PRIMARY KEY(login_id, login_pw);

SELECT * FROM table_pk3;

ALTER TABLE table_pk3
MODIFY login_id PRIMARY KEY;

----------------
-- foreign key
----------------

CREATE TABLE dept_fk(
	deptno number(2) PRIMARY KEY,
	dname varchar2(14),
	loc varchar2(13)
);

CREATE TABLE emp_fk (
	empno number(4) PRIMARY KEY,
	ename varchar2(10),
	deptno number(2) REFERENCES dept_fk(deptno)
);

-- null 됨
INSERT INTO emp_fk
VALUES (1, '용상', null);

-- 없는 값 안됨
INSERT INTO emp_fk
VALUES (2, '용상2', 1);

INSERT INTO dept_fk
VALUES (10, '부서','위치');

SELECT * FROM dept_fk;

INSERT INTO emp_fk
VALUES (2, '용상2', 10);

INSERT INTO emp_fk
VALUES (3, '용상3', 10);
SELECT * FROM emp_fk;

-- 없는 값으로 update 안됨
UPDATE emp_fk
SET deptno = 20
WHERE deptno = 10;

DELETE dept_fk
WHERE deptno = 10;

DROP TABLE dept_fk;

UPDATE dept_fk
SET deptno = 20
WHERE deptno = 10;

TRUNCATE table dept_fk;

DELETE emp_fk
WHERE deptno = 10;

UPDATE dept_fk
SET deptno = 20
WHERE deptno = 10;

DELETE dept_fk
WHERE deptno = 20;

SELECT * FROM dept_fk;

COMMIT;

SELECT * FROM salgrade;

SELECT * FROM USER_tables;

CREATE TABLE users (
	id	varchar2(14)	NOT NULL,
	name	varchar2(14)	NULL,
	phone	number(10)	NULL,
	todo	varchar2(14)	NULL
);

CREATE TABLE todo (
	todo	varchar2(14)	NULL,
	todo_date	date	NULL,
	wakeup	number(2)	NULL,
	good	varchar(3)	NOT NULL
);

CREATE TABLE good (
	good	varchar(3)	NOT NULL
);

ALTER TABLE users ADD CONSTRAINT PK_USER PRIMARY KEY (
	id
);

ALTER TABLE todo ADD CONSTRAINT PK_TODO PRIMARY KEY (
	todo
);

ALTER TABLE good ADD CONSTRAINT PK_GOOD PRIMARY KEY (
	good
);

ALTER TABLE users ADD CONSTRAINT FK_todo_TO_user_1 FOREIGN KEY (
	todo
)

ALTER TABLE todo ADD CONSTRAINT FK_good_TO_todo_1 FOREIGN KEY (
	good
)

SELECT * FROM users;

SELECT * FROM todo;

SELECT * FROM good;

