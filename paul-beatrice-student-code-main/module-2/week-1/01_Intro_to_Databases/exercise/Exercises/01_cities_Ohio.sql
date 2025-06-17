-- 1. The name and population of all cities in Ohio (OH).
-- Order the results alphabetically (A-Z) by city.
-- (6 rows)

Select city_name, population
From city
Where state_abbreviation = 'OH'
Order By city_name
;