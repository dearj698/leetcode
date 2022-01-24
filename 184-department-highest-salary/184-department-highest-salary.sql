# Write your MySQL query statement below


SELECT d.name as Department,e.name as Employee, e.salary
FROM Employee e
JOIN Department d on d.id = e.departmentId
WHERE e.salary >= ALL (
    SELECT salary FROM Employee WHERE departmentId = e.departmentId
)
