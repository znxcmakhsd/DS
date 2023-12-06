package MyLinkedList;

public class MyLinkedList implements IList{

    static class ListNode {
        public ListNode prev;
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.prev = null;
            this.value = value;
            this.next = null;
        }
    }

    public ListNode head;
    public ListNode last;

    // 头插
    @Override
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;

        }else {
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }
    }

    // 尾插
    @Override
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        }else {
            node.prev = last;
            last.next = node;
            last = node;
        }
    }

    // index位置插入,第一个数据节点为0号下标
    @Override
    public void addIndex(int index, int data) {
        // 判断index 是否合法
        if (index < 0 || index > this.size()) {
            System.out.println(index + "是非法下标 重新输入");
            return;
        }
        // 头插 index == 0
        if (index == 0) {
            this.addFirst(data);
            return;
        }
        // 尾插 index == this.size()
        if (index == this.size()) {
            this.addLast(data);
            return;
        }
        // 中间插入  [1,size()-1]
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        int count = index;
        while (count != 0) {
            cur = cur.next;
            count--;
        }
        node.next = cur;
        node.prev = cur.prev;
        cur.prev = node;
        node.prev.next = node;

    }

    @Override
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.value == key) {
                return true;
            }else {
                cur = cur.next;
            }
        }
        return false;
    }

    @Override
    public void remove(int key) {
        if (this.head == null) {
            System.out.println("链表为空 不可删除");
            return;
        }
        // 1. 找到要删除的节点
        ListNode delNode = null;
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.value == key) {
                delNode = cur;
            }
            cur = cur.next;
        }
        if (null == delNode) {
            System.out.println("没有你要删除的节点");
            return;
        }
        // 2. 进行删除
        // 头删
        if (delNode == this.head) {
            head = head.next;
            // 处理 删除一个节点
            if (head == null) {
                this.last = null;
                return;
            }
            head.prev = null;
        }else {
            // 尾删
            if (delNode == this.last) {
                delNode.prev.next = null;
                this.last = delNode.prev;
            }else {
                // 中间删除
                delNode.prev.next = delNode.next;
                delNode.next.prev = delNode.prev;
            }
        }

    }

    @Override
    public void removeAllKey(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            // 头删
            if (cur.value == key) {
                if (cur == this.head) {
                    head = head.next;
                    // 处理 删除一个节点
                    if (head == null) {
                        this.last = null;
                        return;
                    }
                    head.prev = null;
                }else {
                    // 尾删
                    if (cur == this.last) {
                        cur.prev.next = null;
                        this.last = cur.prev;
                    }else {
                        // 中间删除
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

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
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        this.head = null;
        this.last = null;
    }
}
