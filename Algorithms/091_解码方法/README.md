# Question

一条包含字母 A-Z 的消息通过以下方式进行了编码：

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26

给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

    输入: "12"
    输出: 2
    解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

    输入: "226"
    输出: 3
    解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/decode-ways

# Solution

动态规划

# Code

```java
class Solution {
    public int numDecodings(String s) {
        Stack<Integer> res = new Stack<>(); // 存放动态规划的结果
        int strSize = s.length(); 
        if (s.charAt(0) == '0') return 0; // 边界条件 首位是0 返回0
        res.push(1); // push两次是为了 应对 s 长度为2的情况
        res.push(1);
        for (int i = 1; i < strSize; i++) {
            String subStr = s.substring(i - 1, i + 1); // 考虑后两个字符
            if (subStr.charAt(1) == '0') {  // 当 ”10“ ”20“ 时 res(n) = res(n-2)，"00" ”30“~"90"时直接返回0 
                if (subStr.charAt(0) == '1' || subStr.charAt(0) == '2')
                    res.push(res.get(res.size() - 2));
                else return 0;
            } else {
                int val = Integer.parseInt(subStr); 
                if (10 < val && val <= 26) // 当 ”11“ ~ ”26“时 res(n) = res(n-1) + res(n-2)
                    res.push(res.get(res.size() - 2) + res.get(res.size() - 1));
                else res.push(res.get(res.size() - 1)); // 其他情况 res(n) = res(n-1)
            }
        }
        return res.peek();

    }
}
```
