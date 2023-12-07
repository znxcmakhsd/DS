package QueueOJ;

// 两个栈实现队列

import java.util.Stack;

class MyQueue {
    public Stack<Integer> pushStack;
    public Stack<Integer> popStack;

    public MyQueue() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    public void push(int x) {
        this.pushStack.push(x);
    }

    public int pop() {
        if (this.empty())
            return -1;

        if (this.popStack.isEmpty()) {
            while (!this.pushStack.isEmpty()) {
                this.popStack.push(pushStack.pop());
            }
        }
        return this.popStack.pop();
    }

    public int peek() {
        if (this.empty())
            return -1;

        if (this.popStack.isEmpty()) {
            while (!this.pushStack.isEmpty()) {
                this.popStack.push(pushStack.pop());
            }
        }
        return this.popStack.peek();
    }

    public boolean empty() {
        return this.pushStack.isEmpty() && this.popStack.isEmpty();
    }
}



