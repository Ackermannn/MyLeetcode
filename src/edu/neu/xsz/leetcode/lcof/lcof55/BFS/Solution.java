package edu.neu.xsz.leetcode.lcof.lcof55.BFS;

import edu.neu.xsz.datastruct.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 层次遍历法， 使用两个 队列 ，遍历的时候计数
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        Deque<TreeNode> next;
        while (true) {
            next = new ArrayDeque<>();
            while (!deque.isEmpty()) {
                TreeNode item = deque.pollFirst();
                if (item.left != null) next.offerLast(item.left);
                if (item.right != null) next.offerLast(item.right);
            }
            if (!next.isEmpty()) {
                count++;
                deque = next;
            } else break;
        }
        return count;
    }
}
