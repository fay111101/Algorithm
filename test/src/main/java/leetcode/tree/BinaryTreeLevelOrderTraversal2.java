package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Given a binary tree, return the bottom-up level order traversal of its nodes'
values. (ie, from left to right, level by level from leaf to root).
For example:
Given binary tree{3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
]

confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on
 OJ.*/
public class BinaryTreeLevelOrderTraversal2 {
    public  ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode
                                                                         root) {

        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> res=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp=queue.poll();
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
                res.add(temp.val);
            }
            result.add(0,res);
        }
        return result;
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
        BinaryTreeLevelOrderTraversal2 test=new
                BinaryTreeLevelOrderTraversal2();
        ArrayList<ArrayList<Integer>> res=test.levelOrderBottom(root);
        for(ArrayList<Integer> arr:res){
            System.out.println("level");
            //System.out.println(arr.size());

            for(int i:arr){
                System.out.println(i);
            }

        }

    }
}