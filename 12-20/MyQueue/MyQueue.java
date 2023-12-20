package MyQueue;

public class MyQueue {
    static class ListNode {
        private ListNode prev;
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode head;
    public ListNode last;

    // 入队 - 尾插
    public void offer(int data){
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            last = head;
        }else {
            last.next = node;
            node.prev = last;
            last = node;
        }
    }

    // 出队 - 头删
    public int poll() {
        // 如果为空 不能删除
        if (isEmpty()) {
            throw new EmptyException("队列为空 不能获取");
        }
        int ret = head.val;
        head = head.next;
        if (head == null) {
            last = null;
        }else {
            head.prev = null;
        }
        return ret;
    }

    // 获取队头元素---获取链表中第一个节点的值域
    public int peek() {
        // 如果为空 不能获取
        if (isEmpty()) {
            throw new EmptyException("队列为空 不能获取");
        }
        return head.val;
    }

    // 获取队列中有效元素个数
    public int size() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return 0 == this.size();
    }


}
