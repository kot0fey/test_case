SELECT d.NAME        AS Department_Name,
       COUNT(u.ID)   AS Number_of_Employees,
       AVG(u.SALARY) AS Average_Salary
FROM Department d
         LEFT JOIN
     Users u ON d.ID = u.DEPARTMENT_ID
GROUP BY d.NAME;
