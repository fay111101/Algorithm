package leetcode.list;

/**
 *Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class _206_ReverseLinkedList {
    //逐点反转
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
    //插入思想
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

    //递归思想
    public static ListNode reverse2(ListNode head){


        return null;
    }


    public static void main(String[] args) {
        ListNodeCommon list = new ListNodeCommon();
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode head = list.createList(data);
//        list.display(_206_ReverseLinkedList.reverse(head));
//        list.display(_206_ReverseLinkedList.reverse1(head));
    }

}
