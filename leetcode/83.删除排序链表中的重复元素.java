/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    // public ListNode deleteDuplicates(ListNode head) {
    // ListNode pre = null;
    // ListNode ans = new ListNode(Integer.MIN_VALUE);
    // ans.next = head;
    // pre = ans;
    // ListNode cur = head;
    // while (cur != null) {
    // while (cur != null && cur.val == pre.val)
    // cur = cur.next;
    // pre.next = cur;
    // pre = cur;
    // if (cur == null) break;
    // cur = cur.next;
    // }
    // return ans.next;
    // }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        if (head.val == head.next.val) {
            ListNode cur = head;
            while (cur.next != null && cur.next.val == head.val)
                cur = cur.next;
            head.next = deleteDuplicates(cur.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;

    }
}
// @lc code=end
