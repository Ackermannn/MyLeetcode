#  剑指 Offer 31. 栈的压入、弹出序列

## 问题

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出
顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压
栈序列的弹出序列。



示例 1：

    输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
    输出：true
    解释：我们可以按以下顺序执行：
    push(1), push(2), push(3), push(4), pop() -> 4,
    push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
示例 2：

    输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
    输出：false
    解释：1 不能在 2 之前弹出。


提示：

    0 <= pushed.length == popped.length <= 1000
    0 <= pushed[i], popped[i] < 1000
    pushed是popped的排列。

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof

## 解答

可以参考[第一评论](https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/comments/260175)

> 判断合不合法，用个栈试一试: 把压栈的元素按顺序压入，
当栈顶元素和出栈的第一个元素相同，则将该元素弹出，出
栈列表指针后移并继续判断。最后判断出栈列表指针是否指
向出栈列表的末尾即可。

```java

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

```

仓库代码路径： src/edu/neu/xsz/leetcode/lcof/lcof31