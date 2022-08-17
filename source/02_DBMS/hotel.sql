-- HOTEL 
DROP TABLE HOTEL;

CREATE TABLE HOTEL(
    HOTELID VARCHAR2(50) PRIMARY KEY, -- 호텔 일련번호
    HOTELCOUNTRY VARCHAR2(50) NOT NULL,  -- 호텔 국가
    HOTELNAME VARCHAR2(50) NOT NULL, -- 호텔 이름
    HOTELADDRESS VARCHAR2(200) NOT NULL, -- 호텔 주소
    ROOMTYPE VARCHAR2(40) NOT NULL, -- 호텔 룸 타입
    ROMMPRICE NUMBER(10) NOT NULL, -- 호텔 룸 가격
    HOTELIMAGE VARCHAR2(50),  -- 호텔 사진
    ROOMIMAGE VARCHAR2(50)  -- 호텔 룸 사진
);
SELECT * FROM HOTEL;
-- 필리핀 
INSERT INTO HOTEL VALUES ('PTD-SD','필리핀','더 디스트릭트 보라카이','필리핀 웨스턴 비사야 보라카이 발라박 Station 2 Malay, 5608 Aklan 5608',
                            '스탠다드',100000,NULL,NULL);
INSERT INTO HOTEL VALUES ('PTD-DL','필리핀','더 디스트릭트 보라카이','필리핀 웨스턴 비사야 보라카이 발라박 Station 2 Malay, 5608 Aklan 5608',
                            '디럭스',300000,NULL,NULL);
INSERT INTO HOTEL VALUES ('PTD-SW','필리핀','더 디스트릭트 보라카이','필리핀 웨스턴 비사야 보라카이 발라박 Station 2 Malay, 5608 Aklan 5608',
                            '스위트',500000,NULL,NULL);   
INSERT INTO HOTEL VALUES ('PLH-SD','필리핀','라임 호텔 보라카이','필리핀 웨스턴 비사야 보라카이 발라박 Station 2, Main Road, Boracay Island 5608',
                            '스탠다드',100000,NULL,NULL); 
INSERT INTO HOTEL VALUES ('PLH-DL','필리핀','라임 호텔 보라카이','필리핀 웨스턴 비사야 보라카이 발라박 Station 2, Main Road, Boracay Island 5608',
                            '디럭스',300000,NULL,NULL);                             
INSERT INTO HOTEL VALUES ('PLH-SW','필리핀','라임 호텔 보라카이','필리핀 웨스턴 비사야 보라카이 발라박 Station 2, Main Road, Boracay Island 5608',
                            '스위트',500000,NULL,NULL);    
INSERT INTO HOTEL VALUES ('PBH-SD','필리핀','코스트 보라카이','필리핀 웨스턴 비사야 보라카이 발라박 Station 2 Beach Front, Brgy. 5608',
                            '스탠다드',100000,NULL,NULL); 
INSERT INTO HOTEL VALUES ('PBH-DL','필리핀','코스트 보라카이','필리핀 웨스턴 비사야 보라카이 발라박 Station 2 Beach Front, Brgy. 5608',
                            '디럭스',300000,NULL,NULL);                             
INSERT INTO HOTEL VALUES ('PBH-SW','필리핀','코스트 보라카이','필리핀 웨스턴 비사야 보라카이 발라박 Station 2 Beach Front, Brgy. 5608',
                            '스위트',500000,NULL,NULL); 

-- 독일
INSERT INTO HOTEL VALUES ('GHA-SD','독일','호텔 아마노 그랜드 센트럴','독일 베를린 Mitte Heidestrasse 62 10557',
                            '스탠다드',200000,NULL,NULL);
INSERT INTO HOTEL VALUES ('GHA-DL','독일','호텔 아마노 그랜드 센트럴','독일 베를린 Mitte Heidestrasse 62 10557',
                            '디럭스',400000,NULL,NULL);
INSERT INTO HOTEL VALUES ('GHA-SW','독일','호텔 아마노 그랜드 센트럴','독일 베를린 Mitte Heidestrasse 62 10557',
                            '스위트',600000,NULL,NULL);   
