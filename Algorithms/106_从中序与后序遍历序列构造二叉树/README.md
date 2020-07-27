
# 题目

https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

# 解答

在[105](https://github.com/Ackermannn/MyLeetcode/tree/master/Algorithms/105_%E4%BB%8E%E5%89%8D%E5%BA%8F%E4%B8%8E%E4%B8%AD%E5%BA%8F%E9%81%8D%E5%8E%86%E5%BA%8F%E5%88%97%E6%9E%84%E9%80%A0%E4%BA%8C%E5%8F%89%E6%A0%91)上做小修改即可


# my code

```python
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        size = len(inorder)
        if size == 1: return TreeNode(inorder[0])
        if size == 0: return None
        idx = 0
        for i,item in enumerate(inorder[::-1]):
            if item == postorder[-1]:
                idx = size - i - 1
                break
        ans = TreeNode(postorder[-1])
        ans.left  = self.buildTree(inorder[:idx], postorder[:idx])
        ans.right = self.buildTree(inorder[idx+1:], postorder[idx:-1])
        return ans
```
