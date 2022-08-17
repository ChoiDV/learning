-- [VIII] SEQUENCE : 순차번호 생성기, 대부분 인위적인 PK사용 용도
DROP SEQUENCE FRIEND_SEQ;

CREATE SEQUENCE FRIEND_SEQ
    START WITH 1      --시작값 (디폴트 = 1) 안써도됨
    INCREMENT BY 1    --증가값 (디폴트 = 1) 안써도됨
    MAXVALUE 9999
    MINVALUE 1
    NOCACHE
    NOCYCLE;
    
SELECT FRIEND_SEQ.NEXTVAL FROM DUAL;

DROP SEQUENCE FRIEND_SEQ;

CREATE SEQUENCE FRIEND_SEQ
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;
    
DROP TABLE FRIEND;
CREATE TABLE FRIEND(
    NUM NUMBER(4) PRIMARY KEY,  -- 시퀀스 이용
    NAME VARCHAR2(30) NOT NULL,
    TEL VARCHAR2(30) UNIQUE,  -- NULL허용, 유일한 값
    ADDRESS VARCHAR2(300),
    LAST_MODIFYED DATE DEFAULT SYSDATE );

INSERT INTO FRIEND (NUM,NAME, TEL, ADDRESS)
    VALUES (FRIEND_SEQ.NEXTVAL, '박길동','010-9999-9999', '서울시 강남구 강남대로92길 13 삼겸빌딩 4F');
SELECT * FROM FRIEND;
INSERT INTO FRIEND (NUM,NAME, TEL, ADDRESS)
    VALUES (FRIEND_SEQ.NEXTVAL, '신길동','010-8888-8888','서울시 영등포구');

SELECT FRIEND_SEQ.CURRVAL FROM DUAL; -- 현재 시퀀스 값 확인
COMMIT;

--ex. 초기값 101부터 최대값 999,999까지 1씩 증가하는 test_seq 시퀀스를 생성하시오
DROP SEQUENCE TEST_SEQ;
CREATE SEQUENCE TEST_SEQ
    START WITH 101
    MAXVALUE 999999
    NOCACHE
    NOCYCLE ;
SELECT TEST_SEQ.CURRVAL FROM DUAL; -- 시퀀스를 한번도 실행하지않아서 현재 값이 없어서 에러;
SELECT TEST_SEQ.NEXTVAL FROM DUAL;


-- 8장 연습문제 ----------------------------
-- 시퀀스
DROP SEQUENCE MEMBER_MNO_SQE;
CREATE SEQUENCE MEMBER_MNO_SQE
    START WITH 1
    MAXVALUE 9999999999
    NOCACHE
    NOCYCLE;
--MEMBER_LEVEL 테이블
DROP TABLE MEMBER_LEVEL;
CREATE TABLE MEMBER_LEVEL(
    LEVELNO NUMBER(5) PRIMARY KEY,
    LEVELNAME VARCHAR2(10) NOT NULL );

INSERT INTO MEMBER_LEVEL VALUES (-1,'black');
INSERT INTO MEMBER_LEVEL VALUES (0,'일반');
INSERT INTO MEMBER_LEVEL VALUES (1,'실버');
INSERT INTO MEMBER_LEVEL VALUES (2,'골드');

-- MEMBER 테이블
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    mNO NUMBER(10) PRIMARY KEY,
    mNAME VARCHAR2(20) NOT NULL,
    mPW VARCHAR2(8) CHECK( LENGTH(mPW) > 1 AND LENGTH(mPW) < = 8 ),
    mEMAIL VARCHAR2(50) UNIQUE,
    mPOINT NUMBER(10) CHECK(mPOINT >= 0 ),
    mRDATE DATE DEFAULT SYSDATE,
    LEVELNO REFERENCES MEMBER_LEVEL (LEVELNO) );

INSERT INTO MEMBER (mNO, mNAME, mPW, mEMAIL, mPOINT, LEVELNO) 
    VALUES ( MEMBER_MNO_SQE.NEXTVAL,'홍길동','aa','hong@hong.com',0,0);  
INSERT INTO MEMBER (mNO, mNAME, mPW, mEMAIL, mPOINT, LEVELNO) 
    VALUES ( MEMBER_MNO_SQE.NEXTVAL,'신길동','bb','sin@sin.com',1000,1); 

-- 출력 결과
SELECT mNO, mNAME, TO_CHAR(mRDATE, 'YYYY-MM-DD'), mEMAIL, mPOINT, LEVELNAME ||'고객'
    FROM MEMBER M, MEMBER_LEVEL L
     WHERE M.LEVELNO = L.LEVELNO;
COMMIT;