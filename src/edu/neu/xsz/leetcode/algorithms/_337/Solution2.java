package edu.neu.xsz.leetcode.algorithms._337;

import edu.neu.xsz.datastruct.TreeNode;

/**
 * Solution2
 * author: DownUpZ
 * create: 2021/1/6 上午 11:18
 */
public class Solution2 {


    public int rob(TreeNode root) {
        if (root == null) return 0;
        // 不抢劫
        int left = 0;
        int right = 0;
        int leftRight = 0;
        int leftLeft = 0;
        int rightLeft = 0;
        int rightRight = 0;
        if (root.left != null) {
            left = rob(root.left);
            if (root.left.left != null) leftLeft = rob(root.left.left);
            if (root.left.right != null) leftRight = rob(root.left.right);
        }
        if (root.right != null) {
            right = rob(root.right);
            if (root.right.left != null) rightLeft = rob(root.right.left);
            if (root.right.right != null) rightRight = rob(root.right.right);
        }


        int noRob = left + right;
        int doRob = root.val + leftRight + leftLeft + rightLeft + rightRight;

        return Math.max(noRob, doRob);


    }
}