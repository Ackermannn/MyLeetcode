# Question

https://leetcode-cn.com/problems/reorder-list/

# Solution

双端队列法， 注意不要忘记对最后一个链表置空


# code
```java
class Solution{
    public void reorderList(ListNode head) {
        // 先把链表放进双端队列里
        Deque<ListNode> deque = new ArrayDeque();
        ListNode p = head;
        while (p != null) {
            deque.add(p);
            p = p.next;
        }
        if (deque.size() <= 1) return;
        // 再利用双端队列重排
        ListNode before = null;
        ListNode left;
        ListNode right;
        while (deque.size() > 1) {
            left = deque.pollFirst();
            if (before != null) before.next = left;

            right = deque.pollLast();
            left.next = right;

            before = right;
            before.next = null;
        }
        if (deque.size() == 1) {

            before.next = deque.pollFirst();
            before.next.next = null;
        }

    }
}
```