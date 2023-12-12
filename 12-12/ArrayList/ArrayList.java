package ArrayList;

import java.util.Arrays;

public class ArrayList implements IList{

    private int[] elem;
    private int size;
    public static final int DEFAULT_CAPACITY = 5;

    public ArrayList() {
        this.elem = new int[DEFAULT_CAPACITY];
    }

    // 显示所有元素
    @Override
    public void display() {
        for (int i = 0;i < this.size;i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    // 尾插
    @Override
    public void add(int data) {
        // 检查是否需要扩容
        if (this.elem.length == this.size) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length * 2);
        }
        this.elem[size++] = data;
    }

    // pos位置插入数据
    @Override
    public void add(int pos, int data) {
        // 1. 检查是否需要扩容
        if (this.elem.length == this.size) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length * 2);
        }
        // 2. 检查pos位置是否合法
        if (pos < 0 || pos > this.size) {
            System.out.println("pos位置不合法: "+pos);
            return;
        }
        // 3. 移动数据
        for (int i = size-1;i >= pos;i--) {
            this.elem[i+1] = this.elem[i];
        }
        // 4. pos位置插入
        this.elem[pos] = data;
        this.size++;
    }

    // 判定是否包含某个元素
    @Override
    public boolean contains(int toFind) {
        for (int i = 0;i < this.size;i++) {
            if (toFind == this.elem[i]) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    @Override
    public int indexOf(int toFind) {
        for (int i = 0;i < this.size;i++) {
            if (toFind == this.elem[i]) {
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    @Override
    public int get(int pos) {
        if (pos < 0 || pos >= this.size) {
            System.out.println("pos位置不合法: "+pos);
            return -1;
        }
        return this.elem[pos];
    }

    // 给 pos 位置的元素设为 value
    @Override
    public void set(int pos, int value) {
        if (pos < 0 || pos >= this.size) {
            System.out.println("pos位置不合法: "+pos);
            return;
        }
        this.elem[pos] = value;
    }

    // 删除第一次出现的关键字key
    @Override
    public void remove(int toRemove) {
        // 1. 判断数组是否为空 如果为空不能删除
        if (size == 0) {
            System.out.println("数组为空 不能删除");
        }
        // 2. 找到删除位置下标
        int index = -1;
        for (int i = 0;i < size;i++) {
            if (elem[i] == toRemove) {
                index = i;
            }
        }
        // 3. 移动覆盖
        for (int i = index;i < size - 1;i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.size--;
    }

    // 获取顺序表长度
    @Override
    public int size() {
        return this.size;
    }

    // 清空顺序表
    @Override
    public void clear() {
        this.size = 0;
    }
}
