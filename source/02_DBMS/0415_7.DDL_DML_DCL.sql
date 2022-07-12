-- [VII] DDL, DML, DCL
--  SQL = DDL( 테이블 생성, 테이블 삭제, 테이블 구조변경, 테이블 모든 데이터 제거)
--        DML(검색=SELECT, 추가 = INSERT, 수정= UPDATE, 삭제 = DELETE)
--        DCL(사용자계정생성, 사용자권한부여, 권한박탈, 사용자계정삭제, 트랜잭션 명령어=ROLLBACK, COMMIT)

-- ★ ★ ★ DDL ★ ★ ★
-- 1. 테이블 생성 (CREATE TABLE)
CREATE TABLE BOOK(
    BOOKID NUMBER(4),   -- 도서번호 BOOKID 필드 타입은 숫자4자리
    BOOKNAME VARCHAR2(300), -- 책이름 BOOKNAME 필드는 문자 300BYTE   ()안에 BYTE를 적어주는것이고 한글은 1글자에 3BYTE 영어는 1BYTE
    PUBLISHER VARCHAR2(300),-- 출판사 PUBLISHER 필드는 문자 300BYTE,
    RDATE     DATE,         -- 출판일 RDATE 필드는 DATE형
    PRICE     NUMBER(8),    -- 가격 PRICE 필드는 숫자8자리
    PRIMARY KEY(BOOKID) );  -- 테이블 내 주키(PRIMARY KEY) 설정 - NOT NULL, 유일한 값 입력
SELECT * FROM BOOK;
DROP TABLE BOOK;    -- 테이블 삭제 

CREATE TABLE BOOK(
    BOOKID NUMBER(4) PRIMARY KEY,   
    BOOKNAME VARCHAR2(20), 
    PUBLISHER VARCHAR2(20),
    RDATE     DATE,        
    PRICE     NUMBER(8) ); 

SELECT ROWNUM, EMPNO, ENAME FROM EMP;  -- ROWNUM : 테이블에서 읽어들인 논리적 순서
SELECT ROWNUM, EMPNO, ENAME FROM EMP WHERE DEPTNO = 20 ORDER BY ENAME;

-- EMP 테이블과 유사한 EMP01 : EMPNO(숫자4), ENAME(문자20), SAL(숫자7,2)
CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20),
    SAL NUMBER(7,2)  );

DESC EMP01;

-- DEPT와 유사한 DEPT01 : DEPTNO(숫자2,PK), DNAME(문자14), LOC(문자13)
CREATE TABLE DEPT01 (
    DEPTNO NUMBER(2),
    DNAME  VARCHAR2(14),
    LOC  VARCHAR2(13),
    PRIMARY KEY(DEPTNO)  );

DESC DEPT01;

-- 서브쿼리를 이용한 테이블 생성
CREATE TABLE EMP02
    AS
        SELECT * FROM EMP;
-- 서브쿼리 결과만 EMP02 테이블 생성후 들어감

SELECT * FROM EMP02;
DESC EMP02; -- 제약조건 미포함
    -- ex. EMP03 : EMP 테이블에서 EMPNO, ENAME, DEPTNO만 추출한 데이터로 테이블

CREATE TABLE EMP03
    AS 
        SELECT EMPNO, ENAME, DEPTNO FROM EMP;
SELECT * FROM EMP03;

    -- ex. EMP04 : EMP테이블에서 10번 부서만 추출한 데이터로 테이블
CREATE TABLE EMP04
    AS
        SELECT * FROM EMP WHERE DEPTNO=10;
SELECT * FROM EMP04;        -- 테이블 데이터 빽업할때 이렇게 사용, 기존의 시스템 업그레이드 할때

    -- ex.EMP05 : EMP 테이블 구조 (필드와 그의 타입) 만 추출
CREATE TABLE EMP05
    AS
        SELECT * FROM EMP WHERE 1=0;    -- 이렇게 만들면 구조만 들어옴 
SELECT * FROM EMP05;


-- 2.테이블 구조변경  (ALTER TABLE) 
-- ALTER : 기존에 존재하는 데이터베이스 객체를 다시 정의
-- ALTER TABLE 테이블명 ADD || MODIFY || DROP ~ 

-- (1) 필드 추가 (ADD) : 추가된 필드의 데이터는 NULL
SELECT * FROM EMP03;  -- EMPNO, ENAME, DEPTNO
ALTER TABLE EMP03 ADD (JOB VARCHAR2(20), SAL NUMBER(7,2) );
SELECT * FROM EMP03;
ALTER TABLE EMP03 ADD(COMM NUMBER(7,2) );
SELECT * FROM EMP03;

