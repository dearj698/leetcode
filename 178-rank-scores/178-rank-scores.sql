# Write your MySQL query statement below
SELECT score, (
    SELECT COUNT(DISTINCT score) FROM Scores 
    WHERE s.score <= score
) as 'rank' FROM Scores s ORDER BY score DESC;