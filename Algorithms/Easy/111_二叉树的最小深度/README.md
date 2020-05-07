# 二叉树的最小深度

## 问题

给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

## 示例:

给定二叉树 `[3,9,20,null,null,15,7]`,

```
	3
   / \
  9  20
	/  \
   15   7
```

返回它的最小深度  2.

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree

# 代码

自己的版本
```cpp

class Solution {
public:
	int minDepth(TreeNode* root) {
		if (root == NULL) return 0; // 根节点为空
		if (root->left == NULL && root->right == NULL) { // 是叶子节点
			return 1;
		}
		else if (root->left == NULL) { // 当左节点缺失 右存在
			return minDepth(root->right) + 1;
		}
		else if (root->right == NULL) { // 当右节点缺失 左存在
			return minDepth(root->left) + 1;
		}
		else // 左右都不为叶节点 
		{
			int left_depth = minDepth(root->left), right_depth = minDepth(root->right);
			return left_depth < right_depth ? left_depth + 1 : right_depth + 1;
		}

	}
};
```

评论区 @听见下雨的声音 的版本

```cpp
class Solution {
public:
    int minDepth(TreeNode* root) {
        if(!root)
            return 0;
        int left=minDepth(root->left),right=minDepth(root->right);
        return (left && right) ? 1+min(left,right):1+left+right;
    }
};
```