
-- select column from table

select EMPLOYEE_ID, FIRST_NAME from EMPLOYEES;

select * from EMPLOYEES;

-- select unique data using distintc keyword
select distinct FIRST_NAME from EMPLOYEES;

-- condition   use where keyword
select FIRST_NAME, SALARY from EMPLOYEES
where SALARY > 6000;

-- we have >, <, >=, <=, <>not equal , != not equal again
-- and or
-- %    or   _ udnerscore

select FIRST_NAME, SALARY from EMPLOYEES
where SALARY <> 10000 ;

select FIRST_NAME from EMPLOYEES
where FIRST_NAME = 'David';

-- % it stands for the uncertain part of data
select FIRST_NAME from EMPLOYEES
where FIRST_NAME like 'Da%';

-- _ underscore stands for the characters missing in data
select FIRST_NAME from EMPLOYEES
where FIRST_NAME like '____';

select FIRST_NAME from EMPLOYEES
where FIRST_NAME like 'D__%_';

-- between   in
select FIRST_NAME, SALARY from EMPLOYEES
    where SALARY >= 5000 and salary <= 6000;

select FIRST_NAME, SALARY from EMPLOYEES
where SALARY between 5000 and 6000;

select SALARY from EMPLOYEES
    where SALARY in (5000,6000,7000);



-- count   return number of results
select count(FIRST_NAME) from EMPLOYEES
where FIRST_NAME like 'D__%_';

-- order by
-- by default, it's ordering ascending way
-- if we want to descending way, we have to type desc
select FIRST_NAME, SALARY from EMPLOYEES
order by SALARY;

select FIRST_NAME, SALARY from EMPLOYEES
order by SALARY desc;

-- aggragate functions
-- min, max, avg, sum
select min(SALARY), max(SALARY), avg(SALARY),sum(SALARY) from EMPLOYEES;
select min(SALARY), max(SALARY), round(avg(SALARY),2),sum(SALARY) from EMPLOYEES;

-- group by  and having
select count(FIRST_NAME), JOB_ID from EMPLOYEES
group by JOB_ID;

select sum(SALARY) , DEPARTMENT_ID from EMPLOYEES
group by DEPARTMENT_ID
having sum(SALARY) > 30000;

select sum(SALARY) , JOB_ID from EMPLOYEES
group by JOB_ID
having sum(SALARY) > 30000;


-- subquery
-- query inside another query
select FIRST_NAME,SALARY from EMPLOYEES
where SALARY = (select max(SALARY) from EMPLOYEES);


select FIRST_NAME, HIRE_DATE from EMPLOYEES
where HIRE_DATE = (Select min(HIRE_DATE) from EMPLOYEES);

-- string functions
-- concatination    ||
select FIRST_NAME, LAST_NAME from EMPLOYEES;

select FIRST_NAME || ' ' || LAST_NAME from EMPLOYEES;








