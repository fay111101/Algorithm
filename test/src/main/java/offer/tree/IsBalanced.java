package offer.tree;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalanced {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null){
            return true;
        }
        int diff=getHeight(root.left)-getHeight(root.right);
        if(diff>1||diff<-1){
            return false;
        }else{
            IsBalanced_Solution(root.left);
            IsBalanced_Solution(root.right);
        }
        return  true;
    }
    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        return Math.max(left,right)+1;
    }
}
