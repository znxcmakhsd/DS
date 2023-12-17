1. 
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
class Solution {
    public ListNode findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = fast;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head) {
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

    public boolean isPalindrome(ListNode head) {
        ListNode midNode = findMiddleNode(head);
        ListNode newHead = reverseList(midNode);
        // 判断链表是否回文       
        while (head.next != null) {
            if (head.val != newHead.val) {
                return false;
            }else {
                head = head.next;
                newHead = newHead.next;
            }
        }
        return true;
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

3. /**
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
        // 1. 计算两个链表长度
        ListNode curL = headA; // curL指向长链表
        ListNode curS = headB; // curS指向短链表
        int lenL = 0;
        int lenS = 0;
        while (curL != null) {
            lenL++;
            curL = curL.next;
        }
        while (curS != null) {
            lenS++;
            curS = curS.next;
        }
        curL = headA;
        curS = headB;   
        // 2. 让curL先走差距步
        int gap = lenL - lenS;
        if (gap < 0) {
            curL = headB;
            curS = headA;
            gap = lenS - lenL;
        }
        while (gap != 0) {
            curL = curL.next;
            gap--;
        }
        // 3. 同时走 判断链表是否相交
        // 判断方法1:
        // while (curL != null && curS != null) {
        //     if (curL == curS) {
        //         return curL;
        //     }
        //     curL = curL.next;
        //     curS = curS.next;
        // }
        // return null;
        
        // 判断方法2:
        while (curL != null && curS != null && curL != curS) {
            curL = curL.next;
            curS = curS.next;
        }
        if (curL == curS && curL == null) return null;
        
        return curL;
    
    }
}

4. 
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
        ListNode slow = head;
        ListNode fast = slow;
        // 有可能链表不是环形 
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

5. 
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
    public ListNode detectCycle(ListNode head) {
        
        // 1. 找到相遇点
        ListNode slow = head;
        ListNode fast = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        // 走到这里 有两种情况:
        // 1. fast走到null(偶数节点) 或者 fast.next = null(奇数节点) ——》 无环 
        // 2. fast与slow相遇后break
        if (fast == null || fast.next == null) return null;

        // 2. 找到入环点
        ListNode cur = head;
        while (cur != slow) {
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }
}