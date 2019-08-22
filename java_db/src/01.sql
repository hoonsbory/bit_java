

alter user hr identified by hr account unlock;

sqlplus hr/hr

select * from tab;

--주석은 이렇게
--아래 명령은 시스템에서 내리는 명령어.
create tablespace bit
datafile 'c:\lib\bit.dbf'
size 30M
autoextend on next 2M maxsize UNLIMITED;

--계정 생성, 시스템 명령어
--오라클에선 스키마가 계정
create user test01 identified by 1234
default tablespace bit;

--계정삭제 cascade는 참조하는 테이블까지 삭제시킴
drop user test01 cascade;

--계정에 권한부여. 이거 안하면 로그인 거부당함 커넥트 권한 , 커넥트와 리소스 권한 까지 같이 줄 수 있음
grant connect, resource to test01;

--계정 권한뺏기.
revoke connect from test01;

--계정 생성, 시스템 명령어
--오라클에선 스키마가 계정
create user SCOTT identified by TIGER
default tablespace bit;

-- 이 파일에 실행해서 sql명령문들을 불러옴@c:\lib\scott.sql

--쇼는 라인사이즈를 보여줌 겟 같은 느낌
show linesize;
set linesize 300;

show pagesize;
set pagesize 20;
--C:\oraclexe\app\oracle\product\11.2.0\server\sqlplus\admin\glogin 이게 환경설정파일

--오라클 휴지통비우기
PURGE RECYCLEBIN;  

--테이블의 테이블명 출력
select tablespace_name from dba_tablespaces;