-- DCL( 계정생성, 권한부여, 권한박탈, 계정삭제) 
-- DDL (제약조건, 시퀀스 없음)
-- DML (outer join, AND= && , OR=||, 일부 단일행 함수)
show databases;
-- ★ ★ ★ DCL (계정 생성, 권한부여, 권한 박탈, 계정 제거)
create user user01 identified by 'password'; -- 패스워드만 '' 붙여주기 -- 계정 생성
grant all on *.* to user01; -- 권한부여 
revoke all on *.* from user01;
drop user user01;
-- 데이터베이스로 들어감
show databases;
create database kimdb; -- 새로운 kimdb 데이터베이스 생성
use kimdb; -- kimdb 데이터베이스 영역으로 들어감
select database(); -- 현재 들어와있는 데이터베이스 알려줌
use world;  -- world 데이터베이스로 들어감
use kimdb;
show tables;  -- 오라클의 select * from tab; 과 똑같음

-- ★ ★ ★ DDL (테이블 생성, 제약조건, 시퀀스 없음) -- 테이블생성하려면 db에 먼저 들어가야함
create table emp(
	empno numeric(4) primary key,  -- 오라클에서 number는 mysql에서는 numeric
	ename varchar(20) not null,      -- mysql에서는 varchar2 말고 varchar 사용
    nickname varchar(20) unique,
    sal numeric(7,2) check(sal > 0),
    hiredate datetime default now(),
    comm numeric(7,2) default 0 );

select * from emp;
drop table if exists emp;
-- Major (mCode(시퀀스 같은 순차번호) : PK, mName, mOffice)
-- Student ( sNo, : PK, sNAME, mCode )
create table major(
	mCode int primary key auto_increment, -- auto_increment일 경우 int
    mname varchar(20),
    mOffice varchar(50) );

create table student(
	sNo int primary key,
    sName varchar(20),
    mcode int references major(mCode) );
    
insert into major(mName, mOffice) values ('컴공','402호');
insert into major(mName, mOffice) values ('경영','502호');
insert into major(mName, mOffice) values ('경제','301호');
select * from major;

insert into student values(1111,'홍',1);
insert into student values(2222,'이',2);
insert into student values(3333,'사',3);
insert into student values(4444,'박',4);
select * from student;

drop table if exists student;
drop table if exists major;

create table major(
	mCode int auto_increment,  -- auto_increment  = 오라클의 시퀀스 같은 느낌
    mName varchar(30) not null,
    mOffice varchar(30),
    primary key (mCode) );

create table student(
	sNo int,
    sName varchar(30),
    mCode int,
    primary key(sNo),
    foreign key(mCode) references major(mCode) );
    
insert into major(mName, mOffice) values ('컴공','402호');
insert into major(mName, mOffice) values ('경영','502호');
insert into major(mName, mOffice) values ('경제','301호');
select * from major;

insert into student values(1111,'홍',1);
insert into student values(2222,'이',2);
insert into student values(3333,'사',3);
insert into student values(4444,'박',4);
select * from student;

-- 학번, 이름, 학과코드, 학과명, 사무실
select sNo, sName, s.mCode, mName, mOffice
	from student s, major m
		where s.mCode = m.mCode;

-- 자바 (JDEBC)  수업시간에 쓸 테이블
drop table if exists personal; -- emp 테이블과 유사
drop table if exists division; -- dept 테이블과 유사

create table division(
	dno int, -- 부서번호
    dname varchar(20), -- 부서이름
    phone varchar(20), -- 부서 전화번호
    posiition varchar(20), -- 근무지
    primary key(dno) );
insert into division values (10,'finance','02-545-5555','강남');
insert into division values (20,'research','02-777-7777','회현');
insert into division values (30,'sales','02-333-3333','서초');
insert into division values (40,'marketing','02-666-6666','과천');
select * from division;

create table personal(
	pno int,  -- 사번
    pname varchar(20) not null,  -- 사원명
    job varchar(20) not null, -- 직책
    manager int,  -- 상사의 사번
    startdate date,     -- 입사일
    pay   int,      --  급여
    bonus int,    -- 상여
    dno int,         -- 부서번호
    primary key(pno),
    foreign key(dno) references division (dno) );

insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
select * from personal; 
commit;
select * from division;
select * from personal;

-- ★ ★ ★ DML (outer join, 단일행 함수 일부, top-n 구문, and=&& , or=|| 과 같음,  연결연산자 concat 사용 )

-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay
	from personal;
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * from personal
	where pay between 2000 and 5000;
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno, pname, dno 
	from personal
		where dno in (10,20);
        -- in 대신 or, || 사용 가능 
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay
	from personal
		where bonus is null
			order by pay desc;
-- 5. 사번, 이름, 부서번호, 급여. 부서번호 순 정렬 같으면 PAY 큰순
select pno, pname, dno, pay
	from personal
		order by dno, pay desc;
        
-- 6. 사번, 이름, 부서명
select pno, pname, dname
	from personal p, division d
		where p.dno = d.dno;
        
-- 7. 사번, 이름, 상사이름
select w.pno, w.pname "workername", m.pname "managername"
	from personal w, personal m
		where w.manager = m.pno;
        
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)
select w.pno "사번", w.pname "이름", ifnull(m.pname,'ceo')  -- ifnull(값,대치값) null이면 대치값을 사용해라 
	from personal w left outer join personal m
		on w.manager = m.pno; -- left outter join 오른쪽에 있는 데이터가 안나오는것