-- (2) 필드 수정 (MODIFY) : 
SELECT * FROM EMP03; -- EMPNO(숫4), ENAME(문10), DEPTNO(숫2) / JOB(문20), SAL, COMM(숫 7,2)은 데이터 NULL
ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2(4)); -- 이미 숫자 데이터가 들어있는 상태에서는 숫자로만 변경 가능

ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(3)); -- 불가능  작게는 불가능
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(5)); -- 가능
ALTER TABLE EMP03 MODIFY (ENAME NUMBER(4)); -- 불가능  문자데이터가 들어 있는 상태에서는 문자로만 변경 가능
SELECT MAX(LENGTH(ENAME)) FROM EMP;
ALTER TABLE EMP03 MODIFY( ENAME VARCHAR2(3000));
DESC EMP03;
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(6));
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(5)); -- 불가능 (6BYTE 글자 데이터가 있어서)  
ALTER TABLE EMP03 MODIFY (JOB VARCHAR2(2));
ALTER TABLE EMP03 MODIFY(JOB NUMBER(4));

-- (3) 필드 삭제 ( DROP )
ALTER TABLE EMP03 DROP COLUMN JOB;
SELECT * FROM EMP03;
-- 논리적으로 특정 필드를 접근 못하도록 (낮)
ALTER TABLE EMP03 SET UNUSED (DEPTNO);
SELECT * FROM EMP03;
-- 논리적으로 접근 불가했던 필드를 물리적으로 삭제 (새벽)
ALTER TABLE EMP03 DROP UNUSED COLUMNS;

-- 3. 테이블 삭제 (DROP TABLE)
DROP TABLE EMP01;
DROP TABLE DEPT; -- 다른 테이블에서 참조하는 데이터가 있을경우 DROP이 안됨
SELECT * FROM EMP;

-- 4. 테이블의 모든 행을 제거 
SELECT * FROM EMP03;
TRUNCATE TABLE EMP03;  -- EMP03 안의 데이터 제거 (취소 불가)
SELECT * FROM EMP03;

-- 5. 테이블명 변경 (RENAME 원래이름 TO 새로운이름)
SELECT * FROM EMP02;
RENAME EMP02 TO EMP2;
SELECT * FROM EMP2;

-- 6. 데이터 딕셔너리(접근 불가) VS 데이터 딕셔너리 뷰(사용자 접근용)
-- 종류
-- USER_XXX : 현 계정이 소유하고 있는 데이터 객체 (테이블, 인덱스, 제약조건, 뷰)
    -- ex. USER_TABLES, USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS.
SELECT * FROM USER_TABLES; -- 내 계정이 소유한 테이블 객체 정보
SELECT * FROM USER_INDEXES; -- 내 계정이 소유한 인덱스 정보 
SELECT * FROM USER_CONSTRAINTS; -- 내 계정이 소유한 제약조건들
SELECT * FROM USER_VIEWS;  -- 내 계정이 소유한 뷰 정보 
    
-- ALL_XXX : 현 계정이 접근 가능한 객체(테이블, 인덱스, 제약조건, 뷰)
    -- ex. ALL_TABLES, ALL_INDEXES, ALL_CONSTRAINTS, ALL_VIEWS
SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_INDEXES;
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_VIEWS;
    
-- DBA_XXX : DAB권한자만 접근가능. DBMS의 모든 객체
    -- ex. DBA_TABLES, DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS
SELECT * FROM DBA_TABLES;
SELECT * FROM DBA_INDEXES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;

-- ★ ★ ★ DCL(사용자 계정 생성, 사용자 권한 부여, 권한박탈, 사용자 계정 삭제) ★ ★ ★
CREATE USER scott2 IDENTIFIED BY 1234;  -- scott2 계정 생성

-- 권한부여 (세션권한, scott.EMP, scott.DEPT 테이블에 대해 모든 권한 주기)
GRANT CREATE SESSION TO scott2;
GRANT ALL ON EMP TO scott2; -- EMP 테이블에 대한 모든 권한(검색, 추가, 수정, 삭제)
GRANT ALL ON DEPT TO scott2; -- DEPT 테이블에 대한 모든 권한
SHOW USER;

-- 권한 박탈 (권한박탈할 사용자계정이 접속해제)
REVOKE ALL ON EMP FROM scott2; -- scott2의 emp 테이블에 대한 모든 권한 박탈
REVOKE ALL ON DEPT FROM scott2; -- scott2의 dept 테이블에 대한 모든 권한 박탈
SHOW USER;

