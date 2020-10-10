using System;

namespace LeetcodeCSharp
{
    public class Solution
    {
        public int RangeBitwiseAnd(int m, int n)
        {
            // 超出时间限制
            //int ret = m;
            //for (int i = m + 1; i <= n; i++) ret = ret & i;
            //return ret;
            int shift = 0;
            while (m != n) {
                m = m >> 1;
                n = n >> 1;
                shift++;
            }
            return m << shift;
           
        }

        public static void Main(string[] args)
        {
            int ret = new Solution().RangeBitwiseAnd(5, 7);
            Console.WriteLine(ret);
        }
    }
}
