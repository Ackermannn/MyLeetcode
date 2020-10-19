# 剑指 Offer 41. 数据流中的中位数

## Question

https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/

## Solution

### 排序插入法

```java

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

```

### 双堆法

https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/mian-shi-ti-41-shu-ju-liu-zhong-de-zhong-wei-shu-y/

#### My Code

```java


/**
 * 双堆栈
 */
public class MedianFinder {

    PriorityQueue<Integer> smallHalf;
    PriorityQueue<Integer> bigHalf;

    public MedianFinder() {
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
```
