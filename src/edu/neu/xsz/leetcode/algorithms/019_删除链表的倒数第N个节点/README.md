# 问题
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

```
示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
```

说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list

# 解答

双指针法.

1. 设定一个快指针right, 一个慢指针left. 初始化为head.
2. 先让right移动n个节点.
3. 再让 left, right 同时移动, 直到right到达右端.
4. 删除left 指向的节点.

注意: 

  删除节点时得找到left的前一节点, 所以第三步中 循环判断为:`right->next != NULL`, 而不是`right != NULL`.
  
  当要删除的节点是第一个时,需要单拎出来.

# 代码
```cpp
ListNode* removeNthFromEnd(ListNode* head, int n) {
		ListNode* left = head, * right = left;
		// right 先行一步
		for (int i = 0; i < n; i++) right = right->next;
		
		if (right == NULL) return head->next; // 删除第一个节点的情况

		while (right->next != NULL) {
			left = left->next;
			right = right->next;
		}

		// delete 
		left->next = left->next->next;
		
			
		return head;
}
```
