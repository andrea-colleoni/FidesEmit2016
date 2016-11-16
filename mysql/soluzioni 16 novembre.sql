-- query 1
select
	f.rating,
	MAX(f.last_update)
from
	film f
group by
	f.rating;
	
-- query 2
select
	ci.city,
	f.title,
	COUNT(*)
from
	store s inner join inventory i
	on s.store_id = i.store_id
	inner join address a
	on s.address_id = a.address_id
	inner join city ci
	on a.city_id = ci.city_id
	inner join film f
	on i.film_id = f.film_id
group by
	i.film_id,
	f.title,
	s.store_id,
	ci.city;
	
-- query 3
select
	c.name,
	COUNT(*)
from
	category c inner join film_category fc
	on c.category_id=fc.category_id
group by
	c.name;
	
-- query 4
select
	c.name,
	AVG(f.rental_duration)
from
	category c inner join film_category fc
	on c.category_id=fc.category_id
	inner join film f
	on fc.film_id = f.film_id
group by
	c.name;
	
-- query 5
select
	AVG(DATEDIFF(r.return_date, r.rental_date))
from
	rental r;
	
-- query 6
select
	s.store_id,
	SUM(f.replacement_cost)
from
	store s inner join inventory i
	on s.store_id = i.store_id
	inner join film f
	on i.film_id = f.film_id
group by
	s.store_id
order by 2 desc;

-- query 7
select
	CONCAT(a.first_name, ' ', a.last_name),
	COUNT(fa.film_id)
from
	film_actor fa inner join actor a
	on a.actor_id = fa.actor_id
group by
	fa.actor_id,
	CONCAT(a.first_name, ' ', a.last_name)
order by 2 desc;

-- query 8
select
	f.title,
	COUNT(*)
from
	rental r inner join inventory i
	on r.inventory_id = i.inventory_id
	inner join film f
	on i.film_id = f.film_id	
group by
	f.film_id,
	f.title
order by 2 desc;

-- query 9
select
	concat(a.first_name, ' ', a.last_name),
	COUNT(*)
from
	rental r inner join inventory i
	on r.inventory_id = i.inventory_id
	inner join film_actor fa
	on i.film_id = fa.film_id
	inner join actor a
	on fa.actor_id = a.actor_id
group by
	fa.actor_id,
	concat(a.first_name, ' ', a.last_name)
order by
	2 desc;
		
-- query 10
select
	concat(c.first_name, ' ', c.last_name),
	COUNT(*)
from
	rental r inner join customer c
	on r.customer_id=c.customer_id
group by
	c.customer_id,
	concat(c.first_name, ' ', c.last_name)
order by 2 desc;