package offer.list;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null){
            return null;
        }
        ListNode p1=pHead1,p2=pHead2;
        int len1=0,len2=0;
        while(p1!=null){
            len1++;
            p1=p1.next;
        }
        while(p2!=null){
            len2++;
            p2=p2.next;
        }
        int flag=len2-len1;
        p1=pHead1;
        p2=pHead2;
        if(flag>0){
            while(flag>0&&p2!=null){
                p2=p2.next;
                flag--;
            }

        }else{
            flag=len1-len2;
            while(flag>0&&p1!=null){
                p1=p1.next;
                flag--;
            }
        }
        while(p1!=null&&p2!=null){
            if(p1.val==p2.val){
                return p1;
            }else{
                p1=p1.next;
                p2=p2.next;
            }
        }
        return null;
    }
}
