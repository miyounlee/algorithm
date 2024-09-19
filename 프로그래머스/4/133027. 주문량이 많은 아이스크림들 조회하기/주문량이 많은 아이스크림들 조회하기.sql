-- 코드를 입력하세요
SELECT H.FLAVOR
FROM FIRST_HALF H 
INNER JOIN (SELECT FLAVOR, SUM(TOTAL_ORDER) AS JULY_TOTAL_ORDER
            FROM JULY
            GROUP BY FLAVOR ) J
ON H.FLAVOR = J.FLAVOR
ORDER BY (TOTAL_ORDER + JULY_TOTAL_ORDER) DESC
LIMIT 3