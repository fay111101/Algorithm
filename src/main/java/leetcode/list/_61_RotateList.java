package leetcode.list;

/**
 * Created by fay on 2017/12/8.
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given1->2->3->4->5->NULLand k =2,
 * return4->5->1->2->3->NULL.
 */
public class _61_RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        int n = 1;
        //由于n可能大于链表的总长度，需要求出链表长度，n%(链表长度)
        while (cur.next != null) {
            n++;
            cur = cur.next;
        }
        cur.next = head;
        k = k % n;
        for (int i = 0; i < n - k; i++) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
    }


    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int n = 0;
        ListNode cur = head, newH, tail = null;
        while (cur != null) {
            if (cur.next == null) {
                tail = cur;
            }
            cur = cur.next;
            n++;
        }

        cur = head;
        k = k % n;
        for (int i = n - k; i > 1; i--) {
            cur = cur.next;
        }

        if (cur.next != null) {
            newH = cur.next;
        } else {
            return head;
        }


        cur.next = null;
        tail.next = head;

        return newH;
    }
}
