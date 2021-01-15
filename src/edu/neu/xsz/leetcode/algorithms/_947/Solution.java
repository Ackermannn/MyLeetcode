package edu.neu.xsz.leetcode.algorithms._947;

/**
 * create time: 2021/1/15 下午 3:21
 *
 * @author DownUpZ
 */
public class Solution {

    int[] flags;
    int[][] stones;

    private boolean isMoveable(int idx) {
        for (int i = 0; i < stones.length; i++) {
            if ((i != idx) && flags[i] == 0 && (stones[idx][0] == stones[i][0] || stones[idx][1] == stones[i][1])) {
                return true;
            }
        }
        return false;
    }

    public int removeStones(int[][] stones) {
        flags = new int[stones.length]; // 石子是否移除的标记， 1 表示移除
        this.stones = stones;
        return recur();
    }

    public int recur() {
        int ans = 0;
        for (int i = 0; i < flags.length; i++) {
            if (flags[i] == 0 && isMoveable(i)) {
                flags[i] = 1;
                ans = Math.max(ans, recur() + 1);
                flags[i] = 0;
            }
        }
        return ans;
    }

}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] stones = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 2},
                {2, 1},
                {2, 2}
        };
        int ret = sol.removeStones(stones);
        System.out.println(ret);
    }
}
