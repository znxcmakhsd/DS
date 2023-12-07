package QueueOJ;



class MyCircularQueue {

    public int[] array;
    public int front;
    public int rear;

    public MyCircularQueue(int k) {
        this.array = new int[k+1];
    }

    // 入队
    public boolean enQueue(int value) {
        // 1. 这道题 不考虑扩容
        // 2. 满了 不能入队
        if (isFull()) {
            return false;
        }
        this.array[rear] = value;
        rear = (rear + 1) % this.array.length;
        return true;
    }

    // 出队
    public boolean deQueue() {
        // 1. 为空 不能出队
        if (isEmpty()) {
            return false;
        }
        this.front = (front + 1) % this.array.length;
        return true;
    }

    // 从队首获取元素
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.array[front];
    }

    // 从队尾获取元素
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int index = (0 == this.rear) ? this.array.length : this.rear - 1;
        return this.array[index];
    }

    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public boolean isFull() {
        return (this.rear + 1) % this.array.length == this.front;
    }
}
