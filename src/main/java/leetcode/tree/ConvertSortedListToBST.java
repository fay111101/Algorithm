package leetcode.tree;
/*Given a singly linked list where elements are sorted
 in ascending order, convert it to a height balanced BST.
*/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class ConvertSortedListToBST{
    public TreeNode sortedListToBST(ListNode head){
        if(head==null){
            return null;
        }
        return BST(head,null);
    }

    public TreeNode BST(ListNode head,ListNode tail){
        if(head==tail){
            return null;
        }
        ListNode fast=head,slow=head;
        while(fast!=tail&&fast.next!=tail){
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode root=new TreeNode(slow.val);
        root.left=BST(head,slow);
        root.right=BST(slow.next,tail);
        return root;
    }
}
