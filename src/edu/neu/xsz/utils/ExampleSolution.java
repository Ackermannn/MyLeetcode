package edu.neu.xsz.utils;

// 测试模板
class ExampleSolution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int lowest = prices[0];
        int max = 0;
        for (int i : prices) {
            max = Math.max(max, i - lowest);
            lowest = Math.min(lowest, i);

        }
        return max;
    }
}
