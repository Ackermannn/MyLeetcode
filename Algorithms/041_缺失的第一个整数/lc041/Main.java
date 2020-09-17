package lc041;

public class Main {
    public static void main(String[] args) {
        ISolution iSolution = new Solution();
//        int[] nums = {1, 2, 0};
        int[][] testNums = {
                {1, 2, 0},
                {3, 4, -1, 1},
                {7, 8, 9, 11, 12},
                {0, 2, 2, 1, 1}};

        int ans = 0;
        for (int[] nums : testNums) {
            ans = iSolution.firstMissingPositive(nums);
            System.out.println(ans);
        }

    }
}
