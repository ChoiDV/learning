-- [VI] SUB QUERY : QUERY�ȿ� QUERY�� ����
--   QUERY = SQL��
-- SELECT �ʵ�1, (SELECT �ʵ� FROM ���̺� WHERE ����) �̷������� 
--  FROM ���̺�   -- ���⿡�� ���ü� �ְ�
--    WHERE ����  -- ���⿡�� ���ü� ����

-- �� 1. ���� ���� ����(�ʿ伺)

-- ���������� �ʿ伺 : �޿��� ���� ���� �޴� ����� ���, �̸�, ��å, �޿�
SELECT EMPNO, MAX(SAL)
    FROM EMP
        GROUP BY EMPNO;    -- �̷��� �� ����

SELECT MAX(SAL) FROM EMP;  --  �׷��� �갡 ��������

SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP
        WHERE SAL =(SELECT MAX(SAL) FROM EMP);  -- ��������        
-- ���������� ���������� ��ȣ�� �����־����


-- ���� ������ ����(1) : ������ ��������( �������� ����� ������) : =,>,>=,!= ��� ���� ��밡�� 
    -- ex. SCOTT�� �ٹ��ϴ� �μ��̸� ���
SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- ��������

SELECT DNAME                                  
    FROM DEPT 
        WHERE DEPTNO =(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'); -- ��������

SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND E.ENAME = 'SCOTT';  -- JOIN�̿�


-- ���� ������ ���� (2) : ������ �������� (�������� ����� ������(2���̻�)) : IN, ANY, ALL, EXISTS ��밡��
    -- ex. JOB�� MANAGER�� ����� �μ��̸�
SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER';  -- ��������

SELECT DNAME FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER');  -- �������� ������ �����࿡���� =,<=,!= ��� �̷� ������ �����ڵ� ���Ұ�



-- �� 2. ������ ��������
    --�Ʒ� ���� ��ó��
    SELECT E.DEPTNO FROM EMP E, DEPT D WHERE E.DEPTNO= D.DEPTNO AND ENAME = 'SCOTT';
    INSERT INTO DEPT VALUES( 50, 'IT' , 'DALLAS');
    INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (9999,'ȫ�浿',50);  --  ���ϴ� �����͸� �Է��ϰ� �������� NULL�� �Է��ؼ� �߰��ϱ�.
    SELECT * FROM DEPT;
    SELECT * FROM EMP WHERE EMPNO = 9999;
    --ex. SCOTT�� ���� �μ���ȣ�� ����� �̸��� �޿�
SELECT DEPTNO FROM EMP WHERE ENAME ='SCOTT'; -- ��������

SELECT ENAME, SAL FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME ='SCOTT')
        AND ENAME != 'SCOTT';


    --ex. SCOTT�� ���� �ٹ����� ����� �̸��� �޿�
SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT';

SELECT ENAME, SAL
    FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO 
         AND LOC = (SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT')
         AND ENAME != 'SCOTT';

ROLLBACK; -- ������ �߰� ��� (DML-������ �߰�, ���� ,������ ���)

-- ex. �����Ի��ϰ� �����Ի��� ��� �̸�
SELECT MIN(HIREDATE) FROM EMP;  -- ��������

SELECT HIREDATE, ENAME FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);   --��������

-- ex. �ֱ��Ի��ϰ� �ֱ��Ի��ѻ���̸�
SELECT MAX(HIREDATE) FROM EMP;
SELECT HIREDATE "LAST", ENAME "LASTMAN" FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
    
-- ex. �����Ի��ϰ� ���� �Ի��� ����̸�, �ֱ� �Ի��ϰ� �ֱ� �Ի��� ����̸�
SELECT E1.HIREDATE, E1.ENAME, E2.HIREDATE, E2.ENAME
    FROM EMP E1, EMP E2
         WHERE E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP)
         AND E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);


    -- ex. SCOTT �� ���� �μ��� �ٹ��ϴ� ������� �޿���
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- �������� (������)
SELECT SUM(SAL) FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'); -- ����

    --ex. SCOTT�� ������ ��å(JOB)�� ���� ����� ��� �ʵ�
