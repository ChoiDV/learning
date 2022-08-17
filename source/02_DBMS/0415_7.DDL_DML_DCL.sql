-- [VII] DDL, DML, DCL
--  SQL = DDL( ���̺� ����, ���̺� ����, ���̺� ��������, ���̺� ��� ������ ����)
--        DML(�˻�=SELECT, �߰� = INSERT, ����= UPDATE, ���� = DELETE)
--        DCL(����ڰ�������, ����ڱ��Ѻο�, ���ѹ�Ż, ����ڰ�������, Ʈ����� ��ɾ�=ROLLBACK, COMMIT)

-- �� �� �� DDL �� �� ��
-- 1. ���̺� ���� (CREATE TABLE)
CREATE TABLE BOOK(
    BOOKID NUMBER(4),   -- ������ȣ BOOKID �ʵ� Ÿ���� ����4�ڸ�
    BOOKNAME VARCHAR2(300), -- å�̸� BOOKNAME �ʵ�� ���� 300BYTE   ()�ȿ� BYTE�� �����ִ°��̰� �ѱ��� 1���ڿ� 3BYTE ����� 1BYTE
    PUBLISHER VARCHAR2(300),-- ���ǻ� PUBLISHER �ʵ�� ���� 300BYTE,
    RDATE     DATE,         -- ������ RDATE �ʵ�� DATE��
    PRICE     NUMBER(8),    -- ���� PRICE �ʵ�� ����8�ڸ�
    PRIMARY KEY(BOOKID) );  -- ���̺� �� ��Ű(PRIMARY KEY) ���� - NOT NULL, ������ �� �Է�
SELECT * FROM BOOK;
DROP TABLE BOOK;    -- ���̺� ���� 

CREATE TABLE BOOK(
    BOOKID NUMBER(4) PRIMARY KEY,   
    BOOKNAME VARCHAR2(20), 
    PUBLISHER VARCHAR2(20),
    RDATE     DATE,        
    PRICE     NUMBER(8) ); 

SELECT ROWNUM, EMPNO, ENAME FROM EMP;  -- ROWNUM : ���̺��� �о���� ���� ����
SELECT ROWNUM, EMPNO, ENAME FROM EMP WHERE DEPTNO = 20 ORDER BY ENAME;

-- EMP ���̺�� ������ EMP01 : EMPNO(����4), ENAME(����20), SAL(����7,2)
CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20),
    SAL NUMBER(7,2)  );

DESC EMP01;

-- DEPT�� ������ DEPT01 : DEPTNO(����2,PK), DNAME(����14), LOC(����13)
CREATE TABLE DEPT01 (
    DEPTNO NUMBER(2),
    DNAME  VARCHAR2(14),
    LOC  VARCHAR2(13),
    PRIMARY KEY(DEPTNO)  );

DESC DEPT01;

-- ���������� �̿��� ���̺� ����
CREATE TABLE EMP02
    AS
        SELECT * FROM EMP;
-- �������� ����� EMP02 ���̺� ������ ��

SELECT * FROM EMP02;
DESC EMP02; -- �������� ������
    -- ex. EMP03 : EMP ���̺��� EMPNO, ENAME, DEPTNO�� ������ �����ͷ� ���̺�

CREATE TABLE EMP03
    AS 
        SELECT EMPNO, ENAME, DEPTNO FROM EMP;
SELECT * FROM EMP03;

    -- ex. EMP04 : EMP���̺��� 10�� �μ��� ������ �����ͷ� ���̺�
CREATE TABLE EMP04
    AS
        SELECT * FROM EMP WHERE DEPTNO=10;
SELECT * FROM EMP04;        -- ���̺� ������ �����Ҷ� �̷��� ���, ������ �ý��� ���׷��̵� �Ҷ�

    -- ex.EMP05 : EMP ���̺� ���� (�ʵ�� ���� Ÿ��) �� ����
CREATE TABLE EMP05
    AS
        SELECT * FROM EMP WHERE 1=0;    -- �̷��� ����� ������ ���� 
SELECT * FROM EMP05;


-- 2.���̺� ��������  (ALTER TABLE) 
-- ALTER : ������ �����ϴ� �����ͺ��̽� ��ü�� �ٽ� ����
-- ALTER TABLE ���̺�� ADD || MODIFY || DROP ~ 

