-- Dept.xml    xml파일안에서 sql문 하나당 id 하나씩  ( 나중에 특정 sql문을 사용하려 할때 그 sql문의 아이디를 호출하기때문에 )
--  id=deptList   
SELECT * FROM DEPT;

-- Emp.xml의  id=empList
SELECT * FROM EMP WHERE 1=1
    AND ENAME LIKE '%' || 'A' || '%'
        AND JOB LIKE '%' || 'E' || '%'
            AND DEPTNO =20;

            
