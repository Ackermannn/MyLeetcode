package lc174;

class Solution1 implements Solution {

    @Override
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (i == m - 1 && j == n - 1) {
                    // 公主的地方
                    dp[i][j] = Math.max(1 - dungeon[i][j], 1);
                } else if (i == m - 1) {
                    // 在倒数第一行的时候
                    dp[i][j] = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                } else if (j == n - 1) {
                    // 在倒数第一列的时候
                    dp[i][j] = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                } else {
                    dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);

                }


            }
        }
        return dp[0][0];

    }
}
