/*
题目地址
https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 使用两个int[] 分别当 deque 与 queue
*/
class MaxQueue {
    private int MAX = 10000;
    private int[] deque;
    private int[] queue;
    private int front;
    private int back;
    private int de_back;
    private int de_front;

    public MaxQueue() {
        queue = new int[MAX];
        deque = new int[MAX];
        front = 0;
        back = 1;
        de_back = 1;
        de_front = 0;
    }

    public int max_value() {
        if (back - front != 1)
            return deque[de_front];
        else
            return -1;
    }

    public void push_back(int value) {
        while (de_back > de_front && deque[de_back - 1] < value) {
            --de_back;
        }
        deque[de_back] = value;
        ++de_back;
        queue[back - 1] = value;
        ++back;
    }

    public int pop_front() {
        if (back - front != 1) {
            int temp = queue[front];
            ++front;
            if(temp == deque[de_front]) de_front++;
            return temp;
        } else
            return -1;
    }
}