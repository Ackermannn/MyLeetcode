# 剑指 Offer 45. 把数组排成最小的数

## QUESTION

https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/

## SOLUTION

使用API排序

### MY CODE

```java
public class Solution {
    public String minNumber(int[] nums) {
        ArrayList<String> arr = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int x : nums) arr.add(String.valueOf(x));

        arr.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        arr.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }
}
```