package offer.list;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null||pHead.next==null){
            return null;
        }
        ListNode s=pHead;
        ListNode f=pHead;
        while(f!=null&&f.next!=null){

            f=f.next.next;
            s=s.next;
            if(f==null){
                return null;
            }
            if(f==s){
                break;
            }
        }

        f=pHead;
        while(f!=s){
            f=f.next;
            s=s.next;
        }
        return f;

    }
}
