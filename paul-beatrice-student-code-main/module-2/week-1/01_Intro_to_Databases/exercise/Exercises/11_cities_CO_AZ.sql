-- 11. The name, state, and population of all cities in Colorado (CO) or Arizona (AZ).
-- Order the results by state abbreviation alphabetically (A-Z), then by populatuon (highest first).
-- (22 rows)

select city_name, state_abbreviation, population
from city
where state_abbreviation IN ('CO', 'AZ')
order by state_abbreviation, population DESC


;