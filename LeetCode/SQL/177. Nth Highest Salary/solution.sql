CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
    SELECT IFNULL((
        SELECT SALARY
        FROM (
            SELECT 
                SALARY, 
                DENSE_RANK() OVER(ORDER BY SALARY DESC) AS RANKING
            FROM EMPLOYEE
        ) AS SUBQUERY
        WHERE RANKING = N
        LIMIT 1
    ), NULL)
  );
END