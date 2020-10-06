package lc85;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, -1});

        int[] newHeights = Arrays.copyOf(heights, heights.length + 1);

        for (int i = 0; i < newHeights.length; i++) {
            if (newHeights[i] > stack.peek()[0]) { // 发现更高的木板，很高兴装进 stack 里面
                stack.push(new int[]{newHeights[i], i});
            } else if (newHeights[i] == stack.peek()[0]) {
                continue;
            } else {// 发现短的了 就得锯掉 反正后面用不到了
                int[] poped = stack.peek();
                while (newHeights[i] < stack.peek()[0]) {
                    poped = stack.pop();
                    ans = Math.max(ans, poped[0] * (i - poped[1])); // 计算面积
                }
                stack.push(new int[]{newHeights[i], poped[1]});
            }
        }

        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int[] height = new int[matrix[0].length];
        for (char[] chars : matrix) {
            // 更新height
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '1') height[j] += 1;
                else height[j] = 0;
            }

            int tmp = largestRectangleArea(height);
            ans = Math.max(tmp, ans);

        }
        return ans;

    }
}

class Main {
    public static void main(String []args){
        Solution solution = new Solution();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
//        char[][] matrix = {
//                {'1'},
//                {'0'}
//        };
        int ret = solution.maximalRectangle(matrix);
        System.out.println(ret);
    }

}
