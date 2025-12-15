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

SELECT * --q1
FROM EMP
WHERE ename LIKE '%S' ;

SELECT empno, ename, job, sal, deptno --Q2
FROM emp
WHERE job LIKE 'SALESMAN' ;

SELECT empno, ename, job, sal, deptno --Q3-1
FROM EMP
WHERE DEPTNO = 20 AND SAL > 2000
UNION 
SELECT empno, ename, job, sal, deptno
FROM EMP
WHERE DEPTNO = 30 AND SAL > 2000 ;

SELECT empno, ename, job, sal, deptno --Q3-1
FROM EMP
WHERE DEPTNO = 20 AND SAL > 2000
UNION ALL
SELECT empno, ename, job, sal, deptno
FROM EMP
WHERE DEPTNO = 30 AND SAL > 2000 ;

SELECT * --Q4
FROM EMP
WHERE SAL < 2000 OR SAL > 3000 ;

SELECT ENAME, EMPNO, SAL, DEPTNO --Q5
FROM EMP
WHERE ENAME LIKE '%E%' AND DEPTNO = 30 AND SAL NOT BETWEEN 1000 AND 2000 ;

SELECT * --Q6
FROM EMP
WHERE 
	COMM IS NULL AND MGR IS NOT NULL
	AND (JOB = 'MANAGER' OR JOB = 'CLERK')
	AND ENAME NOT LIKE '_L%' ;






















