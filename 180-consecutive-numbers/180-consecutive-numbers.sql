# Write your MySQL query statement below
SELECT DISTINCT num as 'ConsecutiveNums' FROM Logs l 
WHERE (id+1, num) in (SELECT * FROM Logs) AND (id+2,num) in (SELECT * FROM Logs) 