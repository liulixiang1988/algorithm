#!/usr/bin/env python
# -*- coding:utf-8 -*-

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        current, prev = head, None
        while(current is not None):
            # 注意顺序
            prev, current.next, current = current, prev, current.next
        return prev