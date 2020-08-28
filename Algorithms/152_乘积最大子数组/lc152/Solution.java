package lc152;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

abstract class AbstractSolution {
    abstract public int maxProduct(int[] nums);
}

// 暴力法
class Solution extends AbstractSolution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = i; j < nums.length; j++) {
                prod *= nums[j];
                ans = Math.max(ans, prod);
            }
        }
        return ans;
    }
}

// 官方题解--动态规划
class SolutionDP extends AbstractSolution {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        ArrayList<Integer> dpMax = new ArrayList<>();
        ArrayList<Integer> dpMin = new ArrayList<>();
        dpMax.add(nums[0]);
        dpMin.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int a = nums[i];
            int b = dpMax.get(i - 1) * nums[i];
            int c = dpMin.get(i - 1) * nums[i];
            dpMax.add(Math.max(a, Math.max(b, c)));
            dpMin.add(Math.min(a, Math.min(b, c)));
        }

        return Collections.max(dpMax);

    }
}

class Main {
    public static void main(String[] args) {

//        int[] nums = new int[]{2, 3, -2, 4};
        int[] nums = new int[]{-2, 0, -1};
//        int[] nums = new int[]{};


        System.out.println("Which solution do you want?\n" +
                "input lc152.Solution get 暴力法, input lc152.SolutionDP get 动态规划");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        AbstractSolution abstractSolution = null;
        try {
            abstractSolution = (AbstractSolution) Class.forName(name).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("Error: 类名输入错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert abstractSolution != null;
        int res = abstractSolution.maxProduct(nums);
        System.out.println(res);
    }
}