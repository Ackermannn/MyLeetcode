package edu.neu.xsz.leetcode.algorithms.easy.lc20;

import java.util.Stack;


class Solution {
    /**
     * 使用栈
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if ((stack.size() != 0 && c == ')' && stack.peek() == '(')
                    || (stack.size() != 0 && c == ']' && stack.peek() == '[')
                    || (stack.size() != 0 && c == '}' && stack.peek() == '{'))
                stack.pop();

            else return false;

        }
        return stack.size() == 0;

    }

    /**
     * 测试区
     * @param args
     */
    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean res = sol.isValid("{[]}");
        System.out.println(res);
        res = sol.isValid("]");
        System.out.println(res);
        res = sol.isValid("(])");
        System.out.println(res);


    }
}
