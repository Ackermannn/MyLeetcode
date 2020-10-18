# 剑指 Offer 39. 数组中出现次数超过一半的数字

## QUESTION

https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/

## SOLUTION

[面试题39. 数组中出现次数超过一半的数字（摩尔投票法，清晰图解）](https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/)

[在知乎上看到的对摩尔投票法的理解：](https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/584421)

## MY CODE

[仓库代码路径](../../src/edu/neu/xsz/leetcode/lcof/lcof39)

```java
// 摩尔投票法
public class Solution {
    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int votes = 0;

        for (int x : nums) {
            if (votes == 0) {
                votes++;
                ans = x;
            } else {
                if (x != ans) votes--;
                else votes++;
            }

        }
        return ans;

    }
}
```