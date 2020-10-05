package lcof22;

import data_struct.ListNode;

/**
 * 遍历两边
 */
public class Solution1 implements ISolution {
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode pre = new ListNode(0);
        pre.next = head;

        // 计算链表长度
        ListNode p = pre;
        int count = 0;
        while (p.next != null){
            p = p.next;
            count++;

        }

        count = count - k;
        p = pre;
        while (count!=0){
            p = p.next;
            count--;
        }
        return p.next;


    }

}

