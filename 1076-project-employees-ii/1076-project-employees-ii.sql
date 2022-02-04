# Write your MySQL query statement below
SELECT project_id FROM Project GROUP BY project_id HAVING COUNT(employee_id) = (    
    SELECT COUNT(employee_id) as count FROM Project p1
    GROUP BY project_id
    ORDER BY COUNT(employee_id) DESC
    LIMIT 1)
    ;