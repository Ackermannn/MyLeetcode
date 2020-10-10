# Question

请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：

> 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
>
>假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
>
>该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0 。

提示：

>	本题中的空白字符只包括空格字符 ' ' 。
>
>	假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 

示例 1:

		输入: "42"
		输出: 42
示例 2:

		输入: "   -42"
		输出: -42
		解释: 第一个非空白字符为 '-', 它是一个负号。
		     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
示例 3:

		输入: "4193 with words"
		输出: 4193
		解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
示例 4:

		输入: "words and 987"
		输出: 0
		解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
			 因此无法执行有效的转换。
示例 5:

		输入: "-91283472332"
		输出: -2147483648
		解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
		     因此返回 INT_MIN (−231) 。


来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/string-to-integer-atoi

# Code

用strm去除前面的空格

再用Long.parseLong 字符串转Long

用if else 排除边界情况

另外官方题解提供了[确定有限状态机(deterministic finite automaton, DFA)的方法](https://leetcode-cn.com/problems/string-to-integer-atoi/solution/zi-fu-chuan-zhuan-huan-zheng-shu-atoi-by-leetcode-/)。
还有正则表达式的方法


```java
public class Solution {
    public int myAtoi(String str) {
        int res = 0;
        long ans = 0;
        int sign = 1;
        str = str.trim(); // 去掉前面的空格

        if ("+".equals(str)) return 0; // 去掉"+"的情况
        if ("-".equals(str)) return 0; // 去除"-"的情况
        if (str.length() == 0) return 0; // 去除 ""
        char firstChar = str.charAt(0);  // 首字符
        if (firstChar != '+' && firstChar != '-' && !Character.isDigit(firstChar)) return 0; // 去除首字符 不是 + - 数字

        // 找到数字部分的结束
        int end_p = 1;
        for (; end_p < str.length(); end_p++) {
            if (!Character.isDigit(str.charAt(end_p)))
                break;
        }
        // 找到数字部分的开始，应对 "00001" 这种情况
        int start_p = 0;
        if (!Character.isDigit(firstChar)) start_p++;
        for (; start_p < end_p; start_p++) {
            if (str.charAt(start_p) != '0')
                break;
        }

        str = str.substring(start_p, end_p); // 只剩下数字位的str

        if (str.length()==0) return 0; // 应对 "000" 的情况

        // 位数太长的情况
        if (str.length() > 10) {
            if (firstChar == '-')
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }

        ans = Long.parseLong(str);
        if (firstChar == '-') {
            res = (int) Math.max(-1 * ans, Integer.MIN_VALUE);

        }else
            res = (int) Math.min(ans, Integer.MAX_VALUE);
        return res;
    }

    // test
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "++1";
        int res = s.myAtoi(str);
        System.out.println(res);
    }
}

```