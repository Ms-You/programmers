/*
Enter your query here.
*/
SELECT
    IF(GRADE < 8, NULL, NAME),
    GRADE,
    MARKS
FROM STUDENTS S
INNER JOIN GRADES G
    ON S.MARKS BETWEEN G.MIN_MARK AND G.MAX_MARK
ORDER BY GRADE DESC, NAME ASC, MARKS DESC
;