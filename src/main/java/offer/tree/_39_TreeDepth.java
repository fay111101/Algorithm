package offer.tree;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 */
public class _39_TreeDepth {
    public int TreeDepth(TreeNode pRoot)
    {
        //树的深度的定义
        if(pRoot==null){
            return 0;
        }
        int nLeft=TreeDepth(pRoot.left);
        int nRight=TreeDepth(pRoot.right);
        return Math.max(nLeft,nRight)+1;
    }
}
