# 问题
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

**说明**:
1 ≤ m ≤ n ≤ 链表长度。

**示例**:

    输入: 1->2->3->4->5->NULL, m = 2, n = 4
    输出: 1->4->3->2->5->NULL


# 代码
```java
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;

        // 找到插入点 以 1->2->3->4->5 为例子
        for (int i = 0; i < m - 1; i++) p = p.next;
        ListNode insertLeft = p; // insertLeft 为 1
        ListNode insertRight = p.next; // insertRight 为 2

        // 开始折腾了
        ListNode beforeInserted = insertRight; // beforeInserted 存放之前的插入者 好把 1 给连上他
        for (int j = 0; j < n - m; j++) {
            ListNode inserted= insertRight.next; // 2 后面的是插入者inserted
            insertRight.next = inserted.next; // 把 2 和 4 连起来
            inserted.next = beforeInserted; // 把 3 和 之前的插入者连起来
            insertLeft.next = inserted; // 1 和 2 连起来
            beforeInserted = inserted; // 2 变为了 beforeInserted

        }
        return dummy.next;
    }
}
```
# 来源

力扣（LeetCode）

链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