INSERT INTO HOTEL VALUES ('GIB-SD','독일','이비스 베를린 쿠르푸어스텐담','독일 베를린 Tempelhof-Schoneberg Bayreuther Strasse 39 10787',
                            '스탠다드',200000,NULL,NULL); 
INSERT INTO HOTEL VALUES ('GIB-DL','독일','이비스 베를린 쿠르푸어스텐담','독일 베를린 Tempelhof-Schoneberg Bayreuther Strasse 39 10787',
                            '디럭스',400000,NULL,NULL);                             
INSERT INTO HOTEL VALUES ('GIB-SW','독일','이비스 베를린 쿠르푸어스텐담','독일 베를린 Tempelhof-Schoneberg Bayreuther Strasse 39 10787',
                            '스위트',600000,NULL,NULL);    
INSERT INTO HOTEL VALUES ('GNO-SD','독일','노보텔 베를린 미테 호텔','독일 베를린 Mitte Fischerinsel 12 10179',
                            '스탠다드',200000,NULL,NULL); 
INSERT INTO HOTEL VALUES ('GNO-DL','독일','노보텔 베를린 미테 호텔','독일 베를린 Mitte Fischerinsel 12 10179',
                            '디럭스',400000,NULL,NULL);                             
INSERT INTO HOTEL VALUES ('GNO-SW','독일','노보텔 베를린 미테 호텔','독일 베를린 Mitte Fischerinsel 12 10179',
                            '스위트',600000,NULL,NULL); 
                            
-- 스위스
INSERT INTO HOTEL VALUES ('SKI-SD','스위스','호텔 크렙스 인터라겐','스위스 베른  인터라켄 Bahnhofstrasse 4 3800',
                            '스탠다드',150000,NULL,NULL);
INSERT INTO HOTEL VALUES ('SKI-DL','스위스','호텔 크렙스 인터라겐','스위스 베른  인터라켄 Bahnhofstrasse 4 3800',
                            '디럭스',300000,NULL,NULL);
INSERT INTO HOTEL VALUES ('SKI-SW','스위스','호텔 크렙스 인터라겐','스위스 베른  인터라켄 Bahnhofstrasse 4 3800',
                            '스위트',450000,NULL,NULL);   
INSERT INTO HOTEL VALUES ('SBH-SD','스위스','호텔 베르너호프','스위스 베른  인터라켄 Bahnhofstrasse 16 3800',
                            '스탠다드',150000,NULL,NULL); 
INSERT INTO HOTEL VALUES ('SBH-DL','스위스','호텔 베르너호프','스위스 베른  인터라켄 Bahnhofstrasse 16 3800',
                            '디럭스',300000,NULL,NULL);                             
INSERT INTO HOTEL VALUES ('SBH-SW','스위스','호텔 베르너호프','스위스 베른  인터라켄 Bahnhofstrasse 16 3800',
                            '스위트',450000,NULL,NULL);    
INSERT INTO HOTEL VALUES ('SBW-SD','스위스','호텔 버터플라이','스위스 발레 체르마트 Bodmenstrasse 21 3920',
                            '스탠다드',150000,NULL,NULL); 
INSERT INTO HOTEL VALUES ('SBW-DL','스위스','호텔 버터플라이','스위스 발레 체르마트 Bodmenstrasse 21 3920',
                            '디럭스',300000,NULL,NULL);                             
INSERT INTO HOTEL VALUES ('SBW-SW','스위스','호텔 버터플라이','스위스 발레 체르마트 Bodmenstrasse 21 3920',
                            '스위트',450000,NULL,NULL); 
                            
-- 영국
INSERT INTO HOTEL VALUES ('ESP-SD','영국','스트랜드 팰리스 호텔 런던','영국 그레이터 런던 시티오브웨스트민스터 372 Strand WC2R 0JJ',
                            '스탠다드',200000,NULL,NULL); 
INSERT INTO HOTEL VALUES ('ESP-DL','영국','스트랜드 팰리스 호텔 런던','영국 그레이터 런던 시티오브웨스트민스터 372 Strand WC2R 0JJ',
                            '디럭스',400000,NULL,NULL);                             
