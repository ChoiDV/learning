--
INSERT INTO DEPT VALUES(50,'IT','SEOUL');
COMMIT;
-- 부서번호 중복 체크
SELECT * FROM DEPT WHERE DEPTNO=50;   -- 1
SELECT COUNT(*) "CNT" FROM DEPT WHERE DEPTNO=70;  --2
-- 1. rs.next() 결과가 true 면 중복, false 면 중복아님 그러므로 진행 아무것도 없으면 false
-- 2. 1이나오면 중복, 0이나오면 중복아님 그러므로 진행
--  1번은 rs.next 결과가 한행도 안나오거나 한행이 나오거나  그래서 한행도안나오면 false 한행 나오면 true 즉 false는 중복아님 true는 중복 
-- 2번은 rs.next 결과가 무조건 한행이 나오기 때문에 rs.next() 를 해주고 그다음 rs.next() 값을   1이나 0과 비교 
DESC DEPT;
COMMIT;
SELECT * FROM DEPT ;
DELETE FROM DEPT WHERE DEPTNO = 55;

UPDATE DEPT SET DNAME='ABC',LOC='SEOUL' WHERE DEPTNO=90;
