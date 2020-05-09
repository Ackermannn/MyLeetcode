# 

## code
```cpp
class Solution {
public:
	int get_len(ListNode* head) {
		int len = 0;
		while (head != NULL){
			head = head->next;
			len++;
		}
		return len;
	}
	ListNode* getIntersectionNode(ListNode* headA, ListNode* headB) {
		int lenA = 0, lenB = 0;
		lenA = get_len(headA);
		lenB = get_len(headB);

		int diff = abs(lenA - lenB);
		if (lenA < lenB) 
			for (int i = 0; i < diff; i++) headB = headB->next;
		else
			for (int i = 0; i < diff; i++) headA = headA->next;

		while (true){
			if (headA == headB) return headA;
			headA = headA->next;
			headB = headB->next;
		}
	}
};
```