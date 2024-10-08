-- 코드를 작성해주세요
-- 코드를 작성해주세요
SELECT YEAR(DIFFERENTIATION_DATE) YEAR
    , (S.MAX_SIZE - E.SIZE_OF_COLONY) YEAR_DEV
    , ID
FROM ECOLI_DATA E 
INNER JOIN (
    SELECT YEAR(DIFFERENTIATION_DATE) YEAR
        , MAX(SIZE_OF_COLONY) MAX_SIZE
    FROM ECOLI_DATA
    GROUP BY YEAR(DIFFERENTIATION_DATE)) S
ON YEAR(E.DIFFERENTIATION_DATE) = S.YEAR
ORDER BY YEAR, YEAR_DEV
