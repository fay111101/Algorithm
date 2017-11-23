package leetcode.tree;
/*Given inorder and postorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.*/
public class ConstructBinaryTreeFromInorderPostorderTraversal {
    public TreeNode buildTree(int[] inorder,int[] postorder){
        if(inorder==null||postorder==null||inorder.length==0||postorder.length==0){
            return null;
        }
        int length=postorder.length;
        return createTree(inorder,0,length-1,postorder,0,length-1);
    }
    public TreeNode createTree(int[] inorder,int istart,int iend,int[]
            postorder,int pstart,int
            pend){
        if(pstart>pend||istart>iend){
           return null;
        }
        int val=postorder[pend];
        int index=0;
        for(int i=0;i<postorder.length;i++){
            if(inorder[i]==val){
                index=i;
            }
        }
        TreeNode root=new TreeNode(val);
        int leftlen=index-istart;
        root.left=createTree(inorder,istart,index-1,postorder,pstart,
                pstart+leftlen-1);
        root.right=createTree(inorder,index+1,iend,postorder,
                pstart+leftlen,pend-1);
        return root;
    }
    public static void main(String[] args){
        ConstructBinaryTreeFromInorderPostorderTraversal test=new
                ConstructBinaryTreeFromInorderPostorderTraversal();
        int[] in={4,2,5,1,6,3,7};
        int[] po={4,5,2,6,7,3,1};
        test.buildTree(in,po);
    }
}
