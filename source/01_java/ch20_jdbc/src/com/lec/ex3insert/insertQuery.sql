--
INSERT INTO DEPT VALUES(50,'IT','SEOUL');
COMMIT;
-- �μ���ȣ �ߺ� üũ
SELECT * FROM DEPT WHERE DEPTNO=50;   -- 1
SELECT COUNT(*) "CNT" FROM DEPT WHERE DEPTNO=70;  --2
-- 1. rs.next() ����� true �� �ߺ�, false �� �ߺ��ƴ� �׷��Ƿ� ���� �ƹ��͵� ������ false
-- 2. 1�̳����� �ߺ�, 0�̳����� �ߺ��ƴ� �׷��Ƿ� ����
--  1���� rs.next ����� ���൵ �ȳ����ų� ������ �����ų�  �׷��� ���൵�ȳ����� false ���� ������ true �� false�� �ߺ��ƴ� true�� �ߺ� 
-- 2���� rs.next ����� ������ ������ ������ ������ rs.next() �� ���ְ� �״��� rs.next() ����   1�̳� 0�� �� 
DESC DEPT;
COMMIT;
SELECT * FROM DEPT ;
DELETE FROM DEPT WHERE DEPTNO = 55;

UPDATE DEPT SET DNAME='ABC',LOC='SEOUL' WHERE DEPTNO=90;