-- (1) �ʵ� �߰� (ADD) : �߰��� �ʵ��� �����ʹ� NULL
SELECT * FROM EMP03;  -- EMPNO, ENAME, DEPTNO
ALTER TABLE EMP03 ADD (JOB VARCHAR2(20), SAL NUMBER(7,2) );
SELECT * FROM EMP03;
ALTER TABLE EMP03 ADD(COMM NUMBER(7,2) );
SELECT * FROM EMP03;

-- (2) �ʵ� ���� (MODIFY) : 
SELECT * FROM EMP03; -- EMPNO(��4), ENAME(��10), DEPTNO(��2) / JOB(��20), SAL, COMM(�� 7,2)�� ������ NULL
ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2(4)); -- �̹� ���� �����Ͱ� ����ִ� ���¿����� ���ڷθ� ���� ����

ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(3)); -- �Ұ���  �۰Դ� �Ұ���
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(5)); -- ����
ALTER TABLE EMP03 MODIFY (ENAME NUMBER(4)); -- �Ұ���  ���ڵ����Ͱ� ��� �ִ� ���¿����� ���ڷθ� ���� ����
SELECT MAX(LENGTH(ENAME)) FROM EMP;
ALTER TABLE EMP03 MODIFY( ENAME VARCHAR2(3000));
DESC EMP03;
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(6));
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(5)); -- �Ұ��� (6BYTE ���� �����Ͱ� �־)  
ALTER TABLE EMP03 MODIFY (JOB VARCHAR2(2));
ALTER TABLE EMP03 MODIFY(JOB NUMBER(4));

-- (3) �ʵ� ���� ( DROP )
ALTER TABLE EMP03 DROP COLUMN JOB;
SELECT * FROM EMP03;
-- �������� Ư�� �ʵ带 ���� ���ϵ��� (��)
ALTER TABLE EMP03 SET UNUSED (DEPTNO);
SELECT * FROM EMP03;
-- �������� ���� �Ұ��ߴ� �ʵ带 ���������� ���� (����)
ALTER TABLE EMP03 DROP UNUSED COLUMNS;

-- 3. ���̺� ���� (DROP TABLE)
DROP TABLE EMP01;
DROP TABLE DEPT; -- �ٸ� ���̺��� �����ϴ� �����Ͱ� ������� DROP�� �ȵ�
SELECT * FROM EMP;

-- 4. ���̺��� ��� ���� ���� 
SELECT * FROM EMP03;
TRUNCATE TABLE EMP03;  -- EMP03 ���� ������ ���� (��� �Ұ�)
SELECT * FROM EMP03;

-- 5. ���̺�� ���� (RENAME �����̸� TO ���ο��̸�)
SELECT * FROM EMP02;
RENAME EMP02 TO EMP2;
SELECT * FROM EMP2;

-- 6. ������ ��ųʸ�(���� �Ұ�) VS ������ ��ųʸ� ��(����� ���ٿ�)
-- ����
-- USER_XXX : �� ������ �����ϰ� �ִ� ������ ��ü (���̺�, �ε���, ��������, ��)
    -- ex. USER_TABLES, USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS.
SELECT * FROM USER_TABLES; -- �� ������ ������ ���̺� ��ü ����
SELECT * FROM USER_INDEXES; -- �� ������ ������ �ε��� ���� 
SELECT * FROM USER_CONSTRAINTS; -- �� ������ ������ �������ǵ�
SELECT * FROM USER_VIEWS;  -- �� ������ ������ �� ���� 
    
-- ALL_XXX : �� ������ ���� ������ ��ü(���̺�, �ε���, ��������, ��)
    -- ex. ALL_TABLES, ALL_INDEXES, ALL_CONSTRAINTS, ALL_VIEWS
SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_INDEXES;
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_VIEWS;
    
-- DBA_XXX : DAB�����ڸ� ���ٰ���. DBMS�� ��� ��ü
    -- ex. DBA_TABLES, DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS
SELECT * FROM DBA_TABLES;
SELECT * FROM DBA_INDEXES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;

-- �� �� �� DCL(����� ���� ����, ����� ���� �ο�, ���ѹ�Ż, ����� ���� ����) �� �� ��
CREATE USER scott2 IDENTIFIED BY 1234;  -- scott2 ���� ����

-- ���Ѻο� (���Ǳ���, scott.EMP, scott.DEPT ���̺� ���� ��� ���� �ֱ�)
GRANT CREATE SESSION TO scott2;
GRANT ALL ON EMP TO scott2; -- EMP ���̺� ���� ��� ����(�˻�, �߰�, ����, ����)
GRANT ALL ON DEPT TO scott2; -- DEPT ���̺� ���� ��� ����
SHOW USER;

-- ���� ��Ż (���ѹ�Ż�� ����ڰ����� ��������)
REVOKE ALL ON EMP FROM scott2; -- scott2�� emp ���̺� ���� ��� ���� ��Ż
REVOKE ALL ON DEPT FROM scott2; -- scott2�� dept ���̺� ���� ��� ���� ��Ż
SHOW USER;

-- �� �� �� DML (SELECT, INSERT, UPDATE, DELETE) �� �� ��
-- 1. INSERT INTO ���̺�� VALUES (��1, ��2, ��3, ...);
--    INSERT INTO ���̺�� (�ʵ��1, �ʵ��2, ...) VALUES (��1, ��2, ...);
SELECT * FROM DEPT01;
INSERT INTO DEPT01 VALUES (50, 'ACCOUNTING' , 'NEW YORK');
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES ( 60,'IT','SEOUL');
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (70,'OPERATION'); -- ���������� LOC�� NULL �߰�
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (80,'HR',NULL); -- ��������� NULL �߰�
INSERT INTO DEPT01 VALUES (90,'SALES',NULL); -- ��������� NULL �߰�
-- ���������� �̿��� INSERT
INSERT INTO DEPT01 SELECT * FROM DEPT;
-- Ʈ����� ��ɾ� (DML ��ɾ)
COMMIT;

-- �������� 2�� 
CREATE TABLE SAM01 (
    EMPNO NUMBER(4) CONSTRAINTS SAM_PK PRIMARY KEY,  -- CONSTRAINTS ���������̸�  = SAM_PK
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    SAL NUMBER(7,2) );
--  PRIMARY KEY(EMPNO) �̷��� ���������� ������ ����

INSERT INTO SAM01 (EMPNO,ENAME,JOB,SAL) VALUES (1000,'APPLE','POLICE',10000);
INSERT INTO SAM01 (EMPNO,ENAME,JOB,SAL) VALUES (1010,'BANANA','NURSE',15000);
INSERT INTO SAM01 (EMPNO,ENAME,JOB,SAL) VALUES (1020,'ORANGE','DOCTOR',25000);
INSERT INTO SAM01 (EMPNO,ENAME,SAL) VALUES (1030,'VERY',25000);
INSERT INTO SAM01 (EMPNO,ENAME,SAL) VALUES (1040,'CAT',2000);
INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO='10';   -- EMP���̺��� 10���μ��� ����� ���� �߰��ϱ� 
    -- INSERT ���� ���� ���������� ��ȣ �ȳ־ ��.
-- INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE EMPNO = '7782';  -- �̷��� �Ѹ� �߰��ϱ� 

SELECT * FROM SAM01;

SELECT * FROM USER_CONSTRAINTS;
-- Ʈ����� ��ɾ� �� �ϱ� ���ϸ� INSERT ��ҵ�
COMMIT;



-- �ڡڡڡڡ� 2. UPDATE ���̺�� SET �ʵ��1=��1 [, �ʵ��2=��2,...] [WHERE ����];
CREATE TABLE EMP01 AS SELECT * FROM EMP; -- EMP�� �Ȱ��� EMP01 ���̺� �����

-- EMP01 ���̺��� �μ���ȣ�� 30���� ����(WHERE �� ���̴� ��� ���� ����) -- ��� DML���� �����ͺ��̽��� �����Ϸ��� COMMIT �� �ؾ���.
UPDATE EMP01 SET DEPTNO=30 WHERE ENAME = 'SMITH';

-- EMP01 ���̺��� ��� ����� �޿��� 10% �λ�
UPDATE EMP01 SET SAL = SAL*1.1;
SELECT * FROM EMP01;

-- 10�� �μ��� ������ �Ի����� ���÷�, �μ���ȣ�� 30������ ����
UPDATE EMP01
    SET HIREDATE = SYSDATE,
        DEPTNO = 30 
    WHERE DEPTNO=10;
SELECT * FROM EMP01;

