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


-- CheckIn_hotel.sql  

SELECT * FROM HOTEL;
SELECT * FROM HOTEL_RS;
SELECT * FROM HOTEL_ZZIM;

-- HOTEL
-- 관리자가 숙소 등록  id= insertHotel
INSERT INTO HOTEL VALUES ('TPB'|| '-SD','태국','풀만 방콕 킹 파워','태국 방콕 Ratchathewi 8/2 Rangnam Road 10400','스탠다드',100000,NULL,NULL);
INSERT INTO HOTEL VALUES ('TPB'|| '-DL','태국','풀만 방콕 킹 파워','태국 방콕 Ratchathewi 8/2 Rangnam Road 10400','디럭스',200000,NULL,NULL);
INSERT INTO HOTEL VALUES ('TPB'|| '-SW','태국','풀만 방콕 킹 파워','태국 방콕 Ratchathewi 8/2 Rangnam Road 10400','스위트',300000,NULL,NULL);
-- 'TPB' 부분을 ? 로 바꾸고 INSERT문에는 3줄이 들어가야함 한번 id =insertHotel 을 실행하면 3줄 insert 되도록


-- 관리자가 호텔 삭제 id = deleteHotel
DELETE FROM HOTEL_ZZIM WHERE HOTELID LIKE 'TPB' || '%';   -- 먼저 찜 삭제 후
DELETE FROM HOTEL WHERE HOTELID LIKE 'TPB' || '%';   -- 호텔 삭제

SELECT * FROM HOTEL;
-- 관리자가 호텔 수정 id = modifyHotel
UPDATE HOTEL SET HOTELNAME = '수정할 이름입니다.',
                    HOTELCOUNTRY = '수정할 나라입니다.',
                        HOTELADDRESS = '수정할 호텔주소입니다.',
                            HOTELIMAGE = '수정할 호텔사진입니다.'                               
                    WHERE HOTELID= ' ' || '%';             

-- 관리자 특정 호텔 특정 방 수정 id= modifyHotelRoom
UPDATE HOTEL SET ROOMIMAGE = '수정할 사진입니다.',
                    ROMMPRICE = 0
                     WHERE HOTELID = '호텔 풀 아이디 입니다. (TBS-SD) ';
          
-- 전체 숙소 개수     id = totHotel
SELECT COUNT(DISTINCT HOTELNAME) FROM HOTEL;

-- 특정 지역 숙소 개수  id = totHotelLoc
SELECT COUNT(DISTINCT HOTELNAME) FROM HOTEL WHERE HOTELCOUNTRY = '태국';

-- 숙소 상세보기      id = hotelDetail
SELECT * FROM HOTEL WHERE HOTELID LIKE '%' || 'TBS' || '%';

-- 특정 지역 숙소리스트 보기   id = hotelListLoc
SELECT DISTINCT(HOTELNAME),HOTELCOUNTRY,HOTELADDRESS,HOTELIMAGE FROM HOTEL WHERE HOTELCOUNTRY = '태국';

-- 체크인, 체크아웃, 지역 으로 예약 가능한 호텔 리스트  id = hotelReservationList
SELECT DISTINCT HOTELNAME FROM HOTEL 
    WHERE (HOTELNAME, ROOMTYPE) NOT IN (
select HOTELNAME, ROOMTYPE from HOTEL_RS R, HOTEL H where (('2022-08-01' >= CHECKIN OR '2022-08-01' < CHECKOUT)
    AND ('2022-08-10' BETWEEN CHECKIN AND CHECKOUT))
        AND R.HOTELID = H.HOTELID AND HOTELCOUNTRY LIKE '%' || '스위스' || '%') AND HOTELCOUNTRY LIKE '%' || '스위스' || '%' ;


-- HOTEL_RS
-- 숙소 예약 관련  쿼리---------------------------

-- 내 호텔 예약 목록 확인
SELECT * FROM HOTEL_RS WHERE MID = 'bbb';

-- 내 호텔 예약 취소
DELETE FROM HOTEL_RS WHERE HRS_NUM = 1;

-- 호텔 예약하기
INSERT INTO HOTEL_RS VALUES (HRS_SEQ.NEXTVAL,'SKI-SD','bbb','2022-08-10','2022-08-15',2);

-- 더미 예약
INSERT INTO HOTEL_RS VALUES (HRS_SEQ.NEXTVAL,'SKI-SD','aaa','2022-08-01','2022-08-10',5);
INSERT INTO HOTEL_RS VALUES (HRS_SEQ.NEXTVAL,'SKI-DL','aaa','2022-08-01','2022-08-10',5);
INSERT INTO HOTEL_RS VALUES (HRS_SEQ.NEXTVAL,'SKI-SW','aaa','2022-08-01','2022-08-10',5);
INSERT INTO HOTEL_RS VALUES (HRS_SEQ.NEXTVAL,'SBH-SD','aaa','2022-08-01','2022-08-10',5);
INSERT INTO HOTEL_RS VALUES (HRS_SEQ.NEXTVAL,'SBH-DL','aaa','2022-08-01','2022-08-10',5);
INSERT INTO HOTEL_RS VALUES (HRS_SEQ.NEXTVAL,'SBH-SW','aaa','2022-08-01','2022-08-10',5);


--------------------------
-- HOTEL_ZZIM

-- 호텔 찜하기    -- id = insertHZZim 
INSERT INTO HOTEL_ZZIM VALUES (HZZIM_SEQ.NEXTVAL, 'aaa', 'SKI' || '-SD', SYSDATE);
INSERT INTO HOTEL_ZZIM VALUES (HZZIM_SEQ.NEXTVAL, 'aaa', 'SKI' || '-DL', SYSDATE);
INSERT INTO HOTEL_ZZIM VALUES (HZZIM_SEQ.NEXTVAL, 'aaa', 'SKI' || '-SW', SYSDATE);

-- 찜 눌렀는지 안눌렀는지 여부  -- id = checkZZim
SELECT COUNT(*) FROM HOTEL_ZZIM WHERE MID= 'aaa' AND HOTELID LIKE 'SKI'||'%';

-- 내가 찜한 리스트  id = myZZimList
SELECT H.HOTELID,HOTELCOUNTRY, HOTELNAME,ROOMTYPE FROM HOTEL_ZZIM HZ, HOTEL H WHERE HZ.HOTELID = H.HOTELID AND MID='aaa';

-- 찜취소
DELETE FROM HOTEL_ZZIM WHERE MID= 'aaa' AND HOTELID LIKE 'SKI' || '%';


SELECT * FROM HOTEL_ZZIM;





commit;

