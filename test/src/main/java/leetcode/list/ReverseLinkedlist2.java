package leetcode.list;

/**
 * Created by fay on 2017/12/7.
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given1->2->3->4->5->NULL, m = 2 and n = 4,
 * return1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedlist2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode pre = dummy;
        ListNode nNode = null;
        ListNode mNode = null;
        for (int i = 1; i <= m - 1; i++) {
            if (cur != null) {
                cur = cur.next;
            }
        }
        pre = cur;
        mNode = cur.next;
        for (int i = m; i <= n; i++) {
            cur = pre.next;
            pre.next = cur.next;
            cur.next = nNode;
            nNode = cur;
        }
        cur = pre.next;
        pre.next = nNode;
        mNode.next = cur;
        return dummy.next;


    }
}
