-- 문제 1
SELECT rpad(substr(empno,1,2),4,'*') AS empno, ename 
FROM emp
ORDER BY empno DESC;


-- 문제 2
SELECT e.empno, e.ename, d.dname, d.loc
FROM emp e LEFT OUTER JOIN dept d ON (e.deptno = d.deptno)
ORDER BY d.dname DESC;



