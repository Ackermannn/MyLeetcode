# 问题
https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/

# 解答

使用栈

```java
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

```