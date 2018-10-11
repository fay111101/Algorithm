package leetcode.tree;
/*Given a binary tree, return the level order traversal of its nodes' values.
(ie, from left to right, level by level).
For example:
Given binary tree{3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on
OJ.

OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#'
signifies a path terminator where no node exists below.
Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}".*/

import java.util.*;

public class _102_BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int current = 1;//记录当前层节点数
        int next = 0;//记录下一层节点数
        List<Integer> res = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            res.add(n.val);
            current--;
            if (n.left != null) {
                q.offer(n.left);
                next++;
            }
            if (n.right != null) {
                q.offer(n.right);
                next++;
            }
            if (current == 0) {
                result.add(res);
                res = new ArrayList<Integer>();
                current = next;
                next = 0;
            }

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
        int array[] = {23, 10, 0, 88, 0, 0, 15, 0, 34, 0, 0};
        List<List<Integer>> res = levelOrder(root);
        for (List<Integer> arr : res) {
            System.out.println("level");
            //System.out.println(arr.size());

            for (int i : arr) {
                System.out.println(i);
            }

        }

    }
}
