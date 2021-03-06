# 问题

峰值元素是指其值大于左右相邻值的元素。

给定一个输入数组`nums`，其中 `nums[i] ≠ nums[i+1]`，找到峰值元素并返回其索引。

数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

你可以假设`nums[-1] = nums[n] = -∞`。

示例 1:

    输入: nums = [1,2,3,1]
    输出: 2
    解释: 3 是峰值元素，你的函数应该返回其索引 2。
    
示例2:

    输入: nums = [1,2,1,3,5,6,4]
    输出: 1 或 5 
    解释: 你的函数可以返回索引 1，其峰值元素为 2；
        或者返回索引 5， 其峰值元素为 6。
说明:

你的解法应该是`O(logN)`时间复杂度的。

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/find-peak-element

# 解答

## 遍历法


```java
class Solution1 implements Solution {
    /**
     * 暴力法， 不满足 对数时间复杂度的要求
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[0] > nums[1]) return 0;
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) return i;
            } else {
                if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) return i;
            }
        }
        return 0;
    }

}
```
## 官方线性扫描法
```java
class Solution2 implements Solution {
    /**
     * 官方线性扫描法
     */
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

}

```
## 二分查找
```java
class Solution3 implements Solution {
    /**
     * 二分查找, 要大的一半不要小的一半，来回迭代剩下的最后一个点就是结果。
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length;
        int mid = 0;

        while ((right - left) > 1) {
            mid = (left + right - 1) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid + 1;
            }

        }
        return left;
    }
}

```