# 对链表进行插入排序

题目地址

https://leetcode-cn.com/problems/insertion-sort-list/

# code

```java
class Solution {
    public ListNode insertionSortList(ListNode head) {
        // 在头部加一个虚节点，便于编程实现
        ListNode ans = head; // leetcode是原地修改，所以保存一下结果地址
        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode ret = new ListNode(0); // 排好顺序的
        ListNode insert;
        while (preHead.next != null) {
            // 拿出要被插入的
            insert = preHead.next;
            preHead.next = insert.next;

            // 排序插入结果链表
            ListNode p = ret.next;
            ListNode before = ret;
            while (true) {
                if (p == null || p.val >= insert.val) {
                    before.next = insert;
                    insert.next = p;
                    break;
                } else {
                    before = p;
                    p = p.next;
                }
            }
        }
        ans = ret.next;
        return ans;

    }
}
```