package leetcode.tree;

import java.util.LinkedList;

/**
 * 给定一个二叉树
 * <p>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，
 * 则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 说明:
 * <p>
 * 你只能使用额外常数空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 示例:
 * <p>
 * 给定二叉树，
 * <p>
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * 调用你的函数后，该二叉树变为：
 * <p>
 * 1 . NULL
 * /  \
 * 2 . 3 . NULL
 * / \    \
 * 4. 5 . 7 . NULL
 */
public class _117_PopulatingNextRightPointersInEachNode2 {

    //BUG
    public static void connect1(TreeLinkNode root) {
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

    /**
     * 首先申请了一个节点temp作为记录节点,创建left指针指向temp，然后进入循环进行层次遍历；
     * <p>
     * 如果当前节点有左儿子，将left->next指向root->left（这里如果是每层的第一次操作，
     * temp->next将指向root->left，因为初始位置left是指向temp的），其他的就好理解了，如果有右儿子，同样的操作。
     * <p>
     * 如果最后root->next==null，说明这个一层已经遍历完成，将root=temp->next,就到了下一层首节点。然后temp->next=null,防止死循环。
     *
     * @param root
     */
    void connect(TreeLinkNode root) {

        TreeLinkNode dummy = new TreeLinkNode(0), curr = dummy;
        while (root != null) {
            if (root.left != null) {
                curr.next = root.left;
                curr = root.left;
            }
            if (root.right != null) {
                curr.next = root.right;
                curr = root.right;
            }
            root = root.next;
            if (root == null) {
                curr = dummy;
                root = dummy.next;
                dummy.next = null;
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


}


