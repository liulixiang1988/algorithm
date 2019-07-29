/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }

        ListNode result = new ListNode(0);
        result.next = head;
        ListNode prev = result;
        ListNode groupEnd = prev;
        ListNode current = head;

        while(current != null) {
            //查找下一组的tail node
            for(int i = 0; i < k; i++) {
                groupEnd = groupEnd.next;
                if (groupEnd == null)
                    return result.next;
            }

            ListNode nextGroupHead = groupEnd.next;
            //截取一组node
            groupEnd.next = null;
            ListNode groupHead = current;
            //反转列表，并将head node链接到现有list
            prev.next = reverseList(groupHead);

            //移动到分组队尾，为下一次迭代做准备
            prev = groupEnd = current;
            //链接队尾与下一分组的队首
            prev.next = current = nextGroupHead;
        }
        return result.next;
    }

    // 反转链表，反转后head变成了 tail node
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        while(current != null) {
            ListNode nextNode = current.next;
            current.next = pre;
            pre = current;
            current = nextNode;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        testCase(data, 0);
        testCase(data, 1);
        testCase(data, 2);
        testCase(data, 3);
        testCase(data, 4);
        testCase(data, 5);
    }

    public static void testCase(int[] data, int k) {
        ListNode head = generateList(data);
        ListNode result = new Solution().reverseKGroup(head, k);
        System.out.println(ListNode2String(result));
    }

    public static ListNode generateList(int[] dataArray) {
        ListNode head = null;
        ListNode current = null;
        for (int data : dataArray) {
            ListNode node = new ListNode(data);
            if (current == null) {
                head = current = node;
            } else {
                current.next = node;
                current = node;
            }
        }
        return head;
    }

    public static String ListNode2String(ListNode node) {
        StringBuilder builder = new StringBuilder();
        ListNode current = node;
        while (current != null) {
            builder.append(current.val);
            builder.append("->");
            current = current.next;
        }
        builder.append("null");
        return builder.toString();
    }
}