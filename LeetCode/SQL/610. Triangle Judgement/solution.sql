# Write your MySQL query statement below
SELECT
    x, 
    y, 
    z,
    CASE 
        WHEN X+Y <= Z OR X+Z <= Y OR Y+Z <= X THEN "No"
        ELSE "Yes"
    END AS triangle
FROM TRIANGLE
;