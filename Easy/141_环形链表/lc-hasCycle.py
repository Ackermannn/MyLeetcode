'''
leetcode 141.环形链表
'''
# Definition for singly-linked list.
class ListNode:

    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    def hasCycle(self, head):
        set0 = set()
        while True:
            if head not in set0:
                set0.add(head)
                if head is None:
                    return False
                else:
                    head = head.next
            else:
                return True
                    
        
def creatListNode(head, pos):
    '''
    description:
        创建环形链表, head给出链表数值, pos指出链表尾巴链接到的位置
    parameter:
        head: type list
        pos: type int
    return:
        type: ListNode
    '''
    if head == []: return None
    temp0 = ListNode(head[0])
    out_head = temp0
    link = None

    for i in head[1:]:        
        if pos == 0: link = temp0
        pos -= 1
        
        temp1 = ListNode(i)
        temp0.next = temp1
        temp0 = temp1
    
    temp0.next = link
    return out_head
    
head = []
pos = -1
h = creatListNode(head, pos)

solv = Solution()
print(solv.hasCycle(h))