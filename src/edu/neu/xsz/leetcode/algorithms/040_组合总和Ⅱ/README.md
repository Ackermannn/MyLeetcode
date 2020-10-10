# 题目

给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 

示例 1:

输入: 

    candidates = [10,1,2,7,6,1,5], target = 8,

所求解集为:
    [
      [1, 7],
      [1, 2, 5],
      [2, 6],
      [1, 1, 6]
    ]

示例 2:

输入: 

    candidates = [2,5,2,1,2], target = 5,

所求解集为:

    [
      [1,2,2],
      [5]
    ]

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/combination-sum-ii

# 解答

深度优先搜索 + 递归

# code
```java
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); //排序
        ArrayList<Integer> visited = new ArrayList<>(); //挑选好的
        return combinationSum2(candidates, target, visited); // 递归
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target, ArrayList<Integer> visited) {

        List<List<Integer>> res = new ArrayList<>(); // 结果
        int len = candidates.length;

        for (int i = 0; i < len; i++) {

            if (i != 0 && candidates[i] == candidates[i - 1]) continue; // 跳过同级重复
            int newTarget = target - candidates[i];

            visited.add(candidates[i]);
            ArrayList<Integer> newVisited = new ArrayList<>(visited);

            if (newTarget < 0) break; // 新的target < 0， 后面的candidate明显没有可能了果断break
            else if (newTarget > 0) {
                int[] subCandidates = Arrays.copyOfRange(candidates, i + 1, len);
                res.addAll(combinationSum2(subCandidates, newTarget, newVisited)); // 递归
            } else
                res.add(newVisited);

            visited.remove(visited.size() - 1);

        }
        return res;
    }
  
    // 测试入口
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] c = {1, 2, 4, 2, 3};
        int t = 5;
        List<List<Integer>> res;
        res = s.combinationSum2(c, t);
        System.out.println(res.toString());
    }
}

```
