package leetcode.list;

/*
Given a singly linked list L: L 0→L 1→…→L n-1→L n,
reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
You must do this in-place without altering the nodes' values.
For example,
Given{1,2,3,4}, reorder it to{1,4,2,3}.
*/
public class ReOrderList {
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

    public static void main(String[] args) {
        ListNodeCommon common = new ListNodeCommon();
        int[] data = {1,2,3,4,5};
        ListNode node = common.createList(data);
        common.display(node);
        System.out.println("=====");
        ReOrderList test = new ReOrderList();
        test.reorderList(node);
        common.display(node);
    }
}
