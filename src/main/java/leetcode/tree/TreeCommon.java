package leetcode.tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode() {
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

public class TreeCommon {
    static int array[] = {23, 10, 0, 88, 0, 0, 15, 0, 34, 0, 0};

    public TreeNode createTree(TreeNode node, Scanner scanner) {
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

    public TreeNode createTree1(TreeNode node, LinkedList<Integer> list) {
        int data = list.poll();
        if (data == 0) {
            return null;
        } else {
            node = new TreeNode(data);
            node.setLeft(createTree1(node.getLeft(), list));
            node.setRight(createTree1(node.getRight(), list));
        }

        return node;
    }

    public TreeNode createTrees(int[] arr) {
        LinkedList list = new LinkedList();
        TreeNode root = null;
        for (int i : arr) {
            list.offer(i);
        }
        return createTree1(root, list);
    }

    public static TreeNode buildTree(int[] treedata, int n){
        if(treedata.length==0)
            return null;
        else{
            if(n<treedata.length)
            {
                int l=n*2+1;//左子结点
                int r=n*2+2;//右子结点

                TreeNode TreeRoot=new TreeNode(treedata[n], buildTree(treedata, l), buildTree(treedata, r));

                return TreeRoot;
            }
            else
                return null;
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,4,0,0,5,0,0,3,0,0};
        int[] arr1={1,2,0,0,3,4,0,0,5,0,0};
        int[] arr2= {5,3,6,2,4,0,0,1};
        TreeNode root2 = null;
        TreeCommon common=new TreeCommon();
        TreeNode root = null;
        root = common.createTrees(arr);
        root2 = common.buildTree(arr2,0);


    }
}
