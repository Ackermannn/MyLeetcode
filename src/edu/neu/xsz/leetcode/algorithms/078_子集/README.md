# question
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

    输入: nums = [1,2,3]
    输出:
    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/subsets

# solution

采用官方题解的第三种方法，链接如下：

https://leetcode-cn.com/problems/subsets/solution/zi-ji-by-leetcode/

# code

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); // 结果初始化
        int numSize = nums.length; // 集合长度

        for(int j = 0; j < Math.pow(2, numSize); j++){  // 一共有 2的numSize的次方中可能
            int b = j; // 为 位运算做准备
            List<Integer> temp = new ArrayList<>(); // 子集
            
            // 把 j 转化为 二进制，二进制位正好代表nums对应位置的元素是否要取值。
            for(int i= numSize - 1; i >= 0; i--){
                if (b % 2 == 1){
                    temp.add(nums[i]);
                }
                b = b >> 1;
            }
            res.add(temp);
        }
        return res;
    }
}
```
