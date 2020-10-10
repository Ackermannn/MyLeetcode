package edu.neu.xsz.datastruct;

// Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;

    }

    /**
     * 输入int[]数组，给出线性链表
     * @param nums int[] 链表的结点值
     * @return 链表的头
     */
    public static ListNode createListNodes(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int x : nums) {
            p.next = new ListNode(x);
            p = p.next;
        }
        return head.next;
    }

    /**
     * 给出链表的头打印链表
     * @param head 链表的头
     */
    public static void printListNodes(ListNode head){
        while (head != null){
            System.out.print(head.val);
            if (head.next != null) System.out.print("->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode lns = ListNode.createListNodes(new int[]{1,23});
        ListNode.printListNodes(lns);

    }

}
