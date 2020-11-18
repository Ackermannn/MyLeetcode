# 剑指 Offer 56 - I. 数组中数字出现的次数

## 问题

一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。


示例 1：

    输入：nums = [4,1,4,6]
    输出：[1,6] 或 [6,1]

示例 2：

    输入：nums = [1,2,10,4,1,4,3,3]
    输出：[2,10] 或 [10,2]

限制：

    2 <= nums.length <= 10000

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof

## 解答

详细解答可参考以下高赞评论:

https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/comments/281910

我的java代码：

```java
public class Solution {

    public int[] singleNumbers(int[] nums) {
        int[] ans = new int[2];
        int a = 0, bit = 0;

        for (int x : nums) a ^= x; // 全体的亦或就是 所求的两个数的亦或
        for (; a % 2 != 1; bit++) a >>= 1; // 找到一个不同的位

        for (int x : nums) { // 依据不同的位分组, 各自的组进行亦或
            if ((x >> bit) % 2 == 1) ans[0] ^= x;
            else ans[1] ^= x;
        }
        return ans;
    }
}
```
