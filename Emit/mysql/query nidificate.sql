-- quali film costano più della media?
select
	f.*
from
	film f
where
	f.replacement_cost > (
								select
									avg(f.replacement_cost)
								from
									film f
								);
-- qual è la differenza tra la durata di un film
-- e la media delle durate?
select
	f.title,
	f.length - (
					select
						avg(f.length)
					from
						film f
					)
from
	film f;
	
-- 
select
	(
	select f.title
	from film f
	where f.film_id = fa.film_id
	),
	(
	select 
		concat(a.first_name,' ',a.last_name)
	from actor a
	where a.actor_id=fa.actor_id
	)
from
	film_actor fa;
	
select
	f.*
from
	film f inner join (
		select fa.film_id 
		from film_actor fa 
		where fa.last_update > '2006-01-01'
	) recenti
	on f.film_id=recenti.film_id;