-- ★ ★ ★ DML (SELECT, INSERT, UPDATE, DELETE) ★ ★ ★
-- 1. INSERT INTO 테이블명 VALUES (값1, 값2, 값3, ...);
--    INSERT INTO 테이블명 (필드명1, 필드명2, ...) VALUES (값1, 값2, ...);
SELECT * FROM DEPT01;
INSERT INTO DEPT01 VALUES (50, 'ACCOUNTING' , 'NEW YORK');
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES ( 60,'IT','SEOUL');
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (70,'OPERATION'); -- 묵시적으로 LOC에 NULL 추가
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (80,'HR',NULL); -- 명시적으로 NULL 추가
INSERT INTO DEPT01 VALUES (90,'SALES',NULL); -- 명시적으로 NULL 추가
-- 서브쿼리를 이용한 INSERT
INSERT INTO DEPT01 SELECT * FROM DEPT;
-- 트랜잭션 명령어 (DML 명령어만)
COMMIT;

-- 연습문제 2번 
CREATE TABLE SAM01 (
    EMPNO NUMBER(4) CONSTRAINTS SAM_PK PRIMARY KEY,  -- CONSTRAINTS 제약조건이름  = SAM_PK
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    SAL NUMBER(7,2) );
--  PRIMARY KEY(EMPNO) 이렇게 제약조건을 쓸수도 있음

INSERT INTO SAM01 (EMPNO,ENAME,JOB,SAL) VALUES (1000,'APPLE','POLICE',10000);
INSERT INTO SAM01 (EMPNO,ENAME,JOB,SAL) VALUES (1010,'BANANA','NURSE',15000);
INSERT INTO SAM01 (EMPNO,ENAME,JOB,SAL) VALUES (1020,'ORANGE','DOCTOR',25000);
INSERT INTO SAM01 (EMPNO,ENAME,SAL) VALUES (1030,'VERY',25000);
INSERT INTO SAM01 (EMPNO,ENAME,SAL) VALUES (1040,'CAT',2000);
INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO='10';   -- EMP테이블의 10번부서인 사람들 전부 추가하기 
    -- INSERT 절에 들어가는 서브쿼리는 괄호 안넣어도 됌.
-- INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE EMPNO = '7782';  -- 이렇게 한명씩 추가하기 

SELECT * FROM SAM01;

SELECT * FROM USER_CONSTRAINTS;
-- 트랜잭션 명령어 꼭 하기 안하면 INSERT 취소됨
COMMIT;



-- ★★★★★ 2. UPDATE 테이블명 SET 필드명1=값1 [, 필드명2=값2,...] [WHERE 조건];
CREATE TABLE EMP01 AS SELECT * FROM EMP; -- EMP와 똑같은 EMP01 테이블 만들기

-- EMP01 테이블의 부서번호를 30으로 수정(WHERE 절 없이는 모든 행이 수정) -- 모든 DML언어는 데이터베이스에 적용하려면 COMMIT 을 해야함.
UPDATE EMP01 SET DEPTNO=30 WHERE ENAME = 'SMITH';

-- EMP01 테이블의 모든 사원의 급여를 10% 인상
UPDATE EMP01 SET SAL = SAL*1.1;
SELECT * FROM EMP01;

-- 10번 부서의 직원의 입사일을 오늘로, 부서번호는 30번으로 수정
UPDATE EMP01
    SET HIREDATE = SYSDATE,
        DEPTNO = 30 
    WHERE DEPTNO=10;
SELECT * FROM EMP01;

-- SAL이 3000이상인 사원만 급여를 10% 인상
UPDATE EMP01
    SET SAL = SAL*1.1
    WHERE SAL >= 3000;
SELECT * FROM EMP01;

-- 'DALLAS'에 근무하는 직원의 급여를 1000$씩 인상(서브쿼리 사용)
UPDATE EMP01
    SET SAL = SAL+1000
        WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');
SELECT * FROM EMP01;

-- SCOTT의 부서번호를 20으로, JOB을 MANAGER로 SAL과 COMM을 500씩 인상, 상사를 KING으로 수정
UPDATE EMP01
    SET DEPTNO=20,
        JOB = 'MANAGER',
        COMM = NVL(COMM,0)+500,
        MGR = (SELECT EMPNO FROM EMP WHERE ENAME='KING')
    WHERE ENAME = 'SCOTT';
SELECT * FROM EMP01;

-- DEPT01에서 20부터의 지역명을 DEPT테이블의 60번부서의 지역명으로 변경
UPDATE DEPT01 SET LOC= (SELECT LOC FROM DEPT WHERE DEPTNO=60)
    WHERE DEPTNO >= 20; -- DEPT 테이블에 60번 부서가 없어서 NULL값으로 수정
