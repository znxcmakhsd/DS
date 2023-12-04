package MySingleList;

import java.util.List;

public class MySingleList implements IList {

    static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int val) {
            this.value = val;
            this.next = null;
        }
    }

    // 头节点
    public ListNode head;

    @Override
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    // 计算 节点数量
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

    // 判断 当前链表是否存在 key元素
    @Override
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.value == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 头插
    @Override
    public void addFirst(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    // 尾插
    @Override
    public void addLast(int data) {
        ListNode newNode = new ListNode(data);

        if (null == this.head) {
            this.head = newNode;
        }else {
            ListNode cur = this.head;
            // 找尾
            while (cur.next != null) {
                 cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    // index位置插入
    @Override
    public void addIndex(int index, int data) {
        ListNode node = new ListNode(data);
        ListNode cur = this.head;

        while (index-1 > 0) {
            cur = cur.next;
            index--;
        }

        node.next = cur.next;
        cur.next = node;

    }


    // 删除第一次出现关键字为key的节点
    @Override
    public void remove(int key) {

    }

    // 删除所有值为key的节点
    @Override
    public void removeAllKey(int key) {

    }


    @Override
    public void clear() {

    }


    /* public ListNode newListNode(int val) {

    }*/
}
