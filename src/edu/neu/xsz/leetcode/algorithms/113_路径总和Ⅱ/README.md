https://leetcode-cn.com/problems/path-sum-ii/

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<List<Integer>> answer = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return answer;
        recuir(root, sum); // 递归
        return answer;
    }

    public void recuir(TreeNode root, int sum) {
        int newSum = sum - root.val;
        temp.add(root.val);  // 考虑一下当下的root
        if (root.left == null && root.right == null) { // 当root为叶节点
            if (newSum == 0) answer.add(new ArrayList<>(temp)); // sum等于0时，输出结果
        }
        else {
            if (root.left != null) recuir(root.left, newSum);  // 从左节点进入递归
            if (root.right != null) recuir(root.right, newSum); // 从右节点进入递归
        }
        temp.remove(temp.size() - 1); // 回退当前的root, 不要遗漏
    }
}
```
