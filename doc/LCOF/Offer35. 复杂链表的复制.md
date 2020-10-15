# 剑指 Offer 35. 复杂链表的复制

## QUESTION

请实现 `copyRandomList` 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 `next` 指针指向下一个节点，
还有一个 `random` 指针指向链表中的任意节点或者 `null`。

示例 1：

    输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
    输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
    
示例 2：

    输入：head = [[1,1],[2,1]]
    输出：[[1,1],[2,1]]

示例 3：

    输入：head = [[3,null],[3,0],[3,null]]
    输出：[[3,null],[3,0],[3,null]]
    
示例 4：

    输入：head = []
    输出：[]
    解释：给定的链表为空（空指针），因此返回 null。

提示：

    -10000 <= `Node.val` <= 10000
    `Node.random`为空（`null`）或指向链表中的节点。
    节点数目不超过 1000 。


注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-pointer/

链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof

## SOLUTION

### method 1

使用哈希表

```java
class Solution {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node p = head;
        Node newP;
        // 遍历一遍， 建立字典
        while (p != null) {
            newP = new Node(p.val);
            map.put(p, newP);
            p = p.next;
        }

        // 给新链表接线
        p = head;
        while (p != null) {
            newP = map.get(p);
            newP.next = map.get(p.next);
            newP.random = map.get(p.random);
            p = p.next;
        }


        return map.get(head);

    }
}
```
### method 2


原地修改

参考评论： https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/comments/249391

```java

class Solution2 {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        // 先把 1->2->3 变成 1->1->2->2->3->3

        Node p = head;

        while (p != null) {
            Node nextP = p.next;
            Node newP = new Node(p.val);
            p.next = newP;
            newP.next = nextP;
            p = nextP;
        }

        // 处理 newP 的 random
        p = head;
        while (p != null) {
            if (p.random != null)
                p.next.random = p.random.next;
            p = p.next.next;
        }

        // 分离出来
        Node ans = head.next;
        p = head;

        while (p!=null){
            Node newP = p.next;
            Node nextP = newP.next;
            if (newP.next!=null) {
                newP.next = newP.next.next;
            }
            p.next = nextP;
            p = nextP;
        }

        return ans;

    }
}
```

[仓库代码路径](../../src/edu/neu/xsz/leetcode/lcof/lcof35)