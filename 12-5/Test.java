1. 分割链表
https://leetcode.cn/problems/partition-list-lcci/description/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
方法1:
class Solution {
    public ListNode partition(ListNode head, int x) {
        // 处理特殊情况1: 链表无节点
        if (head == null) {
            return null;
        }
        // 处理特殊情况2: 处理 一个节点情况
        if (head.next == null) {
            return head;
        }
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                if (bs == null) {
                    bs = cur;
                    be = bs;                  
                }else {
                    be.next = cur;
                    be = be.next;
                }
                cur = cur.next;
            }else {
                if (as == null) {
                    as = cur;
                    ae = as;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
                cur = cur.next;
            }
        }
        // 处理特殊情况3: 1个为空 1个不为空
        // 如果 < x bs链表为空 直接返回as 
        if (bs == null) {
            return as;
        }
        // 走到这里表示 <x bs链表不为空，开始连接as
        // 注意: 这里 as 为空/不为空 都可以处理
        be.next = as;
        if (as != null){
            ae.next = null;
        }
        return bs;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
方法2:
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode overX = new ListNode(-1);
        ListNode lessX = new ListNode(-1);
        ListNode cur = head;

        ListNode curLX = lessX;
        ListNode curOX = overX;

        while (cur != null) {
            if (cur.val < x) {
                curLX.next = cur;
                curLX = curLX.next;
                cur = cur.next;
            }else {
                curOX.next = cur;
                curOX = curOX.next;
                cur = cur.next;
            }
        }
        curLX.next = overX.next;
        curOX.next = null;
        return lessX.next;
    }
}
2.
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

2.反转链表
https://leetcode.cn/problems/reverse-linked-list/description/
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = head;
            head = cur;
            cur = curNext;
        }
        return head;
    }
}


3. 回文链表
https://leetcode.cn/problems/palindrome-linked-list/description/
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
        //  这里一定要把 fast != null 写在前面
        // 因为如果是偶数节点 fast会走到null 
        // 如果 fast.next 写在&&前面 会访问空指针异常 
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = head;
            head = cur;
            cur = curNext;
        }
        return head;
    }
    public boolean isPalindrome(ListNode head) {
        // 思路:
        // 找到中心节点 然后反转链表
        ListNode midNode = middleNode(head);
        ListNode reverseHead = reverseList(midNode);
        
        // 进行判断
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val != reverseHead.val) {
                return false;
            }else {
                cur = cur.next;
                reverseHead = reverseHead.next;
            }
        }
        return true;
    }
}
4. 相交链表
https://leetcode.cn/problems/intersection-of-two-linked-lists/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // 假设 curA = 长的链表
        ListNode curA = headA;
        ListNode curB = headB;

        // 1. 分别 计算 A B链表长度
        int lenListA = 0;
        int lenListB = 0;
        while (curA != null) {
            lenListA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenListB++;
            curB = curB.next;
        }
        // 重置
        curA = headA;
        curB = headB;

        int len = lenListA - lenListB;
        if (len < 0) {
            curA = headB;
            curB = headA;
            len = lenListB - lenListA;
        }
        // 2. 让长的链表 先走len步
        while (len != 0) {
            curA = curA.next;
            len--;
        } 
        // 3. 同时走
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;       
    }
}

5. 环形链表1
https://leetcode.cn/problems/linked-list-cycle/description/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}