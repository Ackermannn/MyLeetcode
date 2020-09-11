package lc174;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution1();

        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}};
        int[][] dungeon2 = {{100}};
        int[][] dungeon3 = {{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}};

        int ans = solution.calculateMinimumHP(dungeon);
        System.out.println(ans);
        ans = solution.calculateMinimumHP(dungeon2);
        System.out.println(ans);
        ans = solution.calculateMinimumHP(dungeon3);
        System.out.println(ans);

    }
}
