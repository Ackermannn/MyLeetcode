package sort_algorithm;


import sort_algorithm.heap_sort.HeapSort;
import sort_algorithm.quick_sort.QuickSort;

public class Main {
    public static void main(String[] args) {

        // 修改new后面的类名即可更换算法
        Sort s = new QuickSort();

        // 测试例
        int[][] testNums = {
                {9},
                {101, 100},
                {1, 1, 1},
                {90, 10, 50, 80, 30, 70, 40, 60, 20}
        };

        for(var nums:testNums) {
            System.out.println("排序前：");
            s.printNums(nums);

            s.sort(nums);

            System.out.println("排序结果：");
            s.printNums(nums);

        }
    }
}
