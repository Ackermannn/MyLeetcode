#include<iostream>
using namespace std;
struct ListNode {
	int val;
	ListNode* next;
	ListNode(int x) : val(x), next(NULL) {}
	//ListNode(){}
};

class Solution {
public:
	ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
		//long long temp = 0; // int temp 累加数据 不合适，容易产生数据溢出！！！！！！！！！！！！
				// 算法需要改进 成 模拟人工加法运算！！！！！！！！
		int timer = 1;
		ListNode* tempAddr1 = l1, * tempAddr2 = l2, * res;

		// 当链表以0开头时
		if (l1->val == 0 && l1->next == NULL) return l2;
		if (l2->val == 0 && l2->next == NULL) return l1;


		// 数数有多少层
		int length_l1 = 1, length_l2 = 1;
		for (; ; length_l1++)
		{
			if (tempAddr1->next == NULL) break;  // 判断链表是否到头了
			tempAddr1 = tempAddr1->next;
		}
		for (; ; length_l2++)
		{
			if (tempAddr2->next == NULL) break;  // 判断链表是否到头了
			tempAddr2 = tempAddr2->next;
		}


		int max_length; ListNode* max_l, * min_l;   // 找最长
		if (length_l1 >= length_l2) { max_length = length_l1; max_l = l1; min_l = l2; }
		else { max_length = length_l2; max_l = l2; min_l = l1; }

		res = max_l; // 保存一下最终结果的地址
		tempAddr1 = l1; tempAddr2 = l2;
		for (int i = 1; i <= max_length; i++)
		{
			if (i <= length_l1 && i <= length_l2) // l1 , l2 
			{
				if (tempAddr1->val + tempAddr2->val <= 9) max_l->val = tempAddr1->val + tempAddr2->val;
				else
				{
					max_l->val = (tempAddr1->val + tempAddr2->val) % 10;
					if (max_l->next != NULL) max_l->next->val += 1;
					else
					{
						//ListNode adding(1);
						min_l->val = 1;
						min_l->next = NULL;
						max_l->next = min_l;
						//return res;
					}
				}
				tempAddr1 = tempAddr1->next;
				tempAddr2 = tempAddr2->next;
				max_l = max_l->next;
			}
			else								// 只剩一个长的
			{
				if (max_l->val > 9)
				{
					if (max_l->next != NULL) { max_l->val %= 10; max_l->next->val += 1; }
					else
						// 最高位进位的处理
					{
						//  ListNode adding(1);
						  //	ListNode* Padding;
						//  max_l->next = &adding;
						max_l->val %= 10;
						min_l->val = 1;
						min_l->next = NULL;
						max_l->next = min_l;
						//  return res;
					}
				}
				max_l = max_l->next;
			}
		}
		return res;
	}
};
int main() 
{
	Solution s;
	ListNode* res, *l1, *l2;

	ListNode n1(9), n2(9),m1(9);

	n2.next = &n1;

	l1 = &n1;
	l2 = &m1;

	res = s.addTwoNumbers(l1, l2);
	cout << res->val << '\n' << res->next->val << '\n';// << res->next->next->val << endl;
	return 0;
}
