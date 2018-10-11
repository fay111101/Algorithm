package utils;

import java.util.*;

public class TreeTest {
    static int array[] = {23, 10, 0, 88, 0, 0, 15, 0, 34, 0, 0};
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode() {
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

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.left == null && temp.right == null) {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                System.out.println(pop.val);
            } else {
                if (temp.right != null) {
                    stack.push(temp.right);
                    temp.right = null;
                }

                if (temp.left != null) {
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }
        return res;
    }

    public static List<Integer> levelTraverse(TreeNode root) {

        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            System.out.println(temp.val);
            res.add(temp.val);
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        return res;
    }

    static int counter = 0;

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
//        levelTraverse(root);
        postorderTraversal(root);

    }
}
