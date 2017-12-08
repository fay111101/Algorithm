package leetcode.list;
/* Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list:1->2->3->4->5

For k = 2, you should return:2->1->4->3->5

For k = 3, you should return:3->2->1->4->5
测试用例:
{1,2},3

对应输出应该为:

{1,2}

你的输出为:

{2,1}

*/
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k<=1){
            return head;
        }
        ListNode cur=head;
        for(int i=0;i<k;i++){
            if(cur!=null){
                cur=cur.next;
            }else{
                return head;
            }
        }
        ListNode newHead=reverseList(head,cur);
        head.next=reverseKGroup(cur,k);
        return newHead;
    }
    private ListNode reverseList(ListNode head,ListNode tail){
        ListNode pre=null;
        ListNode next=null;
        while(head!=tail){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
