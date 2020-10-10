# question

https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/

# solution

https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/solution/shu-zi-fan-wei-an-wei-yu-by-leetcode-solution/

## C# code

```c#
public class Solution {
    public int RangeBitwiseAnd(int m, int n) {
            int shift = 0;
            while (m != n) {
                m = m >> 1;
                n = n >> 1;
                shift++;
            }
            return m << shift;
          
    }
}

```
