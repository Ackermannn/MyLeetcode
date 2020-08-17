package lc110;
/**
 * Question
 *
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * 递归法
 *
 */

import data_struct.TreeNode;

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right)  // 左右子树为平衡树且高度满足要求
                && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1; // 左右子树高度最大的那个加一
    }
}
