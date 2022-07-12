DROP TABLE CUSTOMER;

CREATE TABLE CUSTOMER (
    CID VARCHAR2(50) PRIMARY KEY,
    CPW VARCHAR2(50) NOT NULL,
    CNAME VARCHAR2(50) NOT NULL,
    CTEL VARCHAR2(50) NOT NULL,
    CEMAIL VARCHAR2(50),
    CADDRESS VARCHAR2(250),
    CGENDER VARCHAR2(10) NOT NULL,
    CBIRTH DATE NOT NULL,
    CRDATE DATE DEFAULT SYSDATE
);

-- 아이디 중복체크
SELECT * FROM CUSTOMER WHERE CID='aaa';

-- 로그인 
SELECT * FROM CUSTOMER WHERE CID='aaa' AND CPW='2';

-- 회원가입
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH)
    VALUES ( 'aaa', '1', '최진영','010-4434-9878', 'chlwlsdud69@naver.com' , '서울시 강남구', 'm','1999-12-03');

-- 정보수정
UPDATE CUSTOMER SET CPW='2',
                                                CNAME='초이진영',
                                                    CTEL='010-4434-9878',
                                                        CEMAIL='chlwlsdud98@nate.com',
                                                            CADDRESS ='수원시',
                                                                CBIRTH='1999-12-03',
                                                                    CGENDER='m'
                                                                WHERE CID='aaa';

-- 아이디로 정보 가져오기
SELECT * FROM CUSTOMER WHERE CID= 'aaa';


SELECT * FROM CUSTOMER;

COMMIT;




