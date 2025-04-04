-- 코드를 작성해주세요
# WITH lan as (
#     SELECT *
#     FROM SKILLCODES
#     WHERE NAME = 'Python' OR NAME = 'C#'
# )
# SELECT DISTINCT ID, EMAIL, FIRST_NAME, LAST_NAME
# FROM DEVELOPERS d
# JOIN lan ON d.SKILL_CODE & lan.CODE = lan.CODE
# ORDER BY ID;

SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS
WHERE SKILL_CODE &
        (SELECT SUM(CODE)
        FROM SKILLCODES
        WHERE NAME in ('Python', 'C#')) > 0
ORDER BY ID;