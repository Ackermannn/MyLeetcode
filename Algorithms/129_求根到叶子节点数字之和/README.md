# 问题描述

https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/

# Code

depth first search, DFS

```java
class Solution {
    public int path = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int answer = 0;
        path = path * 10 + root.val ;
        if (root.left == null && root.right == null)
            answer += path;
        else{
            answer += sumNumbers(root.left);
            answer += sumNumbers(root.right); 
        }
        path = path / 10;
        return answer;
    }
}
```
