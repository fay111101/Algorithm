package leetcode.list;


import java.util.HashMap;

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

public class _138_RandomPointer {

    public RandomListNode copyRandomList1(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new
                HashMap<RandomListNode, RandomListNode>();
        RandomListNode p = head;
        while (p != null) {
            map.put(p, new RandomListNode(p.label));

            p = p.next;
        }
        p = head;
        RandomListNode newl;
        while (p != null) {
            newl = map.get(p);
            newl.next = map.get(p.next);
            newl.random = map.get(p.random);
            p = p.next;
        }


        return map.get(head);
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null)
            return null;
        // 1.遍历链表，复制节点，并将复制的节点放到原节点的后面
        RandomListNode h = head;
        while (h != null) {
            RandomListNode copy = new RandomListNode(h.label);
            RandomListNode next = h.next;
            h.next = copy;
            copy.next = next;
            h = next;
        }
        // 2.遍历链表，更改链表的random节点
        h = head;
        while (h != null) {
            if (h.random != null) {
                h.next.random = h.random.next;
            }
            h = h.next.next;
        }
        // 3.遍历节点，将原链表与复制链表断开
        h = head;
        RandomListNode newHead = h.next,copy;
        while (h != null) {
//            copy = h.next;
//            h.next = copy.next;
//            h = h.next;
//            copy.next = h != null ? h.next : null;
            copy=h.next;
            h.next=copy.next;
            if(h.next==null) copy.next=null;
            else copy.next=h.next.next;
            h=h.next;
        }
        return newHead;
    }




}
