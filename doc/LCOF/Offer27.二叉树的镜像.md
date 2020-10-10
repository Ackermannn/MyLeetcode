
问题地址：

https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/

```Cpp
class Solution {
public:
	TreeNode* mirrorTree(TreeNode* root) {
		if (!root) return root;

		TreeNode* tmp = mirrorTree(root->left);
		root->left = mirrorTree(root->right);
		root->right = tmp;

		return root;
	}
};
```