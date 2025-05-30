# -- 코드를 입력하세요
SELECT FP.PRODUCT_ID, FP.PRODUCT_NAME, (FP.PRICE * FO.TOTAL_AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT FP
INNER JOIN (
    SELECT PRODUCT_ID, PRODUCE_DATE, SUM(AMOUNT) AS TOTAL_AMOUNT
    FROM FOOD_ORDER FO
    WHERE PRODUCE_DATE LIKE "2022-05%"
    GROUP BY PRODUCT_ID
) FO ON FP.PRODUCT_ID = FO.PRODUCT_ID
GROUP BY FP.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, FP.PRODUCT_ID ASC
;

