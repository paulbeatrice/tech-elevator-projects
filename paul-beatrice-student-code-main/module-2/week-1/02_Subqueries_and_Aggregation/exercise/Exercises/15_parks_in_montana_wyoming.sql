-- 15. The park name, date established, and area for parks in Montana and Wyoming.
-- Order the results by park name alphabetically.
-- (3 rows)

SELECT DISTINCT park.park_name, park.date_established, park.area

FROM park

JOIN park_state

ON park.park_id = park_state.park_id

WHERE park_state.state_abbreviation IN ('MT', 'WY')

ORDER BY park.park_name

;