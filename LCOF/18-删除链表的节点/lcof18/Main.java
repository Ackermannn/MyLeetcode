package lcof18;

import data_struct.ListNode;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.createListNodes(new int[]{4, 5, 1, 9});
        solution.deleteNode(head, 5);
        ListNode.printListNodes(head);
    }
}
