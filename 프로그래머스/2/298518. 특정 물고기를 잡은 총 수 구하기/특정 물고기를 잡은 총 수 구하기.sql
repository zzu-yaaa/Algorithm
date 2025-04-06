-- 코드를 작성해주세요

# 1. 바스와 스내퍼의 타입을 구한다
# 2. 인포 테이블에서 조건절로 걔만 남기고 카운트?

WITH type as (
    SELECT FISH_TYPE
    FROM FISH_NAME_INFO
    WHERE FISH_NAME in ('BASS', 'SNAPPER')
)
SELECT COUNT(*) as FISH_COUNT
FROM FISH_INFO i
JOIN type t ON i.FISH_TYPE = t.FISH_TYPE;