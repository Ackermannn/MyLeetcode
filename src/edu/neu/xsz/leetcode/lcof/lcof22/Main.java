package edu.neu.xsz.leetcode.lcof.lcof22;

import edu.neu.xsz.datastruct.ListNode;

class Main {
    public static void main(String[] args) {

//        ISolution solution = new Solution1();  // 方法1
        ISolution solution = new Solution2();  // 方法2

        ListNode head = ListNode.createListNodes(new int[]{1, 2, 3, 4, 5});

        ListNode ret = solution.getKthFromEnd(head,2);

        ListNode.printListNodes(ret);

    }
}