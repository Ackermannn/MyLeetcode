package edu.neu.xsz.leetcode.algorithms._226;

import edu.neu.xsz.datastruct.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}

class Main {

    public static void main(String[] args) {

    }

}
