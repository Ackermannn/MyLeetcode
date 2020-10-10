package lc023;

import edu.neu.xsz.datastruct.ListNode;

class Main {
    public static void main(String[] args) {
        ListNode l1 = ListNode.createListNodes(new int[]{1, 4, 5});
        ListNode l2 = ListNode.createListNodes(new int[]{1, 3, 4});
        ListNode l3 = ListNode.createListNodes(new int[]{2, 6});
        ListNode[] lists = new ListNode[]{l1, l2, l3};

        ListNode ans = new Solution().mergeKLists(lists);

        ListNode.printListNodes(ans);

    }
}