SELECT * FROM DEPT01;

COMMIT;
-- EMP01 테이블의 모든 사원의 급여와 입사일을 'KING'의 급여와 입사일로 수정
SELECT * FROM EMP01;
UPDATE EMP01
    SET SAL = (SELECT SAL FROM EMP WHERE ENAME = 'KING'),
        HIREDATE = (SELECT HIREDATE FROM EMP WHERE ENAME = 'KING');
        
UPDATE EMP01
    SET (SAL,HIREDATE) = (SELECT SAL, HIREDATE FROM EMP WHERE ENAME='KING');

-- DEPT01 테이블의 20번 부서의 지역명과 부서명을 40번 부서의 지역명과 부서명으로 변경
UPDATE DEPT01
    SET (DNAME,LOC) = (SELECT DNAME, LOC FROM DEPT01 WHERE DEPTNO=40)
    WHERE DEPTNO = 20;
COMMIT;

-- ★★★★★ 3. DELETE FROM 테이블명 [WHERE 조건];
SELECT * FROM EMP01;
DELETE FROM EMP01; -- WEHRE 절을 안 쓸경우 전체 행이 모두 삭제. / ROLLBACK 으로 복구가능 


-- EMP01 테이블에서 'FORD'인 사원을 삭제
DELETE FROM EMP01 WHERE ENAME = 'FORD';
SELECT * FROM EMP01 WHERE ENAME = 'FORD';

-- EMP01 테이블에서 30번 부서 직원을 삭제
DELETE FROM EMP01 WHERE DEPTNO=30;
SELECT *  FROM EMP01;

-- EMP01 테이블에서 부서명이 RESEARCH부서의 직원을 삭제
DELETE FROM EMP01
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'RESEARCH');

-- SAM01  테이블에서 JOB이 정해지지 않은 사원을 삭제
SELECT * FROM SAM01;
DELETE FROM SAM01
    WHERE JOB IS NULL;

-- SAM01 테이블에서 ENAME이 ORANGE인 사원을 삭제하시오
DELETE FROM SAM01
    WHERE ENAME='ORANGE';
COMMIT;

-- 연습문제 PDF 1페이지
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
        
DELETE FROM MY_DATA;  -- 데이터 삭제 복구가능
DROP TABLE MY_DATA;  -- 테이블 삭제  복구 불가능 

-- ★ ★ ★ 제약조건 ★ ★ ★  : 부적합한 데이터가 테이블에 삽입, 수정 되는 것을 방지하기 위해
SELECT * FROM EMP;
INSERT INTO EMP VALUES (7369, '홍', NULL, NULL , SYSDATE, NULL, NULL, 40) -- SMITH 사번과 중복 에러
UPDATE EMP SET EMPNO = 7369 WHERE ENAME = 'ALLEN'; -- SMITH 사번과 중복 에러

-- ★(1) PRIMARY KEY : 유일하게 테이블의 각 행을 식별. PRIMARY KEY값이 NOT NULL
    INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (7369,'홍',40); -- 중복된 사번 입력 불가
    
-- (2) NOT NULL : NULL값을 포함하지 않음
-- (3) UNIQUE : 모든 행에 대해 유일해야. NULL값을 허용 (NULL은 여러행 입력 가능)

-- ★(4) FOREIGN KEY : 테이블의 열은 다른 테이블의 열을 참조 (ex. EMP테이블의 DEPTNO는 DEPTNO는 DEPT 테이블의 DEPTNO를 참조)
    -- 비식별 관계: 부모 테이블의 주키가 자식테이블의 일반속성에 속한 필드로 관계를 맺을때 (exERD에서 빨간점선 화살표)
    -- 식별 관계:  부모 테이블의 주키가 자식테이블의 주키(주키군)에 속한 필드로 관계를 맺을때 ( exERD에서 초록점선 화살표)
    INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (1111, '홍', 90); -- 외래키로 90번 입력 불가
    
-- (5) CHECK(조건) : 해당 조건이 만족 (NULL값 허용)
-- DEFAULT : 해당 열의 데이터 입력값이 없으면 NULL이 들어가나, 기본값을 설정하면 그 기본값이 들어감


DROP TABLE DEPT1;

CREATE TABLE DEPT1(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14) UNIQUE,
    LOC VARCHAR2(13) NOT NULL );
    
DROP TABLE EMP1; --테이블 만들기 전에 있으면 지우기 위해 DROP TABLE

CREATE TABLE EMP1 (
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    MGR NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE,
    SAL NUMBER(7,2) CHECK(SAL >0),
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2) REFERENCES DEPT1(DEPTNO) );

