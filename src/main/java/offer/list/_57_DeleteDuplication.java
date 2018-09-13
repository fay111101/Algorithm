package offer.list;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class _57_DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        ListNode head=new ListNode(-1);
        ListNode tail=head;
        tail.next=pHead;
        ListNode cur=pHead;
        while(cur!=null){
            if(cur.next!=null&&(cur.next.val==cur.val)){
                while(cur.next!=null&&cur.next.val==cur.val){
                    cur=cur.next;
                }
                cur=cur.next;
                tail.next=cur;
            }else{
                cur=cur.next;
                tail=tail.next;
            }

        }
        return head.next;
    }
}
