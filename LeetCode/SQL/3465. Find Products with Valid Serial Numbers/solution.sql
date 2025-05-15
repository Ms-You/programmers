# Write your MySQL query statement below
SELECT *
FROM PRODUCTS
WHERE DESCRIPTION REGEXP "( |^)SN[0-9]{4}-[0-9]{4}( |$)"
ORDER BY PRODUCT_ID ASC
;