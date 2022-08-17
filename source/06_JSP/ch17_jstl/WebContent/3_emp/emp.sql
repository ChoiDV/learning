-- DAO query
-- 전체 List
SELECT * FROM EMP;

-- 검색
SELECT * FROM EMP
    WHERE ENAME LIKE '%' || UPPER('A') || '%'
        AND JOB LIKE '%' || UPPER('E') || '%';

-- 
        