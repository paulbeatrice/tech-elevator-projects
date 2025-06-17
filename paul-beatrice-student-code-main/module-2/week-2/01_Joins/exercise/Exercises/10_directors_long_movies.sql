-- 10. The names of directors who have directed a movie over 3 hours [180 minutes], sorted alphabetically.
-- (15 rows)

SELECT DISTINCT person.person_name
FROM movie
JOIN person ON movie.director_id = person.person_id
WHERE length_minutes > 180
ORDER BY person.person_name
;



