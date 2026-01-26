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
SELECT d.deptno, d.dname, floor(avg(sal)), max(sal), min(sal), count(*)
FROM emp e, dept d
WHERE e.deptno = d.deptno
GROUP BY d.deptno, d.dname;

--q3
SELECT d.deptno, d.dname, e.empno, e.ename, e.job, e.sal
FROM dept d LEFT OUTER JOIN emp e on(e.deptno = d.deptno);
--WHERE d.deptno = e.deptno
--GROUP BY d.deptno, d.dname, e.empno, e.ename, e.job, e.sal;

-- q4
-- 모든 부서정보 사원정보 급여 등급 정보
-- 각 사원의 직속상관 정보를 부서번호 사원번호 순서로 정렬

SELECT d.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e1.sal
,e1.deptno deptno_1, sg.losal, sg.hisal, sg.grade,
e2.empno mgr_empno, e2.ename mgr_ename  
--FROM emp e, dept d, salgrade sg
FROM dept d LEFT OUTER JOIN emp e1 
on(e1.deptno = d.deptno)
LEFT OUTER JOIN emp e2 
ON(e1.mgr = e2.empno)
LEFT OUTER JOIN salgrade sg
on(e1.sal >= sg.losal AND e1.sal <= sg.hisal)
ORDER BY deptno, empno;


SELECT * FROM salgrade;


