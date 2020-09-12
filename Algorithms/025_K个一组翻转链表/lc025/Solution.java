package lc025;

import data_struct.ListNode;
import java.util.ArrayDeque;

class Solution implements ISolution {
    /**
     * 使用栈反转链表
     */
    @Override
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        ListNode pre = new ListNode(0);
        ListNode p = head;
        ListNode pPre = pre;

        while (true) {
            // 把k个链表装进栈里
            for (int i = 0; i < k; i++) {
                if (p != null) {
                    stack.push(p);
                    p = p.next;
                } else break; // 剩余不足k时
            }


            if (stack.size() == k) { // 从栈中拿出来 接在结果后面
                while (stack.size() > 0) {
                    pPre.next = stack.pop();
                    pPre = pPre.next;
                }
                pPre.next = null;

            } else { // 剩余不足时的处理，直接接上第一个
                if (stack.size() > 0)
                    pPre.next = stack.getLast();
                break;
            }

        }
        return pre.next;

    }
}