SELECT JOB FROM EMP WHERE ENAME ='SCOTT';  -- �������� (������)
SELECT * FROM EMP 
    WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME ='SCOTT');
    
    --ex. DALLAS���� �ٹ��ϴ� ����� �̸�, �μ���ȣ
SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS';
SELECT ENAME, DEPTNO FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS'); 
    
    --ex. 'KING'�� ���ӻ���� ����� �̸��� �޿�
SELECT EMPNO FROM EMP WHERE ENAME = 'KING';

SELECT ENAME, SAL FROM EMP
    WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');

SELECT W.ENAME, W.SAL
    FROM EMP W, EMP M
        WHERE W.MGR = M.EMPNO
        AND M.ENAME='KING';
        
    --ex1. ��� �޿� ���Ϸ� �޴� ����� �̸��� �޿��� ���

SELECT ENAME, SAL
    FROM EMP
        WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
        
    --ex2. ��� �޿� ���Ϸ� �޴� ����� �̸�, �޿�, ��� �޿� ���
SELECT ENAME, SAL ,ROUND((SELECT AVG(SAL) FROM EMP)) AVG
    FROM EMP
        WHERE SAL <= (SELECT AVG(SAL) FROM EMP);

    --ex3. ��ձ޿� ���Ϸ� �޴� ����� �̸�, �޿�, ��ձ޿��� ���̸� ���
SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP)-SAL,1) DIFF
    FROM EMP
        WHERE SAL <= (SELECT AVG(SAL) FROM EMP);

-- ������ ���߿� �������� : SCOTT�̶� JOB�� DEPTNO�� ���� ������ ��� �ʵ�
SELECT JOB, DEPTNO FROM EMP WHERE ENAME ='SCOTT';  -- �������� (������ ���߿�)

SELECT * FROM EMP
    WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP WHERE ENAME ='SCOTT')
        AND ENAME != 'SCOTT';
        
        
-- �� �� ��������
--1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT ENAME, SAL, HIREDATE
    FROM EMP
        WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);
-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, SAL
    FROM EMP
        WHERE SAL = (SELECT MIN(SAL) FROM EMP);
-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT ENAME, SAL, DEPTNO
    FROM EMP
        WHERE SAL >= (SELECT AVG(SAL) FROM EMP);
--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT ENAME, SAL, DNAME
    FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO
            AND SAL <= (SELECT AVG(SAL) FROM EMP);
--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT ENAME, SAL, HIREDATE , GRADE
    FROM EMP, SALGRADE
        WHERE SAL BETWEEN LOSAL AND HISAL
            AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT');
            
--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� �޿��� ū �� ����
SELECT ENAME, SAL, HIREDATE , GRADE
    FROM EMP, SALGRADE
        WHERE SAL BETWEEN LOSAL AND HISAL
            AND HIREDATE <= (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT');
--7. BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP
        WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');

--8. MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի���
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
        WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER');

--9. �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP
        WHERE SAL > (SELECT AVG(SAL) FROM EMP);
--10. CLARK�� ���� �μ���ȣ�̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP
        WHERE DEPTNO =(SELECT DEPTNO FROM EMP WHERE ENAME = 'CLARK') 
            AND SAL >(SELECT SAL FROM EMP WHERE EMPNO='7698');
            
--11.  �����ȭ. CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�


--12. BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի�����

--13. ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸� �� �޿��� ���� ������ ���)
        

-- �� 3. ������ �������� : IN, ALL, ANY=SOME, EXISTS
-- (1) IN : �������� ��� �� �ϳ��� ��ġ�ϸ� ��
    -- ex. �μ���ȣ���� �Ի����� ���� ���� ����� �̸�, �Ի���, �μ���ȣ
SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO; -- ��������(������)

SELECT ENAME, HIREDATE, DEPTNO
    FROM EMP
        WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO);
        
    -- ex. �޿� 3000�̻� �޴� ����� �Ҽӵ� �μ����� �ٹ��ϴ� ����� ��� �ʵ�
