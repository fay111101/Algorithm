package offer.list;
class ListNode implements Comparable<ListNode>{
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public int compareTo(ListNode other) {
        return val-other.val;
    }
}

public class ListNodeCommon {
    public ListNode insertT(ListNode head, int data) {
        ListNode n = new ListNode(data);
        n.next = head;
        head = n;
        return head;
    }

    public ListNode insertH(ListNode head, int data) {
        ListNode n = new ListNode(data);
        ListNode cur = head;
        if (head == null) {
            n.next = null;//n.next=head
            head = n;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = n;
        }
        return head;
    }

    public void display(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    public ListNode delete(ListNode head, int data){
        ListNode cur=head;
        ListNode pre=null;
        while(null!=cur){
            if(cur.val==data){
                ListNode del=cur;
                cur=cur.next;
                if(null!=pre){
                    pre.next=cur;
                }else{
                    //head del
                    head=cur;
                }
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        return head;
    }
    public ListNode createList(int[] data){
        ListNode head = null;
        for (int i : data) {
            head = insertH(head, i);
        }
        return head;
    }

}
