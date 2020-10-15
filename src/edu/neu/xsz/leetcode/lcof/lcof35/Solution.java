package edu.neu.xsz.leetcode.lcof.lcof35;


import java.util.HashMap;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

// 哈希的做法，but 在大多数公司的面试官面前并不是一个满意的答案
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

// 原地修改
// https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/comments/249391
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

class Main{
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        node1.random = node2;
        node2.next = null;
        node2.random = node2;
        Solution2 solution2 = new Solution2();
        Node ret = solution2.copyRandomList(node1);
        System.out.println(ret);
    }

}