select w.pno "사번", w.pname "이름", if(m.pname is null,'ceo',m.pname)  
	from personal w left outer join personal m
		on w.manager = m.pno;
        
-- 9. 이름이 s로 시작하는 사원 이름
select pname from personal
	where pname like 's%';
    
select pname from personal
	where substr(pname,1,1) = 's';
    
select pname from personal
	where instr(pname, 's') = 1;

-- 10. 사번, 이름, 급여, 부서명, 상사이름
select w.pno, w.pname, w.pay, dname, m.pname
	from personal w, personal m, division d
		where w.dno = d.dno
			and w.manager = m.pno;
-- 11. 부서코드, 급여합계, 최대급여
select dno, sum(pay), max(pay)
	from personal
		group by dno;

-- 12. 부서명, 급여평균, 인원수
select d.dname, round(avg(pay)) "급여평균", count(pname)
	from personal p, division d
		where p.dno = d.dno
			group by dname;
-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select dno, sum(pay), count(*) "인원수"
	from personal
		group by dno
			having 인원수 >= 4;
            
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, max(pay)
	from personal;
    
select pno, pname, pay
	from personal 
    where pay = (select max(pay) from personal);
    
-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pname, pay, dno
	from personal
		where pay > (select avg(pay) from personal);
        
-- 16. 15번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
select pname, pay, p.dno, dname
	from personal p, division d
		where p.dno=d.dno
			and pay > (select avg(pay) from personal)
				order by dname,pay desc;
                
-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 급여, 부서번호, 반올림한 해당부서평균
select pname, pay, dno, round((select avg(pay) from personal where dno=p.dno)) "부서평균"
	from personal p
		where pay > (select avg(pay) from personal where dno=p.dno);

-- inline view 이용
select pname, pay, p.dno, avgpay
	from personal p, (select dno, avg(pay) "avgpay" from personal group by dno) g
    where p.dno=g.dno && 
				pay > avgpay;
			
-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
select pname, pay, startdate
	from personal
		where startdate = (select min(startdate) from personal);
    
-- 19. 이름, 급여, 해당부서평균
select pname, pay, round((select avg(pay) from personal where dno=p.dno)) "부서평균"
	from personal p;
		
-- 20. 이름, 급여, 부서명, 해당부서평균
select pname, pay, dname, round((select avg(pay) from personal where dno=p.dno)) "부서평균"
	from personal p, division d
		where p.dno=d.dno;

-- 오라클에서는 date : 날짜+시간
-- MySql에서 date는 date,time,datetime 세개 있음 
-- mysql은 top-n 구문이 없음 rownum이 없음.

-- Oracle에서의 단일행 함수와 MySql 컬럼 함수의 다른 부분
select round(789.56,2); -- from절 없이도 실행 가능
select pname || '은'||job||'이다'from personal; -- 연결연산자 || 불가능 mysql은 || 가 or임
select concat(pname,'은',job,'이다') from personal; -- mysql은 concat으로 여러개를 이을수 있음.

-- 날짜 관련 컬럼 함수  -- mysql에는 to_char 가 없음 
-- personal 테이블의 startdate의 타입 : datetime 
select year(startdate),month(startdate),day(startdate),
		hour(startdate), minute(startdate), second(startdate) from personal;
-- date_format(날짜나 시간형 데이터, '포맷')  oracle의 to_char와 비슷함  -- 날짜형을 문자로 전환
-- date_format의 포맷 : %y : 22(년도2자리), %Y : 2022(년도4자리)
-- 					  %M : 월이름(4월) , %m : 04월, 05월 ,   %b : 짧은월이름 , %c :  4(월수)
--  			      %d : 일 두자리(01,02,20),  %e : 일 자리(1,2,20)
-- 					  %H : 24시간, %h : 12시간 , %p 오전오후, %i 분, %s 초

-- 시스템으로부터 현재 날짜와 시간
select sysdate();
select now();      -- now() = sysdate()
-- 시스템으로부터 현재 날짜만 갖고오는
select current_date();
select curdate();
-- 시스템으로부터 현재 시간만
select current_time();
select curtime();

select date_format(now(),'%Y년%m월%e일 %p %h시 %i분');


-- format(숫자데이터) : 3자리마다 콤마 추가
-- format(숫자데이터,소수점 자리수) : 소수점 확보되면서 3자리마다 콤마 추가
select format(pay,1) from personal;

-- workbench에서 데이터 삭제하거나 수정하려고 할때 where절에 primary key를 이용한 비교
insert into personal (pno,pname, job, manager, startdate, pay , bonus, dno)
	values (1000,'hong','manager',1001, curdate(), 9000,900,40);
commit;
set sql_safe_updates = 0;
delete from personal where pname='hong';


-- ★★★ TOP-N 구문
select rownum, pno from personal; -- mysql에서는 rownum이 없음
select pname, pay from personal order by pay desc;
-- limit n (1~n등까지)
select pname, pay from personal order by pay desc limit 5; -- 1~5등
-- limit 3,3 * 4등~6등까지
select pname, pay from personal order by pay desc limit 3,3;  -- 4등부터 3개 
-- 0번째 시작
-- limit 5,4 (6등~9등까지_
select pname, pay from personal order by pay desc limit 5,4;  -- 5등부터 4개
