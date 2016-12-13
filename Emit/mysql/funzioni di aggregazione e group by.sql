select COUNT(*)
from actor a;

select
	f.rating,
	f.replacement_cost,
	count(*),
	sum(f.length),
	avg(f.length),
	max(f.length),
	min(f.length)
from film f
group by 
	f.rating,
	f.replacement_cost;
	
select
	-- MONTH(f.last_update),
	LEFT(f.title, 1),
	COUNT(*)
from
	film f
where 
	/*
	-- modo 1
	f.last_update between '2010-01-01'
		and '2010-12-31'
	-- modo 2
	f.last_update >= '2010-01-01'
		and f.last_update < '2011-01-01'	
	*/
	-- modo 3
	YEAR(f.last_update) = 2010
group by
	-- MONTH(f.last_update)
	LEFT(f.title, 1);
	
select
	f.rating
from
	film f
group by
	f.rating;
	
	
select
	LEFT(f.title, 1),
	COUNT(*)
from
	film f
where 
	YEAR(f.last_update) = 2010
group by
	LEFT(f.title, 1)
having
	count(*) >= 5
order by 
	2;
	
select 
	f.*
from 
	film f
order by
	f.title
limit 10;
	
