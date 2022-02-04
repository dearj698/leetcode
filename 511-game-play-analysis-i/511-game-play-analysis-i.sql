# Write your MySQL query statement below
SELECT DISTINCT player_id, min(event_date) as first_login from Activity a group by player_id;