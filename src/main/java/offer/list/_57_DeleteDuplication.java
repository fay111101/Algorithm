package offer.list;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class _57_DeleteDuplication {

    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) return pHead;

        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode curr = pHead;
        ListNode pre = dummy;

        while (curr != null) {
            while (curr.next != null && curr.next.val == curr.val) {
                curr = curr.next;
            }
            if (pre.next == curr) {
                pre = pre.next;
            } else {
                pre.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
