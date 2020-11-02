package edu.neu.xsz.leetcode.algorithms._023_合并K个升序链表;

import edu.neu.xsz.datastruct.ListNode;

/**
 *
 */
class Solution implements ISolution {

    @Override
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode pre = new ListNode(0);
        ListNode last = pre;
        while (true) {

            // 找到最小的
            int minIdx = -1;
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {

                if (lists[i] != null && lists[i].val < minValue) {
                    minValue = lists[i].val;
                    minIdx = i;
                }
            }
            // 插入到结果中
            if (minIdx != -1) {
                last.next = lists[minIdx];
                lists[minIdx] = lists[minIdx].next;
                last.next.next = null;
            } else break;
            last = last.next;
        }

        return pre.next;
    }
}
