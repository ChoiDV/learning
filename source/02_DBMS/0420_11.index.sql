--  [ XI ] �ε��� : ��ȸ�� ������ �ϴ� �ε���
SELECT * FROM USER_INDEXES;  -- ��ųʸ��信�� SCOTT�� ������ �ε��� ����
-- PRIMARY KEY �� �̹� �ε����� ���� �������
-- ���� �˻��� ���ؼ� �ε����� ����Ѵ�.
-- SELECT ���� ó���ӵ��� ����Ű�� ���� ���
--  �߰�,����,������ ���� �Ͼ�°͵��� ������ �ε����� ����ϸ� �ӵ��� ��������.
DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP; -- EMP����� ���� EMP01 ����
SELECT * FROM EMP01; -- 14��
INSERT INTO EMP01 SELECT * FROM EMP01; -- 1�� �ݺ� 28�� 2�� 56�� 
SELECT TO_CHAR(COUNT(*),'9,999,999') FROM EMP01;
INSERT INTO EMP01 SELECT * FROM EMP01; -- 11�� �ݺ� (11��4õ��) 
INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES (1111,'HONG',40);
INSERT INTO EMP01 SELECT * FROM EMP01; -- 3�� HONG �ֱ����� (91����)
SELECT TO_CHAR(COUNT(*),'9,999,999') FROM EMP01;  

SELECT * FROM EMP01 WHERE ENAME='HONG'; --  �ε��� ���� �� : 0.017��
CREATE INDEX IDX_EMP_ENAME ON EMP01(ENAME); -- �ε��� ���� -- 0.368��
--CREATE INDEX �ε��� �̸� ON ����̺���(��ʵ�);

SELECT * FROM EMP01 WHERE ENAME='HONG'; -- �ε��� ���� �� : 0.001�� 
SELECT * FROM USER_INDEXES WHERE INDEX_NAME = 'IDX_EMP01_ENAME';
COMMIT;
INSERT INTO EMP01 SELECT * FROM EMP01;  -- �ε��� ���� �� INSERT �� ��   21.451��
ROLLBACK;   --  180�������� 90������ ���� ����  ��Ұ��� ( 10.3��)
DROP INDEX IDX_EMP_ENAME;
INSERT INTO EMP01 SELECT * FROM EMP01;  -- �ε��� ������ INSERT �ð� 0.903��
SELECT TO_CHAR(COUNT(*),'9,999,999') FROM EMP01; 






