# 剑指 Offer 55 - I. 二叉树的深度

## 问题

输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

例如：

给定二叉树 `[3,9,20,null,null,15,7]`，

        3
       / \
      9  20
        /  \
       15   7
       
返回它的最大深度3



提示：

    节点总数 <= 10000

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof

## 解答

### 方法一

- 思路

深度优先搜索DFS、递归

- 代码

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
```
### 方法二

- 思路

层次遍历法， 使用两个 队列 ，遍历的时候计数

- 代码

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        Deque<TreeNode> next;
        while (true) {
            next = new ArrayDeque<>();
            while (!deque.isEmpty()) {
                TreeNode item = deque.pollFirst();
                if (item.left != null) next.offerLast(item.left);
                if (item.right != null) next.offerLast(item.right);
            }
            if (!next.isEmpty()) {
                count++;
                deque = next;
            } else break;
        }
        return count;
    }
}
```