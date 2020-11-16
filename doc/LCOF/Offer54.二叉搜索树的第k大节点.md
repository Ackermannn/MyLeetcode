# 剑指 Offer 54. 二叉搜索树的第k大节点

## 问题

给定一棵二叉搜索树，请找出其中第k大的节点。

**示例 1:**

    输入: root = [3,1,4,null,2], k = 1
       3
      / \
     1   4
      \
       2
    输出: 4
    
**示例 2:**

    输入: root = [5,3,6,2,4,null,null,1], k = 3
           5
          / \
         3   6
        / \
       2   4
      /
     1
    输出: 4


限制：

    1 ≤ k ≤ 二叉搜索树元素个数

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof

## 解答

### 思路

[很好的题解思路](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/comments/248642)

### 代码

```java
class Solution {

    ArrayList<Integer> arr = new ArrayList<>();
    int size;

    public int kthLargest(TreeNode root, int k) {
        size = k;
        midSearch(root);
        return arr.get(k - 1);
    }

    void midSearch(TreeNode root) {
        if (root.right != null) midSearch(root.right); // 先遍历大的
        arr.add(root.val);
        if (arr.size() >= size) return; // 大的够了，直接停止。
        if (root.left != null) midSearch(root.left);
    }

}
```
### 代码地址

[该代码的本仓库地址](../../src/edu/neu/xsz/leetcode/lcof/lcof54)