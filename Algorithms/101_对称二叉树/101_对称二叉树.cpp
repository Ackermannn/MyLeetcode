#include<iostream>
using namespace std;
struct TreeNode {
	int val;
	TreeNode* left;
	TreeNode* right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
}; 
class Solution {
public:
	bool isSymmetric(TreeNode* root) {
		if (root == nullptr) return true;
		if (root->left == nullptr and root->right == nullptr) return true;
		if (root->left == nullptr or root->right == nullptr) return false;
		mySwap(root->right);
		return isSameTree(root->left, root->right);

	}
	bool isSameTree(TreeNode* p, TreeNode* q) {  // 调用100题 的方法
		if (p == nullptr and q == nullptr) return true;
		if (p == nullptr or q == nullptr) return false;
		if (p->val == q->val and isSameTree(p->right, q->right) and isSameTree(p->left, q->left))
			return true;
		else
			return false;
	}
	void mySwap(TreeNode* root) {    // 将右边一半 所有节点左右交换
		swap(root->left, root->right);
		if (root->left != nullptr) mySwap(root->left);
		if (root->right != nullptr) mySwap(root->right);
	}
};
int main() {
	TreeNode tn1(3),tn2(3),tn3(2),tn4(2),tn5(1);
	tn3.right = &tn1;
	tn4.right = &tn2;
	tn5.left = &tn3;
	tn5.right = &tn4;
	Solution s;
	cout << s.isSymmetric(&tn5) << endl;
	return 0;
}
