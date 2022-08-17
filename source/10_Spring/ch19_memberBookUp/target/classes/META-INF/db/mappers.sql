--  ★ Member.xml(회원가입, id중복체크, id로 memberDto 가져오기, 로그인, 정보수정 ) ★

-- idConfirm
SELECT COUNT(*) FROM MEMBER WHERE MID='aaa';

-- joinMember
INSERT INTO MEMBER VALUES ('bbb', '1', '최진영', 'choi@naver.com', '12345', '서울' );

-- getMember
SELECT * FROM MEMBER WHERE MID='aaa';

-- modifyMember
UPDATE MEMBER SET MPW='123',
                                            MNAME = '최진영',
                                                MMAIL = 'chlwlsdud69@naver.com',
                                                    MPOST = '5678',
                                                     MADDR = '서울시 강남구'
                                        WHERE MID='bbb';

--  ★ Book.xml  ( 페이징 없이 신규순 list , 페이징 포함된 도서보기List(책 이름순) , 책 개수, 상세보기, 도서등록, 도서수정) ★
-- mainList
SELECT * FROM BOOK ORDER BY BRDATE DESC;

-- bookList
SELECT * FROM
    (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BTITLE ) A )
            WHERE RN BETWEEN 1 AND 3;

-- totCntBook
SELECT COUNT(*) FROM BOOK;

-- getDetailBook
SELECT * FROM BOOK WHERE BNUM = 1;

-- registerBook
INSERT INTO BOOK VALUES( BOOK_SQ.NEXTVAL,  '행복이란 무엇인가 ',
                                                                '최작가', SYSDATE, 'noImg.png', 'noImg.png' , '행복이란 무엇인가!!!' );

-- modifyBook
UPDATE BOOK SET BTITLE = '행복',
                                        BWRITER = '최진영',
                                             BRDATE = SYSDATE,
                                               BIMG1 = 'noImg.png',
                                                 BIMG2 = 'noImg.png',
                                                     BINFO = '이책은 무엇일까?'
                                            WHERE BNUM=1;                                        

COMMIT;

