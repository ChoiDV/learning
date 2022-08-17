-- 고양이 분양 게시판 댓글 테이블
DROP SEQUENCE CREPLY_SEQ;

CREATE SEQUENCE CREPLY_SEQ
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;


DROP TABLE CAT_REPLY;

CREATE TABLE CAT_REPLY(
    RNO NUMBER(6) PRIMARY KEY,
    CNUM REFERENCES CAT(CNUM) NOT NULL,
    MID REFERENCES MEMBER(MID) NOT NULL,
    REPLY_CONTENT VARCHAR2(1000) NOT NULL,
    RDATE DATE DEFAULT SYSDATE NOT NULL,
    RIP VARCHAR2(50) NOT NULL
);

-- 고양이 분양글 댓글쓰기
INSERT INTO CAT_REPLY (RNO, CNUM, MID, REPLY_CONTENT, RIP )
    VALUES (CREPLY_SEQ.NEXTVAL, 1, 'aaa', '이 고양이 너무 귀엽네요', '192.168.10.30');
INSERT INTO CAT_REPLY (RNO, CNUM, MID, REPLY_CONTENT, RIP)
    VALUES (CREPLY_SEQ.NEXTVAL, 1, 'aaa', '이 고양이 너무 사랑스럽네요', '192.168.10.30');

-- 고양이 분양글의 댓글 출력
SELECT C.*,M.MNAME NAME FROM(SELECT ROWNUM RN, A.* FROM
                (SELECT * FROM CAT_REPLY ORDER BY RDATE DESC) A) C, MEMBER M
    WHERE C.MID = M.MID
        AND RN BETWEEN 1 AND 10;

-- 댓글 수정
UPDATE CAT_REPLY SET REPLY_CONTENT='이 고양이 제가 키우고싶어요',
                        RIP ='192.147.12.30'
                            WHERE RNO=1;
                            
-- 댓글 삭제
DELETE CAT_REPLY WHERE RNO=3;

COMMIT;

