package leetcode.tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
Note:
A solution using O(n ) space is pretty straight forward. Could you devise a
constant space solution?


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

The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}". */
public class _99_RecoverBST {

    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> list=new ArrayList<>();
        List<Integer> vals=new ArrayList<Integer>();
        inorderBST(root,list,vals);
        Collections.sort(vals);
        TreeNode[] temp=(TreeNode[]) list.toArray(new TreeNode[list.size()]);
        for(int i=0;i<vals.size();i++){
            //list.set(i,new TreeNode(vals.get(i)));
            System.out.print(temp[i].val+" old ");
            temp[i].val=vals.get(i);
            System.out.print(temp[i].val+" new ");
        }
    }
    private void inorderBST(TreeNode root, ArrayList<TreeNode> list,List<Integer> vals){
        if(root==null){
            return;
        }
        inorderBST(root.left,list,vals);
        list.add(root);
        vals.add(root.val);
        inorderBST(root.right,list,vals);

    }
    public static void main(String[] args){
        _99_RecoverBST test=new _99_RecoverBST();
        int[] arr1={6,5,0,0,7,2,0,0,8,0,0};
        TreeCommon common=new TreeCommon();
        TreeNode root = null;
        root = common.createTrees(arr1);
        test.recoverTree(root);


    }

}
