# Write your MySQL query statement below
SELECT
    FIRST.STUDENT_ID,
    FIRST.SUBJECT,
    FIRST.FIRST_SCORE,
    LATEST.LATEST_SCORE
FROM (
    SELECT
        S1.STUDENT_ID,
        S1.SUBJECT,
        S1.SCORE AS FIRST_SCORE,
        S1.EXAM_DATE AS FIRST_EXAM_DATE
    FROM SCORES S1
    INNER JOIN (
        SELECT
            STUDENT_ID,
            SUBJECT,
            MIN(EXAM_DATE) AS MIN_EXAM_DATE
        FROM SCORES
        GROUP BY STUDENT_ID, SUBJECT
    ) AS S2
        ON S1.STUDENT_ID = S2.STUDENT_ID
            AND S1.SUBJECT = S2.SUBJECT
            AND S1.EXAM_DATE = S2.MIN_EXAM_DATE
) AS FIRST
INNER JOIN (
    SELECT
        S1.STUDENT_ID,
        S1.SUBJECT,
        S1.SCORE AS LATEST_SCORE,
        S1.EXAM_DATE AS LATEST_EXAM_DATE
    FROM SCORES S1
    INNER JOIN (
        SELECT
            STUDENT_ID,
            SUBJECT,
            MAX(EXAM_DATE) AS MAX_EXAM_DATE
        FROM SCORES
        GROUP BY STUDENT_ID, SUBJECT
    ) AS S2
        ON S1.STUDENT_ID = S2.STUDENT_ID
            AND S1.SUBJECT = S2.SUBJECT
            AND S1.EXAM_DATE = S2.MAX_EXAM_DATE
) AS LATEST
    ON FIRST.STUDENT_ID = LATEST.STUDENT_ID
        AND FIRST.SUBJECT = LATEST.SUBJECT
WHERE FIRST.FIRST_SCORE < LATEST.LATEST_SCORE
    AND FIRST.FIRST_EXAM_DATE < LATEST.LATEST_EXAM_DATE
ORDER BY FIRST.STUDENT_ID ASC, FIRST.SUBJECT ASC
;