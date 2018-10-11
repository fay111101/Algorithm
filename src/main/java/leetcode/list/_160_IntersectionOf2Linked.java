package leetcode.list;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 *
 * For example, the following two linked lists:
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 *
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class _160_IntersectionOf2Linked {
      public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        ListNode aP=headA,bP=headB,res=null;
        int a=0,b=0;
        while(aP!=null){
            a++;
            aP=aP.next;
        } 
        while(bP!=null){
            b++; 
            bP=bP.next;
        } 
        while(a>b){
            headA=headA.next;
            a--;
        }
        while(a<b){
            headB=headB.next;
            b--;
        }
        while(headA!=null&&headB!=null){
            if(headA==headB) return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return res;
    }

}
