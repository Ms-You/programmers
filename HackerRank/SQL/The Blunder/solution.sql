/*
Enter your query here.
*/
SELECT 
    CEIL(
        AVG(SALARY) - 
        AVG(CAST(REPLACE(CAST(SALARY AS CHAR), '0', '') AS SIGNED))
    )
FROM EMPLOYEES
;