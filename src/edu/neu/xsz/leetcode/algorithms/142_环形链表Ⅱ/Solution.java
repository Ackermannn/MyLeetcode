
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode meet = isLoop(head); // 快慢指针法，判断有无环
        if (meet == null) return null; // 无环直接返回null
        while(head.val != meet.val || head.next != meet.next){ // 有环，初始化两个指针，一个从head出发，一个从上次相遇的地方出发，再次相遇的地方就是答案。
            head = head.next;
            meet = meet.next;
        }
        return head;
    }

    // 快慢指针法 判断是否有环
    // 有环返回相遇的位置，无环返回null
    public ListNode isLoop(ListNode head){
        ListNode slow = head;
        ListNode quick = head;
        while (true){
            if (quick.next == null || quick.next.next == null)
                return null;
            slow = slow.next;
            quick = quick.next.next;
            if (slow.val == quick.val && slow.next == quick.next) break;
        }
        return slow;
    }
}
