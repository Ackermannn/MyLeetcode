package lc150;

import java.util.Stack;

/*
问题地址：
https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if ("+".equals(str)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            } else if ("-".equals(str)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);

            } else if ("*".equals(str)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);

            } else if ("/".equals(str)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);

            } else {
                Integer num = Integer.parseInt(str);
                stack.push(num);
            }

        }
        return stack.peek();
    }
}
