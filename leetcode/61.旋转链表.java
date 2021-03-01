/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    // public ListNode rotateRight(ListNode head, int k) {
    // if (head == null) return null;
    // int len = 1;
    // ListNode last = head;
    // while (last.next != null) {
    // last = last.next;
    // len++;
    // }
    // k = k > len ? k % len : k;
    // if (k == len || k == 0) return head;
    // ListNode fast = head;
    // ListNode cur = head;
    // ListNode pre = null;
    // while (fast != null) {
    // if (k-- <= 0) {
    // pre = cur;
    // cur = cur.next;
    // }
    // fast = fast.next;
    // }
    // if (pre != null) pre.next = null;
    // if (last != head) last.next = head;
    // return cur;
    // }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode last = head;
        int len = 1;
        while (last.next != null) {
            last = last.next;
            len++;
        }
        k = k % len;
        if (k == 0 || k == len)  return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null) {
            if (k-- <= 0) {
                pre = slow;
                slow = slow.next;
            }
            fast = fast.next;
        }
        pre.next = null;
        last.next = head;
        return slow;
    }
}
// @lc code=end
