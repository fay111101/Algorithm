package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeLevelOrderTraversal {
    static ArrayList<ArrayList<Integer>> res = new
            ArrayList<ArrayList<Integer>>();

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return res;
        }
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        int current=1;
        int next=0;
        ArrayList<Integer> resl=new ArrayList<Integer>();
        while(!q.isEmpty()){
            TreeNode n=q.poll();
            resl.add(n.val);
            current--;
            if(n.left!=null){
                q.offer(n.left);
                next++;
            }
            if(n.right!=null){
                q.offer(n.right);
                next++;
            }
            if(current==0){
                res.add(resl);
                resl=new ArrayList<Integer>();
                current=next;
                next=0;
            }

        }
        return res;
    }
    public static TreeNode createTree(TreeNode node, Scanner scanner) {
        int data = scanner.nextInt();
        if (data == 0) {
            return null;
        } else {
            node = new TreeNode(data);
            node.setLeft(createTree(node.getLeft(), scanner));
            node.setRight(createTree(node.getRight(), scanner));
        }

        return node;
    }

    public static void main(String[] args) {

        TreeNode root = null;
        Scanner scanner = new Scanner(System.in);
        root = createTree(root, scanner);
        int array[] = {23,10,0,88,0,0,15,0,34,0,0};
        ArrayList<ArrayList<Integer>> res=levelOrder(root);
        for(ArrayList<Integer> arr:res){
            System.out.println("level");
            //System.out.println(arr.size());

            for(int i:arr){
                System.out.println(i);
            }

        }

    }
}
