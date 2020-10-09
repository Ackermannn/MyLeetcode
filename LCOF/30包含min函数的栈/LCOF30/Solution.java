package LCOF30;


class ListNode {
    int val;
    int min;
    ListNode next;

    ListNode(int val, int min, ListNode next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}

class MinStack {
    ListNode stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = null;
    }

    public void push(int x) {
        if (stack == null)
            stack = new ListNode(x, x, null);
        else
            stack = new ListNode(x, Math.min(x, stack.min), stack);
    }

    public void pop() {
        stack = stack.next;
    }

    public int top() {
        return stack.val;
    }

    public int min() {
        return stack.min;
    }
}

// local test
class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("min: " + minStack.min());
        minStack.pop();
        System.out.println("top: " + minStack.top());
        System.out.println("min: " + minStack.min());
    }

}
