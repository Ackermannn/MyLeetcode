package LC322CoinChange;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] coins = {1,2};
        int amount = 36;
        System.out.println(s.coinChange(coins,amount));
    }
}
