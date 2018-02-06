package offer.list;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
 class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class CopyRandomList {
    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode p=pHead;
        RandomListNode q=pHead;
        //复制节点
        while(p!=null){
            RandomListNode node=new RandomListNode(p.label);
            RandomListNode next=p.next;
            p.next=node;
            node.next=next;
            p=next;
        }
        //将random指针链接上
        while(q!=null){
            RandomListNode next=q.next;
            if(q.random!=null){
                next.random=q.random.next;
            }
            q=next.next;
        }
        //断开两个链表的链接
        RandomListNode head=new RandomListNode(-1);
        RandomListNode tail=head;
        p=pHead;
        while(p!=null){
            RandomListNode t=p.next;
            p.next=t.next;
            t.next=tail.next;
            tail.next=t;
            tail=t;
            p=p.next;
        }
        return head.next;
    }
}
