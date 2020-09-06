# 题目地址
# https://leetcode-cn.com/problems/rank-scores/
# Write your MySQL query statement below

# 参考题解
# https://leetcode-cn.com/problems/rank-scores/solution/tu-jie-sqlmian-shi-ti-jing-dian-pai-ming-wen-ti-by/

select Score , dense_rank() over(order by Score desc) "Rank"
from Scores
order by Score desc;