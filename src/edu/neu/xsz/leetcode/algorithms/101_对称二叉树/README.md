
剑指offer版本的题目地址

https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/


递归解法：

```java
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true; // 空树是对称的
        return recur(root.left, root.right); // 递归
    }

    boolean recur(TreeNode root1, TreeNode root2) {
        if (root2==null && root1 == null) return true; // 两个子树是空时 对称
        else if (root1 == null) return false;   // 一空一有 不对称
        else if (root2 == null) return false;   // 一空一有 不对称
        else
            // 两个子树 val 相同，且 左子树的左子树与右子树的右子树对称、左子树的右子树与右子树的左子树对称时, 树是对称的
            return root1.val == root2.val && recur(root1.left, root2.right) && recur(root1.right, root2.left);
    }
}

```