package edu.neu.xsz.leetcode.lcof.lcof55.recur;

import edu.neu.xsz.datastruct.TreeNode;

/**
 * 深度优先搜索DFS、递归
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}