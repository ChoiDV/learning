-- BOARD TABLE DROP & CREATE
DROP SEQUENCE BOARD_SEQ;

CREATE SEQUENCE BOARD_SEQ
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;
    
DROP TABLE BOARD;

CREATE TABLE BOARD(
    BID NUMBER(6) PRIMARY KEY,
    BNAME VARCHAR2(50) NOT NULL, -- 작성자 이름
    BTITLE VARCHAR2(100) NOT NULL, -- 제목
    BCONTENT VARCHAR2(1000),   -- 본문 
    BDATE DATE DEFAULT SYSDATE NOT NULL, -- 작성시점
    BHIT NUMBER(6) DEFAULT 0 NOT NULL, --  조회수
    BGROUP NUMBER(6) NOT NULL,  -- 글 그룹  ( REF 느낌 )
    BSTEP NUMBER(6) NOT NULL,  -- 글 그룹내 출력 순서
    BINDENT NUMBER(6) NOT NULL, -- 들여쓰기
    BIP VARCHAR2(20) NOT NULL
);
-- DUMMY DATA 
SELECT * FROM BOARD;

INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP )
    VALUES (BOARD_SEQ.NEXTVAL, '오동준' , '제목 1', '본문1', BOARD_SEQ.CURRVAL, 0, 0, '192.168.10.30' );
INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP )
    VALUES (BOARD_SEQ.NEXTVAL, '서예린' , '제목 2', '본문2', BOARD_SEQ.CURRVAL, 0, 0, '192.168.10.20' );
INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP )
    VALUES (BOARD_SEQ.NEXTVAL, '윤정임' , '제목 3', '본문3', BOARD_SEQ.CURRVAL, 0, 0, '192.168.10.10' );    
    -- 1번글의 답변 DUMMY DATA 
    INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP )
        VALUES (BOARD_SEQ.NEXTVAL, '유대환', '제목 1-악플', '본문1-악플', 1, 1 , 1, '191.1.1.1' );
    -- 2번글의 답변 DUMMY DATA
    INSERT INTO BOARD  (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP )
        VALUES (BOARD_SEQ.NEXTVAL, '김-빈', '제목 2-악플', '본문2-악플', 2, 1 , 1 , '4885.48.8.5' );

-- DAO에 들어갈 QUERY

-- 글목록 ( startRow ~ endRow )
SELECT * FROM BOARD ORDER BY BGROUP DESC, BSTEP;  -- 글 출력 순서
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY BGROUP DESC, BSTEP ) A )
        WHERE RN BETWEEN 1 AND 10;
        
-- 전체 글 갯수
SELECT COUNT(*) FROM BOARD;

-- 원글쓰기
INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP )
    VALUES (BOARD_SEQ.NEXTVAL, '최진영' , '제목 4', '본문4', BOARD_SEQ.CURRVAL, 0, 0, '192.168.10.30' );
    
-- BID로 조회수 올리기
UPDATE BOARD SET BHIT = BHIT + 1
    WHERE BID = 5;
    
-- 글 상세보기 ( BID로 DTO 가져오기)
SELECT * FROM BOARD WHERE BID=1;

-- 답변글 쓰기전 STEP A (기존의 답변글의 출력 순서를 + 1 )  -- 기존의 답변글을 밑으로 내리기 위해 필요한 작업

UPDATE BOARD SET BSTEP = BSTEP +1
    WHERE BGROUP=1 AND BSTEP > 0;

-- 답변글 쓰기
INSERT INTO BOARD(BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP )
    VALUES ( BOARD_SEQ.NEXTVAL, '김민우', '본문1-악플2', NULL, 1 , 1 , 1 , '127.0.0.1' ); 
    
-- 글 수정
UPDATE BOARD SET BNAME='오동좌',
                                        BTITLE = '수정 해명글1',
                                            BCONTENT = '수정된 죄송합니다.',
                                                BIP = '192.1.1.1'
                            WHERE BID=1;
-- 글 삭제
DELETE BOARD WHERE BID=7;


COMMIT;