INSERT INTO HOTEL VALUES ('ESP-SW','영국','스트랜드 팰리스 호텔 런던','영국 그레이터 런던 시티오브웨스트민스터 372 Strand WC2R 0JJ',
                            '스위트',600000,NULL,NULL); 

-- 프랑스
INSERT INTO HOTEL VALUES ('FLT-SD','프랑스','르 츠바 호텔 파리','프랑스 일 드 프랑스 파리 파리 17구 - 바티뇰몽소 45 Rue des Acacias 75017',
                            '스탠다드',200000,NULL,NULL); 
INSERT INTO HOTEL VALUES ('FLT-DL','프랑스','르 츠바 호텔 파리','프랑스 일 드 프랑스 파리 파리 17구 - 바티뇰몽소 45 Rue des Acacias 75017',
                            '디럭스',400000,NULL,NULL);                             
INSERT INTO HOTEL VALUES ('FLT-SW','프랑스','르 츠바 호텔 파리','프랑스 일 드 프랑스 파리 파리 17구 - 바티뇰몽소 45 Rue des Acacias 75017',
                            '스위트',600000,NULL,NULL); 

-- 일본
INSERT INTO HOTEL VALUES ('JNI-SD','일본','호텔 닛코 오사카','일본 오사카 주오 구 1-3-3,Nishi-Shinsaibashi,Chuo-ku 542-0086',
                            '스탠다드',100000,NULL,NULL); 
INSERT INTO HOTEL VALUES ('JNI-DL','일본','호텔 닛코 오사카','일본 오사카 주오 구 1-3-3,Nishi-Shinsaibashi,Chuo-ku 542-0086',
                            '디럭스',200000,NULL,NULL);                             
INSERT INTO HOTEL VALUES ('JNI-SW','일본','호텔 닛코 오사카','일본 오사카 주오 구 1-3-3,Nishi-Shinsaibashi,Chuo-ku 542-0086',
                            '스위트',300000,NULL,NULL); 
                            
-- 베트남
INSERT INTO HOTEL VALUES ('BDD-SD','베트남','파리델리 다낭 비치 호텔','베트남 다낭 Quan Son Tra 236 Vo Nguyen Giap, Son Tra 550000',
                            '스탠다드',70000,NULL,NULL); 
INSERT INTO HOTEL VALUES ('BDD-DL','베트남','파리델리 다낭 비치 호텔','베트남 다낭 Quan Son Tra 236 Vo Nguyen Giap, Son Tra 550000',
                            '디럭스',140000,NULL,NULL);                             
INSERT INTO HOTEL VALUES ('BDD-SW','베트남','파리델리 다낭 비치 호텔','베트남 다낭 Quan Son Tra 236 Vo Nguyen Giap, Son Tra 550000',
                            '스위트',210000,NULL,NULL); 
                            
-- 태국
INSERT INTO HOTEL VALUES ('TBS-SD','태국','칼튼 호텔 방콕 수쿰윗','태국 방콕 Khlong Toei 491 Sukhumvit Rd, Khlong Toei Nuea, Watthana 10110',
                            '스탠다드',80000,NULL,NULL); 
INSERT INTO HOTEL VALUES ('TBS-DL','태국','칼튼 호텔 방콕 수쿰윗','태국 방콕 Khlong Toei 491 Sukhumvit Rd, Khlong Toei Nuea, Watthana 10110',
                            '디럭스',160000,NULL,NULL);                             
INSERT INTO HOTEL VALUES ('TBS-SW','태국','칼튼 호텔 방콕 수쿰윗','태국 방콕 Khlong Toei 491 Sukhumvit Rd, Khlong Toei Nuea, Watthana 10110',
                            '스위트',240000,NULL,NULL); 

--------------------------------------------------------------------
DROP TABLE HOTEL_ZZIM;
DROP SEQUENCE HZZIM_SEQ;

CREATE SEQUENCE HZZIM_SEQ
    MAXVALUE 9999999999
    NOCACHE
    NOCYCLE;

