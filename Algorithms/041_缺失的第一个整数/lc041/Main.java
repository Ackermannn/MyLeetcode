package lc041;

class Main {
    public static void main(String[] args) {
        ISolution iSolution = new Solution2();
//        int[] nums = {1, 2, 0};
        int[][] testNums = {
                {1, 2, 0}, // 3
                {3, 4, -1, 1}, // 2
                {7, 8, 9, 11, 12}, // 1
                {0, 2, 2, 1, 1}}; // 3

        int ans = 0;
        for (int[] nums : testNums) {
            ans = iSolution.firstMissingPositive(nums);
            System.out.println(ans);
        }

    }
}
