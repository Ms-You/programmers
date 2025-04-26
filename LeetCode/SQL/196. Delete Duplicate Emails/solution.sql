# Write your MySQL query statement below
DELETE
FROM PERSON
WHERE ID NOT IN (
    SELECT P.ID
    FROM (
        SELECT MIN(ID) AS ID, EMAIL
        FROM PERSON
        GROUP BY EMAIL
    ) AS P
)
;