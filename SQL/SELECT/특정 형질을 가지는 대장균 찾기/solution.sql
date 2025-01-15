-- 코드를 작성해주세요
SELECT COUNT(ID) AS COUNT
FROM ECOLI_DATA
WHERE (GENOTYPE & 2 = 0) AND ((GENOTYPE & 1 > 0) OR (GENOTYPE & 4 > 0))
;

-- 1번형질: GENOTYPE & 1
-- 2번형질: GENOTYPE & 2
-- 3번형질: GENOTYPE & 4
-- 4번형질: GENOTYPE & 8
-- GENOTYPE & 1 > 0 인 이유는 GENOTYPE & 1 = 1이 되면 0001만 잡고, 1111과 같은 경우는 못잡기 때문