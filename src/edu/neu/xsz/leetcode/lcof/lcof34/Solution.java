package edu.neu.xsz.leetcode.lcof.lcof34;

import edu.neu.xsz.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum, new ArrayList<>());
        return this.ans;
    }

    void recur(TreeNode root, int sum, List<Integer> line) {
        if (root != null) {
            line.add(root.val); // 跟新路径
            if (root.left == null && root.right == null) { // 找到路径
                if (root.val == sum) // 存放到 this.ans
                    this.ans.add(line);
            } else {
                if (root.left != null) // 从左子树继续寻找
                    recur(root.left, sum - root.val, new ArrayList<>(line));
                if (root.right != null) // 从右子树继续寻找
                    recur(root.right, sum - root.val, new ArrayList<>(line));
            }
        }
    }
}


