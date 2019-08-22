################################
table 생성 DDL - 취소가 안됨 오토커밋.
#@##############################


drop table book; --삭제하면 취소안댐. ddl의 특징 오토커밋.
create table book(
	bookno number(5),
	title varchar2(30),
	author varchar2(30),
	pubdate date
); 
--4개의 컬럼을 형식에 맞게 지정해줌. 괄호 안의 숫자는 크기(바이트).

####################################
dml 
####################################

insert into book values(1,'java', 'Shin', sysdate);
insert into book values(2,'java2', '신', sysdate);
insert into book values(3,'java3', '김', sysdate);
insert into book values(4,'java4', '사', '19/02/02');
--연속으로 두 개 이상을 insert했을 경우에도 rollback를 하면 다 취소됨.
commit;
rollback;
--롤백하면 취소됨. 테이블 드롭은 롤백못함.

--커밋으로 확정을 해주어야 적용됨. 커밋안하면 다른 cmd창 혹은 sql 디벨로퍼에서 안보임

insert into book (bookno , title ) values(3, 'db');
--컬럼이 4개가 있는 테이블이지만 앞에서 컬럼 명을 기술해주면 그 컬럼만 데이터를 insert 할 수 있음.
insert into book (bookno, title,author,pubdate)
values (4,'db',null,null); 
--이렇게 4개 컬럼을 정해주고 널을 넣어주는거랑 위에 두 개 컬럼만 넣어주는거랑 똑같음.
--굳이 이렇게 써야하나 싶음 걍 정석대로 적는 insert문에 null주고 싶은 컬럼에 줄 수 있음.


delete from book; --이렇게 하면 북에 있는 로우 다 삭제

delete from book where title = 'db';
delete from book where author is null;
--널은 is null / is not null 명심할 것
delete from book where author = 'Shin';
--타이틀이 db인 로우 삭제.

desc book; --book테이블의 구조를 보여줌.

alter table book add(price number(7)); --구조변경
--dml문으로 수행한 결과를 커밋하지 않은 상태에서 ddl문을 사용하면 수행되었던 dml문들까지 같이 오토커밋됨.
insert into book (bookno, title,author,pubdate, price)
values (4,'db',null,null, 10000);

update book set price = 10.99 where bookno = 2;
--기존에 있던 데이터에 추가하고 싶을 때는 업데이트로 . 셋으로 바꿀 컬럼을 지정해주고 where로 조건을 주자.
--정수형이라 알아서 반올림됨.

update book set author = '신재훈', price = 10.99 where bookno = 2;
--여러 컬럼을 한번에 수정가능

update book set price = null;
alter table book modify(price number(7,2));
--프라이스 컬럼을 실수형으로 바꾸고 싶다면 데이터를 비우고 해야한다. 그 전에는 정수형 데이터가 있기때문에 에러가 난다.

alter table book drop column price;
--특정 컬럼을 삭제함. ddl이기 때문에 오토커밋이고 롤백안됨.

rename book to book2;
--table이름 바꾸기 rename

truncate table book2;
--delete는 롤백의 여지가 있지만 truncate는 롤백 안됨. 얘는 오토커밋됨.
##################삭제기능의 차이점############################
--drop는 테이블자체가 삭제되면서 오토커밋 , 
--truncate는 로우만 삭제하면서 오토커밋, 
--delete는 로우만 삭제하면서 롤백 가능.
#############################################

create table emp2 as select * from emp;
create table dept2 as select * from dept;
create table dept3 as select deptno from dept;
--복사 하는 방법 emp에 있는 내용을 그대로 가져와 emp2라는 테이블을 만든다 
--원하는 컬럼만 복사가능. 
--제약조건은 복사안됨. 프라이머리키 포링키

insert into dept values(50,'edu', 'seoul');
insert into dept2 values(50,'edu', 'seoul');

insert into dept values(10,'edu', 'seoul');
--dept는 deptno가 프라이머리키라 중복값 처리가 안됨
insert into dept2 values(10,'edu', 'seoul');


##############################################
트랜잭션  쓰기작업을 하는 동안에는 락걸린다. 커밋을 해주거나 롤백을 해줘야만 락이 풀린다.
DB에서 하나의 작업으로 처리되는 논리적 작업 단위.
##############################################
창1
delete from emp2 where deptno = 10;

창2
update emp2 set comm = 0 where deptno = 10;
--emp2테이블에서 dml문을 수행하고 커밋할지 롤백할지 확정을 안했기 때문에 이 위에 수행문은 블락된다. select 문은 수행됨. 그냥 읽는 거라.
--먼저 수행한 dml문을 확정지으면 블락됐던 문장이 바로 수행된다. 
--읽기작업만 가능하고 쓰기작업이 안되는 것

 
insert into emp(empno, ename, hiredate, sal, deptno) 
values(9999,'sjh' , sysdate, 0, 90);
--90번 부서가 존재하지않기 때문에 에러. 제약조건 즉 deptno가 프라이머리키 이기 때문에  에러가남.

