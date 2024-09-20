-- 코드를 입력하세요 
SELECT I.INGREDIENT_TYPE, SUM(H.TOTAL_ORDER) TOTAL_ORDER 
FROM FIRST_HALF H INNER JOIN ICECREAM_INFO I
ON H.FLAVOR = I.FLAVOR
GROUP BY I.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER