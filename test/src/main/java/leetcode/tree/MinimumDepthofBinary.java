package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MinimumDepthofBinary {
    public int run(TreeNode root) {

        if(root==null){
            return 0;
        }
        int left=run(root.left);
        int right=run(root.right);
        return Math.min(left,right)+1;
    }

    public int run1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int high = 1;
        int current = 1;
        int next = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            current--;

            //此情况为从左到右的情况
            if (n.left != null) {
                q.offer(n.left);
                next++;
            }
            if (n.right != null) {
                q.offer(n.right);
                next++;
            }
            if(n.left==null&&n.right==null){
                return high;
            }
            if (current == 0) {
                high++;
                current = next;
                next = 0;
            }
        }
        return high;
    }

    public int run2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int high = 1;
        int current = 1;
        int next = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            current--;

            //此情况为从左到右的情况
            if (n.left != null) {
                q.offer(n.left);
                next++;
            }
            if (n.right != null) {
                q.offer(n.right);
                next++;
            }
            if(n.left==null&&n.right==null){

                if (next == 0 && current == next && n != root) {
                    high--;
                    return high;
                    //System.out.println(high);
                }
                return high;


            }
            if (current == 0) {
                high++;
                current = next;
                next = 0;
            }
        }
        return high;
    }


    public static void main(String[] args) {
        int[] arr={1,2,4,0,0,5,0,0,3,0,0};
        int[] arr1={1,2,0,0,3,4,0,0,5,0,0};
        //按照方法run1这种情况最小深度等于2,按照方法run2这种情况最小深度为1;
        int[] arr2={1,2,0,0,0,0};
        TreeCommon common=new TreeCommon();
        TreeNode root = null;
        root = common.createTrees(arr1);
        MinimumDepthofBinary min = new MinimumDepthofBinary();
        int high = min.run(root);
//        int high = min.run2(root);
        System.out.println(high);

    }
}
