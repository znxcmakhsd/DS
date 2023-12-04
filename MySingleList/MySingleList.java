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

        // 1. 判断index位置是否合法
        if (index < 0 || index > this.size()) {
            throw new IndexException(index +" 是非法的indexs位置 重新输入");
        }
        // 2. 处理特殊情况1: 链表没有节点
        if (this.head == null) {
            this.head = node;
            return;
        }
        // 3. 处理特殊情况2: 头插
        if (0 == index) {
            node.next = this.head;
            this.head = node;
            return;
        }

        // 正常情况: 尾/中间插入
        while (index-1 > 0) {
            cur = cur.next;
            index--;
        }
        node.next = cur.next;
        cur.next = node;
    }


    // 删除第一次出现数据为key的节点
    @Override
    public void remove(int key) {

        // 处理特殊情况1: 链表没有节点
        if (this.size() == 0) {
            System.out.println("链表为空 不能进行删除操作");
            return;
        }
        // 处理特殊情况2: 头删
        if (this.head.value == key) {
            this.head = this.head.next;
            return;
        }

        ListNode cur = this.head;
        ListNode prev = findPrevKey(cur,key);
        if (prev != null) {
            prev.next = prev.next.next;
        }else {
            System.out.println("没有你要删除的数据: "+key);
            System.out.println("删除失败");
        }
    }
    private ListNode findPrevKey(ListNode cur,int key) {
        while (cur.next != null) {
            if (cur.next.value == key) {
                return cur;
            }else {
                cur = cur.next;
            }
        }
        return null;
    }

    // 删除所有值为key的节点
    @Override
    public void removeAllKey(int key) {
        // 处理特殊情况1: 链表没有节点
        if (this.head == null) {
            System.out.println("链表为空 不能进行删除操作");
            return;
        }

        // 删除 除了第一个节点
        ListNode prev = this.head;
        ListNode cur = prev.next;

        while (cur != null) {
            if (cur.value == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }

        // 处理特殊情况2: 判断第一个节点
        if (this.head.value == key) {
            this.head = this.head.next;
        }
    }


    @Override
    public void clear() {
        this.head = null;
    }

}
