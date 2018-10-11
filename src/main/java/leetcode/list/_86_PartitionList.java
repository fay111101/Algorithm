package leetcode.list;

/**
 * Created by fay on 2017/12/8.
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or
 * equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given1->4->3->2->5->2and x = 3,
 * return1->2->2->4->3->5.
 */
public class _86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        //找到前半段比x小的最后一个数
        while (pre.next != null && pre.next.val < x) {
            pre = pre.next;
        }
        cur = pre;
        while (cur.next != null) {
            if (cur.next.val >= x) {
                cur = cur.next;
            } else {
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    public ListNode partition1(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode curr1 = dummy1;
        ListNode curr2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = curr1.next;
            } else {
                curr2.next = head;
                curr2 = curr2.next;
            }
            head = head.next;
        }
        curr2.next = null;//这句很重要！链表最后一个元素如果小于x的话，那么curr2.next不为null
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}
