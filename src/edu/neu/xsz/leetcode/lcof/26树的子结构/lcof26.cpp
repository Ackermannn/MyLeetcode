#include<iostream>
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
    bool isSubStructure(TreeNode* A, TreeNode* B) {
        if (A == NULL || B == NULL) return false;
        return dfs(A, B) || isSubStructure(A->left, B) || isSubStructure(A->right, B); 
    }
    bool dfs(TreeNode* A, TreeNode* B){
        if (B == NULL) return true;
        if (A == NULL) return false;
        return A->val == B->val && dfs(A->left, B->left) && dfs(A->right, B->right);

    }

};

int main(int argc, char const *argv[])
{
    Solution* solution = new Solution();

    TreeNode tn1 = TreeNode(1);
    TreeNode tn2 = TreeNode(2);
    TreeNode tn3 = TreeNode(3);
    tn1.left = &tn2;
    tn1.right = &tn3;

    TreeNode tn4 = TreeNode(3);
    TreeNode tn5 = TreeNode(1);
    tn4.left = &tn5;

    bool ret = solution->isSubStructure(&tn1, &tn4);

    cout << ret << endl;

    return 0;
}
