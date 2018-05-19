package leetcode.list;
/*
http://blog.csdn.net/willduan1/article/details/50938210 
推导：
假设
1.s代码快慢指针在环中相遇点距离链表起始位置的距离，即慢指针走的距离
2.n代码快指针绕的圈数，r代码环的长度，a代表链表起始位置到环入门结点的距离
3.链表长度设为L，开始点为h，环入口为d，相遇点为c，dc距离为x
2s=s+nr
s=nr（1）
a+x=s （2）
结合（1）和（2）
a+x=nr
a+x=(n-1)r+r
又因为r=L-a
a=(n-1)r+(L-a-x)
所以就有hd等于cd
Given a linked list, return the node where the cycle begins. If there is
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
