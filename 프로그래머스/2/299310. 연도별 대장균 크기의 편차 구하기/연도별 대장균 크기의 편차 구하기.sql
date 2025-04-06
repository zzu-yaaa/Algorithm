-- 코드를 작성해주세요

# 1. 연도와 연도별로 가장 큰 대장균의 크기를 구한다.
# 2. 연도를 비교해서 편차를 구한다.
# 3. 정렬

WITH size_info as (
    SELECT year(DIFFERENTIATION_DATE) as YEAR,
    MAX(SIZE_OF_COLONY) as MAX_SIZE
    FROM ECOLI_DATA
    GROUP BY year(DIFFERENTIATION_DATE)
)
SELECT s.YEAR,
    s.MAX_SIZE - e.SIZE_OF_COLONY as YEAR_DEV,
    ID
FROM ECOLI_DATA e
JOIN size_info s
    ON year(e.DIFFERENTIATION_DATE) = s.YEAR
ORDER BY YEAR, YEAR_DEV;
