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