-- 코드를 작성해주세요
SELECT ID, LENGTH
FROM FISH_INFO
WHERE LENGTH > 10
ORDER BY LENGTH desc, ID asc
LIMIT 10
