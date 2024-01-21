package Heap;

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

    // 建大根堆
    public void createBigHeap(int parent,int end) {
        for (int i = parent;i >= 0;i--) {
            siftDown(i,end);
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

}
