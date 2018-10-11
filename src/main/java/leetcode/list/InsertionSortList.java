package leetcode.list;

/**
 * Sort a linked list using insertion sort.
 * Algorithm of Insertion Sort:
 *
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 */
public class InsertionSortList {
    //2018-8-23
    public ListNode insertionSortList2(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        ListNode insert=head.next, curr, pre, tmp;
        head.next = null;//断开两个节点的处理

        while(insert!=null){
            curr=dummy.next;
            pre=dummy;
            while(curr != null && insert.val > curr.val &&curr.next!=insert){
                pre=curr;
                curr=curr.next;
            }
            tmp=insert.next;
            insert.next=curr;
            pre.next=insert;
            insert=tmp;
        }
        return dummy.next;

    }


    public static void main(String[] args) {
        InsertionSortList test = new InsertionSortList();
        ListNodeCommon utils=new ListNodeCommon();

        ListNode head = null;
        int[] data = {-5, 0, 1, 5, -2, -6};
        for (int i : data) {
            head = utils.insertH(head, i);
        }

        //System.out.println("-----");
        utils.display(head);
        head = test.insertionSortList2(head);
//        head = test.insertionSortList(head);
        System.out.println("-----");
        utils.display(head);


    }


}
