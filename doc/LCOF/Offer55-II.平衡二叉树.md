# 剑指 Offer 55 - II. 平衡二叉树

## 问题

输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。


示例 1:

给定二叉树 `[3,9,20,null,null,15,7]`

        3
       / \
      9  20
        /  \
       15   7

返回 true 。

示例 2:

给定二叉树 `[1,2,2,3,3,null,null,4,4]`

           1
          / \
         2   2
        / \
       3   3
      / \
     4   4
     
返回false 。


限制：

    1 <= 树的结点个数 <= 10000

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof

## 解答

可以参照以下解答

1. [用户@ 普通人能想到的解法 的评论](https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/comments/248392)

2. [面试题55 - II. 平衡二叉树（从底至顶、从顶至底，清晰图解）](https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/solution/mian-shi-ti-55-ii-ping-heng-er-cha-shu-cong-di-zhi/)

## 我的代码

### 法一

利用面试题55-I题的解答，本方法大多数人都能想到

```java
class Solution {

    public int getHight(TreeNode root){
        if (root == null) return 0;
        return Math.max(getHight(root.left), getHight(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHight = getHight(root.left);
        int rightHight = getHight(root.right);
        return Math.abs(leftHight - rightHight) < 2 && isBalanced(root.left) 
                && isBalanced(root.right);
    }
}
```

### 法二

后序遍历+减树

```java
class Solution {

    public int helper(TreeNode root){
        if (root == null) return 0;
        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth -  rightDepth) > 1) 
            return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return helper(root) >= 0;
    }
}
```
