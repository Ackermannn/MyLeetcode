package lc121;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minValue = prices[0];
        int ret = 0; // 最大利润
        for (int price : prices) {
            minValue = Math.min(minValue, price);
            ret = Math.max(price - minValue, ret);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(new Solution().maxProfit(prices));
    }
}