package edu.neu.xsz.leetcode.algorithms._739_每日温度;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*数组位置索引和温度值放在一起*/
class Pair {
    int idx;
    int temp;

    public Pair(int idx, int temp) {
        this.idx = idx;
        this.temp = temp;
    }
}

public class Solution {
    // 栈法
    public int[] dailyTemperatures(int[] T) {
        Deque<Pair> deque = new ArrayDeque<>(); // 栈
        int[] ans = new int[T.length]; // 结果
        for (int i = 0; i < T.length; i++) {
            while (!deque.isEmpty() && deque.peek().temp < T[i]) {  // 当发现新来的值比栈顶的大pop出来，在ans中写上结果
                Pair pair = deque.pop();
                ans[pair.idx] = i - pair.idx;
            }
            deque.push(new Pair(i, T[i]));
        }
        return ans;
    }
}

class Solution1 {
    public int[] dailyTemperatures(int[] T) {

        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;

    }
}

class Main {
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73}; // [1, 1, 4, 2, 1, 1, 0, 0]
        Solution sol = new Solution();
        int[] ret = sol.dailyTemperatures(T);
        System.out.println("==================================");
        System.out.println("Answer: ");
        System.out.println(Arrays.toString(ret));

    }
}