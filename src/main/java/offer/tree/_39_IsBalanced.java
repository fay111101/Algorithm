package offer.tree;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class _39_IsBalanced {

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


//    解法二：每个结点只遍历一次的解法
//    用后序遍历的方式遍历二叉树的每一个结点，在遍历到一个结点之前我们就已经遍历了它的左右子树。
//    只要在遍历每个结点的时候记录它的深度（某一结点的深度等于它到叶节点的路径的长度），我们就可以一边遍历一边判断每个结点是不是平衡的。

    /**
     * 判断是否是平衡二叉树，第二种解法
     *
     * @param root
     * @return
     */
    public static boolean isBalanced2(TreeNode root) {
        int[] depth = new int[1];
        return isBalancedHelper(root, depth);
    }

    public static boolean isBalancedHelper(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
        if (isBalancedHelper(root.left, left) && isBalancedHelper(root.right, right)) {
            int diff = left[0] - right[0];
            if (diff >= -1 && diff <= 1) {
                depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            }
        }
        return false;
    }



    //避免重复遍历的解法

//    bool IsBalanced(const BinaryTreeNode* pRoot, int* pDepth);
//
//    bool IsBalanced_Solution2(const BinaryTreeNode* pRoot)
//    {
//        int depth = 0;
//        return IsBalanced(pRoot, &depth);
//    }
//
//    bool IsBalanced(const BinaryTreeNode* pRoot, int* pDepth)
//    {
//        if(pRoot == nullptr)
//        {
//        *pDepth = 0;
//            return true;
//        }
//
//        int left, right;
//        if(IsBalanced(pRoot->m_pLeft, &left)
//        && IsBalanced(pRoot->m_pRight, &right))
//        {
//            int diff = left - right;
//            if(diff <= 1 && diff >= -1)
//            {
//            *pDepth = 1 + (left > right ? left : right);
//                return true;
//            }
//        }
//
//        return false;
//    }

}
