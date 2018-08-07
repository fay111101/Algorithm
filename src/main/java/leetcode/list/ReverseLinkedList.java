package leetcode.list;

public class ReverseLinkedList {
    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newP = null, next;
        while (head != null) {
            next = head.next;
            head.next = newP;
            newP = head;
            head = next;
        }
        return newP;
    }

    public static ListNode reverse1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode insert = head.next, nextP;
        while (insert != null) {
            nextP = insert.next;
            insert.next = head;
            head = insert;
            insert = nextP;
        }
        return insert;
    }

    public static ListNode reverse2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode footer = head, insert = footer.next;
        while (insert != null) {
            footer.next=insert.next;
            insert.next=head;
            head=insert;
            insert=footer.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNodeCommon list = new ListNodeCommon();
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode head = list.createList(data);
//        list.display(ReverseLinkedList.reverse(head));
//        list.display(ReverseLinkedList.reverse1(head));
        list.display(ReverseLinkedList.reverse2(head));
    }

}
