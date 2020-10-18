# 剑指 Offer 39. 数组中出现次数超过一半的数字

# QUESTION

https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/

# MY CODE

[仓库代码路径](../../src/edu/neu/xsz/leetcode/lcof/lcof39)

```java

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