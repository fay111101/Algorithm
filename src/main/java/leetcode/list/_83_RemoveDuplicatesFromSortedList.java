package leetcode.list;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 *  Example 1:
 *
 *  Input: 1->1->2
 *  Output: 1->2
 *  Example 2:
 *
 *  Input: 1->1->2->3->3
 *  Output: 1->2->3
 */

public class _83_RemoveDuplicatesFromSortedList {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (head != null) {
            while (head != null && head.val == val) {
                head = head.next;
            }
            pre.next = head;
            if (head != null) {
                head = head.next;
            }
            pre = pre.next;
            if (dummy.next == null) {
                dummy.next = pre;
            }
        }
        return dummy.next;
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
                if (fast == null) {
                    slow.next = null;
                }
            } else {

                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        return head;
    }

    public ListNode insertT(ListNode head, int data) {
        ListNode n = new ListNode(data);
        n.next = head;
        head = n;
        return head;
    }

    public ListNode insertH(ListNode head, int data) {
        ListNode n = new ListNode(data);
        ListNode cur = head;
        if (head == null) {
            n.next = null;//n.next=head
            head = n;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = n;
        }
        return head;
    }

    public void display(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        _83_RemoveDuplicatesFromSortedList test = new
                _83_RemoveDuplicatesFromSortedList();
        ListNode head = null;
        int[] data = {-1, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7, 7};
        for (int i : data) {
            head = test.insertH(head, i);
        }
        test.display(head);
        System.out.println("====");
        test.deleteDuplicates(head);
        System.out.println("====");
        test.display(head);

    }
}
