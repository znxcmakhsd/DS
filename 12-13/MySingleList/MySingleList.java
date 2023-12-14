package MySingleList;

import java.util.List;

public class MySingleList implements IList{
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    private ListNode head;

    // 计算节点个数
    @Override
    public int size() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    // 清空
    @Override
    public void clear() {
        this.head = null;
    }

    // 打印所有节点
    @Override
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    // 头插
    @Override
    public void addFirst(int data) {
        ListNode newNode = new ListNode(data);
        ListNode nextNode = this.head;
        this.head = newNode;
        this.head.next = nextNode;
    }
    // 尾插
    @Override
    public void addLast(int data) {
        ListNode newNode = new ListNode(data);
        if (this.head == null) {
            this.head= newNode;
        }else {
            // 找尾
            ListNode cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }
    // index位置插入,第一个数据节点为0号下标
    @Override
    public void addIndex(int index, int data) {
        // 1. 判断index位置是否合法
        if (index < 0 || index > this.size()) {
            throw new IndexException("index输入不合法: "+ index);
        }
        // 2. 插入有3种情况 需要分别处理
        ListNode newNode = new ListNode(data);
        // 头插
        if (index == 0) {
            // 处理 链表没有节点/头插
            ListNode next = this.head;
            this.head = newNode;
            newNode.next = next;
            return;
        }
        // 尾插
        if (index == this.size()) {
            // 不需要处理为空情况
            ListNode cur = this.head;
            // 找尾
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
            return;
        }
        // 中间插入
        // 找到插入节点的前一个 插入节点
        ListNode prev = this.head;
        while (index - 1 != 0) {
            prev = prev.next;
        }
        ListNode next = prev.next;
        newNode.next = next;
        prev.next = newNode;
    }

    //查找是否包含关键字key是否在单链表当中
    @Override
    public boolean contains(int key) {
        // 如果没有节点 不能遍历
        if (this.head == null) {
            throw new NullListException("链表为空 不能删除");
        }
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private boolean isEmpty() {
        return 0 == this.size();
    }
    // 删除第一次出现关键字为key的节点
    @Override
    public void remove(int key) {
        // 如果链表为空 不能删除
        if (isEmpty()) {
            throw new NullListException("链表为空 不能删除");
        }
        // 1. 找到删除节点的位置
        ListNode cur = this.head;
        ListNode delNode = null;
        while (cur != null) {
            if (cur.val == key) {
                delNode = cur;
                break;
            }
            cur = cur.next;
        }
        // 2. 删除分2种情况:
        // 处理 头删和删除只有一个节点的情况
        if (delNode == this.head) {
            this.head = this.head.next;
        }else {
            // 处理 删除中间和尾 是一样的
            // 找前一个节点
            ListNode prev = this.head;
            while (prev.next != delNode) {
                prev = prev.next;
            }
            prev.next = delNode.next;
        }
    }

    // 删除所有值为key的节点
    @Override
    public void removeAllKey(int key) {
        // 如果链表为空 不能删除
        if (isEmpty()) {
            throw new NullListException("链表为空 不能删除");
        }
        ListNode cur = this.head;
        ListNode prev = cur;
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }

    }
}

