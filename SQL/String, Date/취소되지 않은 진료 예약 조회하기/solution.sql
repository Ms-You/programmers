-- 코드를 입력하세요
SELECT
    APNT_NO,
    P.PT_NAME,
    P.PT_NO,
    D.MCDP_CD,
    D.DR_NAME,
    AP.APNT_YMD
FROM APPOINTMENT AP
INNER JOIN PATIENT P
    ON AP.PT_NO = P.PT_NO
INNER JOIN DOCTOR D
    ON AP.MDDR_ID = D.DR_ID AND AP.MCDP_CD = D.MCDP_CD
WHERE APNT_YMD LIKE "2022-04-13%" AND APNT_CNCL_YN = "N" AND AP.MCDP_CD = "CS"
ORDER BY AP.APNT_YMD ASC
;