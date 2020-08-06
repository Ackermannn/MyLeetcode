
# 题目地址

https://leetcode-cn.com/problems/house-robber-ii/

# code

把环拆成两个队列，一个是从0到n-1，另一个是从1到n，然后返回两个结果最大的。两个队列分别用198的解答即可。

```java
class Solution {
    public int rob0(int[] nums) {
        int l = nums.length;
        int[] dp = nums.clone();
        if (l == 0) return 0;     
        for(int i = 0; i < l; i++){
            if (i == 0) ;
            else if (i == 1) dp[i] = Math.max(nums[0], nums[1]);
            else dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1] );
        }   
        return dp[l-1];
    }
    public int rob(int[] nums) {
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int res0 = rob0(Arrays.copyOfRange(nums, 0, nums.length-1));
        int res1 = rob0(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(res0, res1);
    }
}
```