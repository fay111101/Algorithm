package leetcode.list;

/*
Given a singly linked list L: L 0→L 1→…→L n-1→L n,
reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
You must do this in-place without altering the nodes' values.
For example,
Given{1,2,3,4}, reorder it to{1,4,2,3}.
*/
public class _143_ReOrderList {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null){
            return;
        }

        ListNode p = head, q = head, preq = null, pnext = null;
        while (q.next != null) {
            preq = q;
            q = q.next;
        }
        while (p != null) {
            if (p.next != null) {
                pnext = p.next;
                p.next = q;
                q.next = pnext;
                preq.next = null;
                p=pnext;
                q=preq;
                if(p.next==q){
                    return;
                }
                preq = getPre(head, q);

            }
            if(pnext==q){
                return;
            }

        }
    }

    public ListNode getPre(ListNode head, ListNode current) {
        while (head != null) {
            if (head.next != null && head.next == current) {
                return head;
            }
            head = head.next;
        }
        return null;
    }


    public void reorderList1(ListNode head) {
        ListNode mid=getMid(head);
        ListNode next=mid.next;
        mid.next=null;
        ListNode l2=reversList(next),l1=head;



        ListNode l1next,l2next;
        while(l2!=null){
            l1next=l1.next;
            l2next=l2.next;
            l1.next=l2;
            l2.next=l1next;
            l2=l2next;
            l1=l1next;
        }

    }

    public ListNode getMid(ListNode head){
        if(head==null){
            return head;
        }

        ListNode fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public ListNode reversList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre=null,cur=head,next;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNodeCommon common = new ListNodeCommon();
        int[] data = {1,2,3,4,5};
        ListNode node = common.createList(data);
        common.display(node);
        System.out.println("=====");
        _143_ReOrderList test = new _143_ReOrderList();
        test.reorderList1(node);
        common.display(node);
    }
}
