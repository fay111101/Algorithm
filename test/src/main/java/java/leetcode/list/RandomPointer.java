package leetcode.list;


import java.util.*;

class RandomListNode{
    int label;
    RandomListNode next,random;
    RandomListNode(int x){
        this.label=x;
    }
}
public class RandomPointer {

    public RandomListNode copyRandomList(RandomListNode head){
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
