package edu.neu.xsz.leetcode.algorithms._103;

import edu.neu.xsz.datastruct.BitTree;
import edu.neu.xsz.datastruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<Integer> reverseList(List<Integer> list) {

        List<Integer> ans = new ArrayList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            ans.add(list.get(i));
        }
        return ans;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        // 层序遍历
        deque.addLast(root);
        while (deque.size() > 0) {
            Deque<TreeNode> nextDeque = new ArrayDeque<>();
            List<Integer> ans_line = new ArrayList<>();
            while (deque.size() > 0) {
                TreeNode item = deque.pollFirst();
                ans_line.add(item.val);
                if (item.left != null) nextDeque.addLast(item.left);
                if (item.right != null) nextDeque.addLast(item.right);
            }
            ans.add(ans_line);
            deque = nextDeque;
        }
        // 翻转偶数层
        for (int i = 1; i < ans.size(); i += 2) {
            ans.set(i, reverseList(ans.get(i)));
        }

        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = BitTree.creatABitTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Solution sol = new Solution();

        List<List<Integer>> ans = sol.zigzagLevelOrder(root);

        for (List<Integer> x : ans) {

            System.out.println(x.toString());

        }

    }
}
