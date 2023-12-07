
package QueueOJ;

import java.util.LinkedList;
import java.util.Queue;


// 两个队列 实现栈
class MyStack {

    public Queue<Integer> queueA;
    public Queue<Integer> queueB;

    public MyStack() {
        this.queueA = new LinkedList<>();
        this.queueB = new LinkedList<>();
    }

    public void push(int x) {
        // 1. 如果A B队列都没有数据 入A队列
        if (this.queueA.isEmpty() && this.queueB.isEmpty()) {
            this.queueA.offer(x);
            return;
        }
        // 2. 否则 入有数据的队列
        if (!queueA.isEmpty()) {
            this.queueA.offer(x);
        }else {
            this.queueB.offer(x);
        }
    }

    public int pop() {
        // 1. 找到不为空的队列
        // 假设队列A 不为空  队列B 为空
        Queue<Integer> elemInQueue = this.queueA;
        Queue<Integer> elemOutQueue = this.queueB;
        if (elemInQueue.isEmpty()) {
            elemInQueue = this.queueB;
            elemOutQueue = this.queueA;
        }
        int count = elemInQueue.size() - 1;
        while (count != 0) {
            int date = elemInQueue.poll();
            elemOutQueue.offer(date);
            count--;
        }
        int ret = elemInQueue.poll();
        return ret;
    }

    public int top() {
        Queue<Integer> elemInQueue = this.queueA;
        Queue<Integer> elemOutQueue = this.queueB;
        if (elemInQueue.isEmpty()) {
            elemInQueue = this.queueB;
            elemOutQueue = this.queueA;
        }
        int count = elemInQueue.size() - 1;
        while (count != 0) {
            int date = elemInQueue.poll();
            elemOutQueue.offer(date);
            count--;
        }
        int tmp = elemInQueue.peek();
        elemOutQueue.offer(elemInQueue.poll());
        return tmp;
    }

    public boolean empty() {
        return this.queueA.isEmpty() && this.queueB.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */