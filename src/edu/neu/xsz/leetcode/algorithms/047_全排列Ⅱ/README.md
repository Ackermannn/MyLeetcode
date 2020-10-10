# Question

给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

    输入: [1,1,2]
    输出:
    [
      [1,1,2],
      [1,2,1],
      [2,1,1]
    ]

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/permutations-ii


# Solution

与全排列Ⅰ 类似


# Code
```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> oneCase = new ArrayList<>();
        return permuteUnique(nums, oneCase);
    }


    public List<List<Integer>> permuteUnique(int[] nums, List<Integer> oneCase) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length==0){
            res.add(oneCase);
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) continue; // 因为有重复的元素，加上去除重复
            
            oneCase.add(nums[i]);
            
            List<Integer> newOneCase = new ArrayList<>(oneCase);
            
            // 剩下的可选项
            int[] newNums = new int[nums.length - 1];
            System.arraycopy(nums, 0, newNums, 0, i);
            System.arraycopy(nums, i + 1, newNums, i, nums.length - i - 1);

            List<List<Integer>> temp_res = permuteUnique(newNums, newOneCase); // 递归
            
            res.addAll(temp_res); // 收集递归的结果
            
            oneCase.remove(oneCase.size() - 1); // 移除当前选择进行新的循环

        }
        return res;

    }

}
```
