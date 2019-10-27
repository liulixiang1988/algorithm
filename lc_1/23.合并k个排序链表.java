import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (47.68%)
 * Likes:    373
 * Dislikes: 0
 * Total Accepted:    51.4K
 * Total Submissions: 107.8K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        ListNode temp = result;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for(int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            priorityQueue.offer(lists[i]);
        }

        while (!priorityQueue.isEmpty()) {
            ListNode next = priorityQueue.poll();
            if (next.next != null) {
                priorityQueue.offer(next.next);
            }
            temp.next = next;
            temp = next;
        }
        return result.next;
    }
}
// @lc code=end

