/*

 给定一个二叉树，返回它的前序遍历。

 示例:

 输入: [1,null,2,3]
 1
   \
    2
   /
 3

 输出: [1,2,3]
 进阶:递归算法很简单，你可以通过迭代算法完成吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal

 */

import edu.neu.xsz.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    // 先写个递归的前序遍历
    public List<Integer> preorderTraversalRecur(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        ans.add(root.val);
        ans.addAll(preorderTraversalRecur(root.left));
        ans.addAll(preorderTraversalRecur(root.right));
        return ans;
    }

    // 迭代算法
    public List<Integer> preorderTraversalR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        while (true) {
            ans.add(root.val);
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                root = root.left;
            else {
                if (stack.size() > 0) {
                    root = stack.peek();
                    stack.pop();
                } else
                    return ans;

            }
        }
    }

    public static void main(String[] args) {
        TreeNode[] treeNodes = new TreeNode[3];
        for (int i = 1; i <= 3; i++) {
            treeNodes[i - 1] = new TreeNode(i);
        }
        treeNodes[0].left = treeNodes[1];
        treeNodes[0].right = treeNodes[2];
        TreeNode root = treeNodes[0];

        List<Integer> ret = new Solution().preorderTraversalR(root);

    }


}