SELECT DEPTNO FROM EMP WHERE SAL >= 3000;

SELECT * FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL>=3000);
    
-- (2) ALL : �������� ����� ��� �����ؾ� ��
     -- ex. 30�� �μ� �޿��� ��κ��� ū ��� (= 30�� �μ� �ִ� �޿����� ū ���) ������ ��� �ʵ�
SELECT SAL FROM EMP WHERE DEPTNO=30;
SELECT * FROM EMP WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO=30);

-- ���� ������ ���������� ������ ���������� 
SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30;
SELECT * FROM EMP WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30); 

-- (3) ANY = SOME : �������� ����� �ϳ��� �����ϸ� ��
    -- ex. 30�� �μ��� �� �ϳ����̶� ū ���(= 30�� �μ� �ּ� �޿����� ū ���) ������ ��� �ʵ�
SELECT SAL FROM EMP WHERE DEPTNO = 30;  -- ��������(������)
SELECT * FROM EMP WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO = 30);
    -- ���� QUERY�� ������ ����������
SELECT * FROM EMP WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30);

-- (4) EXISTS : �������� ����� �����ϸ� ��
    -- ex. ���Ӻ��ϰ� �ִ� �������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP MANAGER
        WHERE EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO = MGR);
        
        -- JOIN ����
        SELECT DISTINCT M.EMPNO, M.ENAME , M.SAL
            FROM EMP W, EMP M
                WHERE W.MGR = M.EMPNO;

    -- ex. ���� ����� ��� �ʵ� ���
SELECT * FROM EMP MANAGER
    WHERE NOT EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO = MGR);
    -- SELF JOIN �̿��
SELECT M.*
    FROM EMP W, EMP M
        WHERE W.MGR(+) = M.EMPNO
            AND W.ENAME IS NULL;

-- źź1. �μ����� ���� �޿��� ���� �޴� ����� ���� (�����ȣ, ����̸�, �޿�, �μ���ȣ) �� ���  (IN ������ �̿�)
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO;
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP
        WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);

-- źź2. ����(JOB)�� MANAGER�� ����� ���� �μ��� �μ� ��ȣ�� �μ���� ������ ���(IN)
SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER';
SELECT DEPTNO, DNAME, LOC
    FROM DEPT
        WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER');
        
-- źź3. �޿��� 3000�̻��� ����� �� ���� ����� ����� �ش� ��޺� �ְ� ������ �޴� �������
--              ���, �̸�, ����, �Ի���, �޿�, �޿������ ��� 

SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
    FROM SALGRADE, EMP    
        WHERE (GRADE,SAL) IN(SELECT GRADE,MAX(SAL) FROM EMP, SALGRADE 
                                WHERE SAL BETWEEN LOSAL AND HISAL AND  SAL >= 3000  GROUP BY GRADE);
    
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
    FROM EMP, SALGRADE
        WHERE SAL >= 3000 
            AND (GRADE,SAL) IN(SELECT GRADE,MAX(SAL) FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL GROUP BY GRADE);
            
-- źź4. �����ȭ : �Ի��� �б⺰�� ���� ���� �޿��� �޴� ������� 
    -- �б�, ���, �̸�, JOB, �����, �Ի��� , �޿�, �󿩸� ����ϼ��� 
        -- �б� : 1,2,3 -> 1 /  4,5,6 -> 2 / 7,8,9 ->3 / 10,11,12 -> 4
        -- �б������� : MM/3 �� �ø� 
SELECT HIREDATE, CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUARTER" FROM EMP;
SELECT HIREDATE, CEIL(TO_CHAR(HIREDATE, 'MM')/3) "QUARTER" FROM EMP;

SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUARTER", MAX(SAL) FROM EMP
    GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3);  -- ����

SELECT HIREDATE, TO_CHAR(HIREDATE, 'Q') "QUARTER" FROM EMP;  -- �б��� �ϴ¹�

SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUARTER", EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM
    FROM EMP
        WHERE (CEIL(EXTRACT(MONTH FROM HIREDATE)/3), SAL) IN
            (SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3), MAX(SAL)
                FROM EMP
                    GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3))
                        ORDER BY QUARTER;
                        
