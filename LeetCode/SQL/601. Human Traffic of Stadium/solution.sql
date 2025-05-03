# Write your MySQL query statement below
SELECT
    ID,
    VISIT_DATE,
    PEOPLE
FROM (
    SELECT
        ID,
        VISIT_DATE,
        PEOPLE,
        ID - ROW_NUMBER() OVER(ORDER BY ID ASC) AS DIFF
    FROM STADIUM
    WHERE PEOPLE >= 100
) AS S1
WHERE DIFF IN (
    SELECT DIFF
    FROM (
        SELECT 
            ID,
            ID - ROW_NUMBER() OVER(ORDER BY ID ASC) AS DIFF
        FROM STADIUM
        WHERE PEOPLE >= 100
    ) AS S2
    GROUP BY DIFF
    HAVING COUNT(DIFF) >= 3
)
ORDER BY VISIT_DATE ASC
;