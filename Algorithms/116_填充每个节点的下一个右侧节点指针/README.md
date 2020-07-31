# 填充每个节点的下一个右侧节点指针


给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

    struct Node {
      int val;
      Node *left;
      Node *right;
      Node *next;
    }
    
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

 

示例：



    输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

    输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}

    解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。


提示：

> 你只能使用常量级额外空间。
>
> 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node


# method 1

使用队列的层序遍历

详细查看[官方题解](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-j-3/)

```java
class Solution {
    public Node connect1(Node root) {
        int count;
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return null;

        queue.offer(root);
        while (true) {
            Node before = null;
            count = queue.size();
            while (count > 0) {
                Node first = queue.poll();
                first.next = before;
                --count;
                queue.offer(first.right);
                queue.offer(first.left);
                before = first;
            }
            if (before.left == null) break;
        }
        return root;

     }
 }
 ```
 # method 2
 
 时间复杂度为O(n)的方法。利用Node的next方法
 
 详细查看[官方题解](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-j-3/)

 ```java
    public Node connect2(Node root) {
        Node layerFirst = root;
        while (layerFirst != null) {
            Node p = layerFirst;
            while (p != null && p.left != null) {
                p.left.next = p.right;
                if (p.next != null) p.right.next = p.next.left;
                p = p.next;
            }
            layerFirst = layerFirst.left;
        }
        return root;
    }
 ```
 
 # method 3
 
自己想出来的中间缝合的递归
 
 ```java
    public Node connect3(Node root) {
        if (root == null) return null;
        if (root.left == null) return root;

        connect3(root.left);
        connect3(root.right);

        root.left.next = root.right;

        // 中间缝合起来，这里貌似不满足空间要求
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        return root;
    }
 ```
 
 # method 4
 
 自认为最优秀的
 
 https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/comments/104340
 
 ```java
    public Node connect(Node root) {
        if(root == null || root.left == null)
            return root;
        root.left.next = root.right;
        if(root.next != null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

```