-- SAL�� 3000�̻��� ����� �޿��� 10% �λ�
UPDATE EMP01
    SET SAL = SAL*1.1
    WHERE SAL >= 3000;
SELECT * FROM EMP01;

-- 'DALLAS'�� �ٹ��ϴ� ������ �޿��� 1000$�� �λ�(�������� ���)
UPDATE EMP01
    SET SAL = SAL+1000
        WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');
SELECT * FROM EMP01;

-- SCOTT�� �μ���ȣ�� 20����, JOB�� MANAGER�� SAL�� COMM�� 500�� �λ�, ��縦 KING���� ����
UPDATE EMP01
    SET DEPTNO=20,
        JOB = 'MANAGER',
        COMM = NVL(COMM,0)+500,
        MGR = (SELECT EMPNO FROM EMP WHERE ENAME='KING')
    WHERE ENAME = 'SCOTT';
SELECT * FROM EMP01;

-- DEPT01���� 20������ �������� DEPT���̺��� 60���μ��� ���������� ����
UPDATE DEPT01 SET LOC= (SELECT LOC FROM DEPT WHERE DEPTNO=60)
    WHERE DEPTNO >= 20; -- DEPT ���̺� 60�� �μ��� ��� NULL������ ����
SELECT * FROM DEPT01;

COMMIT;
-- EMP01 ���̺��� ��� ����� �޿��� �Ի����� 'KING'�� �޿��� �Ի��Ϸ� ����
SELECT * FROM EMP01;
UPDATE EMP01
    SET SAL = (SELECT SAL FROM EMP WHERE ENAME = 'KING'),
        HIREDATE = (SELECT HIREDATE FROM EMP WHERE ENAME = 'KING');
        
UPDATE EMP01
    SET (SAL,HIREDATE) = (SELECT SAL, HIREDATE FROM EMP WHERE ENAME='KING');

-- DEPT01 ���̺��� 20�� �μ��� ������� �μ����� 40�� �μ��� ������� �μ������� ����
UPDATE DEPT01
    SET (DNAME,LOC) = (SELECT DNAME, LOC FROM DEPT01 WHERE DEPTNO=40)
    WHERE DEPTNO = 20;
COMMIT;

-- �ڡڡڡڡ� 3. DELETE FROM ���̺�� [WHERE ����];
SELECT * FROM EMP01;
DELETE FROM EMP01; -- WEHRE ���� �� ����� ��ü ���� ��� ����. / ROLLBACK ���� �������� 


-- EMP01 ���̺��� 'FORD'�� ����� ����
DELETE FROM EMP01 WHERE ENAME = 'FORD';
SELECT * FROM EMP01 WHERE ENAME = 'FORD';

-- EMP01 ���̺��� 30�� �μ� ������ ����
DELETE FROM EMP01 WHERE DEPTNO=30;
SELECT *  FROM EMP01;

-- EMP01 ���̺��� �μ����� RESEARCH�μ��� ������ ����
DELETE FROM EMP01
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'RESEARCH');

-- SAM01  ���̺��� JOB�� �������� ���� ����� ����
SELECT * FROM SAM01;
DELETE FROM SAM01
    WHERE JOB IS NULL;

-- SAM01 ���̺��� ENAME�� ORANGE�� ����� �����Ͻÿ�
DELETE FROM SAM01
    WHERE ENAME='ORANGE';
COMMIT;

-- �������� PDF 1������
CREATE TABLE MY_DATA(
    ID NUMBER(4),
    NAME VARCHAR2(10),
    USERID VARCHAR2(30),
    SALARY NUMBER(10,2), 
    PRIMARY KEY(ID) );

INSERT INTO MY_DATA (ID,NAME,USERID,SALARY) VALUES (1,'Scott','sscott',10000);
INSERT INTO MY_DATA (ID,NAME,USERID,SALARY) VALUES (2,'Ford','fford',13000);
INSERT INTO MY_DATA (ID,NAME,USERID,SALARY) VALUES (3,'Patel','ppatel',33000);
--INSERT INTO MY_DATA (ID,NAME,USERID,SALARY) VALUES (3,'Patel','ppatel',TO_NUMBER('33,000.00','99,999,99'));
INSERT INTO MY_DATA (ID,NAME,USERID,SALARY) VALUES (4,'Report','rreport',23500);
--INSERT INTO MY_DATA (ID,NAME,USERID,SALARY) VALUES (4,'Report','rreport',TO_NUMBER('26,500,00','00,000.00'));
INSERT INTO MY_DATA (ID,NAME,USERID,SALARY) VALUES (5,'Good','ggood',44450);

