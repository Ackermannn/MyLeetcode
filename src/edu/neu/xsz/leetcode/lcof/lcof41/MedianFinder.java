package edu.neu.xsz.leetcode.lcof.lcof41;

/**
 * 插入排序法
 */
public class MedianFinder {
    int[] arr;
    int end;

    public MedianFinder() {
        arr = new int[50000];
        end = 0;
    }

    public void addNum(int num) {


        for (int i = end; i >= 0; i--) {
            if (i == 0 || num >= arr[i - 1]) {
                arr[i] = num;
                break;
            } else {
                arr[i] = arr[i - 1];
            }
        }
        ++end;
    }

    public double findMedian() {
        if (end % 2 == 1) { // 奇数
            return arr[end / 2];
        } else { // 偶数
            return 0.5 * (arr[end / 2 - 1] + arr[end / 2]);
        }
    }
}
