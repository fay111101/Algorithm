package leetcode.list;

/* Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given1->2->3->4, you should return the list as2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in
 the list, only nodes itself can be changed. */

public class _24_SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = new ListNode(-1);
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            pre.next = curr.next;
            if (pre.val == -1) {
                head = head.next;
            }
            pre = curr;
            ListNode temp = curr.next.next;
            curr.next.next = curr;
            curr.next = temp;
            curr = temp;
        }
        return head;

    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy, tmp, cur = head;
        dummy.next = head;

        while (cur != null && cur.next != null) {
            tmp = cur.next.next;
            cur.next.next = cur;
            pre.next = cur.next;
            cur.next = tmp;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNodeCommon common = new ListNodeCommon();
        int[] data = {1, 2, 3, 4, 5};
        int[] data1 = {1, 2, 3, 4};
        int[] data2 = {1, 2};
        ListNode node = common.createList(data2);
        common.display(node);
        System.out.println("=====");
        _24_SwapNodesInPairs test = new _24_SwapNodesInPairs();
        ListNode head = test.swapPairs(node);
        common.display(head);
    }
}
