package leetcode.list;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class _203_RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(-1);
        ListNode pre=dummy;
        while(head!=null){
            while(head!=null&&head.val==val){
                head=head.next;
            }
            pre.next=head;
            if(head!=null){
                head=head.next;
            }
            pre=pre.next;
            if(dummy.next==null){
                dummy.next=pre;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode pre=head;
        ListNode curr=head.next;
        while(curr!=null){
            while(curr!=null&&pre.val!=curr.val){
                pre.next=curr;
                pre=curr;
                curr=curr.next;
            }
            if(curr!=null){
                curr=curr.next;
            }
        }
        if(curr==null){
            pre.next=null;
        }
        return head;
    }
}
