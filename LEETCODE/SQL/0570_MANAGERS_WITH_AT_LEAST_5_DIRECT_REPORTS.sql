
-- Goal: Select the names of managers who oversee at least 5 employees.

-- We perform an inner self join to create row entries that pair a manager to an
-- employee that they oversee (this is based on the condition that the employee's
-- manager ID matches the manager's ID).

-- Then, we group employees according to their manager ID and check if the count of
-- employees in a group associated with a manager ID is at least 5. If so, we select
-- the name of that manager.

SELECT
    m.name
FROM
    Employee m
JOIN
    Employee e ON m.id = e.managerId
GROUP BY e.managerId
HAVING COUNT(e.managerId) >= 5;

