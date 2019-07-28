/*
* You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/
public class Solution {
    private class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode lp1 = l1, lp2 = l2;
        ListNode nextNode = result;

        int carry = 0, x = 0, y = 0;
        while(lp1 != null || lp2 != null){
            if(lp1 != null) {
                x = lp1.val;
                lp1 = lp1.next;
            } else {x = 0;}
            if(lp2 != null) {
                y = lp2.val;
                lp2 = lp2.next;
            } else {y = 0;}
            int sum = x + y + carry;
            carry = sum / 10;
            nextNode.next = new ListNode(sum%10);
            nextNode = nextNode.next;
        }

        if (carry > 0) {
            nextNode.next = new ListNode(carry);
        }
        return result.next;
    }
}
