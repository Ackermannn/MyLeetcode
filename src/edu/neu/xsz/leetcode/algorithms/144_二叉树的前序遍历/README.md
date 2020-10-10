# Question

https://leetcode-cn.com/problems/binary-tree-preorder-traversal/

# Solutions

## Method one

use recur
```java
public List<Integer> preorderTraversalRecur(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) return ans;
    ans.add(root.val);
    ans.addAll(preorderTraversalRecur(root.left));
    ans.addAll(preorderTraversalRecur(root.right));
    return ans;
}

```


## Method two

use stack

```java
public List<Integer> preorderTraversalR(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> ans = new ArrayList<>();
    if (root == null) return ans;
    while (true) {
        ans.add(root.val);
        if (root.right != null)
            stack.push(root.right);
        if (root.left != null)
            root = root.left;
        else {
            if (stack.size() > 0) {
                root = stack.peek();
                stack.pop();
            } else
                return ans;

        }
    }
}

```