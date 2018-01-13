package offer.list;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 *
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre=null,cur=head;
        ListNode newHead=null;
        while(cur!=null){
            if(cur.next==null){
                newHead=cur;

            }
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;

        }
        return newHead;

    }
}
