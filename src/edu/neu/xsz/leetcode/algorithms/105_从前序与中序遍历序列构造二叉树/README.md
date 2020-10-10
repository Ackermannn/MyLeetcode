
https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 1: return TreeNode(preorder[0])
        if len(preorder) == 0: return None
        idx = 0
        for i, item in enumerate(inorder):
            if item == preorder[0]:
                idx = i
                break
        ans = TreeNode(preorder[0])
        ans.left = self.buildTree(preorder[1:i + 1], inorder[:i])
        ans.right = self.buildTree(preorder[i + 1:], inorder[i + 1:])
        return ans
```
