import java.util.ArrayList;
import java.util.List;

/*
问题：
https://leetcode-cn.com/problems/permutation-sequence/

解答：
https://leetcode-cn.com/problems/permutation-sequence/solution/di-k-ge-pai-lie-by-leetcode/

*/
public class Solution {
    public String getPermutation(int n, int k) {

        // 阶乘数系统
        int[] factorials = {1, 2, 6, 24, 120, 720, 5040, 40320, 362880}; // 1! ~ 9!
        List<Integer> factorialsNums = new ArrayList<>(); // 存放计算好的阶乘数系数
        k = k - 1; // 从0开始 而不是1

        // 对k 从 factorials 一个个除，算出 阶乘数
        for (int i = n - 2; i >= 0; i--) {
            int temp = k / factorials[i];
            factorialsNums.add(temp);
            k -= temp * factorials[i];
        }
        factorialsNums.add(0);

        // 建立 nums
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            nums.add(i);

        String output = "";
        for (int x:factorialsNums){
            output = output.concat(String.valueOf(nums.get(x)));
            nums.remove(x);
        }

        return output.toString();

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 9;
        int k = 89;
        String str = s.getPermutation(n, k);

        System.out.println(str);
    }
}
