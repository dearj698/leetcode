SELECT s.name FROM SalesPerson s 
WHERE sales_id NOT IN (
    SELECT sales_id from Orders o 
    JOIN Company c USING(com_id)
    WHERE c.name = 'RED'
);