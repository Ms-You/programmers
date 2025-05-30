# Write your MySQL query statement below
SELECT NAME
FROM SALESPERSON
WHERE SALES_ID NOT IN (
    SELECT O.SALES_ID
    FROM ORDERS O
    INNER JOIN COMPANY C
        ON O.COM_ID = C.COM_ID
    WHERE C.COM_ID IN (
        SELECT COM_ID
        FROM COMPANY
        WHERE NAME = 'RED'
    )
)
;