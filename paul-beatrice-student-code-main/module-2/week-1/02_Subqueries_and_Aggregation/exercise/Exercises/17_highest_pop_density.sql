-- 17. The highest population density of all records in the state table. Name the column 'population_density'.
-- Population density is expressed as people per square kilometer. In other words, population divided by area.
-- Exepcted answer is around 4,000
-- (1 row)

select (population/area) as population_density

from state

ORDER BY population_density DESC

limit 1



;