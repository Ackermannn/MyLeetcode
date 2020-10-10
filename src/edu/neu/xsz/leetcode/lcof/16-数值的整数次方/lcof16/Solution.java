public class Solution {
    public double myPow(double x, int n){
        return myPow(x, (long)n);
    }

    /**
     * n使用long类型 应对 n为 Integer.MAX_VALUE Integer.MIN_VALUE的边界条件
     */
    public double myPow(double x, long n) {
        if (n == 0) return 1;
        else if (n < 0) return 1.0 / myPow(x, -1 * n);
        else {
            double ans = x;
            long bit = 1;

            while (bit * 2 < n) {
                ans *= ans;
                bit *= 2;
            }
            return ans * myPow(x, n - bit);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        double[] xs = {2.00000, 2.10000, 2.00000, 2.0};
        int[] ns = {10, 3, -2, Integer.MIN_VALUE};

        for (int i = 0; i < xs.length; i++) {
            double x = xs[i];
            int n = ns[i];
            double ret = solution.myPow(x, n);
            System.out.println(ret);
        }

    }
}
