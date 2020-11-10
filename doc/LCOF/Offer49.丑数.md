# 剑指 Offer 49. 丑数

## 问题

我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。


**示例:**

    输入: n = 10
    输出: 12
    解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
    
**说明:**

    1是丑数。
    n不超过1690。

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/chou-shu-lcof

## 解答

### code

```java
/**
 * 三指针法
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int p2 = 1;
        int p3 = 1;
        int p5 = 1;

        for (int i = 2; i < n + 1; i++) {
            int n2 = dp[p2] * 2;
            int n3 = dp[p3] * 3;
            int n5 = dp[p5] * 5;

            if (n2 <= n3 && n2 <= n5) {
                dp[i] = n2;
                p2++;
            }
            if (n3 <= n2 && n3 <= n5) {
                dp[i] = n3;
                p3++;
            }
            if (n5 <= n3 && n5 <= n2) {
                dp[i] = n5;
                p5++;
            }
        }
        return dp[n];
    }
}
```