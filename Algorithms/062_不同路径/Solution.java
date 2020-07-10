
/**
 * 题目地址
 *  https://leetcode-cn.com/problems/unique-paths/
 */

public class Solution {
    public int uniquePaths(int m, int n) {
        int[] line = new int[n];
        line[0] = 1;
        if (m == 1) return 1;
        for (int j = 0; j < m; j++)
            for (int i = 0; i < n; i++)
                if (i != 0) line[i] = line[i] + line[i - 1];
        return line[n - 1];
    }
}
