package TestHeap;

public class Test {
    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        TestHeap heap = new TestHeap();
        heap.InitHeap(array);
        heap.createHeap();
        //heap.push(80);
        heap.poll();
    }
}
