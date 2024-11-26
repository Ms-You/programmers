-- 코드를 입력하세요
SELECT AI.ANIMAL_ID, AI.NAME
FROM ANIMAL_INS AI
INNER JOIN ANIMAL_OUTS AO ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE AI.DATETIME > AO.DATETIME
ORDER BY AI.DATETIME ASC
;