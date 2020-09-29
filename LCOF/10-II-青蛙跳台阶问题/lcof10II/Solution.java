package lcof10II;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题地址
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class Solution {
    public int numWays(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (n == 0) return 1;
        else if (n == 1) return 1;
        else {
            arr.add(1);
            arr.add(1); // n = 1
            for (int i = 2; i <= n; i++) {
                arr.add((arr.get(i - 1) + arr.get(i - 2)) % 1000000007) ;
            }

            return arr.get(arr.size()-1) ;
        }


    }
}
