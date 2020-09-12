package lc025;

import data_struct.ListNode;

class Main {
    public static void main(String[] args) {
        ISolution iSolution = new Solution();
//        ListNode head = ListNode.createListNodes(new int[]{1, 2, 3, 4, 5});
//        ListNode res = iSolution.reverseKGroup(head, 2);

        ListNode head = ListNode.createListNodes(new int[]{1, 2});
        ListNode res = iSolution.reverseKGroup(head, 2);


        ListNode.printListNodes(res);

    }
}
