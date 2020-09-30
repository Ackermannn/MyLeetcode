# 问题

地址:

https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/

#  解答

大佬的解答：

https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/comments/240095

```java
class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }
}
```