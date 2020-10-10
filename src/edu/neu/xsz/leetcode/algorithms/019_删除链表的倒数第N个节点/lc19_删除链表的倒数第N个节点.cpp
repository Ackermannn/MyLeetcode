#include<iostream>
#include<vector>

using std::vector;
using std::cout;
using std::endl;

struct ListNode{
	int val;
	ListNode* next;
	ListNode(int x):val(x),next(NULL){}
};
ListNode* getListNode(vector<int> nums) {
	/*
	* 函数功能:
	*	输入 数组 生成 线性链表
	* 例子:
	*   输入: nums = { 4,5,1,9 }
	*   输出: 4->5->1->9
	*/
	ListNode* temp = new ListNode(nums[0]);
	ListNode* h = new ListNode(0);
	h = temp;

	for (int i = 1; i < nums.size(); i++) {
		ListNode* new_one = new ListNode(nums[i]); // 申请动态内存分配,否则被压栈从而无法导出整个链表
		temp->next = new_one;
		temp = new_one;
	}
	return h;
}

void printListNode(ListNode* head) {
	/*
	* 功能:
	*	打印线性链表
	* 例子:
	*   输入: nums = { 4,5,1,9 }
	*   打印输出: 4->5->1->9
	*/
	while (head->next != NULL)
	{
		std::cout << head->val << "->";
		head = head->next;
	}
	std::cout << head->val << endl;
}



class Solution {
public:
	/*
	* 空间复杂度O(n) 指针的指针法 (Solution2改进)
	*/
	ListNode* removeNthFromEnd(ListNode* head, int n) {
		vector<ListNode**> addr; // 存放 各个节点的 xx->next 的地址
		ListNode** temp = &head;
		// 把地址保存下来
		while ( *temp != NULL)
		{
			addr.push_back(temp);
			temp = &((*temp)->next);
		}
		// 删除
		int idx = addr.size() - n ;
		*addr[idx] = (*(addr[idx]))->next; 
		return *(addr[0]);
	
	}


};
class Solution2 {
public:
	ListNode* removeNthFromEnd(ListNode* head, int n) {
		vector<ListNode*> addr;
		ListNode* temp = head;
		// 把地址保存下来
		while (temp != NULL)
		{
			addr.push_back(temp);
			temp = temp->next;
		}

		// 删除
		int idx = addr.size() - n - 1;
		if (idx != -1)	addr[idx]->next = addr[idx]->next->next; // 删除非首地址时
		else {
			head = head->next; // 删除首地址时
		}

		return head;
	}
};
class Solution3 {
public:
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


};

int main() {
	vector<int> nums = { 1,2,3,4,5 };
	int n = 2;

	ListNode* head = getListNode(nums);
	Solution3 solv;
	head = solv.removeNthFromEnd(head, 5);
	printListNode(head);
	return 0;
}