SELECT * FROM MY_DATA;

SELECT ID,NAME,USERID,TO_CHAR(SALARY,'99,999,999.99') FROM MY_DATA;

COMMIT;

UPDATE MY_DATA
    SET SALARY = 65000
        WHERE ID = '3';

COMMIT;

DELETE FROM MY_DATA
    WHERE NAME = 'Ford';
COMMIT;

UPDATE MY_DATA
    SET SALARY = 15000
        WHERE SALARY <= 15000;
        
DELETE FROM MY_DATA;  -- ������ ���� ��������
DROP TABLE MY_DATA;  -- ���̺� ����  ���� �Ұ��� 

-- �� �� �� �������� �� �� ��  : �������� �����Ͱ� ���̺� ����, ���� �Ǵ� ���� �����ϱ� ����
SELECT * FROM EMP;
INSERT INTO EMP VALUES (7369, 'ȫ', NULL, NULL , SYSDATE, NULL, NULL, 40) -- SMITH ����� �ߺ� ����
UPDATE EMP SET EMPNO = 7369 WHERE ENAME = 'ALLEN'; -- SMITH ����� �ߺ� ����

-- ��(1) PRIMARY KEY : �����ϰ� ���̺��� �� ���� �ĺ�. PRIMARY KEY���� NOT NULL
    INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (7369,'ȫ',40); -- �ߺ��� ��� �Է� �Ұ�
    
-- (2) NOT NULL : NULL���� �������� ����
-- (3) UNIQUE : ��� �࿡ ���� �����ؾ�. NULL���� ��� (NULL�� ������ �Է� ����)

-- ��(4) FOREIGN KEY : ���̺��� ���� �ٸ� ���̺��� ���� ���� (ex. EMP���̺��� DEPTNO�� DEPTNO�� DEPT ���̺��� DEPTNO�� ����)
    -- ��ĺ� ����: �θ� ���̺��� ��Ű�� �ڽ����̺��� �ϹݼӼ��� ���� �ʵ�� ���踦 ������ (exERD���� �������� ȭ��ǥ)
    -- �ĺ� ����:  �θ� ���̺��� ��Ű�� �ڽ����̺��� ��Ű(��Ű��)�� ���� �ʵ�� ���踦 ������ ( exERD���� �ʷ����� ȭ��ǥ)
    INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (1111, 'ȫ', 90); -- �ܷ�Ű�� 90�� �Է� �Ұ�
    
-- (5) CHECK(����) : �ش� ������ ���� (NULL�� ���)
-- DEFAULT : �ش� ���� ������ �Է°��� ������ NULL�� ����, �⺻���� �����ϸ� �� �⺻���� ��


DROP TABLE DEPT1;

CREATE TABLE DEPT1(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14) UNIQUE,
    LOC VARCHAR2(13) NOT NULL );
    
DROP TABLE EMP1; --���̺� ����� ���� ������ ����� ���� DROP TABLE

CREATE TABLE EMP1 (
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    MGR NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE,
    SAL NUMBER(7,2) CHECK(SAL >0),
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2) REFERENCES DEPT1(DEPTNO) );

DROP TABLE DEPT1; -- �ٸ� ���̺��� �����ϴ� �ʵ尡 ������ (�θ����̺���) ���� DROP �ȵ�.
DROP TABLE DEPT1 CASCADE CONSTRAINTS; -- ���� (�����ϴ� ���̺��� �־ �����ϰ� DROP)

CREATE TABLE DEPT1(
    DEPTNO NUMBER(2),
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13) NOT NULL,
    PRIMARY KEY(DEPTNO),
    UNIQUE(DNAME) );

CREATE TABLE EMP1(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    MGR NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE,
    SAL NUMBER(7,2),
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2),
    PRIMARY KEY(EMPNO),
    CHECK(SAL>0),
    FOREIGN KEY(DEPTNO) REFERENCES DEPT1(DEPTNO) );

