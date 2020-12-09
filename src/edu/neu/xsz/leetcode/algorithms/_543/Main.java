package edu.neu.xsz.leetcode.algorithms._543;

import edu.neu.xsz.datastruct.BitTree;
import edu.neu.xsz.datastruct.TreeNode;
import org.junit.jupiter.api.Test;

class MyTest {
    @Test
    void test1() {
        Solution sol = new Solution();
        Integer[] nums = {1, 2, 3, 4, 5};
        TreeNode root = BitTree.creatABitTree(nums);
        int ans = sol.diameterOfBinaryTree(root);
        System.out.println("================");
        System.out.println("LeetCode No.543");
        System.out.println("Answer: " + ans);

    }

}