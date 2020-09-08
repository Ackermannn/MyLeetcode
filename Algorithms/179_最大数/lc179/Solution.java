package lc179;

import java.util.Arrays;
import java.util.Comparator;

interface Solution {
    String largestNumber(int[] nums);
}


class Solution1 implements Solution {
    static class StringCompare implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String order1 = o1 + o2;
            String order2 = o2 + o1;
            return order2.compareTo(order1);
        }
    }

    @Override
    public String largestNumber(int[] nums) {
        String[] arrStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arrStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arrStr, new StringCompare());

        StringBuilder ans = new StringBuilder();
        for (String s : arrStr) {
            ans.append(s);
        }
        if (ans.toString().charAt(0) == '0') return "0";
        return ans.toString();
    }

}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution1();

        int[] nums = {3, 30, 34, 5, 9};

        String ans = solution.largestNumber(nums);

        System.out.println(ans);

    }
}
