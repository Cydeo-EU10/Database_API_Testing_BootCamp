-- select column from table

select EMPLOYEE_ID, FIRST_NAME
from EMPLOYEES;

select *
from EMPLOYEES;

-- select unique data using distintc keyword
select distinct FIRST_NAME
from EMPLOYEES;

-- condition   use where keyword
select FIRST_NAME, SALARY
from EMPLOYEES
where SALARY > 6000;

-- we have >, <, >=, <=, <>not equal , != not equal again
-- and or
-- %    or   _ udnerscore

select FIRST_NAME, SALARY
from EMPLOYEES
where SALARY <> 10000;

select FIRST_NAME
from EMPLOYEES
where FIRST_NAME = 'David';

-- % it stands for the uncertain part of data
select FIRST_NAME
from EMPLOYEES
where FIRST_NAME like 'Da%';

-- _ underscore stands for the characters missing in data
select FIRST_NAME
from EMPLOYEES
where FIRST_NAME like '____';

select FIRST_NAME
from EMPLOYEES
where FIRST_NAME like 'D__%_';

-- between   in
select FIRST_NAME, SALARY
from EMPLOYEES
where SALARY >= 5000
  and salary <= 6000;

select FIRST_NAME, SALARY
from EMPLOYEES
where SALARY between 5000 and 6000;

select SALARY
from EMPLOYEES
where SALARY in (5000, 6000, 7000);


-- count   return number of results
select count(FIRST_NAME)
from EMPLOYEES
where FIRST_NAME like 'D__%_';

-- order by
-- by default, it's ordering ascending way
-- if we want to descending way, we have to type desc
select FIRST_NAME, SALARY
from EMPLOYEES
order by SALARY;

select FIRST_NAME, SALARY
from EMPLOYEES
order by SALARY desc;

-- aggragate functions
-- min, max, avg, sum
select min(SALARY), max(SALARY), avg(SALARY), sum(SALARY)
from EMPLOYEES;
select min(SALARY), max(SALARY), round(avg(SALARY), 2), sum(SALARY)
from EMPLOYEES;

-- group by  and having
select count(FIRST_NAME), JOB_ID
from EMPLOYEES
group by JOB_ID;

select sum(SALARY), DEPARTMENT_ID
from EMPLOYEES
group by DEPARTMENT_ID
having sum(SALARY) > 30000;

select sum(SALARY), JOB_ID
from EMPLOYEES
group by JOB_ID
having sum(SALARY) > 30000;


-- subquery
-- query inside another query
select FIRST_NAME, SALARY
from EMPLOYEES
where SALARY = (select max(SALARY) from EMPLOYEES);


select FIRST_NAME, HIRE_DATE
from EMPLOYEES
where HIRE_DATE = (Select min(HIRE_DATE) from EMPLOYEES);

-- string functions
-- concatination    ||
select FIRST_NAME, LAST_NAME
from EMPLOYEES;

select FIRST_NAME || ' ' || LAST_NAME
from EMPLOYEES;

-- lower, upper, initcap
select FIRST_NAME, LAST_NAME, EMAIL
from EMPLOYEES;
select lower(FIRST_NAME), upper(LAST_NAME), initcap(EMAIL)
from EMPLOYEES;

-- length
select FIRST_NAME, length(FIRST_NAME)
from EMPLOYEES;

-- substr
-- index number is starting from 1, NOT 0
-- the first number is starting point
-- second number is how much character we want
select LAST_NAME
from EMPLOYEES;
select substr(LAST_NAME, 1, 3)
from EMPLOYEES;

-- view
-- virtual table that store our results
create view shortLastName as
select substr(LAST_NAME, 1, 3) as shortLastName
from EMPLOYEES;

-- join
select city
from LOCATIONS;
select DEPARTMENT_NAME
from DEPARTMENTS;

select CITY, DEPARTMENT_NAME
from LOCATIONS
         join
     DEPARTMENTS on LOCATIONS.LOCATION_ID = DEPARTMENTS.LOCATION_ID;

-- left join --> perform join action based on left table
select CITY, DEPARTMENT_NAME
from LOCATIONS
         left join
     DEPARTMENTS on LOCATIONS.LOCATION_ID = DEPARTMENTS.LOCATION_ID;


-- right join --> perform join action based on right table
select CITY, DEPARTMENT_NAME
from LOCATIONS
         right join
     DEPARTMENTS on LOCATIONS.LOCATION_ID = DEPARTMENTS.LOCATION_ID;

-- inner join --> take only matching data from two tables
select CITY, DEPARTMENT_NAME
from LOCATIONS
         inner join
     DEPARTMENTS on LOCATIONS.LOCATION_ID = DEPARTMENTS.LOCATION_ID;

-- outer join --> get all the data no matter it matches or not
select CITY, DEPARTMENT_NAME
from LOCATIONS
         full outer join
     DEPARTMENTS on LOCATIONS.LOCATION_ID = DEPARTMENTS.LOCATION_ID;


select REGION_ID, REGION_NAME from REGIONS;
select * from COUNTRIES;

select REGION_NAME, COUNTRY_NAME from REGIONS
left join COUNTRIES C2 on REGIONS.REGION_ID = C2.REGION_ID;

select REGION_NAME, COUNTRY_NAME from REGIONS
                                          right join COUNTRIES C2 on REGIONS.REGION_ID = C2.REGION_ID;


-- DDL and DML
-- DDL is data definition language
-- DML is data manipulation language

-- create tabel
create table teachers (
    t_id integer primary key ,
    name varchar(25),
    branch varchar(40)
) ;


insert into teachers values (1,'Muhtar','Java');
insert into teachers values (2,'Asiya','SoftSkill');
insert into teachers values (3,'Jamal','Api');

select * from teachers;


create table students (
                          s_id integer primary key ,
                          name varchar(25),
                          course varchar(40)
) ;

insert into students values (1,'Mesut','java');
insert into students values (2,'Ahmet','Selenium');
insert into students values (3,'Jamal','SQL');

select * from students;

-- update data
update teachers
set branch = 'sql'
where t_id = 3;

update instructors
set branch = ''
where t_id = 3;

-- delete
delete teachers
where t_id=2;

-- alter actions
-- change table name
alter table teachers rename to instructors;
select * from instructors;

-- change column name
alter table students rename column course to class;
select * from students;


-- turncate
-- delete all the data inside table, but not table
truncate table students;
select * from students;

-- delete the whole table
drop table instructors;
select * from instructors;

-- union
-- two independent query
-- data type should be same
-- column numbers should be same

-- union all --> return all the data, not deleting duplicated ones ,not sorting
select name from instructors
union all
select name from students;


--union --> return only unique data, and sorting
select name,branch from instructors
union
select name,class from students;

-- minus
select name from instructors
minus
select name from students;

select name from INSTRUCTORS;
select name from students;

-- intersect
select name from instructors
intersect
select name from students;