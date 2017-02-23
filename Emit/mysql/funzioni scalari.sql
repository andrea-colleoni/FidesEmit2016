SELECT CONCAT('My', 'S', 'QL')
FROM DUAL;

select length('ciao');
select left('1234567890', 5);
select right('1234567890soqeqoiuh', 5);

select left(f.title, 5)
from film f;

select lcase('HhHhHhHhH');
select ucase('HhHhHhHhH');
select trim('   dfdsfvdsf fsd fdsfsd    ');
select ltrim('   dfdsfvdsf fsd fdsfsd    ');
select rtrim('   dfdsfvdsf fsd fdsfsd    ');
select instr('Ciao a tutti io sono Andrea', 'ciao');
select reverse('ciao');
select replace('Ciao io sono Andrea', 'Ciao', 'Buongiorno');

select replace(f.title, 'A', '#')
from film f
where f.title like 'g%';

select now();
select date(now());
select time(now());
select year(now());
select month(now());
select day(now());
select hour(now());
select minute(now());
select second(now());
select dayname(now());
select week(now());
select dayname(now());
select last_day(now());
select date_add(now(), INTERVAL 100 DAY);
select datediff(now(), '2000-11-01');
select 10 + (RAND() * 15);