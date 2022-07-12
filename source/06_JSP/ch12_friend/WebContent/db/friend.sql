DROP TABLE FRIEND;

CREATE TABLE FRIEND(
    NO NUMBER(2) PRIMARY KEY,
    NAME VARCHAR2(30) NOT NULL,
    PHONE VARCHAR2(30) UNIQUE  
);

DROP SEQUENCE FRIEND_SEQ;

CREATE SEQUENCE FRIEND_SEQ
    MAXVALUE 99
    NOCACHE
    NOCYCLE;
    
--  친구 추가    
INSERT INTO FRIEND (NO, NAME, PHONE ) VALUES (FRIEND_SEQ.NEXTVAL,'오동준','010-1111-2222');

-- 친구 추가후 전체 친구 출력
SELECT * FROM FRIEND;


SELECT * FROM FRIEND ORDER BY NO;

-- 2번
SELECT * FROM FRIEND WHERE NAME LIKE '%'||'홍'||'%' AND TEL LIKE '%'||'1111'||'%';

    
