/* query 1 */
select
	f.title,
	lo.name,
	l.name
from
	film f inner join language l
	on f.language_id=l.language_id
	inner join language lo
	on f.original_language_id=lo.language_id;
	
/* quey 2 */

select
	ci.city,
	co.country
from
	city ci inner join country co
	on ci.country_id=co.country_id;
	
/* query 3 */

select
	a.address,
	ci.city,
	co.country
from
	store s inner join address a
	on s.address_id= a.address_id
	inner join city ci
	on a.city_id=ci.city_id
	inner join country co
	on co.country_id=ci.country_id;
	
/* query 4 */

select
	f.title,
	ci.city
from
	film f inner join inventory i
	on f.film_id=i.film_id
	inner join store s 
	on i.store_id=s.store_id
	inner join address a
	on s.address_id=a.address_id
	inner join city ci
	on ci.city_id=a.city_id;