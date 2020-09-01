package sort_algorithm;


import sort_algorithm.simple_selection_sort.SelectSort;
import sort_algorithm.straight_insert_sort.InsertSort;

public class Main {
    public static void main(String[] args) {

        Sort s = new InsertSort();

//        int[] nums = {9, 1, 5, 8, 3, 7, 4, 6, 2};
        int[] nums = {9};
        s.sort(nums);
        for (int x : nums) {
            System.out.printf("%d ", x);
        }


    }
}
