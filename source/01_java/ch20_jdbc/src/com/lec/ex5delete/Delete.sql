SELECT * FROM DEPT;
-- ����
DELETE FROM DEPT WHERE DEPTNO=80;
ROLLBACK;
COMMIT;

-- ����ڷκ��� �μ����� �Է¹޾� �ش� �μ� ����� ���,�̸�, ��å, �޿��� ����Ͻÿ�
SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO
            AND DNAME=UPPER('sales');
        
