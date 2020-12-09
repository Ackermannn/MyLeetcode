package edu.neu.xsz.leetcode.algorithms._543;

import edu.neu.xsz.datastruct.TreeNode;

/*评论区给出的这个方法速度 0ms 击败100% */
public class Solution2 {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        int L = depth(root.left), R = depth(root.right);
        ans = Math.max(L + R, ans);
        return 1 + Math.max(L, R);
    }
}
