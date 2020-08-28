# 问题
给你一个整数数组 nums，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。



**示例 1:**

    输入: [2,3,-2,4]
    输出: 6
    解释:子数组 [2,3] 有最大乘积 6。

**示例 2:**

    输入: [-2,0,-1]
    输出: 0
    解释:结果不能为 2, 因为 [-2,-1] 不是子数组。

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/maximum-product-subarray

# 解答
```java
// 暴力法
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = i; j < nums.length; j++) {
                prod *= nums[j];
                ans = Math.max(ans, prod);
            }
        }
        return ans;
    }
}
```
```java
// 官方题解--动态规划
class Solution {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        ArrayList<Integer> dpMax = new ArrayList<>();
        ArrayList<Integer> dpMin = new ArrayList<>();
        dpMax.add(nums[0]);
        dpMin.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int a = nums[i];
            int b = dpMax.get(i - 1) * nums[i];
            int c = dpMin.get(i - 1) * nums[i];
            dpMax.add(Math.max(a, Math.max(b, c)));
            dpMin.add(Math.min(a, Math.min(b, c)));
        }

        return Collections.max(dpMax);

    }
}
```