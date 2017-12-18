package leetcode.list;
/*Given a linked list, return the node where the cycle begins. If there is
no cycle, returnnull.
Follow up:
Can you solve it without using extra space?*/
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode fast=head.next.next,slow=head.next;
        while(fast!=slow){
            slow=slow.next;
            if(fast.next==null||fast.next.next==null){
                return null;
            }
            fast=fast.next.next;
        }
        fast=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}
