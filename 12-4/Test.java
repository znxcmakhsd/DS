/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
1. 删除链表中等于给定值 val 的所有节点
https://leetcode.cn/problems/remove-linked-list-elements/description/

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;

    }
}


2. 反转链表
https://leetcode.cn/problems/reverse-linked-list/description/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = head;
            head = cur; 
            cur = next;
        }
        return head;
    }
}

3.链表的中间结点
方法1:
https://leetcode.cn/problems/middle-of-the-linked-list/description/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        // 计算链表长度
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        cur = head;
        int times = count/2;
        while (times != 0) {
            cur = cur.next;
            times--;
        }
        return cur;
    }
}
方法2: 
快慢指针
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

4. 面试题 02.返回倒数第 k 个节点
https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/description/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        // 让快指针先走k-1步
        while(k-1 != 0) {
            fast = fast.next;
            k--;
        }
        // 然后同时走 当快指针走到终点 slow指针指向的位置就是倒数第 k 个节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
     }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

5. 合并两个有序链表
https://leetcode.cn/problems/merge-two-sorted-lists/description/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while (list1 != null && list2 != null) {           

            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }

        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }
}
6. 分割链表
https://leetcode.cn/problems/partition-list-lcci/description/
1:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode lessX = new ListNode(-1);
        ListNode overX = new ListNode(-1);
        
        ListNode curLx = lessX;
        ListNode curOx = overX;

        while (cur != null) {
            if (cur.val < x) {
                curLx.next = cur;
                cur = cur.next;
                curLx = curLx.next;
            }else {
                curOx.next = cur;
                cur = cur.next;
                curOx = curOx.next;
            }
        }
        curOx.next = null;
        curLx.next = overX.next;
        return lessX.next;

    }
}