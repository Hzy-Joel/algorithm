/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    // public ListNode reverseKGroup(ListNode head, int k) {
    // if (head == null) return null;
    // ListNode cur = head;
    // int temp = k;
    // // 找到下一个k的节点的下一个
    // while (--temp >= 0 && cur != null) {
    // cur = cur.next;
    // }
    // if (temp >= 0) return head;
    // ListNode last = reverseList(head, cur);
    // head.next = reverseKGroup(cur, k);
    // return last;
    // }

    // /***
    // * 反转[head,des)之间的节点，不包括des节点
    // * 其实就是反转链表，只是停止条件由null变为des
    // */
    // public ListNode reverseList(ListNode head, ListNode des) {
    // ListNode pre = null;
    // ListNode cur = head;
    // ListNode next = head;
    // while (cur != des) {
    // next = cur.next;
    // cur.next = pre;
    // pre = cur;
    // cur = next;
    // }
    // return pre;
    // }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nextK = head;
        for (int i = 0; i < k; i++) {
            if(nextK == null) return head;
            nextK = nextK.next;
        }
        ListNode ans = reverseK(head, nextK);
        head.next = reverseKGroup(nextK, k);
        return ans;
    }

    public ListNode reverseK(ListNode head, ListNode last) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != last){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
        
    }

}
// @lc code=end
