package MyStack;

import java.util.Arrays;

public class MyStack {
    private int[] elem;
    private int usedSize;

    public MyStack() {
        this.elem = new int[5];
        this.usedSize = 0;
    }

    // 压栈 / 入栈
    public void push(int data) {
        if (elem.length == usedSize) {
            this.elem = Arrays.copyOf(this.elem,elem.length*2);
        }
        this.elem[usedSize] = data;
        this.usedSize++;
    }

    // 出栈
    public int pop() {
        if (empty()) {
            throw new EmptyException("栈为空 不能出栈");
        }
        int tmp = this.elem[usedSize-1];
        this.usedSize--;
        return tmp;
    }

    // 获取栈顶元素
    public int peek() {
        if (empty()) {
            throw new EmptyException("栈为空 不能获取栈顶元素");
        }
        return this.elem[usedSize-1];
    }

    // 获取栈中有效元素个数
    public int size() {
        return this.usedSize;
    }

    // 检测栈是否为空
    public boolean empty() {
        return this.usedSize == 0;
    }
}
