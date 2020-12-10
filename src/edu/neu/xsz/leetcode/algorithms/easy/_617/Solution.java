package edu.neu.xsz.leetcode.algorithms.easy._617;

import edu.neu.xsz.datastruct.TreeNode;

/**
 * 递归就完事儿了
 *
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode ans = new TreeNode(0);
        if (t1 == null && t2 == null) return null;
        if (t1 == null) ans = t2;
        else if (t2 == null) ans = t1;
        else {
            ans.val = t1.val + t2.val;
            ans.left = mergeTrees(t1.left, t2.left);
            ans.right = mergeTrees(t1.right, t2.right);
        }
        return ans;
    }
}
