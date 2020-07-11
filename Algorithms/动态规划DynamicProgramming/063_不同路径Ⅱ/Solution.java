package lc063_不同路径;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;

        int m = obstacleGrid.length; // 行数
        int n = obstacleGrid[0].length; // 列数

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j]==1){
                    obstacleGrid[i][j] = 0;
                }else if(i==0 && j==0) {
                    obstacleGrid[i][j] = 1;
                }else if(i==0){
                    obstacleGrid[i][j] = obstacleGrid[i][j-1];
                }else if(j==0){
                    obstacleGrid[i][j] = obstacleGrid[i-1][j];
                }else
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }


        return obstacleGrid[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] obstacleGrid = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        int result = s.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(result);
    }
}
