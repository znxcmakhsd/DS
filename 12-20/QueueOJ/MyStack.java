package QueueOJ;

import java.util.LinkedList;
import java.util.Queue;

// 队列实现栈
class MyStack {
    public Queue<Integer> queueA;
    public Queue<Integer> queueB;

    public MyStack() {
        queueA = new LinkedList<>();
        queueB = new LinkedList<>();
    }

    public void push(int x) {
        // 如果两个队列都为空入QueueA
        if (empty()) {
            queueA.offer(x);
            return;
        }
        // 入不为空的队列
        if (!queueA.isEmpty()) {
            queueA.offer(x);
        }else {
            queueB.offer(x);
        }
    }

    public int pop() {
        int tmp = -1;
        if (!queueA.isEmpty()) {
            int n = queueA.size();
            for (int i = 0;i < n - 1;i++) {
                queueB.offer(queueA.poll());
            }
            tmp = queueA.poll();
        }else {
            int n = queueB.size();
            for (int i = 0;i < n - 1;i++) {
                queueA.offer(queueB.poll());
            }
            tmp = queueB.poll();

        }
        return tmp;
    }

    public int top() {
        int tmp = -1;
        if (!queueA.isEmpty()) {
            int n = queueA.size();
            for (int i = 0;i < n;i++) {
                tmp = queueA.poll();
                queueB.offer(tmp);
            }
        }else {
            int n = queueB.size();
            for (int i = 0;i < n;i++) {
                tmp = queueB.poll();
                queueA.offer(tmp);
            }
        }
        return tmp;
    }

    public boolean empty() {
        return queueA.isEmpty() && queueB.isEmpty();
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
