package lcof24;


import data_struct.ListNode;

/**
 * 迭代的方法
 */
class Solution1 implements ISolution{
    public ListNode reverseList(ListNode head) {
        if (head == null) return head; // 处理 head 为 null 的情况
        ListNode left = head;
        ListNode right = left.next;
        ListNode last = null;
        while (right != null) {
            ListNode temp = right.next; // 保存下个节点

            left.next = last;
            right.next = left;

            last = left;

            left = right;
            right = temp;

        }
        return left;
    }
}

/**
 * 递归的方法
 */
class Solution2 implements ISolution{
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode recurResult = reverseList(head.next);
        ListNode p = recurResult;
        while (p.next != null) p = p.next;
        p.next = head;
        head.next = null;
        return recurResult;
    }
}

class Main {
    public static void main(String[] args) {
        ISolution solution = new Solution2();
        ListNode head = ListNode.createListNodes(new int[]{1, 2, 3, 4, 5});
        ListNode ret = solution.reverseList(head);
        ListNode.printListNodes(ret);
    }

}
