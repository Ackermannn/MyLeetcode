package edu.neu.xsz.leetcode.lcof.lcof41;

import java.util.PriorityQueue;

/**
 * 双堆栈
 */
public class MedianFinder2 {

    PriorityQueue<Integer> smallHalf;
    PriorityQueue<Integer> bigHalf;

    public MedianFinder2() {
        smallHalf = new PriorityQueue<>((o1, o2) -> o2 - o1); // 大堆顶
        bigHalf = new PriorityQueue<>(); // 小堆顶
    }

    public void addNum(int num) {
        if (smallHalf.size() != bigHalf.size()) {
            smallHalf.offer(num);
            bigHalf.offer(smallHalf.poll());

        } else {
            bigHalf.offer(num);
            smallHalf.offer(bigHalf.poll());
        }
    }

    public double findMedian() {
        return smallHalf.size() == bigHalf.size() ? 0.5 * (smallHalf.peek() + bigHalf.peek()) : smallHalf.peek();
    }

}
