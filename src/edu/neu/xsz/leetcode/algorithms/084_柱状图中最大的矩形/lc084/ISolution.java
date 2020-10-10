package lc084;

/*
 题目地址：

 https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
* */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

interface ISolution {
    int largestRectangleArea(int[] heights);
}

/**
 * 1283ms 5.07% 通过了但是速度很慢
 */
class Solution1 implements ISolution {
    @Override
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int left;
        int right;

        for (int i = 0; i < heights.length; i++) {
            left = i;
            right = i;
            while (left != 0 && heights[left - 1] >= heights[i]) left--;
            while (right != heights.length - 1 && heights[right + 1] >= heights[i]) right++;
            ans = Math.max(ans, heights[i] * (right - left + 1));
        }
        return ans;
    }
}


/**
 * 参考一下@wenere 的思路
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/comments/73308
 */
class Solution2 implements ISolution {
    @Override
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, -1});

        // 最后加一块高度为0的木板
        int[] newHeights = Arrays.copyOf(heights, heights.length+1);

        for (int i = 0; i < newHeights.length; i++) {


            if (newHeights[i] > stack.peek()[0]) {

                // 发现更高的木板，很高兴装进 stack 里面
                stack.push(new int[]{newHeights[i], i});

            } else if (newHeights[i] == stack.peek()[0]) {

                // 发现短的了 就得锯掉 反正后面用不到了
                int[] poped = stack.peek();
                while (newHeights[i] < stack.peek()[0]) {
                    poped = stack.pop();
                    ans = Math.max(ans, poped[0] * (i - poped[1])); // 计算面积
                }
                stack.push(new int[]{newHeights[i], poped[1]}); // 凡是比该点高的都被锯下来了，设定和当前一样的高度。

            }


        }
        return ans;
    }
}