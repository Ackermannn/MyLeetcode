# 问题

https://leetcode-cn.com/problems/sort-list/

# 解答
## 递归法

```java
public class SolutionWithRecur {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head; // 如果只有 0 or 1 个节点直接返回。

        ListNode preHead = new ListNode(0);
        preHead.next = head;

        // 快慢指针找到中间节点
        ListNode fast = preHead;
        ListNode slow = preHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 分出两半，递归
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(preHead.next);

        // 合并
        ListNode p = preHead;
        while (left != null && right != null) { // 查看左右链表，把小的头接到结果链表的尾巴上

            if (left.val <= right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
            p.next = null;
        }
        // 一个链表用完了，另外的链表有富裕的情况
        if (left == null) p.next = right;
        if (right == null) p.next = left;

        return preHead.next;
    }
}

```
## 非递归

