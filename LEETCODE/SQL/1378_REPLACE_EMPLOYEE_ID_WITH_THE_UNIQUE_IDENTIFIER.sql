SELECT
    EmployeeUNI.unique_id AS eid,
    Employees.name as ename
FROM
    Employees
LEFT JOIN 
    ON Employees.id = EmployeeUNI.id;