package leetcode.tree;

import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNode2 {
    //内存超限？？？？
    public void connect1(TreeLinkNode root) {
        TreeLinkNode level = root, cur = level;
        while (cur != null) {
            if (cur.left != null) {
                cur.left.next = cur.right;
            }
            if (cur.right != null && cur.next != null) {
                if (cur.next.left != null) {
                    cur.right.next = cur.next.left;
                } else {
                    cur.right.next = cur.next.right;
                }

            }
            if (cur.next != null) {
                cur = cur.next;
            } else {
                level = level.left;
                cur = level;
            }
        }
    }

    //内存超限
    public void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        int current = 1;
        int next = 0;
        while (!queue.isEmpty()) {
            TreeLinkNode temp = queue.poll();
            current--;
            if (current != 0) {
                temp.next = queue.peek();
            } else {
                temp.next = null;
            }
            if (root.left != null) {
                queue.offer(root.left);
                next++;
            }
            if (root.right != null) {
                queue.offer(root.right);
                next++;
            }
            if (current == 0) {
                current = next;
                next = 0;
            }

        }

    }
    //内存超限
    public void connect3(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeLinkNode curlevel=root,nextlevel=root,last=null;
        while (!queue.isEmpty()) {
            TreeLinkNode temp = queue.poll();
            if(last!=null){
                last.next=temp;
            }
            if(temp==curlevel){
                temp.next=null;
                last=null;
            }else{
                last=temp;
            }
            if(temp.left!=null){
                nextlevel=temp.left;
                queue.add((temp.left));
            }
            if(temp.right!=null){
                nextlevel=temp.right;
                queue.add(temp.right);
            }
            if(temp==curlevel){
                curlevel=nextlevel;
            }

        }

    }
    

}
