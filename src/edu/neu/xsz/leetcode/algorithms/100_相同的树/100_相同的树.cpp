class Solution {
public:
	bool isSameTree(TreeNode* p, TreeNode* q) {
		if (p == nullptr and q == nullptr) return true;
		if (p == nullptr or q == nullptr) return false;
		if (p->val == q->val and isSameTree(p->right, q->right) and isSameTree(p->left, q->left)) 
			return true;
		else
			return false;
	}
};
