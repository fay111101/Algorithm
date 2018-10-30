package leetcode.list;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 */
public class _19_RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) {
            return null;
        }
        ListNode dumy = new ListNode(-1);
        ListNode fast = dumy;
        ListNode slow = dumy;
        slow.next = head;
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;

        }
        slow.next = slow.next.next;
        return dumy.next;
    }


    public static void main(String[] args) {

        ListNodeCommon common = new ListNodeCommon();
        int[] data = {1, 2, 3, 4, 5};
        int[] data1 = {1, 2};
        ListNode node = common.createList(data);
        common.display(node);
        System.out.println("=====");
        _19_RemoveNthNodeFromEndOfList test = new _19_RemoveNthNodeFromEndOfList();
        ListNode nnode = test.removeNthFromEnd(node, 1);
        common.display(nnode);
    }
}
