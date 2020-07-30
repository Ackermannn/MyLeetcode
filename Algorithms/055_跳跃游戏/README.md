从后往前遍历，计算当下数值是否可以跳到尾部。当该点可以跳到尾部，则把该点当作尾部。

```java
class Solution {
    public boolean canJump(int[] nums) {
        int n = 0;
        for (int i = nums.length - 1; i >= 0; --i){
            if (nums[i] >= n)  n = 0;
            if (i == 0 && n == 0) return true;
            ++n; 
        }
        return false;
    }
}

```
