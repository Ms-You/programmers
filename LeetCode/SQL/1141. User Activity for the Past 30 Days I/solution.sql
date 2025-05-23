# Write your MySQL query statement below
SELECT
    ACTIVITY_DATE AS DAY,
    COUNT(DISTINCT USER_ID) AS ACTIVE_USERS
FROM ACTIVITY
WHERE ACTIVITY_DATE > "2019-06-27" AND ACTIVITY_DATE <= "2019-07-27"
GROUP BY ACTIVITY_DATE
;