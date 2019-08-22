문제 1

select e.employee_id, e.first_name, d.department_name, m.first_name
from employees e join departments d
on e.department_id = d.department_id
join employees m
on e.manager_id = m.employee_id;

문제 2

select e.last_name, e.salary 
from employees e join employees m
on e.manager_id = m.employee_id
where e.salary > m.salary;

문제 3

select first_name, last_name ,salary 
from employees e join jobs j
on e.job_id = j.job_id
where lower(job_title )= lower('Sales Representative') and salary between 9000 and 10000; 

문제 4

select e.employee_id, e.last_name , e.hire_date
from employees e join employees m
on e.manager_id = m.employee_id
where e.hire_date < m.hire_date;

문제 5

select distinct job_title , department_name
from jobs j join employees e on j.job_id =  e.job_id
join departments d on e.department_id = d.department_id
order by job_title;

문제 6

select to_char(hire_date, 'mm') "월" , count(*) "입사자수"
from employees 
group by to_char(hire_date, 'mm')
order by 1;

문제 7

select e.first_name, e.hire_date , m.employee_id , m.first_name
from employees e left outer join employees m
on e.manager_id = m.employee_id
where to_char(e.hire_date , 'yy') = '08';

문제 8

select first_name , salary , d.department_name
from employees e join  departments d
on e.department_id = d.department_id
where lower(d.department_name) = lower('Sales');
--검색은 무조건 로어나 어퍼로 맞춰주자.

문제 9

select  employee_id , first_name, last_name ,nvl(department_name,'NOT ASSIGNED')
from employees e left outer join departments d
on e.department_id = d.department_id
where to_char(e.hire_date , 'yy') = '04' or department_name is null;

문제 10

select e.first_name , e.hire_date, m.employee_id, m.first_name
from employees e left outer join employees m
on e.manager_id = m.employee_id
where to_char(e.hire_date , 'yy') = '03';