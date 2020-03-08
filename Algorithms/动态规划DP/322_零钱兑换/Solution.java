package LC322CoinChange;
/*
题目:
https://leetcode-cn.com/problems/coin-change/
题解:
https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-tao-lu-xiang-jie-by-wei-lai-bu-ke/
此题解值得收藏
*/
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int size = coins.length;
        int[] dpTable = new int[amount + 1];
        // 填写动态规划表
        for (int target = 1; target < amount + 1; target++) {

            // 遍历硬币的可能
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (target - coin < 0) continue;
                int temp = dpTable[target - coin] + 1;
                if (temp != 0) min = Math.min(temp, min);
            }
            if (min != Integer.MAX_VALUE) dpTable[target] = min;
            else dpTable[target] = -1;
        }
        return dpTable[amount];
    }


}
