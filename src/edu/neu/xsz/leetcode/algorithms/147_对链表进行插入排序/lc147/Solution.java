import edu.neu.xsz.datastruct.ListNode;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        // 在头部加一个虚节点，便于编程实现
        ListNode ans = head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode ret = new ListNode(0); // 排好顺序的
        ListNode insert;
        while (preHead.next != null) {
            // 拿出要被插入的
            insert = preHead.next;
            preHead.next = insert.next;

            // 排序插入结果链表
            ListNode p = ret.next;
            ListNode before = ret;
            while (true) {
                if (p == null || p.val >= insert.val) {
                    before.next = insert;
                    insert.next = p;
                    break;
                } else {
                    before = p;
                    p = p.next;
                }
            }
        }
        ans = ret.next;
        return ans;

    }

    public static void main(String[] args) {
        ListNode head = ListNode.createListNodes(new int[]{4,3,2,1});
        ListNode r = new Solution().insertionSortList(head);
        ListNode.printListNodes(r);

    }
}