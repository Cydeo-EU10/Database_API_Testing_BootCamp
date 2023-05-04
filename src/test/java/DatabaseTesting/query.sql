
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