CREATE TABLE HOTEL_ZZIM(
    HZZIM NUMBER(10) PRIMARY KEY,  -- 찜번호
    MID REFERENCES CUSTOMER(MID) NOT NULL,  -- 찜한 사람의 아이디
    HOTELID REFERENCES HOTEL(HOTELID) NOT NULL, -- 호텔 일련번호(호텔의 정보)
    HZDATE DATE DEFAULT SYSDATE NOT NULL -- 찜한시점
);

INSERT INTO HOTEL_ZZIM VALUES (HZZIM_SEQ.NEXTVAL,'aaa','TBS-SW',SYSDATE);
INSERT INTO HOTEL_ZZIM VALUES (HZZIM_SEQ.NEXTVAL,'bbb','BDD-SW',SYSDATE);

SELECT * FROM HOTEL_ZZIM HZ, HOTEL H
    WHERE HZ.HOTELID = H.HOTELID
        AND MID='aaa';
        

-- HOTEL_RS ( 호텔 예약 )
DROP TABLE HOTEL_RS;
DROP SEQUENCE HRS_SEQ;

CREATE SEQUENCE HRS_SEQ
    MAXVALUE 9999999999
    NOCACHE
    NOCYCLE;
    
CREATE TABLE HOTEL_RS(
    HRS_NUM NUMBER(10) PRIMARY KEY,    -- 의미없는 시퀀스(PK 위해)
    HOTELID REFERENCES HOTEL(HOTELID) NOT NULL,  -- 호텔 일련번호 (호텔정보)
    MID REFERENCES CUSTOMER(MID) NOT NULL,  -- 회원 아이디 
    CHECKIN DATE NOT NULL,   -- 예약 완료 체크인 날짜
    CHECKOUT DATE NOT NULL,   -- 예약 완료 체크아웃 날짜
    HEADCOUNT NUMBER(10) NOT NULL  -- 예약 인원수
);

INSERT INTO HOTEL_RS VALUES (HRS_SEQ.NEXTVAL,'ESP-SW','aaa','2022-08-01','2022-08-10',5);

SELECT * FROM HOTEL_RS HR, CUSTOMER C
    WHERE HR.MID = C.MID;

SELECT * FROM HOTEL_RS;
SELECT * FROM HOTEL WHERE HOTELCOUNTRY = '영국' ; 
-- 연습장 -----------------------------------------------------------------------
-- 이쿼리로 검색했을때 3행이 안나오면 호텔을 띄워야됌 목록에서 


SELECT * FROM HOTEL WHERE HOTELCOUNTRY = '스위스'
    AND ((select COUNT(*) from HOTEL_RS R, HOTEL H where (('2022-08-01' >= checkin AND '2022-08-01' < CHECKOUT)  
     OR ('2022-08-10' BETWEEN checkin AND CHECKOUT))     
        AND R.HOTELID = H.HOTELID
            AND H.HOTELID IN (SELECT DISTINCT SUBSTR(HOTELID,1,3) FROM HOTEL  WHERE HOTELCOUNTRY = '스위스')) != 
                    (SELECT COUNT(*) FROM (SELECT DISTINCT SUBSTR(HOTELID,1,3) FROM HOTEL  WHERE HOTELCOUNTRY = '스위스')));  

            
-- 호텔리스트
SELECT DISTINCT SUBSTR(HOTELID,1,3) FROM HOTEL  WHERE HOTELCOUNTRY = '스위스';




SELECT DISTINCT HOTELNAME FROM HOTEL WHERE HOTELCOUNTRY = '스위스';



SELECT DISTINCT H.HOTELCOUNTRY, H.HOTELNAME,H.HOTELADDRESS,H.HOTELIMAGE FROM HOTEL H, HOTEL_RS R WHERE HOTELCOUNTRY='스위스'
        AND HOTELNAME != (
        SELECT DISTINCT HOTELNAME FROM 
        (select * from HOTEL_RS R, HOTEL H where (('2022-08-01' >= CHECKIN AND '2022-08-01' < CHECKOUT)
    OR ('2022-08-10' BETWEEN CHECKIN AND CHECKOUT))
        AND R.HOTELID = H.HOTELID AND HOTELCOUNTRY = '스위스'));


