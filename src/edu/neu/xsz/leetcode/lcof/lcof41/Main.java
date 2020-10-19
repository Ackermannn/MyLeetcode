package edu.neu.xsz.leetcode.lcof.lcof41;

public class Main {
    public static void main(String[] args) {
        MedianFinder2 mf = new MedianFinder2();
        mf.addNum(-1);
        System.out.println(mf.findMedian());
        mf.addNum(-2);
        System.out.println(mf.findMedian());
        mf.addNum(-3);
        System.out.println(mf.findMedian());

/*
输入：
["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
[[],[1],[2],[],[3],[]]
输出：[null,null,null,1.50000,null,2.00000]

* */

    }
}
