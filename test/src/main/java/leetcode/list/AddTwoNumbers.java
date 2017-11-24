package leetcode.list;
/**/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
            return null;
        }
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        int carry=0;
        int num=0;
        while(l1!=null&&l2!=null){
            num=l1.val+l2.val+carry;
            carry=num>=10?1:0;
            num=num>=10?num-10:num;
            curr.next=new ListNode(num);
            curr=curr.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            num=l1.val+carry;
            carry=num>=10?1:0;
            num=num>=10?num-10:num;
            curr.next=new ListNode(num);
            curr=curr.next;
            l1=l1.next;
        }
        while(l2!=null){
            num=l2.val+carry;
            carry=num>=10?1:0;
            num=num>=10?num-10:num;
            curr.next=new ListNode(num);
            curr=curr.next;
            l2=l2.next;
        }
        if(carry!=0){
            curr.next=new ListNode(carry);
        }
        return dummy.next;
    }
}