-- źź5. SALESMAN ��� ����� ���� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ�
--          ���� ����� ������� �ʴ´�.(ALL�̿�) 
SELECT SAL FROM EMP WHERE JOB ='SALESMAN'; -- ��������

SELECT ENAME, SAL, JOB
    FROM EMP
        WHERE SAL > ALL (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN')
            AND JOB != 'SALESMAN';  -- ������ �������� �̿��� ��������
        
SELECT ENAME, SAL, JOB
    FROM EMP
        WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN') AND JOB != 'SALESMAN'
            ORDER BY SAL;

-- źź6. ?	SALESMAN �Ϻ� � �� ������� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� 
--                      ���� ����� ���(ANY)
SELECT ENAME, SAL, JOB
    FROM EMP
        WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN')
            AND JOB != 'SALESMAN';  -- ������ �������� �̿��� ��������
        
SELECT ENAME, SAL, JOB
    FROM EMP
        WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB = 'SALESMAN') AND JOB != 'SALESMAN'
            ORDER BY SAL;

-- źź7. �޿��� 3000�̸��� ��� �߿� ���� �ֱٿ� �Ի��� ����� �����ȣ�� �̸�, �޿�, �Ի����� ���
SELECT EMPNO, ENAME, SAL, HIREDATE
    FROM EMP
        WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL < 3000);
        
-- źź8.������ ��SALESMAN���� ����� �޴� �޿��� �ּ� �޿����� ���� �޴� ������� �̸�, �޿�, ����, �μ���ȣ�� ����ϵ�
--                              �μ���ȣ�� 20���� ����� �����Ѵ�(ANY ������ �̿�)
SELECT SAL FROM EMP WHERE JOB = 'SALESMAN';

SELECT ENAME, SAL, JOB ,DEPTNO
    FROM EMP
        WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN')
            AND DEPTNO != 20;
            

-- �� �� ��������
-- ���⼭���ʹ� �����༭�������� �����༭������, ������ �����༭������
-- 14.  �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� ������ ��� ��ȣ,�̸�,�޿�(�� ��� �� ���)
SELECT EMPNO, ENAME, SAL
    FROM EMP 
        WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
            ORDER BY EMPNO;

-- 15. �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿�    
SELECT ENAME, JOB, SAL
    FROM EMP E, DEPT D 
        WHERE E.DEPTNO = D.DEPTNO
            AND LOC = (SELECT LOC FROM DEPT WHERE LOC = 'DALLAS');
            
SELECT ENAME, JOB, SAL
    FROM EMP 
     WHERE DEPTNO = (SELECT DEPTNO FROM DEPT 
                    WHERE INITCAP(LOC)='Dallas');  -- ������ 
                    
-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿�
SELECT ENAME, SAL
    FROM EMP
        WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');
-- 17. SALES�μ� ����� �̸�, ����
SELECT ENAME, JOB
    FROM EMP
        WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');
-- 18. ������ �μ� 30�� ���� ���޺��� ���� ����� ��� �ʵ�
SELECT * FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = '30');
-- 19. �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ����
SELECT ENAME, JOB
    FROM EMP
        WHERE DEPTNO = 10
            AND JOB IN (SELECT JOB FROM EMP WHERE DEPTNO= '30');
-- 20.  FORD�� ������ ���޵� ���� ����� ��� �ʵ�  
SELECT * FROM EMP
    WHERE (SAL,JOB) = (SELECT SAL,JOB FROM EMP WHERE ENAME = 'FORD')
        AND ENAME != 'FORD';
            
                
-- 21. �̸��� JONES�� ������ JOB�� ���ų� FORD�� SAL �̻��� �޴� ����� ������ �̸�, ����, �μ���ȣ, �޿�
    -- ��, ������ ���ĺ� ��, ������ ���� ������ ���
SELECT ENAME, JOB, DEPTNO, SAL
    FROM EMP
        WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'JONES')
            OR SAL >= (SELECT SAL FROM EMP WHERE ENAME = 'FORD')
                ORDER BY JOB,SAL DESC;
