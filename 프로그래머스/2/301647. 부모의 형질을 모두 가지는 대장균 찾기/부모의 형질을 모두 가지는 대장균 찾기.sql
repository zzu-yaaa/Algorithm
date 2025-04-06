-- 코드를 작성해주세요

# 3 -> 11
# 5 -> 101
# 3 & 5 001 부모 모두 가지려면 11과 같아야함? 아니면 큰 수 와 같아야함?
# 1. 패런트아이디와 아이디가 같으면
# 비트연산 수행

SELECT e1.ID, e1.GENOTYPE, e2.GENOTYPE as PARENT_GENOTYPE
FROM ECOLI_DATA e1
JOIN ECOLI_DATA e2
    ON e1.PARENT_ID = e2.ID
WHERE e1.GENOTYPE & e2.GENOTYPE = e2.GENOTYPE
ORDER BY e1.ID;