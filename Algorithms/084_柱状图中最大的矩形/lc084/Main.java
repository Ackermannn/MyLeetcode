package lc084;

public class Main {
    public static void main(String[] args) {
        ISolution solution = new Solution2();
        int[] heights = {2, 1, 5, 6, 2, 3};
        int ret = solution.largestRectangleArea(heights);
        System.out.println(ret);
    }
}
