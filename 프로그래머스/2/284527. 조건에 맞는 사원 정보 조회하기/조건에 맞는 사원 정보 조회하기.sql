-- 코드를 작성해주세요

WITH best as (
    SELECT EMP_NO, SUM(SCORE) as score
    FROM HR_GRADE
    GROUP BY EMP_NO
)
SELECT b.score, e.EMP_NO, e.EMP_NAME, e.POSITION, e.EMAIL
FROM HR_EMPLOYEES e
JOIN best b ON e.EMP_NO = b.EMP_NO
ORDER BY b.score desc
LIMIT 1;

