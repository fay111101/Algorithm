package utils;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
        next=null;
    }
}
public class LeetcodeHelper {
    public ListNode sortList(ListNode head) {
        ListNode lastNode=getLast(head);
        System.out.println("lastNode "+lastNode.val);
        System.out.println("head "+head.val);
        quickSort(head,head,lastNode);
        return head;
    }
    public void quickSort(ListNode head,ListNode p,ListNode r){


        if(!p.next.equals(r)&&r!=null){
            ListNode x=partition(head,p,r);
            if(x!=null){
                System.out.println("quickSort "+x.val);
//            quickSort(head,p,);
                ListNode xPre=getPre(head,x);
                quickSort(head,p,xPre);
                quickSort(head,x.next,r);
            }

        }
    }
    public void swap(ListNode u,ListNode v){
        int temp=u.val;
        u.val=v.val;
        v.val=temp;

    }
    public int getVal(ListNode head,int index){
        ListNode p=head;
        for(int i=0;i<index;i++){
            p=p.next;
        }
        return p.val;
    }
    public ListNode getLast(ListNode head){
        ListNode p=head;
        while(p.next!=null){
            p=p.next;
        }
        return p;
    }
    public ListNode getPre(ListNode head,ListNode n){
        ListNode p=head;

        while(p!=null){
            if (p.next!=null&&p.next.equals(n)) {

                return p;
            }
            p=p.next;
        }
        return p;
    }
    public ListNode partition(ListNode head,ListNode p,ListNode r){

        ListNode x=r;
        ListNode i=new ListNode(-1);
        i.next=head;
        ListNode rPr=getPre(head,r);
        for(ListNode j=head;!j.equals(rPr);j=j.next){
            System.out.println("j "+j.val);
            System.out.println("x "+x.val);
            if(j.val<x.val){
                i=i.next;
                swap(i,j);
            }

        }
        swap(i.next,x);
        //System.out.println(i.val);
        //System.out.println(i.next.val);
        return i.next;

    }
    public ListNode creatList(int[] arr){
        ListNode head=null;
        ListNode p=head;
        for(int i=0;i<arr.length;i++){
            ListNode node=new ListNode(i);
            if(i==0){
                head=node;

            }

        }
        return head;
    }
    public  ListNode insertH(ListNode head,int data){
        ListNode n=new ListNode(data);
        ListNode cur=head;
        if(head==null){
            n.next=null;//n.next=head
            head=n;
        }else{
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=n;
        }
        return head;
    }
    public static void main(String[] args){
        LeetcodeHelper test=new LeetcodeHelper();
        ListNode head=null;
        int[] arr={10,2,4,1,3,6,7,8,-1,0};
        for(int i:arr){
            head=test.insertH(head,i);
        }
        ListNode p=head;
        while(p!=null){
            //System.out.println(p.val);
            p=p.next;
        }
        test.sortList(head);
    }
}