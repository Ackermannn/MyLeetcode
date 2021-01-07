package edu.neu.xsz.leetcode.algorithms._547;

/**
 * Solution
 * author: DownUpZ
 * create: 2021/1/7 上午 10:56
 */
public class Solution {
    public int pullNet(int[][] isConnected, int province) {
        // 拔出网线
        if (isConnected[province][province] == 1) {
            isConnected[province][province] = 0;
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[province][i] == 1) pullNet(isConnected, i);
            }
            return 1;
        } else
            return 0;
    }

    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        for (int i = 0; i < isConnected.length; i++) ans += pullNet(isConnected, i);
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ret = sol.findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        });
        System.out.println(ret);

    }
}