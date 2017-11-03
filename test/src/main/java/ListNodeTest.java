

public class ListNodeTest {
    class Node{
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
    public static Node reverseList(Node head){
        Node next=null;
        Node pre=null;
        while(head!=null){
            next=head.next;
            next.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
    public Node removeRep(Node head){

        Node cur=head;
        Node pre=null;
        Node next=cur.next;
        while(cur!=null){
            while(next!=null){
                if(cur.data==next.data){
                    cur=next;
                    next=next.next;
                }else{
                    pre=cur;
                    cur=next;
                    next=next.next;
                    break;
                }
            }
            cur=cur.next;

        }
        return cur;
    }
    /*
    *
    *
    * public ListNode deleteDuplication(ListNode pHead)
    {
		if(pHead==null){
            return null;
        }
        ListNode cur=pHead;
        ListNode next=cur.next;
        ListNode pre=null;
        while(cur!=null){
            while(next!=null){
                if(cur.val==next.val){
                    cur=next;
                    next=next.next;

                }else{
                    pre=cur;
                    cur=next;
                    next=next.next;
                    break;

                }
            }
            cur=cur.next;
        }
        return pHead;
    }
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

    public class Solution {
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
    }*/
}
