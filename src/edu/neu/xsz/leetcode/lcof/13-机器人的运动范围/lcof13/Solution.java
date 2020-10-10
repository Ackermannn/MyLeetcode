public class Solution {
    private int[][] map;
    private int m;
    private int n;
    private int k;

    /**
     *  获得整数的数位和
     */
    int getIndexSum(int num) {
        int ans = 0;
        while (num != 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;

    }

    /***
     * 递归
     */
    void recuir(int i, int j) {
        int sum = getIndexSum(i) + getIndexSum(j);
        if (sum <= k && map[i][j] == 0) {
            map[i][j] = 1;
            if (i != 0) recuir(i - 1, j);
            if (j != 0) recuir(i, j - 1);
            if (i != m - 1) recuir(i + 1, j);
            if (j != n - 1) recuir(i, j + 1);
        }
    }

    public int movingCount(int m, int n, int k) {
        map = new int[m][n];
        this.m = m;
        this.n = n;
        this.k = k;

        recuir(0, 0);

        // count flags
        int sum = 0;
        for (int[] line : map) {
            for (int x : line) {
                sum += x;
            }
        }
        return sum;
    }


}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // answer is 3
//        int m = 2;
//        int n = 3;
//        int k = 1;

        // answer is 1
        int m = 3;
        int n = 1;
        int k = 0;

        int ret = solution.movingCount(n, m, k);
        System.out.println(ret);

    }

}