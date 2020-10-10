package edu.neu.xsz.leetcode.lcof.lcof18;

import edu.neu.xsz.datastruct.ListNode;

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p = pre;
        while (p.next != null){
            if (p.next.val == val){
                p.next = p.next.next;
                return pre.next;
            }

            p = p.next;

        }
        return pre.next;

    }
}
