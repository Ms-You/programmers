-- 코드를 입력하세요
SELECT
    CRCRH.CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY CRCRH
INNER JOIN CAR_RENTAL_COMPANY_CAR CRCC
    ON CRCRH.CAR_ID = CRCC.CAR_ID
WHERE CAR_TYPE = "세단" AND START_DATE LIKE "2022-10-%"
GROUP BY CRCRH.CAR_ID
ORDER BY CRCRH.CAR_ID DESC
;