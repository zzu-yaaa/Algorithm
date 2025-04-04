-- 코드를 작성해주세요
WITH upgrade as(
    SELECT t.ITEM_ID as ITEM_ID
    FROM ITEM_TREE t
    JOIN ITEM_INFO i ON t.PARENT_ITEM_ID = i.ITEM_ID
    WHERE RARITY = 'RARE'
)
SELECT info.ITEM_ID, info.ITEM_NAME, info.RARITY
FROM upgrade up
JOIN ITEM_INFO info ON info.ITEM_ID = up.ITEM_ID
ORDER BY info.ITEM_ID desc;