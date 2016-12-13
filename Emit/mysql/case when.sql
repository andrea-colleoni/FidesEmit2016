select
	case 
		when f.last_update <= '2012-12-31' then 'OK'
		when f.last_update between '2013-01-01' 
				and '2014-12-31' then 'Insomma'
		else 'KO'
	end as Verifica,
	COUNT(*)
from
	film f
group by
	case 
		when f.last_update <= '2012-12-31' then 'OK'
		when f.last_update between '2013-01-01' 
				and '2014-12-31' then 'Insomma'
		else 'KO'
	end;