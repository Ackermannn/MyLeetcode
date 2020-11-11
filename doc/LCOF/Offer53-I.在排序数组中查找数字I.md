# 剑指 Offer 53 - I. 在排序数组中查找数字 I

## 问题

https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/

## 解答

### 方法一
```java
public class Solution{
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) count++;
            else if (nums[i] > target) break;
        }
        return count;
    }
}
```

### 方法二

二分法。找第一个满足的和最后一个满足的

```java
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        return leftSearch(nums, target + 1) - leftSearch(nums, target);
    }

    int leftSearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        int mid;
        if (nums[0] == target) return left;

        while (right - left > 0) {
            mid = (right + left) / 2;
            if (nums[mid] > target) right = mid;
            else if (nums[mid] < target) left = mid + 1;
            else {
                if (nums[mid - 1] != target) return mid;
                else right = mid;
            }
        }
        return left;
    }
}
```