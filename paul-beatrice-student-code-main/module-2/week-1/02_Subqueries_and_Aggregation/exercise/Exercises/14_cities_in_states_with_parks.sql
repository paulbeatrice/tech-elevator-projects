-- 14. The city name and state abbreviation for all states with a national park.
-- Order the results by state abbreviation, then city name, both in alphabetical order.
-- (261 rows)

select DISTINCT city.city_name, city.state_abbreviation

from city

JOIN park_state

ON city.state_abbreviation = park_state.state_abbreviation

ORDER BY city.state_abbreviation, city.city_name

;