# Write your MySQL query statement below
# SELECT project_id FROM (    
#     SELECT COUNT(employee_id) as count,project_id FROM Project p1
#     GROUP BY project_id
#     ORDER BY COUNT(employee_id) DESC
#     LIMIT 1) project_count
#     ;

SELECT project_id
FROM project
GROUP BY project_id
HAVING COUNT(employee_id) =
(
    SELECT count(employee_id)
    FROM project
    GROUP BY project_id
    ORDER BY count(employee_id) desc
    LIMIT 1
)