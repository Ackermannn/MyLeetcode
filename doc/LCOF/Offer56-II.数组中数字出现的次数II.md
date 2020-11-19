# 剑指 Offer 56 - II. 数组中数字出现的次数 II
## 问题
在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。


示例 1：

    输入：nums = [3,4,3,3]
    输出：4
    
示例 2：
    
    输入：nums = [9,1,7,9,7,9,7]
    输出：1


限制：
    
    1 <= nums.length <= 10000
    1 <= nums[i] < 2^31

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof

## 解答

状态机

参考评论：

https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/comments/242372

参考博文：

https://www.cnblogs.com/MyStringIsNotNull/p/12585218.html

```java
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        int temp;
        for (int x : nums) {
            temp = a;
            a = (x ^ a) & b;
            b = (x ^ b) & ~temp | a;
        }
        return b;
    }
}
```
