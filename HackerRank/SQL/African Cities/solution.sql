SELECT CI.NAME
FROM CITY CI
INNER JOIN COUNTRY CO
    ON CI.COUNTRYCODE = CO.CODE
WHERE CO.CONTINENT = "Africa"
;