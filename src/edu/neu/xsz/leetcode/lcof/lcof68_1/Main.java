package edu.neu.xsz.leetcode.lcof.lcof68_1;

import edu.neu.xsz.datastruct.BitTree;
import edu.neu.xsz.datastruct.TreeNode;

class Main {
    public static void main(String[] args) {
        Integer[] nums = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = BitTree.creatABitTree(nums); //[]
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);

        TreeNode ret = new Solution().lowestCommonAncestor(root, p, q);
        System.out.println(ret.val);

    }
}
