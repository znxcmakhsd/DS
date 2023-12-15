package MySingleList;

public class MySingleList implements IList{
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    private ListNode head;

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

    @Override
    public void clear() {
        this.head = null;
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

    // 查找是否包含关键字key是否在单链表当中
    @Override
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
        }
        return false;
    }

    // 头插
    @Override
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        node.next = this.head;
        this.head = node;
    }

    // 尾插
    @Override
    public void addLast(int data) {
        ListNode listNode = new ListNode(data);
        // 1. 处理没有节点情况:
        if (this.head == null) {
            this.head = listNode;
        }else {
            // 找尾
            ListNode cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = listNode;
        }
    }

    // index位置插入,第一个数据节点为0号下标
    @Override
    public void addIndex(int index, int data) {
        // 判断index位置是否合法
        if (index < 0 || index > this.size()) {
            throw new IndexException(index + ":下标不合法");
        }

        // 头插
        if (index == 0) {
            this.addFirst(data);
            return;
        }
        // 尾插
        if (index == this.size()) {
            this.addLast(data);
            return;
        }
        // 中间插入
        // 找到插入节点的前一个
        ListNode listNode = new ListNode(data);
        ListNode prev = this.head;
        while (index - 1 != 0) {
            prev = prev.next;
            index--;
        }
        listNode.next = prev.next;
        prev.next = listNode;
    }

    // 删除第一次出现关键字为key的节点
    @Override
    public void remove(int key) {
        if (isEmpty()) {
            throw new NullListException("该链表没有节点 不能删除");
        }
        ListNode cur = this.head;
        ListNode prev = cur;
        while (cur != null) {
            if (cur.val == key) {
                if (this.head == cur) {
                    this.head = cur.next;
                }else {
                    prev.next = cur.next;
                }
                // 只删除一次
                break;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
    }
    public boolean isEmpty() {
        return this.size() == 0;
    }

    // 删除所有值为key的节点
    @Override
    public void removeAllKey(int key) {
        if (isEmpty()) {
            throw new NullListException("该链表没有节点 不能删除");
        }
        ListNode cur = this.head;
        ListNode prev = cur;
        while (cur != null) {
            if (cur.val == key) {
                if (this.head == cur) {
                    this.head = cur.next;
                }else {
                    prev.next = cur.next;
                }
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
    }

}
