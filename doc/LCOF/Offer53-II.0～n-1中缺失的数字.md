# 剑指 Offer 53 - II. 0～n-1中缺失的数字

## QUESTION

[https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/](https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/)

## SOLUTION

二分法

### CODE

```java
class Solution {
    public int missingNumber(int[] nums) {
        /*二分法*/
        int left = 0;
        int right = nums.length;
        int mid = 0;

        if (nums[0] == 1) return 0;
        if (nums[nums.length - 1] == nums.length - 1) return nums.length;

        while (right > left) {
            mid = (left + right) / 2;
            if (nums[mid] == mid) left = mid + 1; // 结果一定在右边
            else {
                if (nums[mid - 1] == (mid - 1)) return mid;
                else right = mid;
            }
        }
        return mid;

    }
}
```

[代码地址](../../src/edu/neu/xsz/leetcode/lcof/lcof53_2)