# Write your MySQL query statement below
SELECT DISTINCT num as 'ConsecutiveNums' FROM Logs l WHERE num in (
    SELECT num FROM Logs ls 
    WHERE l.num = ls.num AND l.id+1 = ls.id AND num in (
            SELECT num FROM Logs 
            WHERE ls.num = num AND ls.id+1 = id
    )
) 

ORDER BY id
