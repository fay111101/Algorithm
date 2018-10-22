package leetcode.list;
import utils.*;

/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of
their nodes contain a single digit. _47_Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
* */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
            return null;
        }
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        int carry=0;
        int num;
        while(l1!=null&&l2!=null){
            num=l1.val+l2.val+carry;
            carry=num>=10?1:0;
            num=num>=10?num-10:num;
            curr.next=new ListNode(num);
            curr=curr.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null||l2!=null){
            if(l1!=null){
                num=l1.val+carry;
            }else{
                num=l2.val+carry;
            }
            carry=num>=10?1:0;
            num=num>=10?num-10:num;
            curr.next=new ListNode(num);
            curr=curr.next;
            if(l1!=null){
                l1=l1.next;
            }else{
                l2=l2.next;
            }
        }
//        while(l2!=null){
//            num=l2.val+carry;
//            carry=num>=10?1:0;
//            num=num>=10?num-10:num;
//            curr.next=new ListNode(num);
//            curr=curr.next;
//            l2=l2.next;
//        }
        if(carry!=0){
            curr.next=new ListNode(carry);
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;
            int sum = d1 + d2 + carry;
            carry = sum >= 10 ? 1 : 0;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) cur.next = new ListNode(1);
        return dummy.next;
    }


    public static void main(String[] args){
        ListNodeCommon l=new ListNodeCommon();
//        int[] data={1};
//        int[] data={9,9,9};
        int[] data={2,4,3};
        ListNode l1=l.createList(data);
//        int[] data1={9,9};
//        int[] data1={1};
        int[] data1={5,6,4};

        ListNode l2=l.createList(data1 );
        l.display(AddTwoNumbers.addTwoNumbers(l1,l2));


    }
}
