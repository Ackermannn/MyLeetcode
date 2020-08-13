package lc143;

import data_struct.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Solution {
    public void reorderList(ListNode head) {
        // 先把链表放进双端队列里
        Deque<ListNode> deque = new ArrayDeque();
        ListNode p = head;
        while (p != null) {
            deque.add(p);
            p = p.next;
        }
        if (deque.size() <= 1) return;
        // 再利用双端队列重排
        ListNode before = null;
        ListNode left;
        ListNode right;
        while (deque.size() > 1) {
            left = deque.pollFirst();
            if (before != null) before.next = left;

            right = deque.pollLast();
            left.next = right;

            before = right;
            before.next = null;
        }
        if (deque.size() == 1) {

            before.next = deque.pollFirst();
            before.next.next = null;
        }

    }

    /**
     * 测试区
     * @param args
     */
    public static void main(String[] args) {
        int[][] tests = {
                {1, 2, 3, 4},
                {1, 2, 3, 4, 5},
                {1}
        };

        for (int[] x : tests) {
            ListNode head = ListNode.createListNodes(x);
            Solution sol = new Solution();
            sol.reorderList(head);
            ListNode.printListNodes(head);
            System.out.println();
        }
    }
}
