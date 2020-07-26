# 问题

给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

示例：
    二叉树：[3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7
返回其层次遍历结果：

    [
      [3],
      [9,20],
      [15,7]
    ]

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal

# 解答

使用队列

# 代码

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null ) return answer;
        while (!queue.isEmpty()) {
            List<Integer> subAnswer = new ArrayList<>();
            Queue<TreeNode> newQueue = new LinkedList<>();
            while (queue.peek() != null) {
                TreeNode temp = queue.poll();
                if(temp.left!=null)newQueue.offer(temp.left);
                if(temp.right!=null)newQueue.offer(temp.right);
                subAnswer.add(temp.val);
            }
            answer.add(subAnswer);
            queue = newQueue;

        }
        return answer;

    }
}
```
