/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc21合并两个有序链表;

import common.ListNode;

/**
 * lc21合并两个有序链表
 *
 * @since 2019-10-13
 */
public class Solution {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode p1 = l1;
    ListNode p2 = l2;
    ListNode result = new ListNode(0);
    ListNode temp = result;
    while (p1 != null || p2 != null) {
      if (p1 != null && p2 != null) {
        if (p1.val < p2.val) {
          temp.next = new ListNode(p1.val);
          p1 = p1.next;
        } else {
          temp.next = new ListNode(p2.val);
          p2 = p2.next;
        }
        temp = temp.next;
        continue;
      }
      if (p1 == null) {
        p1 = p2;
      }
      temp.next = p1;
      break;
    }
    return result.next;
  }
}
