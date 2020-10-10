# Question

https://leetcode-cn.com/problems/first-missing-positive/

# Solution
## method1

排序法 

不符合题目要求

### code

```java

class Solution {
    /**
     * 有排序的方法 不符合题目要求
     */
    public int firstMissingPositive(int[] nums) {
        // 排序
        Arrays.sort(nums);
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || (i != nums.length - 1 && nums[i] == nums[i + 1])) continue;
            if (nums[i] == ans) ans++;
            else break;
        }
        return ans;
    }
}

```

## method2
来自@Saoqi 老哥的精妙解答

https://leetcode-cn.com/problems/first-missing-positive/comments/8020

### code

```java

class Solution {
    /**
     * 交换
     */
    void swap(int[] nums, int x, int y) {
        int temp;
        temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (1 <= nums[i] && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }

        }
        int ans = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) return i + 1;
        }
        return ans;
    }
}


```

