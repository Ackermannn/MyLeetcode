package edu.neu.xsz.leetcode.algorithms._543;

import edu.neu.xsz.datastruct.TreeNode;

class Solution {
    // 算树高
    public int heightOfTree(TreeNode root) {
        if (root == null) return 0;
        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int thisHeight = heightOfTree(root.left) +  heightOfTree(root.right);
        int temp = Math.max(thisHeight, diameterOfBinaryTree(root.right));
        return Math.max(temp, diameterOfBinaryTree(root.left));
    }
}

