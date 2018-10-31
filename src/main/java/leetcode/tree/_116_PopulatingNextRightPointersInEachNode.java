package leetcode.tree;
/**
 * 给定一个二叉树
 *
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 说明:
 *
 * 你只能使用额外常数空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 你可以假设它是一个完美二叉树（即所有叶子节点都在同一层，每个父节点都有两个子节点）。
 * 示例:
 *
 * 给定完美二叉树，
 *
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * 调用你的函数后，该完美二叉树变为：
 *
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 * https://www.cnblogs.com/ariel-dreamland/p/9165670.html
 */

import java.util.LinkedList;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class _116_PopulatingNextRightPointersInEachNode {
    //LTM
    public void connect1(TreeLinkNode root) {
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

    public void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeLinkNode temp = queue.poll();
                if (i == len - 1) {
                    temp.next = null;
                } else {
                    temp.next = queue.peek();
                }
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
    }


    public void connect(TreeLinkNode root) {
        TreeLinkNode levelFirst = root;
        TreeLinkNode cur = levelFirst;
        while (cur != null) {
            //给左指针添加next指针
            if (cur.left != null) {
                cur.left.next = cur.right;
            }
            //给右指针添加next指针
            if (cur.right != null && cur.next != null) {
                cur.right.next = cur.next.left;
            }
            //移动指针的位置
            if (cur.next != null) {
                cur = cur.next;
            } else {
                levelFirst = levelFirst.left;
                cur = levelFirst;
            }
        }
    }

}
