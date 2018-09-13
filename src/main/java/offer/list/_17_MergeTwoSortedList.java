package offer.list;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class _17_MergeTwoSortedList {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode p = list1, q = list2;
        ListNode head = new ListNode(-1);
        ListNode tail = head;

        while (p != null && q != null) {
            if (p.val < q.val) {
                tail.next = p;
                tail = p;
                p = p.next;
            } else {
                tail.next = q;
                tail = q;
                q = q.next;
            }
        }
        if (p != null) {
            tail.next = p;
        }

        if (q != null) {
            tail.next = q;
        }
        return head.next;
    }
}
