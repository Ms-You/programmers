# Write your MySQL query statement below
SELECT UNIQUE_ID, NAME
FROM EMPLOYEES EMP
LEFT JOIN EMPLOYEEUNI UNI
    ON EMP.ID = UNI.ID
;