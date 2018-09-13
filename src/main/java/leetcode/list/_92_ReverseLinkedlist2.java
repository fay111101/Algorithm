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

public class _92_ReverseLinkedlist2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, next;
        ListNode curr = head;
        for (int i = 1; i <= m - 1; i++) {
            if (curr != null) {
                pre = curr;
                curr = curr.next;
            }
        }
        //每次改变next指针，pre始终指向已经插入的节点，头节点插入法，每次执行插入
        for (int i = m; i < n; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
