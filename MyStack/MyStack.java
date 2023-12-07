package MyStack;
import java.util.Arrays;

public class MyStack {
    public int[] elem;
    public int usedSize;
    public static final int DEFAULT_CAPACITY = 3;

    public MyStack() {
        this.elem = new int[DEFAULT_CAPACITY];
        this.usedSize = 0;
    }

    // 打印
    public void Display() {
        for (int i = this.usedSize-1;i >= 0;i--) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
    // 入栈/压栈
    public void push(int data) {
        // 检查是否扩容
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }
    // 出栈
    public int pop() {
        // 处理空栈情况
        if (isEmpty()) {
            throw new EmptyException("栈为空 删除数据失败");
        }
        int tmp = this.elem[this.usedSize-1];
        this.usedSize--;
        return tmp;
    }
    // 获取栈顶元素
    public int peek() {
        // 处理空栈情况
        if (isEmpty()) {
            throw new EmptyException("栈为空 获取数据失败");
        }
        return this.elem[this.usedSize-1];
    }
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

}
