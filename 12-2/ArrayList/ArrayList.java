package ArrayList;

import java.util.Arrays;

public class ArrayList implements IList{
    private int[] array;
    private int usedSize;
    private static final int DEFAULT_CAPACITY = 3;

    public ArrayList() {
        this.array = new int[DEFAULT_CAPACITY];
        this.usedSize = 0;
    }

    // 显示顺序表
    @Override
    public void display() {
        for (int i = 0;i < this.usedSize;i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }

    private void isFull() {
        if (this.usedSize == this.array.length) {
            this.array = Arrays.copyOf(this.array,this.array.length*2);
        }
    }

    // 尾插
    @Override
    public void add(int data) {
        // 判断是否需要扩容
        this.isFull();

        this.array[this.usedSize] = data;
        this.usedSize++;
    }

    // pos位置插入数据
    @Override
    public void add(int pos, int data) {
        // 判断是否需要扩容
        this.isFull();
        // 判断pos是否合法
        if (pos < 0 || pos > this.usedSize) {
            throw new PosException(pos + " : 非法的pos坐标 重新输入");
        }

        for (int i = this.usedSize-1;i >= pos;i--) {
            this.array[i+1] = this.array[i];
        }
        this.array[pos] = data;
        this.usedSize++;
    }

    @Override
    public boolean contains(int toFind) {
        for (int i = 0;i < this.usedSize;i++) {
            if (this.array[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int toFind) {
        for (int i = 0;i < this.usedSize;i++) {
            if (this.array[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    private boolean isEmpty() {
        return this.usedSize == 0;
    }
    @Override
    public int get(int pos) {
        // 1. 数组没有元素不可获取
        if (this.isEmpty()) {
            throw new ArrEmptyException("数组为空 不可获取");
        }
        // 2. pos非法不可获取
        if (pos < 0 || pos > this.usedSize-1) {
            throw new PosException(pos + ": 输入的pos坐标非法 重写输入");
        }
        return this.array[pos];

    }

    @Override
    public void set(int pos, int value) {
        //  pos非法 不可设置元素
        if (pos < 0 || pos > this.usedSize) {
            throw new PosException(pos + ": 输入的pos坐标非法 重写输入");
        }
        this.array[pos] = value;
    }

    @Override
    public void remove(int toRemove) {
        // 1. 判断: 数组为空 不能再删
        if (isEmpty()) {
            throw new ArrEmptyException("数组为空 不可删除");
        }

        // 2. 找下标
        int index = -1;
        for (int i = 0;i < this.usedSize;i++) {
            if (this.array[i] == toRemove) {
                index = i;
            }
        }


        if (-1 == index) {
            System.out.println("没有你要删除的数据");
            return;
        }else {
            // 移动覆盖
            for (int i = index;i < this.usedSize-1;i++) {
                this.array[i] = this.array[i+1];
            }
            this.usedSize--;
        }
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void clear() {
        this.usedSize = 0;
    }
}
