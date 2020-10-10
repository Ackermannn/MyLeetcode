package lc200;

interface Solution {
    int numIslands(char[][] grid);
}

class Solution1 implements Solution {
    char[][] grid;
    int m;
    int n;

    /**
     * @param i 起始点的横坐标
     * @param j 起始点的纵坐标
     * @return 当前是否是岛屿
     */
    boolean dps(int i, int j) {
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            if (i != 0) dps(i - 1, j);
            if (i != m - 1) dps(i + 1, j);
            if (j != 0) dps(i, j - 1);
            if (j != n - 1) dps(i, j + 1);
            return true;
        } else return false;

    }

    @Override
    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length; // 行数
        if(m==0) return 0;
        n = grid[0].length; // 列数
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 调用深度优先搜索把相互链接的岛屿置为0
                if (dps(i, j)) {
                    res++;
                }


            }
        }
        return res;

    }
}

/*
测试入口
 */
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution1();
        char[][] grip1 =

                {
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}

                };

        char[][] grip2 =

                {
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                };
        var ret1 = solution.numIslands(grip1);
        System.out.println(ret1);
        var ret2 = solution.numIslands(grip2);
        System.out.println(ret2);
    }
}