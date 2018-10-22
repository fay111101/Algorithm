package leetcode.list;


/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */

public class _148_SortList {
    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }

    public static void quickSort(ListNode head, ListNode end) {
        if(head != end) {
            ListNode partion = partion(head);
            quickSort(head, partion);
            quickSort(partion.next, end);
        }
    }
    public static void swap(ListNode m,ListNode n){

        int temp=m.val;
        m.val=n.val;
        n.val=temp;
    }
    public static ListNode partion(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if(fast.val < head.val) {
                slow = slow.next;

                //fast.val = slow.val ^ fast.val ^ (slow.val = fast.val);
                swap(fast,slow);
            }
            fast = fast.next;
        }
        //slow.val = head.val ^ slow.val ^ (head.val = slow.val);
        swap(slow,head);

        return slow;
    }


    public ListNode sortList1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode mid=getMid(head);
        ListNode next=mid.next;
        mid.next=null;
        ListNode l1,l2;
        l1=sortList(head);
        l2=sortList(next);

        return mergeList(l1,l2);
    }

    public ListNode mergeList(ListNode l1,ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        ListNode head;
        if(l1.val<=l2.val){
            head=l1;
            head.next=mergeList(l1.next,l2);
        }else{
            head=l2;
            head.next=mergeList(l1,l2.next);
        }

        return head;
    }

    public static ListNode getMid(ListNode head) {
//        StackOverflow Error
        if(head==null||head.next==null){
            return head;
        }
        ListNode fast=head,slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
//        ListNode slow=head;
//        ListNode fast=head;
//        while(fast.next!=null&&fast.next.next!=null)
//        {
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        return slow;
    }

    public static void main(String[] args){
        ListNodeCommon l=new ListNodeCommon();
//        int[] data={1};
//        int[] data={9,9,9};
        int[] data={4,2,1,3};
        ListNode head=l.createList(data);
        _148_SortList s=new _148_SortList();
        ListNode tmp=_148_SortList.getMid(head);
        System.out.println(tmp.val);
//        head=s.sortList1(head);
        head=s.sortList(head);
        l.display(head);

    }
}
