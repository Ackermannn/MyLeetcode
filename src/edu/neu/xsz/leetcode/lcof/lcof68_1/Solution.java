package edu.neu.xsz.leetcode.lcof.lcof68_1;

import edu.neu.xsz.datastruct.BitTree;
import edu.neu.xsz.datastruct.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (p.val < root.val && q.val < root.val) // 充分利用二叉搜索树的性质
            return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}

