/*
Enter your query here.
*/
SELECT
    HA.HACKER_ID,
    HA.NAME,
    COUNT(CH.CHALLENGE_ID) AS CNT
FROM HACKERS HA
INNER JOIN CHALLENGES CH
    ON HA.HACKER_ID = CH.HACKER_ID
GROUP BY HA.HACKER_ID, HA.NAME
HAVING CNT IN (
    SELECT MAX(CNT)
    FROM (
        SELECT HACKER_ID, COUNT(CHALLENGE_ID) AS CNT
        FROM CHALLENGES
        GROUP BY HACKER_ID
    ) AS SUBQUERY
) OR CNT IN (
    SELECT CNT
    FROM (
        SELECT HACKER_ID, COUNT(CHALLENGE_ID) AS CNT
        FROM CHALLENGES
        GROUP BY HACKER_ID
    ) AS SUBQUERY
    GROUP BY CNT
    HAVING COUNT(CNT) = 1
)
ORDER BY CNT DESC, HA.HACKER_ID ASC
;