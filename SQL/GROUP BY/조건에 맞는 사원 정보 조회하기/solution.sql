# -- 코드를 작성해주세요
# SELECT 
#     HG.SCORE,
#     HE.EMP_NO,
#     HE.EMP_NAME,
#     HE.POSITION,
#     HE.EMAIL
# FROM HR_EMPLOYEES HE
# INNER JOIN (
#     SELECT EMP_NO, SUM(SCORE) AS SCORE
#     FROM HR_GRADE
#     GROUP BY EMP_NO
#     ORDER BY SCORE DESC
#     LIMIT 1
# ) HG ON HE.EMP_NO = HG.EMP_NO
# ;

# -- 혹은

# -- 코드를 작성해주세요
# SELECT 
#     HG.SCORE,
#     HE.EMP_NO,
#     HE.EMP_NAME,
#     HE.POSITION,
#     HE.EMAIL
# FROM HR_EMPLOYEES HE
# INNER JOIN (
#     SELECT EMP_NO, SUM(SCORE) AS SCORE
#     FROM HR_GRADE
#     GROUP BY EMP_NO
# ) HG ON HE.EMP_NO = HG.EMP_NO
# ORDER BY HG.SCORE DESC
# LIMIT 1
# ;

# -- 혹은

-- 코드를 작성해주세요
SELECT 
    HG.SCORE,
    HE.EMP_NO,
    HE.EMP_NAME,
    HE.POSITION,
    HE.EMAIL
FROM HR_EMPLOYEES HE
INNER JOIN (
    SELECT EMP_NO, SUM(SCORE) AS SCORE
    FROM HR_GRADE
    GROUP BY EMP_NO
) HG ON HE.EMP_NO = HG.EMP_NO
WHERE HG.SCORE = (
    SELECT MAX(SCORE)
    FROM (
        SELECT EMP_NO, SUM(SCORE) AS SCORE
        FROM HR_GRADE
        GROUP BY EMP_NO
    ) AS SUBQUERY  -- 내부 쿼리 사용시 별칭을 부여해야 함
)
;

