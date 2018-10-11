package offer.list;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class _15_FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(k<=0){
            return null;
        }
        ListNode p1=head;
        ListNode p2=head;
        for(int i=0;i<k-1;i++){
            if(p2==null){
                return null;
            }
            p2=p2.next;

        }
        if(p2==null){
            return null;
        }
        while(p2.next!=null){
            p2=p2.next;
            p1=p1.next;
        }

        return p1;

    }
}
