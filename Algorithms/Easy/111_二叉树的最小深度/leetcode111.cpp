#include<iostream>

using namespace std;
//Definition for a binary tree node.
struct TreeNode {
	int val;
	TreeNode* left;
	TreeNode* right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

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