INSERT INTO DEPT1 SELECT * FROM DEPT;
SELECT * FROM DEPT1;
INSERT INTO DEPT1 VALUES(40,'IT','SEOUL'); -- PK �������ǿ� ����
INSERT INTO DEPT1 VALUES(50,'SALES','SEOUL'); -- UNIQUE �������ǿ� ����
INSERT INTO DEPT1 VALUES(50,'IT',NULL); -- NOT NULL �������ǿ� ����

INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO) VALUES (1001,'ȫ',10);  --HIREDATE�� DEFAULT ������ SYSDATE�� ��
SELECT * FROM EMP1;
INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO) VALUES (1001,'��',10); -- PK ����
INSERT INTO EMP1 (EMPNO, DEPTNO) VALUES (1002,20); -- ENAME�� NOT NULL����

INSERT INTO EMP1 (EMPNO, ENAME, SAL, DEPTNO) VALUES (1002, '��', -1); -- SAL�� CHECK ���� ���� 
INSERT INTO EMP1 VALUES(1002,'��',NULL, NULL, TO_DATE('95/01/01','YY/MM/DD'), 900 , NULL, 99);  --DEPTNO��  FK ���� FOREIGN KEY

COMMIT;

-- �������� (PDF 4��5��)
DROP TABLE BOOKCATEGORY;
CREATE TABLE BOOKCATEGORY(
    CATEGORY_CODE NUMBER(3) PRIMARY KEY,
    CATEGORY_NAME VARCHAR2(20) UNIQUE,
    OFFICE_LOC VARCHAR2(20) NOT NULL );

DROP TABLE BOOK;
CREATE TABLE BOOK(
    CATEGORY_CODE REFERENCES BOOKCATEGORY(CATEGORY_CODE),  --BOOK�� CATEGORY_CODE�� BOOKCATEGORY�� CATEGORY_CODE�� �Ѵ�.
    BOOKNO VARCHAR2(10) PRIMARY KEY, 
    BOOKNAME VARCHAR2(50),
    PUBLISHER VARCHAR(50),
    PUBYEAR NUMBER(4) DEFAULT EXTRACT(YEAR FROM SYSDATE) );
SELECT * FROM BOOK;
INSERT INTO BOOKCATEGORY VALUES(100,'ö��','3�� �ι���');
INSERT INTO BOOKCATEGORY VALUES(200,'�ι�','3�� �ι���');
INSERT INTO BOOKCATEGORY VALUES(300,'�ڿ�����','4�� ���н�');
INSERT INTO BOOKCATEGORY VALUES(400,'IT','4�� ���н�');
SELECT * FROM BOOKCATEGORY;

INSERT INTO BOOK VALUES(100,'100A01','ö������ ��','��������',2021);
INSERT INTO BOOK VALUES(400,'400A01','�̰��� DB��','��������',2018);
INSERT INTO BOOK (CATEGORY_CODE,BOOKNO,BOOKNAME,PUBLISHER) VALUES (100,'500A01','YA','THEJONE'); -- ���ǳ� Ȯ��
SELECT * FROM BOOK;

-- 5��

DROP TABLE MAJOR;
CREATE TABLE MAJOR(
    MAJOR_CODE NUMBER(4) PRIMARY KEY,
    MAJOR_NAME VARCHAR2(50) UNIQUE,
    MAJOR_OFFICE_LOC VARCHAR2(50) NOT NULL );

DROP TABLE STUDENT;
CREATE TABLE STUDENT(
    STUDENT_CODE VARCHAR(10) PRIMARY KEY,
    STUDENT_NAME VARCHAR(20),
    SCORE NUMBER(3) CHECK( SCORE >= 0 AND SCORE <= 100),  -- ( SCORE BETWEEN 0 AND 100) �̷��� �ص���
    MAJOR_CODE REFERENCES MAJOR (MAJOR_CODE) );

INSERT INTO MAJOR VALUES (1,'�濵����','�濵�� 305ȣ');
INSERT INTO MAJOR VALUES (2,'����Ʈ�������','������ 808ȣ');
INSERT INTO MAJOR VALUES (3,'������','������ 606ȣ');
INSERT INTO MAJOR VALUES (4,'����','���� 202ȣ');
SELECT * FROM MAJOR;

INSERT INTO STUDENT VALUES('A01','��浿',100,1);
INSERT INTO STUDENT VALUES('A02','���浿',90,2);
INSERT INTO STUDENT VALUES('A03','ȫ�浿',95,1);
SELECT * FROM STUDENT;