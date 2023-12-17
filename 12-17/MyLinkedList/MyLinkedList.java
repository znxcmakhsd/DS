package MyLinkedList;

import java.util.List;

public class MyLinkedList implements IList{
    static class ListNode {
        public ListNode prev;
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode head;
    public ListNode last;

    @Override
    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        this.head = null;
        this.last = null;
    }

    // 头插
    @Override
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        // 处理没有节点的头插
        if (head == null) {
            head = node;
            last = head;
        }else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    // 尾插
    @Override
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            last = head;
        }else {
            node.prev = last;
            last.next = node;
            last = node;
        }
    }

    // index位置插入,第一个数据节点为0号下标
    @Override
    public void addIndex(int index, int data) {
        // 检查index位置
        if (index < 0 || index > size()) {
            throw new IndexException(index + " :非法index下标");
        }
        // 头插
        if (index == 0) {
            addFirst(data);
        }
        // 尾插
        if (index == size()) {
            addLast(data);
        }
        // 中间插入
        ListNode node = new ListNode(data);
        // 让cur走Index-1步，找到插入节点位置
        ListNode cur = head;
        int count = 0;
        while (count != index-1) {
            cur = cur.next;
            count++;
        }
        ListNode curPrev = cur.prev;
        cur.prev = node;
        node.prev = curPrev;
        node.next = cur;
        curPrev.next = node;
    }

    @Override
    public boolean contains(int key) {
        return false;
    }

    @Override
    public void remove(int key) {

    }

    @Override
    public void removeAllKey(int key) {

    }
}
