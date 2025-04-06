-- 코드를 작성해주세요

# 1. 날짜를 분기로 바꾼다.
# 2. 분기로 그룹바이해서 날짜를 센다?

WITH info as (
    SELECT ID,
        CASE 
            WHEN MONTH(DIFFERENTIATION_DATE) between 1 and 3
            THEN 1
            WHEN MONTH(DIFFERENTIATION_DATE) between 4 and 6
            THEN 2
            WHEN MONTH(DIFFERENTIATION_DATE) between 7 and 9
            THEN 3 
            WHEN MONTH(DIFFERENTIATION_DATE) between 10 and 12
            THEN 4
        END as QUARTER
    FROM ECOLI_DATA
)
SELECT CONCAT(QUARTER,'Q') as QUARTER, COUNT(*) as ECOLI_COUNT
FROM info
GROUP BY QUARTER
ORDER BY QUARTER

