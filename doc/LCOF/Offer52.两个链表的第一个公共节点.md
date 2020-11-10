# 剑指 Offer 52. 两个链表的第一个公共节点
```java
/*
题目地址
https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
太浪漫了 两个结点不断的去对方的轨迹中寻找对方的身影，只要二人有交集，就终会相遇
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
```