package leetcode.list;

import java.util.HashMap;

/*
* A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.*/
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return null;
        }
        HashMap<RandomListNode,RandomListNode> map=new
                HashMap<RandomListNode,RandomListNode>();
        RandomListNode p=head;
        while(p!=null){
            map.put(p,new RandomListNode(p.label));

            p=p.next;
        }
        p=head;
        RandomListNode newl;
        while(p!=null){
            newl=map.get(p);
            newl.next=map.get(p.next);
            newl.random=map.get(p.random);
            p=p.next;
        }


        return map.get(head);
    }
}
