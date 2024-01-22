package Heap;

public class Test {
    public static void main(String[] args) {
        int[] array = { 27,15,19,18,28,34,65,49,25,37};
        TestHeap testHeap = new TestHeap();
        testHeap.initHeap(array);
        testHeap.createBigHeap((array.length-1-1)/2,array.length);
        //System.out.println(testHeap.poll());
    }
}
