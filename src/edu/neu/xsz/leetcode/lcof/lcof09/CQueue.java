package edu.neu.xsz.leetcode.lcof.lcof09;

import java.util.Queue;

public class CQueue {
    private int top1;
    private int top2;
    private int[] stack1;
    private int[] stack2;

    public CQueue() {
        top1 = 0;
        top2 = 0;
        stack1 = new int[1000];
        stack2 = new int[1000];
    }

    public void appendTail(int value) {
        stack1[top1++] = value;
    }

    public int deleteHead() {
        if (top2 > 0) {
            return stack2[--top2];
        } else { // stack2 为空
            if (top1 == 0) return -1; // 没有元素

            while (top1 > 0) { // 从 stack1 捯饬进来
                stack2[top2++] = stack1[--top1];
            }
            return stack2[--top2];
        }
    }
}
