-- query 2.1
select
	f.*
from 
	film f
order by LENGTH(f.title) desc;

-- query 2.2
select
	a.*
from
	actor a
where
	length(a.first_name) < length(a.last_name);
	
-- query 2.3
select
	a.*
from
	actor a
where
	reverse(a.first_name) = a.first_name
	OR reverse(a.last_name) = a.last_name;
	
-- query 2.4
select
	f.*,
	DATEDIFF(now(),f.last_update)
from
	film f
where
	DATEDIFF(now(),f.last_update) <= 100;
	
-- query 2.5
select
	f.*
from
	film f
where 
	DAYOFWEEK(f.last_update) = 1;
	
-- query 2.6
select
	concat(a.first_name, ' ' , a.last_name) as denominazione
from
	actor a;
	
-- query 2.7
select distinct -- distinct sopprime i record duplicati
	a.*
from
	actor a inner join film_actor fa
	on a.actor_id = fa.actor_id
	inner join film f
	on fa.film_id=f.film_id
where
	f.length>150;
	
-- query 2.8
select
	f.title,
	left(f.description, 50)
from
	film f;
	
-- query 2.9
select
	a.first_name,
	a.last_name,
	DATEDIFF(now(),a.last_update)
from
	actor a;