DROP TABLE DEPT1; -- 다른 테이블에서 참조하는 필드가 있을떄 (부모테이블은) 먼저 DROP 안됨.
DROP TABLE DEPT1 CASCADE CONSTRAINTS; -- 비추 (참조하는 테이블이 있어도 무시하고 DROP)

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
INSERT INTO DEPT1 VALUES(40,'IT','SEOUL'); -- PK 제약조건에 위배
INSERT INTO DEPT1 VALUES(50,'SALES','SEOUL'); -- UNIQUE 제약조건에 위배
INSERT INTO DEPT1 VALUES(50,'IT',NULL); -- NOT NULL 제약조건에 위배

INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO) VALUES (1001,'홍',10);  --HIREDATE는 DEFAULT 값으로 SYSDATE가 들어감
SELECT * FROM EMP1;
INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO) VALUES (1001,'김',10); -- PK 위배
INSERT INTO EMP1 (EMPNO, DEPTNO) VALUES (1002,20); -- ENAME이 NOT NULL위배

INSERT INTO EMP1 (EMPNO, ENAME, SAL, DEPTNO) VALUES (1002, '박', -1); -- SAL이 CHECK 조건 위배 
INSERT INTO EMP1 VALUES(1002,'윤',NULL, NULL, TO_DATE('95/01/01','YY/MM/DD'), 900 , NULL, 99);  --DEPTNO가  FK 위배 FOREIGN KEY

COMMIT;

-- 연습문제 (PDF 4번5번)
DROP TABLE BOOKCATEGORY;
CREATE TABLE BOOKCATEGORY(
    CATEGORY_CODE NUMBER(3) PRIMARY KEY,
    CATEGORY_NAME VARCHAR2(20) UNIQUE,
    OFFICE_LOC VARCHAR2(20) NOT NULL );

DROP TABLE BOOK;
CREATE TABLE BOOK(
    CATEGORY_CODE REFERENCES BOOKCATEGORY(CATEGORY_CODE),  --BOOK의 CATEGORY_CODE를 BOOKCATEGORY의 CATEGORY_CODE로 한다.
    BOOKNO VARCHAR2(10) PRIMARY KEY, 
    BOOKNAME VARCHAR2(50),
    PUBLISHER VARCHAR(50),
    PUBYEAR NUMBER(4) DEFAULT EXTRACT(YEAR FROM SYSDATE) );
SELECT * FROM BOOK;
INSERT INTO BOOKCATEGORY VALUES(100,'철학','3층 인문실');
INSERT INTO BOOKCATEGORY VALUES(200,'인문','3층 인문실');
INSERT INTO BOOKCATEGORY VALUES(300,'자연과학','4층 과학실');
INSERT INTO BOOKCATEGORY VALUES(400,'IT','4층 과학실');
SELECT * FROM BOOKCATEGORY;

INSERT INTO BOOK VALUES(100,'100A01','철학자의 삶','더존출판',2021);
INSERT INTO BOOK VALUES(400,'400A01','이것이 DB다','더존출판',2018);
INSERT INTO BOOK (CATEGORY_CODE,BOOKNO,BOOKNAME,PUBLISHER) VALUES (100,'500A01','YA','THEJONE'); -- 출판년 확인
SELECT * FROM BOOK;

-- 5번

DROP TABLE MAJOR;
CREATE TABLE MAJOR(
    MAJOR_CODE NUMBER(4) PRIMARY KEY,
    MAJOR_NAME VARCHAR2(50) UNIQUE,
    MAJOR_OFFICE_LOC VARCHAR2(50) NOT NULL );

DROP TABLE STUDENT;
CREATE TABLE STUDENT(
    STUDENT_CODE VARCHAR(10) PRIMARY KEY,
    STUDENT_NAME VARCHAR(20),
    SCORE NUMBER(3) CHECK( SCORE >= 0 AND SCORE <= 100),  -- ( SCORE BETWEEN 0 AND 100) 이렇게 해도됨
    MAJOR_CODE REFERENCES MAJOR (MAJOR_CODE) );

INSERT INTO MAJOR VALUES (1,'경영정보','경영관 305호');
INSERT INTO MAJOR VALUES (2,'소프트웨어공학','정보관 808호');
INSERT INTO MAJOR VALUES (3,'디자인','예술관 606호');
INSERT INTO MAJOR VALUES (4,'경제','경상관 202호');
SELECT * FROM MAJOR;

INSERT INTO STUDENT VALUES('A01','김길동',100,1);
INSERT INTO STUDENT VALUES('A02','문길동',90,2);
INSERT INTO STUDENT VALUES('A03','홍길동',95,1);
SELECT * FROM STUDENT;