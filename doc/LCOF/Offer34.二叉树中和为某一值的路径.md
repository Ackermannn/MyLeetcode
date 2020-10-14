# 剑指 Offer 34. 二叉树中和为某一值的路径

## 问题

输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。



示例:

给定如下二叉树，以及目标和`sum = 22`，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

    [
    [5,4,11,2],
    [5,8,4,5]
    ]


提示：

    节点总数 <= 10000
注意：本题与主站 113题相同：https://leetcode-cn.com/problems/path-sum-ii/

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof

## 解答

回溯法

```java
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum, new ArrayList<>());
        return this.ans;
    }

    void recur(TreeNode root, int sum, List<Integer> line) {
        if (root != null) {
            line.add(root.val); // 跟新路径
            if (root.left == null && root.right == null) { // 找到路径
                if (root.val == sum) // 存放到 this.ans
                    this.ans.add(line);
            } else {
                if (root.left != null) // 从左子树继续寻找
                    recur(root.left, sum - root.val, new ArrayList<>(line));
                if (root.right != null) // 从右子树继续寻找
                    recur(root.right, sum - root.val, new ArrayList<>(line));
            }
        }
    }
}


```

[仓库代码路径](../../src/edu/neu/xsz/leetcode/lcof/lcof34)
