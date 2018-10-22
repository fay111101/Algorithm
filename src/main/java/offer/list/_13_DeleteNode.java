package offer.list;

/**
 * 在O（1）时间内删除一个单链表的节点
 */
public class _13_DeleteNode {

    public void deleteNode(ListNode head,ListNode deListNode){
        if(deListNode == null || head == null){
            return ;
        }
        if(head == deListNode){
            head =null;
        }
        else{
            //要删除的节点时尾节点
            if(deListNode.next == null){
                ListNode pinitListNode = head;
                while(pinitListNode.next.next != null){
                    pinitListNode = pinitListNode.next;
                }
                pinitListNode.next = null;
            }else{
                //要删除的不是尾节点
                deListNode.val = deListNode.next.val;
                deListNode.next = deListNode.next.next;
            }
        }
    }

}
