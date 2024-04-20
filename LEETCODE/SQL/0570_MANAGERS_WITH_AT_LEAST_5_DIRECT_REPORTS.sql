
-- Goal: Select the names of managers who oversee at least 5 employees.

-- We perform an inner self join to create row entries that pair a manager to an
-- employee that they oversee (this is based on the condition that the employee's
-- manager ID matches the manager's ID). 

SELECT
    m.name
FROM
    Employee m
JOIN
    Employee e ON m.id = e.managerId
GROUP BY e.managerId
HAVING COUNT(e.managerId) >= 5;

