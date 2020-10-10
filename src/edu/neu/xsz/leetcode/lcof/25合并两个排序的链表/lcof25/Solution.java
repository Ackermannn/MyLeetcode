import edu.neu.xsz.datastruct.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ansPre = new ListNode(0);
        ListNode p = ansPre;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;

        }

        if (l1 == null) p.next = l2;
        else p.next = l1;

        return ansPre.next;

    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] num1 = {1, 2, 4};
        int[] num2 = {1, 3, 4};

        ListNode l1 = ListNode.createListNodes(num1);
        ListNode l2 = ListNode.createListNodes(num2);

        ListNode ret = solution.mergeTwoLists(l1, l2);

        ListNode.printListNodes(ret);

    }

}
