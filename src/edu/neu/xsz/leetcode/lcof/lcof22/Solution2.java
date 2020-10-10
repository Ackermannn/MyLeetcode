package edu.neu.xsz.leetcode.lcof.lcof22;

import edu.neu.xsz.datastruct.ListNode;

/**
 * 快慢指针的方法
 */
public class Solution2 implements ISolution {
    @Override
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;



    }
}
