/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    // private ListNode lastNext = null;

    // public ListNode reverseBetween(ListNode head, int m, int n) {
    // if (m == 1) return reverseN(head, n);
    // head.next = reverseBetween(head.next, m - 1, n - 1);
    // return head;
    // }

    // public ListNode reverseN(ListNode head, int n) {
    // if (n == 1 || head.next == null) {
    // lastNext = head.next;
    // return head;
    // }
    // ListNode last = reverseN(head.next, n - 1);
    // head.next.next = head;
    // head.next = lastNext;

    // return last;
    // }



    private ListNode next;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == 1) return reverseN(head, n);
        head.next = reverseBetween(head.next, --m, --n);
        return head;
    }

    public ListNode reverseN(ListNode head, int n) {
        if(n == 1){
            next = head.next;
            return head;
        }
        ListNode ans = reverseN(head.next, --n);
        head.next.next = head;
        head.next = next;
        return ans;
    }
   
}
// @lc code=end
