package sort_algorithm;


import sort_algorithm.heap_sort.HeapSort;

public class Main {
    public static void main(String[] args) {

        Sort s = new HeapSort();

        int[] nums = {9};
//        int[] nums = {90, 10, 50, 80, 30, 70, 40, 60, 20};

        System.out.println("排序前：");
        s.printNums(nums);

        s.sort(nums);

        System.out.println("排序结果：");
        s.printNums(nums);


    }
}
