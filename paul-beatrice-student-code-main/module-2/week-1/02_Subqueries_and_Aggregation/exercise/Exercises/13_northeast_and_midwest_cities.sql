-- 13. The city name, state abbreviation, and population for all cities in the Northeast and Midwest census regions.
-- Order the results by state abbreviation first (alphabetical), then by population (largest first).
-- (84 rows)

SELECT 
city.city_name,
city.state_abbreviation,
city.population

FROM
city

JOIN
state

ON
city.state_abbreviation = state.state_abbreviation

WHERE state.census_region IN ('Northeast', 'Midwest')

ORDER BY state_abbreviation, population DESC

;