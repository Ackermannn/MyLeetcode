#include <iostream>
#include <algorithm>
#include <vector>
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
	vector<vector<int>> levelOrderBottom(TreeNode* root) {
		vector<vector<int>> ans;
		vector<int> row = {}; // save nums in this depth 
		vector<TreeNode*> p = {root}; // save points of next nodes
		while (true)
		{
			row.clear();
			vector<TreeNode*> new_p;
			for (auto x : p) {
				if (x != NULL) { 
					row.push_back(x->val); 
					new_p.push_back(x->left);
					new_p.push_back(x->right);
				}
			}
			if (row.empty()) break;
			ans.push_back(row);
			p = new_p;
		}
		reverse(ans.begin(), ans.end()); // reverse 
		return ans;
	}
};

int main() {
	Solution solu;

	// create Tree
	TreeNode a1(3),a2(9),a3(20),a4(15),a5(7);
	a1.left = &a2;
	a1.right = &a3;
	a3.left = &a4;
	a3.right = &a5;
	
	auto ans = solu.levelOrderBottom(&a1);

	// print ans
	for (auto x : ans) {
		cout << "[";
		for (auto y : x) {
			cout << y << ",";
		}
		cout << ']'<<endl;
	}
}