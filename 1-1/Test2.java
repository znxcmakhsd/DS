package Heap;

public class TestHeap {

    private int[] elem;
    private int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    public void initElem(int[] arr) {
        for (int i = 0;i < arr.length;i++) {
            this.elem[i] = arr[i];
            this.usedSize++;
        }
    }

    // 创建大根堆
    public void createHeap() {
        for (int parent = (elem.length-1-1)/2; parent >= 0;parent--) {
            siftDown(parent,this.usedSize);
        }
    }

    // 向下调整
    private void siftDown(int parent,int size) {

        int child = parent * 2 + 1;
        while (child < size) {
            // 进这个循环说明至少有左树
            // 然后找到左右子树的最大值 注意: 需要判断是否有右树
            if (child + 1 < size && elem[child+1] > elem[child]) {
                child = child + 1;
            }

            if (elem[child] > elem[parent]) {
                int tmp = elem[parent];
                elem[parent] = elem[child];
                elem[child] = tmp;
                parent = child;
                child = parent * 2 + 1;
            }else {
                break;
            }
        }
    }

}
