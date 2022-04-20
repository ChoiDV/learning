-- [X] VIEW, INLINE VIEW, TOP-N ����
-- 1. VIEW : ������ ���̺� (1) �ܼ��� (2) ���պ�
-- ��� �÷����� ������ ���� ���̺�
-- �̹� �����ϰ� �ִ� ���̺� ���������� �����ϵ��� �ϱ� ����

-- (1) �ܼ��� : �ϳ��� ���̺�� ������ ��
-- EMPv0 �̶�� VIEW ���� �Ǵ� ���� = EMP���̺� �Ϻ� �ʵ带 ���� ������ ���̺�
SELECT * FROM USER_VIEWS; -- ������ ��ųʸ� �� Ȯ��

CREATE OR REPLACE VIEW EMPv0 
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP; -- DDL�� �����ϸ� ������ ��ųʸ� �ڵ� ����

SELECT * FROM EMPv0; -- ������ ���̺�
INSERT INTO EMPv0 VALUES (1111,'ȫ','ITMANAGER',7369,SYSDATE,40);
SELECT * FROM EMP;
UPDATE EMPv0 SET JOB='MANAGER' WHERE EMPNO=1111; -- �� UPDATE�ϸ� EMP���̺� UPDATE��
DELETE FROM EMPv0 WHERE EMPNO=1111; -- �� DELETE�ϸ� EMP���̺� DELETE ��
SELECT * FROM EMPv0;
SELECT * FROM EMP;

-- EMPv0�̶�� VIEW : EMP���̺��� 30�� �μ��ุ 
CREATE OR REPLACE VIEW EMPv0 
    AS SELECT * FROM EMP WHERE DEPTNO=30;
SELECT * FROM EMPv0;
DESC EMPv0;
INSERT INTO EMPv0 VALUES (1111,'ȫ',NULL,NULL,SYSDATE,9000,900,30); -- 30�� �μ� INSERT
SELECT * FROM EMPv0;
SELECT * FROM EMP;
-- 40�� �μ� INSERT �� �����ϳ� EMPv0������ ������ ����. EMPv0�� 30���μ��� ���̰� �س���
INSERT INTO EMPv0 VALUES (2222,'��',NULL,NULL,SYSDATE,8000,800,40);
SELECT * FROM EMPv0;
SELECT * FROM EMP;
DELETE FROM EMPv0 WHERE EMPNO IN (1111,2222); -- �̷��� 1111�� ������, 2222�� EMPv0���� ���ٰ� �����ؼ� 
SELECT * FROM EMPv0;
SELECT * FROM EMP;
DELETE FROM EMP WHERE EMPNO=2222; -- 40�� �μ��� EMP���� ����

-- EMPv0 �� ����: ENAME, JOB, HIREDATE������ �� ���� NOT NULL�ʵ带 �������ϸ� INSERT �Ұ� 
CREATE OR REPLACE VIEW EMPv0
    AS SELECT ENAME, JOB, HIREDATE FROM EMP;
INSERT INTO EMPv0 VALUES ('ȫ','SALESMAN',SYSDATE);   -- NOT NULL�ʵ带 �������ϸ� INSERT �Ұ�
SELECT * FROM EMPv0;
COMMIT;

-- VIEW�� ���� ���� (1) ���� ���� (2) �б� ���� 
-- WITH CHECK OPTION�� ������ ��� ���� ���ǿ� �ش�Ǵ� �����͸� ����, ����, ���� ����
-- WITH READ ONLY : ������ ��� �б� ���� ��
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO= 30
        WITH CHECK OPTION;  -- 30�� �μ��� �ƴϸ� ������ ����,����,���� �Ұ���
