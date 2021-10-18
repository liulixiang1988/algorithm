/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (64.27%)
 * Likes:    422
 * Dislikes: 0
 * Total Accepted:    73.3K
 * Total Submissions: 113.7K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例:
 * 
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // 俩俩交换需要有三个节点进行（只有2个Node时引入一个虚Node）
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        while (pre.next != null && pre.next.next != null) {
            ListNode a = pre.next;
            ListNode b = a.next;
            pre.next = b;
            a.next = b.next;
            b.next = a;
            pre = a;
        }
        return newHead.next;
    }
}
// @lc code=end
