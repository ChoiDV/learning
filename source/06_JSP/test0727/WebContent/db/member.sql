DROP TABLE GRADE;
CREATE TABLE GRADE(
    GRADE CHAR(1) PRIMARY KEY,
    GRADENAME VARCHAR2(4000)
);
INSERT INTO GRADE VALUES ('A', 'VIP');
INSERT INTO GRADE VALUES ('B', '일반');
INSERT INTO GRADE VALUES ('C','직원');

SELECT * FROM GRADE;


DROP SEQUENCE MEMBER_SQ;
CREATE SEQUENCE MEMBER_SQ
        START WITH 1001
        MAXVALUE 9999
        NOCACHE
        NOCYCLE;
        
DROP TABLE MEMBER;
CREATE TABLE MEMBER (
    CUSTNO NUMBER(5) PRIMARY KEY,
    CUSTNAME VARCHAR2(20),
    PHONE VARCHAR2(20),
    ADDRESS VARCHAR2(60),
    JOINDATE DATE,
    GRADE REFERENCES GRADE(GRADE),
    CITY CHAR(2)
);
SELECT * FROM MEMBER;

INSERT INTO MEMBER VALUES (MEMBER_SQ.NEXTVAL, '홍길동' , '010-1111-2222' , '서울 동대문구', TO_DATE('20220702','YYYYMMDD'),'A','01');
INSERT INTO MEMBER VALUES (MEMBER_SQ.NEXTVAL, '신길동' , '010-1111-3333' , '서울 강남구', TO_DATE('20220601','YYYYMMDD'),'B','01');
INSERT INTO MEMBER VALUES (MEMBER_SQ.NEXTVAL, '김길동' , '010-1111-4444' , '경기도 안양시', TO_DATE('20220501','YYYYMMDD'),'B','30');
INSERT INTO MEMBER VALUES (MEMBER_SQ.NEXTVAL, '유길동' , '010-1111-5555' , '경기도 의정부시', TO_DATE('20220703','YYYYMMDD'),'A','30');
INSERT INTO MEMBER VALUES (MEMBER_SQ.NEXTVAL, '정길동' , '010-1111-6666' , '서울시 용산구', TO_DATE('20220703','YYYYMMDD'),'B','60');



SELECT * FROM MEMBER M , GRADE G
    WHERE M.GRADE = G.GRADE;


DROP TABLE MONEY;

CREATE TABLE MONEY (
    SALENO NUMBER(6) PRIMARY KEY,
    CUSTNO REFERENCES MEMBER(CUSTNO) NOT NULL,
    COST NUMBER(6),
    AMOUNT NUMBER(4),
    PRICE NUMBER(8),
    PCODE VARCHAR2(4),
    SDATE DATE
);
SELECT * FROM MONEY;

INSERT INTO MONEY VALUES( 202201, 1001,100,20,2000,'A01', TO_DATE('20220701','YYYYMMDD') );
INSERT INTO MONEY VALUES( 202202, 1001,150,20,3000,'A02', TO_DATE('20220701','YYYYMMDD') );
INSERT INTO MONEY VALUES( 202203, 1002,200,10,2000,'A03', TO_DATE('20220701','YYYYMMDD') );
INSERT INTO MONEY VALUES( 202204, 1003,100,5,500,'A01', TO_DATE('20220701','YYYYMMDD') );
INSERT INTO MONEY VALUES( 202205, 1004,100,9,900,'A01', TO_DATE('20220702','YYYYMMDD') );
INSERT INTO MONEY VALUES( 202206, 1003,150,6,900,'A02', TO_DATE('20220703','YYYYMMDD') );
INSERT INTO MONEY VALUES( 202207, 1001,200,2,400,'A03', TO_DATE('20220704','YYYYMMDD') );




-- 쿼리

--  회원 리스트 뿌리기
SELECT * FROM MEMBER;

-- 회원 정보수정
UPDATE MEMBER SET CUSTNAME ='홍길동',
                                            PHONE='010-1111-1234',
                                                ADDRESS='서울시 어디구',
                                                    GRADE = 'A',
                                                        CITY='01'
                                                WHERE CUSTNO = 1001;

-- 회원 매출 조회  -- COST:  단가 , AMOUNT : 수량, PRICE: 가격
SELECT MEMBER.CUSTNO, MEMBER.CUSTNAME, GRADENAME, (SELECT SUM(PRICE) FROM MONEY WHERE CUSTNO = MEMBER.CUSTNO) SUM FROM
    MEMBER MEMBER , GRADE G
        WHERE MEMBER.GRADE = G.GRADE; 
  
-- 매출 조회
SELECT PCODE , SUM(PRICE) SUM FROM MONEY GROUP BY PCODE ORDER BY PCODE;



-- 회원 dto 가져오기
SELECT * FROM MEMBER 
    WHERE CUSTNO = 1001;
    
-- 회원번호 자동발생
SELECT (MAX(CUSTNO)+1) MAXNO FROM MEMBER;
select * from member;

commit;






commit;

