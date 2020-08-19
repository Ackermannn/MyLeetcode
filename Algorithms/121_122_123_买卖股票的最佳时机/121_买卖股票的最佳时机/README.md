# Question

https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/

# Solution

对数值遍历，记录经历过的最低值。计算当下点与最低值的差，如果比历史值大则更新。

```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minValue = prices[0]; // 遍历国产中出现的历史最低点
        int ret = 0;  // 遍历过程中历史最大
        for (int price : prices) {
            minValue = Math.min(minValue, price);
            ret = Math.max(price - minValue, ret);
        }
        return ret;
    }
}


```