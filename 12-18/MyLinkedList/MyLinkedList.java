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

    @Override
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (key == cur.val) {
                return true;
            }
        }
        return false;
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
            return;
        }
        // 尾插
        if (index == size()) {
            addLast(data);
            return;
        }
        // 中间插入
        ListNode node = new ListNode(data);
        // 让cur走Index步，找到插入节点位置
        ListNode cur = head;
        int count = 0;
        while (count != index) {
            cur = cur.next;
            count++;
        }
        node.prev = cur.prev;
        node.next = cur;
        cur.prev = node;
        node.prev.next = node;
    }

    private boolean isEmpty() {
        return 0 == size();
    }
    // 删除第一次出现关键字为key的节点
    @Override
    public void remove(int key) {
        // 没有节点不能删除
        if (isEmpty()) {
            throw new EmptyListException("没有节点不能删除");
        }
        // 找到删除节点位置
        ListNode cur = head;
        while (cur != null) {
            if (key == cur.val) {
                // 删除头结点情况:
                if (cur == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }else {
                        last = null;
                    }
                }else {
                    // 删除尾节点/中间节点
                    if (cur == last) {
                        last = cur.prev;
                    }else {
                        cur.next.prev = cur.prev;
                    }
                    cur.prev.next = cur.next;
                }
                return;
            }
            cur = cur.next;
        }
    }

    // 删除所有值为key的节点
    @Override
    public void removeAllKey(int key) {
        // 没有节点不能删除
        if (isEmpty()) {
            throw new EmptyListException("没有节点不能删除");
        }

        ListNode cur = head;
        while (cur != null) {
            if (key == cur.val) {
                // 删除头结点情况:
                if (cur == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }else {
                        last = null;
                    }
                }else {
                    // 删除尾节点/中间节点
                    if (cur == last) {
                        last = cur.prev;
                    }else {
                        cur.next.prev = cur.prev;
                    }
                    cur.prev.next = cur.next;
                }
            }
            cur = cur.next;
        }
    }
}
