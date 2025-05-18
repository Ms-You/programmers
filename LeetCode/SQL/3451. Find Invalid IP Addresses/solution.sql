# Write your MySQL query statement below
-- 잘못된 IP 주소를 찾기 위한 솔루션을 작성합니다. IPv4 주소는 다음 조건 중 하나를 충족하면 유효하지 않습니다:

-- 옥텟에 255보다 큰 숫자가 포함되어 있습니다
-- 모든 옥텟에 선행 0이 있습니다(예: 01.02.03.04)
-- 옥텟이 4개 이하입니다

SELECT
    IP,
    COUNT(*) AS INVALID_COUNT
FROM LOGS
WHERE IP NOT IN (
    SELECT IP
    FROM (
        SELECT 
            IP,
            SUBSTRING_INDEX(SUBSTRING_INDEX(IP, '.', 1), '.', -1) AS SPLIT1,
            SUBSTRING_INDEX(SUBSTRING_INDEX(IP, '.', 2), '.', -1) AS SPLIT2,
            SUBSTRING_INDEX(SUBSTRING_INDEX(IP, '.', 3), '.', -1) AS SPLIT3,
            SUBSTRING_INDEX(SUBSTRING_INDEX(IP, '.', 4), '.', -1) AS SPLIT4
        FROM LOGS
        WHERE LENGTH(IP) - LENGTH(REPLACE(IP, '.', '')) = 3
    ) AS TEMP
    WHERE SPLIT1 <= 255 AND SPLIT2 <= 255 AND SPLIT3 <= 255 AND SPLIT4 <= 255
    AND SPLIT1 NOT LIKE "0%" AND SPLIT2 NOT LIKE "0%" AND SPLIT3 NOT LIKE "0%" AND SPLIT4 NOT LIKE "0%"
)
GROUP BY IP
ORDER BY INVALID_COUNT DESC, IP DESC
;