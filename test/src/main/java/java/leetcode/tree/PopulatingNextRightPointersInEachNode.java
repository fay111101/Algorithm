package leetcode.tree;
/**/
import java.util.LinkedList;

class TreeLinkNode {
   int val;
   TreeLinkNode left, right, next;
   TreeLinkNode(int x) { val = x; }
}

public class PopulatingNextRightPointersInEachNode {
    public void connect1(TreeLinkNode root) {
        if(root==null){
            return;
        }
        LinkedList<TreeLinkNode> queue=new LinkedList<>();
        queue.offer(root);
        int current=1;
        int next=0;
        while(!queue.isEmpty()){
            TreeLinkNode temp=queue.poll();
            current--;
            if(current!=0){
                temp.next=queue.peek();
            }else{
                temp.next=null;
            }
            if(root.left!=null){
                queue.offer(root.left);
                next++;
            }
            if(root.right!=null){
                queue.offer(root.right);
                next++;
            }
            if(current==0){
                current=next;
                next=0;
            }

        }

    }
    public void connect2(TreeLinkNode root){
        if(root==null){
            return;
        }
        LinkedList<TreeLinkNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                TreeLinkNode temp=queue.poll();
                if(i==len-1){
                    temp.next=null;
                }else{
                    temp.next=queue.peek();
                }
            }
            if(root.left!=null){
                queue.offer(root.left);
            }
            if(root.right!=null){
                queue.offer(root.right);
            }
        }
    }
    public void connect(TreeLinkNode root){
        TreeLinkNode levelFirst=root;
        TreeLinkNode cur=levelFirst;
        while (cur!=null){
            if(cur.left!=null){
                cur.left.next=cur.right;
            }
            if(cur.right!=null&&cur.next!=null){
                cur.right.next=cur.next.left;
            }
            if(cur.next!=null){
                cur=cur.next;
            }else{
                levelFirst=levelFirst.left;
                cur=levelFirst;
            }
        }
    }

}
