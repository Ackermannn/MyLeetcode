package lc166;

import java.util.HashMap;
import java.util.Map;

class Solution1 implements Solution {
    /**
     * 把数折腾成正数
     */
    @Override
    public String fractionToDecimal(int numerator, int denominator) {
        long a = Math.abs((long) numerator);
        long b = Math.abs((long) denominator);

        if ((long) numerator * (long) denominator < 0) {
            return "-" + fractionToDecimal(a, b);
        } else
            return fractionToDecimal(a, b);
    }

    /**
     * 当 numerator  denominator 都为 long 型 整数
     */
    public String fractionToDecimal(long numerator, long denominator) {

        long remainder; // 余数
        StringBuilder ans = new StringBuilder();

        // 整数部分
        ans.append(numerator/denominator);
        remainder = numerator % denominator;
        if (remainder == 0L) return ans.toString();

        ans.append('.');
        Map<Long, Integer> map = new HashMap<>(); // 余数作为键值，value为坐标
        // 小数部分
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                ans.insert(map.get(remainder), "(");
                ans.append(")");
                break;
            }
            map.put(remainder, ans.length());
            remainder *= 10;
            ans.append(remainder/denominator);
            remainder %= denominator;
        }
        return ans.toString();
    }
}
