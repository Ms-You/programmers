# Write your MySQL query statement below
SELECT
    Q1.QUERY_NAME,
    ROUND(AVG(Q1.RATING/Q1.POSITION), 2) AS QUALITY,
    COALESCE(ROUND(Q2.TARGET_CNT/COUNT(Q1.QUERY_NAME) * 100, 2), 0) AS POOR_QUERY_PERCENTAGE
FROM QUERIES Q1
LEFT JOIN (
    SELECT
        QUERY_NAME,
        COUNT(QUERY_NAME) AS TARGET_CNT
    FROM QUERIES
    WHERE RATING < 3
    GROUP BY QUERY_NAME
) Q2
    ON Q1.QUERY_NAME = Q2.QUERY_NAME
GROUP BY Q1.QUERY_NAME, Q2.TARGET_CNT
;