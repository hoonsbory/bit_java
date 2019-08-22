CREATE TABLE boardv2 (
    seq          number(38),
    title        VARCHAR2(30),
    regdate      DATE,
    content      varchar2(1000),
    id           VARCHAR2(30),
    usersv2_id   VARCHAR2(30) NOT NULL,
    cnt          number(38)
)
LOGGING;

ALTER TABLE boardv2
    ADD CONSTRAINT boardv2_usersv2_fk FOREIGN KEY ( usersv2_id )
        REFERENCES usersv2 ( id )
    NOT DEFERRABLE;
    
    회원등록
    
    insert into users values('tonymkcv',1234,'신재훈','유저');
    insert into users values('tonymkcv1',12345,'신재훈','유저');
    
    회원정보수정
    
    update users set password = 4567, name = '재훈이' where id = 'tonymkcv';
    
    로그인
    
    select id , role
    from users 
    where password = 4567;
    
    
    글 등록
    create sequence seq_seq;
    
    insert into board values(seq_seq.nextval, '힘내자', '제목이 곧 내용', sysdate, null , 'tonymkcn');
    insert into board values(seq_seq.nextval, '힘내자', '제목이 곧 내용', sysdate, null , 'tonymkcv1');
    
    글 수정
    update board set content = '글 수정 중~' where seq = 2;
    
    게시판 글 삭제
    delete from board where seq = 2;
    
    전체글 수
    select count(*) "전체 글 수"
    from board; 
    
    사용자별 등록글 수
    select id ,count(*) "사용자별 등록 수"
    from board
    group by id;
    
    월별 게시글 수 
    select to_char(regdate, 'mm'), count(*) "월 별 게시글 수"
    from board 
    group by to_char(regdate, 'mm')
    order by 1;
    
    사용자별 게시글 검색
    select id, title, regdate 
    from board 
    group by id, title , regdate;
    order by id;
    
    제목으로 게시글 검색
    select id , title, regdate
    from board 
    where title = '힘내자';
    order by 1;
    
    update board set cnt = nvl(max(cnt), 0)+1 where (select * from )
    