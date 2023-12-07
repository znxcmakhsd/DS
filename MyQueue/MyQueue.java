package MyQueue;

public class MyQueue {

    static class ListNode {
        public ListNode prev;
        public int value;
        public ListNode next;

        public ListNode(int data) {
            this.value = data;
        }
    }

    public ListNode first;
    public ListNode last;
    public int size;

    // 入队列 - 尾插
    public void offer(int data){
        ListNode node = new ListNode(data);
        if (first == null) {
            first = last =node;
        }else {
            node.prev = last;
            last.next = node;
            last = last.next;
        }
        this.size++;
    }

    // 出队列 - 头删
    public int poll() {
        if (this.first == null) {
           throw new EmptyException("队列中没有数据 删除失败");
        }
        int ret = this.first.value;
        if (first.next == null) {
            this.first = this.last = null;
        }else {
            this.first = this.first.next;
            this.first.prev = null;
        }
        return ret;
    }

    // 获取队头元素---获取链表中第一个节点的值域
    public int peek() {
        return this.first.value;
    }

    // 获取队列中有效元素个数
    public int size() {
        return this.size;
    }

    // 检测队列是否为空
    boolean isEmpty() {
        return 0 == this.size;
    }

}
