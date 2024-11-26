-- 코드를 작성해주세요
SELECT
    YEAR(ED.DIFFERENTIATION_DATE) AS YEAR,
    (
        SELECT MAX(SIZE_OF_COLONY)
        FROM ECOLI_DATA
        WHERE YEAR(DIFFERENTIATION_DATE) = YEAR
    ) - ED.SIZE_OF_COLONY AS YEAR_DEV,
    ED.ID AS ID
FROM ECOLI_DATA ED
ORDER BY YEAR ASC, YEAR_DEV ASC
;