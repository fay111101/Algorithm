package leetcode.list;

/**
 * Given a sorted linked list, delete all nodes that have _51_duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class _82_RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head;
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

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head.next;
        boolean flag = false;
        while (fast != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
                if (fast == null) {
                    pre.next = null;
                }
                flag = true;
            } else {

                if (flag) {
                    if (pre == null) {
                        head = fast;
                    } else {
                        pre.next = fast;
                    }
                    flag = false;
                } else {
                    pre = slow;
                }

                slow = fast;
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
        _82_RemoveDuplicatesFromSortedList2 test = new
                _82_RemoveDuplicatesFromSortedList2();
        ListNode head = null;
        int[] data = {2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7, 7, 7, 8};
        for (int i : data) {
            head = test.insertH(head, i);
        }
        test.display(head);
        System.out.println("====");
        head = test.deleteDuplicates(head);
        test.display(head);

    }
}
