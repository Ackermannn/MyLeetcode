# 剑指 Offer 36. 二叉搜索树与双向链表

# QUESTION

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。



为了让您更好地理解问题，以下面的二叉搜索树为例：

![](https://assets.leetcode.com/uploads/2018/10/12/bstdlloriginalbst.png)

我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。

下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。

![](https://assets.leetcode.com/uploads/2018/10/12/bstdllreturndll.png)

特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，
树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。


**注意：**

本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

**注意：**

此题对比原题有改动。

**来源：** 

力扣（LeetCode）

**链接：** 

https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof



# SOLUTION

```java

/**
 * 借助List的方法
 */
public class Solution {
    ArrayList<Node> arr = new ArrayList<>();

    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        // 中序遍历把arr 存进ArrayList种
        middleScan(root);

        Node last = arr.get(arr.size() - 1);
        Node p;
        // 穿针引线
        for (int i = 0; i < arr.size(); i++) {
            p = arr.get(i);

            p.left = last;

            p.right = arr.get((i + 1) % arr.size());

            last = p;
        }

        return arr.get(0);
    }

    void middleScan(Node root) {
        if (root != null) {
            middleScan(root.left);
            arr.add(root);
            middleScan(root.right);
        }

    }

}

```

直接穿针引线不借助List

```java

public class Solution2 {
    Node head = new Node(Integer.MAX_VALUE);
    Node tail = new Node(Integer.MIN_VALUE);
    Node last = tail;

    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        middleScan(root);
        tail.right = head;
        head.left = tail;
        return head;
    }

    void middleScan(Node root) {
        if (root != null) {
            middleScan(root.left);
            root.left = last;
            last.right = root;
            last = root;

            if (root.val < head.val) head = root;
            if (root.val > tail.val) tail = root;
            middleScan(root.right);
        }
    }
}

```