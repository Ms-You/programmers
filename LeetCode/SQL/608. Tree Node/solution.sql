# Write your MySQL query statement below
SELECT
    ID,
    CASE
        WHEN P_ID IS NULL THEN "Root"
        WHEN ID IN (SELECT P_ID FROM TREE WHERE P_ID IS NOT NULL) THEN "Inner"
        ELSE "Leaf"
    END AS TYPE
FROM TREE
;