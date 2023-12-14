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
1. 环形链表 II
https://leetcode.cn/problems/linked-list-cycle-ii/description/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 1. 找相遇点
        ListNode cur = head;
        ListNode meet = null;
        ListNode fast = head;
        ListNode slow = fast;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                meet = fast;
                break;
            }
        }
        if (meet == null)
            return null;
        
        // 一个指针
        while (cur != meet) {
            cur = cur.next;
            meet = meet.next;
        }
        return cur;
    }
}