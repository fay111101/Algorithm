package leetcode.list;

/*Given a linked list, determine if it has a cycle in it.
Follow up:
Can you solve it without using extra space?*/
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode slow = head.next, fast = head.next.next;
        //若slow=head fast=head,此时牛客中不能通过所有的测试用例
        while (fast != null) {
            if (fast == null || fast.next == null) {
                return false;
            }
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
