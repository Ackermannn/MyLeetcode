package lc032;

public class Main {
    public static void main(String[] args) {
        ISolution iSolution = new Solution();
        String[] s = {")()()(",
                      ")()())",
                      "(()"};

        for (String x:s) {
            int ans = iSolution.longestValidParentheses(x);
            System.out.println(ans);
        }
    }
}
