/*
* 此题需要注意审题 只给一个输入参数 参数是个 ListNode* 型的, 不是int型
* 所以不需要 链表头从头找
* 直接对给出的 ListNode* 型变量从 链表中删除即可
*/
class Solution {
public:
    void deleteNode(ListNode* node) {
        node->val = node->next->val;
        node->next = node->next->next;
        
    }
};