INSERT INTO EMPv0 VALUES(1111,'ȫ',NULL,NULL,SYSDATE,9000,900,30); 
INSERT INTO EMPv0 VALUES(1112,'��',NULL,NULL,SYSDATE,9000,900,40);  -- 30�� �μ��� �ƴ϶� �Ұ���
SELECT * FROM EMP;
DELETE FROM EMPv0 WHERE ENAME='SMITH'; -- 20�� �μ� SMITH �� ���� �ȵ�
DELETE FROM EMPv0 WHERE EMPNO=1111; -- 30�� �μ� DELETE
SELECT * FROM EMP;

-- EMPv0 : �б����� ��
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, DEPTNO FROM EMP
        WITH READ ONLY;  -- �б� ���� ��
INSERT INTO EMPv0 VALUES (1111,'ȫ',NULL,NULL,40);  -- ���� (�б����� ��)


-- (2) ���պ� : 2�� �̻��� ���̺�� ������ ���̰ų� ������ �ʵ�� �並 ���� ��� DML ���� ���������� ����Ҽ� ����
-- 1. 2�� �̻��� ���̺�
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DNAME, LOC
        FROM EMP E, DEPT D
            WHERE E.DEPTNO = D.DEPTNO;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111,'HONG','MANAGER','RESEARCH','DALLAS'); -- ���պ�� ���� �Ұ� (INSERT, DELETE �Ұ� )

-- 2. ������ �ʵ�� �� ���� : �÷��� ��Ī(�����ڷν���, ������, ����, _ )�� �̿��Ͽ� �� ���� 
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, SAL*12 "YEAR_SAL" FROM EMP     -- ������ ��Ī ���� ��� 
        WHERE DEPTNO=10;

CREATE OR REPLACE VIEW EMPv0 (EMPNO, ENAME, YEAR_SAL)  -- �̷��� ��Ī ���� ���� ( ��Ī�鸸 ���� ���� )
    AS SELECT EMPNO, ENAME, SAL*12 FROM EMP 
        WHERE DEPTNO=10; 
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111,'ȫ',2400); -- ���պ�� ���� �Ұ�

-- ex. �μ���ȣ, �ּұ޿�, �ִ� �޿�, �μ���� �޿��� ������ �� ���� DEPTv1
CREATE OR REPLACE VIEW DEPTv1 (DEPTNO,MINSAL,MAXSAL,AVGSAL)
    AS SELECT DEPTNO, MIN(SAL),MAX(SAL), AVG(SAL)
        FROM EMP
            GROUP BY DEPTNO;
SELECT * FROM DEPTv1;

-- ex. ��å, �μ��� ������ EMPv0 �並 ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT DISTINCT JOB, DEPTNO
        FROM EMP
            ORDER BY DEPTNO;  -- DISTINCT �����ϸ� INSERT �Ұ� 
SELECT * FROM EMPv0;

-- 2. INLINE VIEW : FROM���� ���������� INLINE VIEW�� �ϸ�, FROM���� ���� ���������� VIEW ó�� �۵�
-- ex. �޿��� 2000�� �ʰ��ϴ� ����� ��� �޿�
SELECT AVG(SAL) FROM EMP WHERE SAL > 2000;

SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL> 2000);  -- FROM���� ���������� �̿�. ��� �並 ��������

-- ex. �μ� ��� ���޺��� ���� ����� ���, �̸� ,�޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP E
        WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO); --  ��������

--INLINE VIEW
SELECT EMPNO, ENAME, SAL
    FROM EMP E,(SELECT DEPTNO, AVG(SAL) "AVGSAL" FROM EMP GROUP BY DEPTNO) A
        WHERE E.DEPTNO=A.DEPTNO
            AND SAL > AVGSAL;

-- 3. TOP-N ���� (TOP 1~10�� / TOP 11~20�� / TOP 6~10�� )
-- �� ROWNUM : FROM���� ���̺�κ��� ������ ����
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO=20;
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO=20 ORDER BY ENAME;

-- ���, �̸�, SAL (��ü�࿡ ����)
SELECT ROWNUM, ENAME, SAL FROM EMP ORDER BY SAL DESC; -- ��� ROWNUM�� ����� �ƴϰ� ���̺�κ��� ������ ����

SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL DESC);  -- ROWNUM�� ��� 
    
-- �Լ��� �̿��� RANK ��� (����)
SELECT RANK() OVER(ORDER BY SAL DESC) RANK,
    DENSE_RANK() OVER(ORDER BY SAL DESC) DENSE_RANK,
    ROW_NUMBER() OVER(ORDER BY SAL DESC) ROW_NUMBER,
    ENAME, SAL FROM EMP;

-- SAL�������� 1~5��
SELECT ROWNUM, ENAME, SAL 
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM <=5;

-- SAL �������� 6~10
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)
        WHERE ROWNUM BETWEEN 6 AND 10; -- ����� ���൵ �ȳ���


-- �� TOP - N ���� 1�ܰ�
SELECT ROWNUM "RN", ENAME, SAL
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC);
-- �� TOP - N ���� 2�ܰ� (�ϼ��� TOP-N����)
SELECT ROWNUM, RN, ENAME, SAL
    FROM (SELECT ROWNUM "RN", ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)) A
        WHERE RN BETWEEN 6 AND 10;  -- BETWEEN ���ڸ� �ٲٸ� ��� �ٲܼ� ����
        
-- �̸��� ���ĺ� ������� �����ؼ� 6~10��°���� ���(���, �̸�, ���, JOB, MGR, HIREDATE)
SELECT RN, ENAME, EMPNO, JOB, MGR, HIREDATE
    FROM (SELECT ROWNUM "RN",ENAME, EMPNO, JOB, MGR, HIREDATE FROM (SELECT * FROM EMP ORDER BY ENAME) ) A
        WHERE RN BETWEEN 6 AND 10;
        
-- �� ��������
-- 1. �μ���� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW DNAME_ENAME_VU
    AS SELECT DNAME, ENAME FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO;
SELECT * FROM DNAME_ENAME_VU;

-- 2. ������ ���ӻ������ ����ϴ� �뵵�� ��,  WORKER_MANAGER_VU�� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW WORKER_MANAGER_VU
    AS SELECT W.ENAME "WORKER", M.ENAME "MANAGER"FROM EMP W, EMP M
        WHERE W.MGR = M.EMPNO;
SELECT * FROM WORKER_MANAGER_VU;

-- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���). -- �л� ����
SELECT DEPTNO, "SUMSAL" ,RN
    FROM (SELECT ROWNUM "RN",DEPTNO, "SUMSAL" FROM 
            (SELECT DEPTNO,SUM(SAL) "SUMSAL" FROM EMP GROUP BY DEPTNO ORDER BY SUMSAL DESC));

            
-- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�.
SELECT DEPTNO, SUMSAL, RN
    FROM (SELECT ROWNUM "RN",DEPTNO, "SUMSAL" FROM 
              (SELECT DEPTNO,SUM(SAL) "SUMSAL" FROM EMP GROUP BY DEPTNO ORDER BY SUMSAL DESC))
            WHERE RN IN (2,3);
           
-- 4. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
        ORDER BY HIREDATE DESC;
-- 5. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�
SELECT RN, EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM "RN",EMPNO,ENAME,HIREDATE FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC))
            WHERE RN BETWEEN 1 AND 5;

SELECT EMPNO, ENAME, HIREDATE
    FROM( SELECT EMPNO, ENAME, HIREDATE FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC))
        WHERE ROWNUM <= 5;  -- �̷��� �ص� �� ������ ���ĵȻ��¿��� ������ ������ ���⶧���� �̷��� �ص���
                             -- ��� 6~10 ��° ó�� �߰����� �����°��� �ȵ�
            
-- 6. ��� ���̺��� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� ���
SELECT RN, EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM "RN",EMPNO,ENAME,HIREDATE FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC))
            WHERE RN BETWEEN 6 AND 10;

SELECT EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM "RN",A.* FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC) "A")
            WHERE RN BETWEEN 6 AND 10;   -- �̷��� �Ȱ���