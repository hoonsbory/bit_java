select * from tab;

select 
from
where
order by

select ename , sal from emp order by deptno;alter
--셀렉트절에 deptno가 없어도 deptno로 정렬가능. 프로젝션되지않는 컬럼으로도 정렬이 된다는 뜻.

########################################
join
#######################################

select ename, dname
from emp,dept;
--위에처럼 하면 그냥 ename에 dname를 곱해서 다출력함.

select ename, dname 
from emp,dept
where emp.deptno = dept.deptno;
--이런식으로  조건을 걸어줘야함. 테이블이 많을수록 그만큼 조건이 필요함. 보통 포링키 프라이머리키를 조건으로 건다. 오라클 전용 조인방식임.

-- deptno같은 키값은 select문에 쓸 때 어디 테이블에 있는지 적어줘야함 dept.deptno 이런식으로


select *
from emp e,dept d
where e.deptno = d.deptno and sal >=2500;

select ename, dname , d.deptno, loc
from emp e,dept d
where e.deptno = d.deptno;
--테이블이름을 얼라이어스할 때는 참조하는 주소명소 같이 바꿔줘야함. e로 얼라이어스했는데 emp.deptno로 쓰면 에러남. e.deptno로 해야함.
################################################
anci join 표준 (위에껀 오라클 밑에가 anci 조인) ,=>join(from절에서만) where => on 콤마는 조인, 웨어는 온
################################################
select ename, dname , d.deptno, loc
from emp e join dept d
on e.deptno = d.deptno;

select ename, dname , d.deptno, loc
from emp e inner join dept d 
on e.deptno = d.deptno and sal>=2500; 
--밑에 where절에 조건넣어도됨 
--inner 가 생략되어있음. 양쪽에 다 있는 값을 조인할 때 사용.


###############################################
outer join 한쪽에만 존재하는 데이터를 처리할 때. 아우터가 없으면 양쪽 모두 존재하는 데이터만 출력됨.
###############################################
--오라클 방식에서 +는 null쪽에 마킹
select ename, sal,dname,loc , d.deptno
from emp e, dept d
where e.deptno(+) = d.deptno;
--emp에 없는 데이터를 출력해야하기 때문에 emp에 + 마킹해준다.

select ename, sal,dname,loc , d.deptno
from emp e right outer join dept d
on e.deptno = d.deptno;
--anci방식으로 바꾼 것. 여기선 +가 아니라 아우터 조인을 쓴다. LEFT RIGHT로 마스터, 
--즉 기준이 되는 테이블을 잡아준다. 마스터 테이블의 정보는 NULL이어도 출력

SELECT * FROM SALGRADE;

SELECT ename, sal, grade
from emp e, salgrade s
where sal between losal and hisal;
--키값으로 하는 조인이 아닌 방식. 비트윈앤드로 값을 구분짓는다. 
--위는 오라클 방식 아래는 anci방식.
SELECT ename, sal, grade
from emp e join salgrade s
on sal between losal and hisal;

#############################################
세 개의 테이블 조인
############################################
 select ename, sal, dname , loc , grade
 from emp e, dept d , salgrade s
 where e.deptno = d.deptno and sal between losal and hisal
 order by grade;
 
 select ename, sal, dname , loc , grade
 from emp e, dept d , salgrade s
 where e.deptno = d.deptno and sal between losal and hisal and e.deptno = 20
 order by grade;
 
