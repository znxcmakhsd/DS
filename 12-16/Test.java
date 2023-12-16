1. https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&&tqId=11167&rp=2&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
链表中倒数第k个结点
import java.util.*;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) {
            return null;
        }
        if (k < 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = fast;
        
        // 让fast先走k-1步
        int count = 0;
        while (count != k-1) {
            // k有可能会是一个很大的数字
            if (fast.next != null) {
                fast = fast.next;
                count++;
            }else {
                return null;
            }

        }
        // 然后同时走
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}



2. 合并两个有序链表
方法1:
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        ListNode head = null;
        ListNode tail = null;

        // 处理两个链表为空
        if (list1 == null && list2 == null) {
            return null;
        }
        // 处理一个为空 一个不为空
        if (list1 == null && list2 != null) {
            head = list2;
            return head;
        }
        if (list2 == null && list1 != null) {
            head = list1;
            return head;
        }

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val < ptr2.val) {
                if (head == null) {
                    head = ptr1;
                    tail = head;
                }else {
                   tail.next = ptr1;
                   tail = tail.next;
                }
                ptr1 = ptr1.next;
            }else {
                if (head == null) {
                    head = ptr2;
                    tail = head;
                }else {
                    tail.next = ptr2;
                    tail = tail.next;
                }
                ptr2 = ptr2.next;
            }
        }
        if (ptr1 != null) {
            tail.next = ptr1;
        }
        if (ptr2 != null) {
            tail.next = ptr2;
        }
        return head;
    }
}
3. 分割链表
方法1:
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
        ListNode overX = new ListNode(-1);
        ListNode lessX = new ListNode(-1);
        ListNode tailOv = overX;
        ListNode tailLe = lessX; 

        while (cur != null) {
            if (cur.val < x) {
                tailLe.next = cur;
                cur = cur.next;
                tailLe = tailLe.next;
            }else {
                tailOv.next = cur;
                cur = cur.next;
                tailOv = tailOv.next;
            }
        }
        tailOv.next = null;
        tailLe.next = overX.next;
        return lessX.next;
    }
}

方法2:
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
        // 处理空链表
        if (head == null) {
            return null;
        }
        ListNode headOx = null;
        ListNode headLx = null;
        ListNode tailOx = null;
        ListNode tailLx = null; 
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x){
                if (headLx == null) {
                    headLx = cur;
                    tailLx = headLx;
                }else {
                    tailLx.next = cur;
                    tailLx = tailLx.next;
                }
                cur = cur.next;
            }else {
                if (headOx == null) {
                    headOx = cur;
                    tailOx = headOx;
                }else {
                    tailOx.next = cur;
                    tailOx = tailOx.next;
                }
                cur = cur.next;
            }
        }
        // 分割链表后可能 headLx为空 或者 headOx为空，但是不可能都为空
        if (headLx == null) {
            return headOx;
         }
        // 走到这里表示< x 的链表不为空，直接链接headOx
        // 可以直接链接是因为 无论 val > x 链表是否有节点都对结果不影响
        // 为空: headOx = null, tailLx.next = headOx(null)
        tailLx.next = headOx;
        // 但是最后需要判断 因为最后一个节点得置空 
        if (tailOx != null)         
            tailOx.next = null;    
        return headLx;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, L istNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // 1. 找到中间节点
        ListNode fast = head;
        ListNode slow = fast;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2. 从中间节点开始反转链表
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = slow;
            slow = cur;
            cur = next;
        }
        // 3. 判断是否回文
        while (head != slow) {
            if (head.val != slow.val) {
                return false;
            }
            // 判断偶数节点回文
            if (head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        // 走到这表示奇数个节点链表为回文
        return true;

    }
}