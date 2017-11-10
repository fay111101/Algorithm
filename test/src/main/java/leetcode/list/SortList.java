package leetcode.list;

public class SortList {
    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }

    public static void quickSort(ListNode head, ListNode end) {
        if(head != end) {
            ListNode partion = partion(head);
            quickSort(head, partion);
            quickSort(partion.next, end);
        }
    }
    public static void swap(ListNode m,ListNode n){

        int temp=m.val;
        m.val=n.val;
        n.val=temp;
    }
    public static ListNode partion(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if(fast.val < head.val) {
                slow = slow.next;

                //fast.val = slow.val ^ fast.val ^ (slow.val = fast.val);
                swap(fast,slow);
            }
            fast = fast.next;
        }
        //slow.val = head.val ^ slow.val ^ (head.val = slow.val);
        swap(slow,head);

        return slow;
    }
}
