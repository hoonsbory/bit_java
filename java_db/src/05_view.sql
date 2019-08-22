############################
231p view 
##############################

select ename, sal, d.deptno , dname, loc
from emp e, dept d
where e.deptno = d.deptno;
--위에 명령문을 하나의 뷰로 만듦 , 그대로 명령문가져와서 as붙이고 써줌
create or replace view emp_dept
as select ename, sal, d.deptno , dname, loc
from emp e, dept d
where e.deptno = d.deptno;
--or replace 없으면 새로만들고 있다면 교체해라
--계정이 뷰를 만들 권한이 없으므로 grant dba to SCOTT; 이 명령문을 통해 할당해주자.
--셀렉트 문에 * 올 수 없음 . 두 테이블 조인되어있는 상태라 중복됨.

drop view emp_dept;
--뷰 삭제

select user from dual;
--유저 정보 출력

create or replace view highsalavg as select deptno, ename, sal from emp outer where sal > (select avg(sal) from emp where deptno= outer.deptno )
############################################
Sequence
############################################

create sequence deptno_seq;

insert into dept2 (deptno, dname, loc) values((select nvl(max(deptno), 0)+10 from dept2) , '인사부', '비트');
--시퀀스를 안쓰는 원시적인 방법
insert into dept2 (deptno, dname, loc) values(deptno_seq.nextval , '인사부', '비트');
--deptno 시퀀스를 넣고 nextval를 써서 순차적으로 넘버를 정해줌.

select deptno_seq.currval from dual;
--시퀀스의 가장 최근 벨류 확인.

drop sequence deptno_seq;
--시퀀스 삭제

create sequence deptno_seq start with 10 increment by 10;
--10부터 시작해서 10씩 증가함.



############################################
index
############################################

select * frmo emp where empno = 7698;   //index기반  pk는 자동으로 인덱스, 목차가 만들어져 금방찾음.
select * from emp where ename= 'FORD';  //full scan 목차가없이 처음부터 끝까지 스캔 때려버림! 운이 좋으면 금방 찾지만 아닐 경우 엄청 오래걸림

set autotrace on;  
set autotrace off;  
--어떤식으로 서치했는지 정보가 나옴

create index emp_ename_idx on emp(ename);
--인덱스 생성 및 삭제.   
drop index emp_ename_idx;


select index_name, table_name from user_indexes;