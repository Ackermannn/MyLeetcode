# 题目

https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/

# code


来自[评论区高赞的答案](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/comments/116994)

```cpp
    TreeNode* last = nullptr;
    void flatten(TreeNode* root) {
        if (root == nullptr) return;
        flatten(root->right);
        flatten(root->left);
        root->right = last;
        root->left = nullptr;
        last = root;
    }
```

my solution

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        flatten(root.left);
        flatten(root.right);
        
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        
        TreeNode p = root;
        while (p.right != null) p = p.right;
        p.right = temp;

    }
}
```
