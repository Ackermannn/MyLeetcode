package edu.neu.xsz.leetcode.lcof.lcof54;

import edu.neu.xsz.datastruct.TreeNode;

import java.util.ArrayList;
/*
很好的题解思路
https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/comments/248642
 */
class Solution {
    ArrayList<Integer> arr = new ArrayList<>();
    int size;

    public int kthLargest(TreeNode root, int k) {
        size = k;
        midSearch(root);
        return arr.get(k - 1);
    }

    void midSearch(TreeNode root) {
        if (root.right != null) midSearch(root.right); // 先遍历大的
        arr.add(root.val);
        if (arr.size() >= size) return; // 大的够了，直接停止。
        if (root.left != null) midSearch(root.left);
    }

}
