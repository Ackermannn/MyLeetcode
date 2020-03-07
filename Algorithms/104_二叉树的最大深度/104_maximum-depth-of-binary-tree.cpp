#include<iostream>
#include <algorithm>

using namespace std;
 // Definition for a binary tree node.
  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };
 
class Solution {
public:
	int maxDepth(TreeNode* root) {
		if (root == NULL) return 0; // 核心代码就是这两行 递归寻找, PS: 递归大法好
		return max(1 + maxDepth(root->left), 1 + maxDepth(root->right));
	}
};

int main() {
	Solution solu;
	TreeNode a(1);
	int ans = solu.maxDepth(&a);
	cout << "ans = " << ans << endl;
}