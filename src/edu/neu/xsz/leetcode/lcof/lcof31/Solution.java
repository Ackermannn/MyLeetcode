package edu.neu.xsz.leetcode.lcof.lcof31;

import java.util.Stack;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {

            stack.push(pushed[i]);
            while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == popped.length;


    }
}

// local test

class Main {
    public static void main(String[] args) {
        System.out.println("Local test is starting! ");
        Solution solution = new Solution();

        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};

        boolean ret = solution.validateStackSequences(pushed, popped);

        System.out.println("answer: " + ret);


    }
}