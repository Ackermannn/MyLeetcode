package lc166;

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution1();
        int[][] test = new int[][]{
                {1, 9},
                {1, 26},
                {1, 6},
                {2, 1},
                {2, 3},
                {-50, 8},
                {7, -12},
                {1, 214748364},
                {1, Integer.MIN_VALUE},
                {0, 2}
        };
        for (int[] x : test) {
            var ret = sol.fractionToDecimal(x[0], x[1]);
            System.out.println(ret + "\n");
        }

    }
}