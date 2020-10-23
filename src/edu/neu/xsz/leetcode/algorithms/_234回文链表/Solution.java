package edu.neu.xsz.leetcode.algorithms._234回文链表;

import edu.neu.xsz.datastruct.ListNode;
/*
题目地址：
https://leetcode-cn.com/problems/palindrome-linked-list/
 */

public class Solution {
    public boolean isPalindrome(ListNode head) {

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        StringBuilder tmp;
        while (head != null){
            s1.append(head.val);
            tmp = new StringBuilder();
            tmp.append(head.val);
            s2.append(tmp.reverse());
            head = head.next;
        }
        return s1.toString().equals(s2.reverse().toString());


    }
}
