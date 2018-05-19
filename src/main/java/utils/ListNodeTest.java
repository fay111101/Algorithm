<<<<<<< HEAD:test/src/main/java/utils/ListNodeTest.java
package utils;

public class ListNodeTest {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int data) {
            this.val = data;
        }
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
    public ListNode insertT(ListNode head,int data){
        ListNode n=new ListNode(data);
        n.next=head;
        head=n;
        return head;
    }
    public ListNode delete(ListNode head,int data){
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
    public void display(ListNode head){
        ListNode cur=head;
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
    public ListNode createList(int[] data){
        ListNode head = null;
        for (int i : data) {
            head = insertH(head, i);
        }
        return head;
    }
    public static void main(String[] args){
        ListNodeTest test=new ListNodeTest();
        /*Scanner sc=new Scanner(System.in);
        utils.ListNode head=null;
        int dataLength=sc.nextInt();
        while(dataLength-->0){
            int data=sc.nextInt();
            head=test.insertT(head,data);
        }
         sc.close();*/

        ListNode head = null;
        int[] data = {-5, 0, 1, 5, -2, -6};
        head=test.createList(data);
        test.display(head);


    }
=======
import java.util.Scanner;

public class ListNodeTest {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int data) {
            this.val = data;
        }
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
    public ListNode insertT(ListNode head,int data){
        ListNode n=new ListNode(data);
        n.next=head;
        head=n;
        return head;
    }
    public ListNode delete(ListNode head,int data){
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
    public void display(ListNode head){
        ListNode cur=head;
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
    public ListNode createList(int[] data){
        ListNode head = null;
        for (int i : data) {
            head = insertH(head, i);
        }
        return head;
    }
    public static void main(String[] args){
        ListNodeTest test=new ListNodeTest();
        /*Scanner sc=new Scanner(System.in);
        ListNode head=null;
        int dataLength=sc.nextInt();
        while(dataLength-->0){
            int data=sc.nextInt();
            head=test.insertT(head,data);
        }
         sc.close();*/

        ListNode head = null;
        int[] data = {-5, 0, 1, 5, -2, -6};
        head=test.createList(data);
        test.display(head);


    }
>>>>>>> 29e5412baafe1c3e828bcc824210d0be06cdac0c:test/src/main/java/ListNodeTest.java
}