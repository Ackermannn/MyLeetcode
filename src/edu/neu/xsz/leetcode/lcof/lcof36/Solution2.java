package edu.neu.xsz.leetcode.lcof.lcof36;

/**
 * 直接
 */
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
