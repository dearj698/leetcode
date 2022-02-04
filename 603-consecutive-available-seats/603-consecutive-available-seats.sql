# Write your MySQL query statement below
SELECT DISTINCT c1.seat_id FROM Cinema c1
JOIN Cinema c2
ON c1.seat_id = c2.seat_id+1 or c1.seat_id = c2.seat_id-1
WHERE c2.free = 1 AND c1.free=1
;