# Write your MySQL query statement below
SELECT
    USER_ID,
    EMAIL
FROM USERS
WHERE EMAIL REGEXP "^[A-Za-z0-9_]+@[A-Za-z]+\.com$"
ORDER BY USER_ID ASC
;