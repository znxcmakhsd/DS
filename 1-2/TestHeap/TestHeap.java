package TestHeap;

import java.util.Arrays;

public class TestHeap {
    private int[] elem;
    private int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    public void InitHeap(int[] arr) {
        for (int i = 0;i < arr.length;i++) {
            elem[i] = arr[i];
            usedSize++;
        }
    }

    // 向下调整
    public void siftDown(int parent,int size) {
        int child = parent * 2 + 1;
        while (child < size) {
            // 走进循环说明至少有左树
            // 然后判断是否存在右数 取左右树最大值 与parent比较
            if (child + 1 < size && elem[child + 1] > elem[child]) {
                child = child + 1;
            }
            if (elem[child] > elem[parent]) {
                Swap(child, parent);
                parent = child;
                child = parent * 2 + 1;
            } else {
                break;
            }
        }
    }

    // 向下调整建堆
    public void createHeap () {
        for (int parent = (usedSize - 1 - 1) / 2; parent >= 0; parent--) {
            siftDown(parent,usedSize);
        }
    }

    // 数据插入堆
    public void push(int val) {
        if (isFull()) {
            this.elem = Arrays.copyOf(elem,2 * elem.length);
        }
        elem[usedSize] = val;
        siftUp(usedSize);
        usedSize++;
    }
    public void siftUp(int child) {
        int parent = (child-1)/2;
        while (child > 0) {
            if (elem[child] > elem[parent]) {
                Swap(child,parent);
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    public boolean isFull() {
        return this.elem.length == usedSize;
    }

    private void Swap(int x,int y) {
        int tmp = elem[x];
        elem[x] = elem[y];
        elem[y] = tmp;
    }

    // 删除堆顶数据
    public int poll() {
        if (Empty()) {
            return -1;
        }
        int tmp = elem[0];
        Swap(0,usedSize-1);
        this.usedSize--;
        siftDown(0,usedSize);
        return tmp;
    }
    public boolean Empty() {
        return usedSize == 0;
    }

}
