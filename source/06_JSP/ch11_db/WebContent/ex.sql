SELECT * FROM EMP; -- 실행은 실행하고자 하는 sql문을 블럭 잡고 alt + x   => result탭에 결과
SELECT * FROM DEPT;

SELECT * FROM EMP
    WHERE ENAME LIKE '%'||upper('al')||'%';
    
SELECT * FROM EMP  WHERE ENAME LIKE '%%';

DESC EMP;