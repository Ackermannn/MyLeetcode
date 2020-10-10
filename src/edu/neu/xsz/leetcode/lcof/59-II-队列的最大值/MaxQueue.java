class MaxQueue {
    private int MAX = 10000;
    private int[] queue;
    private int front;
    private int back;

    public MaxQueue() {
        this.queue = new int[MAX];
        this.front = 0;
        this.back = 1;
    }

    public int max_value() {
        if (back - front != 1) {
            int max = queue[front];
            for (int i = front; i < back; i++) {
                if (queue[i] > max) {
                    max = queue[i];
                }
            }
            return max;
        } else
            return -1;
    }

    public void push_back(int value) {
        if (back < MAX) {
            queue[back - 1] = value;
            ++back;
        } else
            System.out.println("容量不足");
    }

    public int pop_front() {
        if (back - front != 1) {
            ++front;
            return queue[front - 1];
        } else
            return -1;

    }
}