package QueueOJ;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> pushst;
    private Stack<Integer> popst;

    public MyQueue() {
        pushst = new Stack<>();
        popst = new Stack<>();
    }

    public void push(int x) {
        pushst.push(x);
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        if (popst.isEmpty()) {
            while (!pushst.isEmpty()) {
                popst.push(pushst.pop());
            }
        }
        return popst.pop();
    }

    public int peek() {
        if (empty()) {
            return -1;
        }
        if (popst.isEmpty()) {
            while (!pushst.isEmpty()) {
                popst.push(pushst.pop());
            }
        }
        return popst.peek();
    }

    public boolean empty() {
        return pushst.isEmpty() && popst.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