insert into emp2(empno, ename, hiredate, sal, deptno) 
values(9999,'sjh' , sysdate, 0, 90);
--emp2는 제약조건이 없어서 그냥 들어가짐

drop table book;
--constraint로 제약 설정 뒤에이름은 맘대로 지으면 된다.\
--PK는 널을 허용하지 않고 unique는 널을 허용함
create table book( 
	bookno number(5) constraint scott_book_pk primary key,
	title varchar2(30) constraint scott_book_title_unique unique,
	author varchar2(30),
	price number(7,2) constraint book_price_check check(price>0),
	pubdate date default sysdate
); 
--체크옵션으로 제약 걸어줌.  bookno는 프라이머리키 설정해주고 타이틀은 unique로 중복막아주고
--  price 는 0보다 큰 조건을 걸어줌. pubdate는 기본값으로 현재 날짜를 줌
insert into book (bookno , title, author, price,pubdate) 
values(2,'jsp', '홍길동', 1000, sysdate);

insert into book (bookno , title, author, price,pubdate) 
values(3,'java', '김길동', 1000, default);


insert into book (bookno , title, author, price) 
values(3,'java', '김길동', 1000);
--위에 처럼 파라미터에 pubdate 정보를 빼고 넣어도 디폴트 값으로 sysdate를 줘서 알아서 현재 날짜가 들어감.

select CONSTRAINT_name
from user_cons_columns
where table_name='BOOK';
--BOOK테이블에 걸려있는 제약조건 확인하는 명령문.


create table book( 
	bookno number(5) primary key,
	title varchar2(30) unique,
	author varchar2(30),
	price number(7,2) check(price>0),
	pubdate date default sysdate
); 
--제약조건의 이름을 정하지 않고도 제약조건이 잘 걸린다. 그렇지만 이름이 없어서 구분하기가 불편함. 유니크 속성은 null까지 허용함. 
--pk는 유니크속성이지만 널 허용안함 null
--유니크는 자동적으로 인덱스 자동 생성 pk도 마찬가지.

###############################
테이블 생성 후 제약을 거는 법
###############################
create table book( 
	bookno number(5) ,
	title varchar2(30) ,
	author varchar2(30),
	price number(7,2) ,
	pubdate date default sysdate
); 

alter table book add constraint book_bookno_pk primary key(bookno);
--alter로 bookno에 제약을 걸어둠 프라이머리 키로.
alter table book drop constraint book_bookno_pk;
--제약 제거
####################################33
EMP DEPT 포링키 만드는법
####################################33

create table dept2 as select * from dept;
create table emp2  as select * from emp;

alter table dept2 add constraint dept2_deptno_pk primary key(deptno);
alter table emp2 add constraint emp2_empno_pk primary key(empno);
alter table emp2 add constraint emp2_deptno_fk foreign key(deptno)  references dept2;
--프라이머리 키를 두 컬ㄹ럼을 설정해줄 수 있따 복합 키. deptno,author로 설정하면 책 번호가 같아도 저자가 다르면 통과된다.
--emp2의 deptno에 포링키를 설정해주고 주소인 dept2를 지정해주면 알아서 dept2테이블의 pk를 참조한다.
--포링키는 null 허용
alter table emp2 add constraint emp2_mgr_fk foreign key(mgr)  references emp2;

alter table emp2 add constraint emp2_deptno_fk foreign key(deptno) references dept2 on delete set null;
--on delete set null = 참조를 하고 있어도 삭제가 되지만 그 대신 null로 세팅  프라이머리키를 지우면 참조하던 포링키의 값이 null로 세팅
--on delete는 부모가 삭제될 때 자식이 수행하는 명령.
alter table emp2 add constraint emp2_deptno_fk foreign key(deptno) references dept2 on delete cascade;
--cascade는 부모테이블을 삭제하면 참조하고있던 자식도 같이 삭제됨.


--mgr에 제약이 안걸려있어서 어떤 매니져값이든 입력이 되기 때문에 나중에 셀프조인 시 문제가 생긴다. 무결성을 띄게 제약 조건을 걸어주자. 
--같은 테이블의 직원번호로 걸어주면된다.
alter table emp2 drop constraint emp2_mgr_fk;
alter table emp2 drop constraint emp2_deptno_fk;

insert into emp2(empno, ename, hiredate, sal, deptno) 
values(9999,'sjh' , sysdate, 0, 90);
