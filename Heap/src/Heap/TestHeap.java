package Heap;

import java.util.Arrays;
public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    public void initHeap(int[] array) {
        for (int i = 0;i < elem.length;i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }

    // 向下调整 建大根堆
    public void createBigHeap(int parent,int end) {
        for (int i = parent;i >= 0;i--) {
            siftDown(i,end);
        }
    }

    // 向上调整 建大根堆
    public void createBigHeap2() {
        for (int i = 0;i < usedSize;i++) {
            siftUp(i);
        }
    }

    public void siftDown(int parent,int end) {
        int child = parent*2+1;
        while (child < end) {
            if (child + 1 < end && elem[child + 1] > elem[child]) {
                child++;
            }
            if (elem[child] > elem[parent]) {
                Swap(child,parent);
                parent = child;
                child = parent * 2 + 1;
            }else {
                break;
            }
        }
    }
    private void Swap(int x,int y) {
        int tmp = elem[x];
        elem[x] = elem[y];
        elem[y] = tmp;
    }

    // 堆的删除
    public int poll() {
        int tmp = elem[0];
        Swap(0,usedSize-1);
        usedSize--;
        siftDown(0,usedSize);
        return tmp;
    }

    // 堆的插入
    public void offer(int data) {
        if (elem.length == usedSize) {
            this.elem = Arrays.copyOf(elem,elem.length*2);
        }
        elem[usedSize++] = data;
        siftUp(usedSize-1);
    }

    // 向上调整
    public void siftUp(int child) {
        int parent = (child - 1) / 2;
        // 判断条件也可以是 child > 0
        while (parent >= 0) {
            if (elem[child] > elem[parent]) {
                Swap(child,parent);
                child = parent;
                parent = (child-1)/2;
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 27,15,19,18,28,34,65,49,25,37};
        TestHeap testHeap = new TestHeap();
        testHeap.initHeap(array);
        //testHeap.createBigHeap((array.length-1-1)/2,array.length);
        testHeap.createBigHeap2();
        //testHeap.offer(80);

    }

}
