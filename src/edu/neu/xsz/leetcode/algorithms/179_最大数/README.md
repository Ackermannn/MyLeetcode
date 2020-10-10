# Question

给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

示例 1:

    输入: [10,2]
    输出: 210
示例2:

    输入: [3,30,34,5,9]
    输出: 9534330
    说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/largest-number

# Solution

官方题解：

https://leetcode-cn.com/problems/largest-number/solution/zui-da-shu-by-leetcode/

```java
class StringCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String order1 = o1 + o2;
        String order2 = o2 + o1;
        return order2.compareTo(order1);
    }
}
class Solution {
    public String largestNumber(int[] nums) {
        String[] arrStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arrStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arrStr, new StringCompare());

        StringBuilder ans = new StringBuilder();
        for (String s : arrStr) {
            ans.append(s);
        }
        if (ans.toString().charAt(0) == '0') return "0";
        return ans.toString();
    }
}
```