-- 22. SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿�
SELECT ENAME, JOB, SAL
    FROM EMP
        WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME = 'SCOTT' OR ENAME = 'WARD')
            AND ENAME NOT IN ('SCOTT', 'WARD');
-- 23. CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,����           
 SELECT ENAME, JOB
    FROM EMP
    WHERE JOB IN (SELECT JOB FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO');  
    
-- 24. �μ����� ��� ���޺��� ���� ����� ���, �̸�, �޿�, �μ���ȣ

SELECT EMPNO, ENAME, SAL
    FROM EMP E
        WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);
        
SELECT EMPNO,ENAME, E.SAL, E.DEPTNO
    FROM EMP E, (SELECT DEPTNO, AVG(SAL)SAL FROM EMP GROUP BY DEPTNO) A
    WHERE E.DEPTNO = A.DEPTNO AND E.SAL > A.SAL
        ORDER BY DEPTNO;   -- INLINE VIEW �̿� 

-- �ش� �μ� ��պ��� ���� ����� ���� - ���, �̸�, �޿�, �μ���ȣ, �ش�μ��� ���(�Ҽ��� 2�ڸ�)
SELECT EMPNO, ENAME, SAL, DEPTNO,ROUND((SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO),2) "AVG"
    FROM EMP E
        WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);

SELECT EMPNO, ENAME, SAL, E.DEPTNO AVG
    FROM EMP E, (SELECT DEPTNO, ROUND(AVG(SAL),2) "AVG" FROM EMP GROUP BY DEPTNO) A
        WHERE E.DEPTNO = A.DEPTNO
            AND SAL > AVG;  -- INLINE VIEW �̿� 
           
-- 25. �������� ��� ���޺��� ���� ������ �޴� ����� �μ���ȣ, �̸�, �޿�
SELECT DEPTNO, ENAME, SAL, JOB
    FROM EMP E
        WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE JOB = E.JOB);
        
-- 26. ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����, �̸�, ���, �μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP M
        WHERE EXISTS (SELECT * FROM EMP WHERE MGR = M.EMPNO)
            ORDER BY DEPTNO;
            
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP
        WHERE EMPNO IN (SELECT MGR FROM EMP)
            ORDER BY DEPTNO;   -- IN ������ �̿�

SELECT DISTINCT M.JOB, M.ENAME, M.EMPNO, M.DEPTNO
    FROM EMP W, EMP M
        WHERE W.MGR = M.EMPNO; -- SELF JOIN �̿�
            
-- 27.  ���� ����� ���, �̸�, ����, �μ���ȣ
SELECT EMPNO, ENAME, JOB, DEPTNO
    FROM EMP M
        WHERE NOT EXISTS (SELECT * FROM EMP WHERE M.EMPNO = MGR);   
       
SELECT JOB, ENAME, EMPNO, DEPTNO
  FROM EMP
  WHERE EMPNO IN (SELECT MGR FROM EMP); -- ����� MGR�� �����ϴ� ���(���Ӻ��ϻ���� �ִ� ���)
  
SELECT JOB, ENAME, EMPNO, DEPTNO
  FROM EMP
  WHERE EMPNO NOT IN (SELECT MGR FROM EMP); -- �ƹ��൵ ��µ��� �ʾ� (NULL)
  
SELECT JOB, ENAME, EMPNO, DEPTNO
  FROM EMP
  WHERE EMPNO NOT IN (SELECT MGR FROM EMP WHERE NOT MGR IS NULL); 
  
SELECT JOB, ENAME, EMPNO, DEPTNO
  FROM EMP
  WHERE EMPNO NOT IN (SELECT NVL(MGR,0) FROM EMP);  -- �������� �ҽ�
  
SELECT M.JOB, M.ENAME, M.EMPNO, M.DEPTNO
  FROM EMP W, EMP M
  WHERE W.MGR(+)=M.EMPNO AND W.ENAME IS NULL; -- SELF JOIN �� OUTTER JOIN �̿� 