select * from hotel where hotelcountry='영국';

SELECT * FROM HOTEL;
-- 더미 예약
INSERT INTO HOTEL_RS VALUES (HRS_SEQ.NEXTVAL,'SKI-SD','aaa','2022-08-01','2022-08-10',5);
INSERT INTO HOTEL_RS VALUES (HRS_SEQ.NEXTVAL,'SKI-DL','aaa','2022-08-01','2022-08-10',5);
INSERT INTO HOTEL_RS VALUES (HRS_SEQ.NEXTVAL,'SKI-SW','aaa','2022-08-01','2022-08-10',5);
INSERT INTO HOTEL_RS VALUES (HRS_SEQ.NEXTVAL,'SBH-SD','aaa','2022-08-01','2022-08-10',5);
INSERT INTO HOTEL_RS VALUES (HRS_SEQ.NEXTVAL,'SBH-DL','aaa','2022-08-01','2022-08-10',5);
INSERT INTO HOTEL_RS VALUES (HRS_SEQ.NEXTVAL,'SBH-SW','aaa','2022-08-01','2022-08-10',5);
-- 연습장 -----------------------------------------------------------------------

SELECT DISTINCT H.HOTELCOUNTRY, H.HOTELNAME,H.HOTELADDRESS,H.HOTELIMAGE FROM HOTEL H, HOTEL_RS R WHERE HOTELCOUNTRY='스위스'
        AND 3 !=(
        SELECT COUNT(HOTELNAME) FROM 
        (select * from HOTEL_RS R, HOTEL H where (('2022-08-01' >= CHECKIN AND '2022-08-01' < CHECKOUT)
    OR ('2022-08-10' BETWEEN CHECKIN AND CHECKOUT))
        AND R.HOTELID = H.HOTELID AND HOTELCOUNTRY='스위스'));   -- 8월1일~ 8월 10일에 출력되는 호텔들만 출력 
        -- 현재 하나라도 예약되어있으면 안나옴
SELECT * FROM HOTEL WHERE HOTELCOUNTRY = '스위스';


--  결과 쿼리
SELECT DISTINCT HOTELNAME FROM HOTEL 
    WHERE (HOTELNAME, ROOMTYPE) NOT IN (
select HOTELNAME, ROOMTYPE from HOTEL_RS R, HOTEL H where (('2022-08-01' >= CHECKIN OR '2022-08-01' < CHECKOUT)
    AND ('2022-08-10' BETWEEN CHECKIN AND CHECKOUT))
        AND R.HOTELID = H.HOTELID AND HOTELCOUNTRY='스위스') AND HOTELCOUNTRY='스위스';


SELECT * FROM HOTEL_RS;






-- 예린이가 영국에 특정 호텔 8/1 ~ 8/10일 예약함

-- 날짜를 받고 검색를 받아서 다음으로 넘어감
-- 태국을 검색하면 DISTANT 사용해서 호텔 목록 띄운뒤 클릭하면  HOTELNAME 갖고 넘기기
SELECT * FROM HOTEL WHERE HOTELCOUNTRY = '스위스'
    AND ((select COUNT(*) from HOTEL_RS R, HOTEL H where (('2022-08-01' >= checkin AND '2022-08-01' < CHECKOUT)  -- 이쿼리로 검색했을때 3행이 안나오면 호텔을 띄워야됌 목록에서 
     OR ('2022-08-10' BETWEEN checkin AND CHECKOUT))     
        AND R.HOTELID = H.HOTELID
            AND H.HOTELID LIKE '%'||'S'||'%') != (SELECT COUNT(*) FROM HOTEL WHERE HOTELCOUNTRY = '스위스'));   
        -- 예린이가 영국에 스트랜드 팰리스 호텔 런던 을 8/1 ~ 8/10일 예약을 함
        -- 저 호텔은 방2개가 남음 그래서 호텔 목록에 띄워줘야함 
        -- 만약 호텔의 스탠다드, 디럭스, 스위트가 전부 특정날짜에 예약됐다면 
        -- 목록에 호텔 자체를 안띄워야함 
         -- 07/08 ~ 07~15 놀러갈 위치  --  근데 스위스의 호텔중에  1번호텔 매진  2번호텔 1자리 3번호텔 2자리 남았으면 1번호텔 뺴고 2번,3번 호텔만 띄워야함  
         
