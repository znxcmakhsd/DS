package demo1;

import java.util.Arrays;

public class MyArrayList implements IList{
    public int[] elem;
    public int usedSize;

    public static final int DEFAULT_CAPACITY = 5;

    public MyArrayList() {
        this.elem = new int[DEFAULT_CAPACITY];
    }

    // 打印所有元素
    @Override
    public void display() {
        for (int i = 0;i < this.usedSize;i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    // 尾插
    @Override
    public void add(int data) {
        // 1. 判断是否需要扩容
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length * 2);
        }
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }
    private boolean isFull() {
        if (this.usedSize == this.elem.length) {
            return true;
        }else {
            return false;
        }
    }

    // pos位置插入数据
    @Override
    public void add(int pos, int data) {
        // 1. 判断 pos
        if (pos < 0 || pos > this.usedSize) {
            throw new PosException(pos + " 是一个不合法的pos位置 重新输入");
        }
        // 2. 判断是否需要扩容
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }

        for (int i = this.usedSize-1;i >= pos;i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    // 查找当前元素 是否存在
    @Override
    public boolean contains(int toFind) {
       for (int i = 0;i < this.usedSize;i++) {
           if (this.elem[i] == toFind) {
               return true;
           }
       }
       return false;
    }

    // 查找当前元素的下标
    @Override
    public int indexOf(int toFind) {
        for (int i = 0;i < this.usedSize;i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    @Override
    public int get(int pos) {
        // 判断 pos位置 是否合法
        if (pos < 0 || pos >= this.usedSize) {
            throw new PosException(pos + " 是一个不合法的pos位置 重新输入");
        }
        // 判断是否为空
        if (isEmpty()) {
            throw new NullArrayException("数组为空 不能取数据");
        }

        return this.elem[pos];
    }

    private boolean isEmpty() {
        return this.usedSize == 0;
    }

    // 更新pos位置的数据 为value
    @Override
    public void set(int pos, int value) {
        // 1. 判断 pos位置 是否合法
        if (pos < 0 || pos >= this.usedSize) {
            throw new PosException(pos + " 是一个不合法的pos位置 重新输入");
        }
        // 2. 判断是否为空
        if (isEmpty()) {
            throw new NullArrayException("数组为空 不能取数据");
        }
        this.elem[pos] = value;
    }

    // 删除 toRmove 这个数据
    @Override
    public void remove(int toRemove) {
        // 1. 判断是否为空
        if(isEmpty()){
            throw new NullArrayException("数组为空 不可删除 重新输入");
        }
        // 2. 找数据
        int index = -1;
        for (int i = 0;i < this.usedSize;i++) {
            if (this.elem[i] == toRemove) {
                index = i;
            }
        }
        // 3. 找不到数据
        if (-1 == index) {
            System.out.println("找不到数据");
            return;
        }
        // 4. 删除数据
        for (int i = index;i < this.usedSize-1;i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }

    @Override
    // 返回数据个数
    public int size() {
        return this.usedSize;
    }

    // 清空顺序表 防止内存泄漏
    @Override
    public void clear() {
        this.usedSize = 0;
    }
}
