-- 22. The name and sales tax for states and territories with sales tax greater than or equal to 2% and less than or equal to 5%.
-- Order the results by sales tax, lowest first.
-- (15 rows)

select state_name, sales_tax

from state
where sales_tax Between 2.0 and 5.0
order by sales_tax

;