--anci 조인 방식.  join걸고 on으로 조건걸고 반복.
 select ename, sal, dname , loc , grade
 from emp e 
 	join dept d 
 	on e.deptno = d.deptno 
 	join salgrade s
 	on sal between losal and hisal 
 	where e.deptno= 10
 order by grade;
 --안시 방식에서 조인을 위한 on에 조건을 걸지말고 where절을 따로 해주는 걸로 통일하자. 성능 차이가 있을수도 있다고 한다.
 
 ##################################
 셀프 조인 방식 같은 테이블을 다른 이름으로 얼라이어스해서 조인한다.
 ##################################
 select   e.ename "직원",   nvl(m.ename,'CEO') "상사"
 from emp e left outer join  emp m
 on e.mgr = m.empno;

 --상사가없는 직원도 있기 때문에 레프트 아우터로 모두 출력

 ####상사보다 월급이 많은 직원 출력################
  select  e.sal, d.dname, d.loc, e.ename "직원",   m.sal ,m.ename "상사"
 from emp e  join  emp m 
 on e.mgr = m.empno
 join dept d 
 on e.deptno = d.deptno
  where e.sal > m.sal;
  --부서정보를 출력하기 위해 새로 조인을 걸고 양 테이블의 키값인 deptno가 같은 때라는 조건을 걸어줌.
  
  #####################################
  집계 함수 (여러 데이터가 들어가서 하나의 결과값이 나옴)
  ####################################
  
  select ename, round(sal) from emp;
  select avg(sal) from emp;
  select round(avg(sal),2) "평균 급여" from emp;
  --카운트 함수는 row의 갯수를 출력
  select count(empno), count(comm), count(*), count(mgr), round(avg(sal),2) "평균 급여" from emp;
  
  select count(job) from emp;
  select count(distinct job) from emp; 
  --중복제거 함수안에서 선언해서 job의 중복을 제거한 뒤 출력.
  
  select sum(sal) , count(*), round(avg(sal)), sum(sal) / count(*) from emp;  
  
  --10번 부서의 평균급여.
  select round(avg(sal)) 
  from emp
  where deptno=10;

  select *  from emp order by deptno;
  
  select deptno , round(avg(sal)) 
  from emp
  group by deptno;
  --부서별로 평균급여가 출력됨. 부서번호로 그룹지었기 때문.
  --그룹바이에서는 조인을 안해도 그룹바이한 테이블 컬럼을 셀렉트에 쓸 수 있음
  --그룹바이는 집계함수를 쓰겠다는 것.
  
  #####부서별 평균 급여 구하기################
  ########################################
  ###########################제일 중요함########################################
  --오더바이는 그룹바이보다 위에온다.
   select dept.deptno , dname , round(avg(sal)) "부서별 평균 급여"
  from emp right outer join dept 
  on emp.deptno = dept.deptno 
  group by dname, dept.deptno 
  having round(avg(sal))>2000
  order by 2;
  --emp에 있는 sal의 평균을 구해야하고  dept테이블의 dname그룹별로 구해야하기 때문에 두 테이블이 필요하며 
  --두 테이블을 이어줄 키 값을 조건으로 설정해줘야한다.
  --deptno를 출력하고 싶으면 그룹바이에 추가해주면됨. 
  --오더바이 숫자는 인덱스 순서다. 2면 두번째 인덱스의 컬럼으로 정렬.
  --##################그룹바이의 함수가 끝난 후에 조건처리해야하므로 having절을 쓴다.
  -- 웨어절은 그룹바이에 쓰인 함수 말고 다른건 사용가능 순서를 명심.#################################
  --having절은 그룹바이의 출력조건을 담당.
  select max(sal),min(sal),count(*),avg(sal) from emp;
  --최대급여 최소급여 인원수 평균급여
  
  select deptno, max(sal),min(sal),count(*),avg(sal) from emp
  group by deptno;  
  --부서별로  최대급여 최소급여 인원수 평균급여
  
  ##포드보다 급여를 많이 받는 사원 리스트############
  --서브쿼리 셀렉트안에 셀렉트를 넣음
  select *
  from emp
  where sal > (select sal from emp where ename='ford');
  ##평균급여보다 많이 받는 사람들###############
  select *
  from emp
  where sal > (select avg(sal) from emp);
  --where절에는 집계함수 못들어간다.
  #######급여가 가장 작은 사람 출력#########
  select *
  from emp
  where sal  = (select min(sal) from emp);
  --최소값과 '같은'으로 조건을 걸어줘야함
  
 #########################################
 스칼라 = 단일값 , 벡터 = 다중값    =다음에는 스칼라    in 다음에는 다중값이 와도 됨.
 ######각 부서에서 급여 가장 적은 사원 리스트############
select deptno, ename, sal
from emp 
where sal IN (select min(sal) from emp group by deptno);
 --in으로 전체를 감싸서 비교한다. 

select deptno, ename, sal
from emp 
where (deptno, sal) IN (select deptno, min(sal) from emp group by deptno);
 --이게 더 정확함. 부서별로 그룹바이했지만 부서별로 뽑은 값이 같을 경우엔 데이터 처리가 정확하지 않을 수 있기 때문에 어떤부서가 어떤 값인지 확실히 써주는 게 좋다.
############################################################
상관관계 서브쿼리 : outer 쿼리의 컬럼 중 하나가 inner 쿼리문에서 사용되는 쿼리문
############################################################

##자신의 속한 부서의 평균 급여보다 적은 사원 리스트###########
select deptno, ename, sal
from emp outer
where sal < (select avg(sal) from emp where deptno= outer.deptno);
--emp에 아우터를 붙여서 서브쿼리에서 쓸 수 잇게함. 서브쿼리에서는 그 사원이 속한 부서의 평균을 구해야 하기 때문.
--deptno를 알아야 하기 때문에 아우터로 핸들링

############################
rownum  = row마다 번호가 매겨짐
############################

select rownum,ename,sal,hiredate
from (select * from emp order by  sal desc)
where rownum < 4;
--rownum은 1부터 접근해야 한다. 4보다 큰건 안됨.
--서브쿼리로 프롬절에서 정렬한 값으로 부터 받아오면 정렬 후 rownum이 새겨짐
select rownum,ename,sal,hiredate
from (select * from emp order by  sal desc)
where rownum between 1 and 4;
--1부터 접근은 가능 2이상인 숫자부터 접근하면 안됨.

###################################
page 처리
###################################

select * from(
select rownum row#,ename,sal,hiredate
from (select * from emp order by  sal desc))
where row# between 2 and 4;
--rownum을 명명해주고 서브쿼리로 감싸준다. 함수 로넘이 아닌 row#이라는 이름을 가진 컬럼으로 컨버팅 됐다고 생각하면 됨.

			start	end
1page 1~5	5*0+1	+4
2page 6~10  5*1+1	+4
3page 11~15	5*2+1	+4




