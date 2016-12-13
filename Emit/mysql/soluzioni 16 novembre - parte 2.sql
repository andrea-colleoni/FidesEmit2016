-- query 1
select
	f.*
from
	film f
where 
	f.replacement_cost > (
									select
										AVG(f.replacement_cost)
									from film f
								)
order by 
	f.replacement_cost desc
limit 10;

-- query 2
select
	f.*
from 
	film f
order by
	f.last_update desc
limit 10;

-- query 3
select
	case
		when f.length < 100 then 'Brevissimo'
		when f.length between 100 and 150 then 'Breve'
		when f.length between 151 and 200 then 'Medio'
		else 'Lungo'
	end cat_lunghezza,
	COUNT(*) numero_film
from
	film f
group by
	cat_lunghezza;
	
-- query 4
select 
	concat(c.first_name, ' ' , c.last_name)
from 
	customer c INNER JOIN (
				select DISTINCT
					r.customer_id
				from rental r
				where 
					DATEDIFF(r.return_date, r.rental_date) > (
									select
										AVG(DATEDIFF(r.return_date, r.rental_date))
									from
										rental r
									)
				) clienti_ritardatari
	on c.customer_id = clienti_ritardatari.customer_id;
/*	
where
	r.return_date - AVG(r.return_date) > 0
*/

-- query 5
select
	concat(c.first_name, ' ', c.last_name) denominazione,
	case
		when medie_settimanali.media_settimanale > 5 then 'Fascia A'
		when medie_settimanali.media_settimanale between 3 and 5 then 'Fascia B'
		else 'Fascia C'
	end fascia
from 
	(select
		nol_per_cli_e_sett.customer_id,
		AVG(nol_per_cli_e_sett.num_noleggi) media_settimanale
	from (
			select
				r.customer_id,	
				concat(
					weekofyear(
						r.rental_date),
						'#', 
						year(r.rental_date)
						) settimana,		
				COUNT(*) num_noleggi 
			from
				rental r
			group by 
				settimana,
				r.customer_id) nol_per_cli_e_sett
	group by
		nol_per_cli_e_sett.customer_id
		) medie_settimanali inner join customer c
		on medie_settimanali.customer_id=c.customer_id
order by 2		;

-- query 5 (bis)
select
	concat(c.first_name, ' ', c.last_name),
	case 
		when AVG(nps.num_noleggi) > 4 then 'Tanti'
		when AVG(nps.num_noleggi) Between 2 and 4 then 'Medi'
		when AVG(nps.num_noleggi) < 2 then 'Pochi'
	end
from (
		select
			r.customer_id,
			concat(WEEKOFYEAR(r.rental_date), '-', YEAR(r.rental_date)) settimana,
			COUNT(*) num_noleggi
		from
			rental r
		group by
			concat(WEEKOFYEAR(r.rental_date), '-', YEAR(r.rental_date)),
		   r.customer_id
		) nps inner join customer c
		on nps.customer_id=c.customer_id
group by
	nps.customer_id,
	concat(c.first_name, ' ', c.last_name);
	
-- query 6
select
	f.title,
	c.name,
	(f.length - avg_dur_x_cat.durata_media) diff_durata
from (
	select
		fc1.category_id,
		AVG(f.length) durata_media
	from
		film f inner join film_category fc1
		on f.film_id = fc1.film_id 
	group by
		fc1.category_id
	) avg_dur_x_cat inner join film_category fc2
	on avg_dur_x_cat.category_id = fc2.category_id
	inner join film f
	on fc2.film_id = f.film_id
	inner join category c
	on fc2.category_id=c.category_id;
	
-- query 7
select
	AVG(
		DATEDIFF(f1.last_update,
			(
				select
					MIN(f2.last_update)
				from 
					film f2
				where
					f2.last_update > f1.last_update
			)
		)
	)
from
	film f1;
	
	
	
	
	