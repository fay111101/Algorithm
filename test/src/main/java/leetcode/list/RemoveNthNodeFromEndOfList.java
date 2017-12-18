package leetcode.list;

public class RemoveNthNodeFromEndOfList {
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
        RemoveNthNodeFromEndOfList test = new RemoveNthNodeFromEndOfList();
        ListNode nnode = test.removeNthFromEnd(node, 1);
        common.display(nnode);
    }
}
