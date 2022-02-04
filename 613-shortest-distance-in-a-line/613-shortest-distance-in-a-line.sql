# Write your MySQL query statement below
SELECT min(ABS(p1.x-p2.x)) as shortest FROM Point p1
JOIN Point p2
WHERE p1.x!=p2.x
;