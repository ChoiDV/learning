-- 프리미엄 동물 종류 테이블
DROP TABLE PANIMAL;

CREATE TABLE PANIMAL(
    PANIMALNO NUMBER(2) PRIMARY KEY,  -- 고양이 10번, 강아지 20번
    PANIMALNAME VARCHAR2(30) NOT NULL  -- 고양이 OR 강아지
);

INSERT INTO PANIMAL (PANIMALNO, PANIMALNAME)
    VALUES (10, '고양이' );
INSERT INTO PANIMAL (PANIMALNO, PANIMALNAME)
    VALUES (20, '강아지' );
    
SELECT * FROM PANIMAL;

COMMIT;