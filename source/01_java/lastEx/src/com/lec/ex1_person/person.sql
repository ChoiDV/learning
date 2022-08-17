-- ������
DROP TABLE JOB;
DROP TABLE PERSON;

CREATE TABLE JOB(
    JNO NUMBER(2) PRIMARY KEY,
    JNAME VARCHAR2(30) NOT NULL );

CREATE TABLE PERSON(
    PNO NUMBER(5) PRIMARY KEY,
    PNAME VARCHAR2(30) NOT NULL,
    JNO REFERENCES JOB(JNO),
    KOR NUMBER(3),
    ENG NUMBER(3),
    MAT NUMBER(3) );

DROP SEQUENCE PERSON_NO_SQ;
CREATE SEQUENCE PERSON_NO_SQ
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;

INSERT INTO JOB VALUES (10,'���');
INSERT INTO JOB VALUES (20,'����');
INSERT INTO JOB VALUES (30,'MC');


INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL,'���켺',10,90,80,81);
INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL,'�ڼ���',10,80,90,80);
INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL,'�����',20,20,90,90);
INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL,'����',20,95,95,95);
INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL,'������',10,100,100,100);

SELECT * FROM PERSON;
SELECT * FROM JOB;
COMMIT;

-- 1�� pNAME, jNAME, KOR, ENG, MAT�� �Է¹޾� INSERT
INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL,'������',(SELECT jNO FROM JOB WHERE jNAME='���'),100,100,100);
    --                                                                                                    ?                ? = �����̸� �Է¹���                                         ?   ?     ? 
-- 2�� : �������� �Է¹޾� ���, �̸�(pNO), ������, ����, ����, ����, ������ ��� ( ������������ �������� ����)
SELECT PNAME||'(' ||PNO ||'��)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
    FROM PERSON P, JOB J
        WHERE P.JNO = J.JNO AND JNAME = '����' 
            ORDER BY SUM DESC; -- FROM ���� �������� 
            
SELECT ROWNUM RANK, A.*
    FROM (SELECT PNAME||'(' ||PNO ||'��)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
    FROM PERSON P, JOB J
        WHERE P.JNO = J.JNO AND JNAME = '���'
            ORDER BY SUM DESC) A;
        
-- 3�� : ������� ���, �̸�(pNO), ������, ����, ����, ����, ������ ���(������������ �������� ����)
SELECT ROWNUM RANK, A.*
    FROM (SELECT PNAME||'(' ||PNO ||'��)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT "SUM"
    FROM PERSON P, JOB J
        WHERE P.JNO = J.JNO
            ORDER BY SUM DESC) A;

SELECT * FROM PERSON;
SELECT * FROM JOB;
commit;
rollback;

-- �޺� �ڽ��� �� ������ list
SELECT JNAME FROM JOB;








