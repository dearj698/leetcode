# Write your MySQL query statement below
SELECT a.player_id, a.event_date, sum(ay.games_played) as games_played_so_far FROM Activity a
JOIN Activity ay ON
a.event_date>=ay.event_date
AND 
a.player_id = ay.player_id
GROUP BY player_id,event_date;
