# Question

给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。


示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs

# Solution

重点是在单链表前加个空头，这样易于编程。

# Code

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        if (head == null) return null;

        // 加个空头
        ListNode real_head = new ListNode();
        real_head.next = head;
        ListNode res = real_head;

        while (real_head.next != null && real_head.next.next != null) {
            real_head = swapTwo(real_head);
            real_head = real_head.next.next;
        }

        return res.next;
    }

    public ListNode swapTwo(ListNode real_head) {

        ListNode next_one = real_head.next;
        ListNode next_two = next_one.next;
        ListNode next_three = next_two.next;

        real_head.next = next_two;
        next_two.next = next_one;
        next_one.next = next_three;

        return real_head;
    }


}
```