SELECT * FROM HOTEL WHERE HOTELNAME = '칼튼 호텔 방콕 수쿰윗';   -- 넘어온 HOTELNAME 갖고 다시 SELECT 하면 HOTELNAME에 해당하는 방 3개가 나옴 이거 뿌려주기
                                                              -- 스탠다드, 디럭스, 스위트 중 하나 클릭하면 HOTELID 넘겨주기
           
--    ( ex) 태국의 칼튼 호텔 방콕 수쿰윗 의 스위트룸 선택하면 
SELECT * FROM HOTEL WHERE HOTELID = 'TBS-SW';  -- 넘어와서 방정보 뿌려주고
        
        -- 다음 체크인 , 체크아웃 날짜
SELECT * FROM HOTEL_RS;
                                                              
 -- 예약 가능인지 조회 쿼리
-- 나오는 튜플은 예약 불가                                                             
SELECT * FROM HOTEL_RS R, HOTEL H WHERE (('2022-08-01' >= CHECKIN AND '2022-08-01' < CHECKOUT)  -- 이쿼리로 검색했을때 3행이 안나오면 호텔을 띄워야됌 목록에서 
    OR ('2022-08-30' BETWEEN CHECKIN AND CHECKOUT))     
        AND R.HOTELID = H.HOTELID
            AND H.HOTELID LIKE '%'||'E'||'%';      
            
SELECT * FROM HOTEL_RS R, HOTEL H WHERE (('2022-08-01' >= CHECKIN AND '2022-08-01' < CHECKOUT)  -- 이쿼리로 검색했을때 3행이 안나오면 호텔을 띄워야됌 목록에서 
    OR ('2022-08-30' BETWEEN CHECKIN AND CHECKOUT))     
        AND R.HOTELID = H.HOTELID
            AND H.HOTELID LIKE '%'||'E'||'%';     

SELECT DISTINCT HOTELNAME FROM HOTEL 
    WHERE (HOTELNAME, ROOMTYPE) NOT IN (
SELECT HOTELNAME, ROOMTYPE from HOTEL_RS R, HOTEL H WHERE (('2022-08-01' >= CHECKIN OR '2022-08-01' < CHECKOUT)
    AND ('2022-08-10' BETWEEN CHECKIN AND CHECKOUT))
        AND R.HOTELID = H.HOTELID AND HOTELCOUNTRY LIKE '%' || '스위스' || '%') AND HOTELCOUNTRY LIKE '%' || '스위스' || '%' ;
        
SELECT * FROM HOTEL_ZZIM;
INSERT INTO HOTEL_ZZIM VALUES (HZZIM_SEQ.NEXTVAL, 'aaa', (SELECT HOTELID FROM HOTEL WHERE HOTELID LIKE 'SBH' || '%'), SYSDATE);

(SELECT * FROM HOTEL WHERE HOTELID LIKE 'SKI' || '%');

INSERT INTO HOTEL_ZZIM VALUES (HZZIM_SEQ.NEXTVAL, 'aaa', 'SKI' || '-SD', SYSDATE);
INSERT INTO HOTEL_ZZIM VALUES (HZZIM_SEQ.NEXTVAL, 'aaa', 'SKI' || '-DL', SYSDATE);
INSERT INTO HOTEL_ZZIM VALUES (HZZIM_SEQ.NEXTVAL, 'aaa', 'SKI' || '-SW', SYSDATE);


DELETE FROM HOTEL_ZZIM WHERE MID= 'aaa' AND HOTELID LIKE 'SKI' || '%';
SELECT COUNT(*) FROM HOTEL_ZZIM WHERE MID='aaa' AND HOTELID LIKE 'SKI'||'%';
commit;
SELECT COUNT(*) FROM HOTEL_ZZIM WHERE MID= 'aaa' AND HOTELID LIKE 'SKI'||'%';
commit;
select * from hotel_zzim;