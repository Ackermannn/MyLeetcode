/*
题目地址：
https://leetcode-cn.com/problems/balanced-binary-tree/

使用递归解决

*/
#include<iostream>
#include<algorithm>
using namespace std;


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
 
class Solution {
public:
    bool isBalanced(TreeNode* root) {
        if (root == NULL) return true;
        int left_len = getTreeHeigh(root->left);
        int right_len = getTreeHeigh(root->right);
        if (abs(left_len - right_len) > 1) return false; // 子树的高度差>1 输出false
        else {

            return isBalanced(root->left) && isBalanced(root->right); // 否则递归
        }
    }
    int getTreeHeigh(TreeNode* root) {
        // 计算树的高度
        if (root == NULL) return 0;
        else
            return max(getTreeHeigh(root->left), getTreeHeigh(root->right)) + 1;
    }
};

int main() {

    return 0;
}
