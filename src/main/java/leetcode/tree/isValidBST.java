package leetcode.tree;

import java.util.ArrayList;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 Assume a BST is defined as follows:
 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.

 confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.

 OJ's Binary Tree Serialization:
 The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
 Here's an example:
 1
 / \
 2   3
 /
 4
 \
 5
 The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}".

 * Created by fay on 2017/12/4.
 */
public class isValidBST{
    public boolean isValidBST(TreeNode root){
        ArrayList<Integer> list=new ArrayList<>();
        inorderBST(root,list);
        //存在你逆序对
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>=list.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public void inorderBST(TreeNode root, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        inorderBST(root.left,list);
        list.add(root.val);
        inorderBST(root.right,list);
    }
}
