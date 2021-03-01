/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // ListNode ans = new ListNode(0);
    // ListNode cur = ans;
    // int carry = 0;
    // while (l1 != null || l2 != null || carry != 0) {
    // int value = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
    // carry = value / 10;
    // value %= 10;
    // if (l1 != null) l1 = l1.next;
    // if (l2 != null) l2 = l2.next;
    // cur.next = new ListNode(value);
    // cur = cur.next;
    // }
    // return ans.next;
    // }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int value = carry;
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            carry = value / 10;
            cur.next = new ListNode(value % 10);
            cur = cur.next;
        }
        return ans.next;
    }
}
// @lc code=end
