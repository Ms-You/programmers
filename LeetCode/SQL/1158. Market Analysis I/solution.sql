# Write your MySQL query statement below
SELECT
    U.USER_ID AS buyer_id,
    join_date,
    COALESCE(orders_in_2019, 0) AS orders_in_2019
FROM USERS U
LEFT JOIN (
    SELECT
        BUYER_ID,
        COUNT(BUYER_ID) AS orders_in_2019
    FROM ORDERS O
    WHERE ORDER_DATE LIKE "2019%"
    GROUP BY BUYER_ID
) O
    ON U.USER_ID = O.BUYER_ID
GROUP BY U.USER_ID, JOIN_DATE, ORDERS_IN_2019
;