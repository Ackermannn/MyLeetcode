package edu.neu.xsz.leetcode.lcof.lcof32;

import edu.neu.xsz.datastruct.BitTree;
import edu.neu.xsz.datastruct.TreeNode;

import java.util.*;

/***
 * 广度优先搜索
 */
public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.offer(root);

        ArrayList<Integer> ans = new ArrayList<>();
        while (!deque.isEmpty()){
            TreeNode tmp = deque.poll();
            ans.add(tmp.val);
            if (tmp.left!=null) deque.add(tmp.left);
            if (tmp.right!=null) deque.add(tmp.right);

        }

        int[] intAns = new int[ans.size()];
        for (int i = 0; i<ans.size();i++){
            intAns[i] = ans.get(i);
        }
        return intAns;


    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = BitTree.creatABitTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        int[] ret = solution.levelOrder(root);
        System.out.println(Arrays.toString(ret));
    }

}
