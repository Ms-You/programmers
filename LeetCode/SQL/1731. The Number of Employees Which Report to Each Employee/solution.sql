# Write your MySQL query statement below
SELECT
    E1.EMPLOYEE_ID,
    E1.NAME,
    COUNT(E2.EMPLOYEE_ID) AS REPORTS_COUNT,
    ROUND(AVG(E2.AGE), 0) AS AVERAGE_AGE
FROM EMPLOYEES E1
INNER JOIN EMPLOYEES E2
    ON E1.EMPLOYEE_ID = E2.REPORTS_TO
GROUP BY E1.EMPLOYEE_ID, E1.NAME
ORDER BY E1.EMPLOYEE_ID ASC
;