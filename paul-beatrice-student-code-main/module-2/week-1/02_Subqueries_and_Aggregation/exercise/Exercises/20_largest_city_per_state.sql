-- 20. The state abbreviation, and population of the city with the largest population (name column 'city_population') for all states, territories, and districts.
-- Order the results from highest to lowest populations.
-- (56 rows)

select state_abbreviation, MAX(population) AS city_population

FROM city

GROUP BY state_abbreviation

ORDER BY city_population DESC


;






