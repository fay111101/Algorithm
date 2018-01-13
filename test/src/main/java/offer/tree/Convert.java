package offer.tree;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {
    //递归方法实现
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }

        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=pRootOfTree;
        TreeNode pre=null;
        TreeNode root=null;
        boolean isHead=true;
        while(!stack.isEmpty()||p!=null){
            while(p!=null){
                stack.push(p);
                p=p.left;
            }

            p=stack.pop();
            if(isHead){
                root=p;
                pre=root;
                isHead=false;
            }else{
                pre.right=p;
                p.left=pre;
                pre=p;
            }

            p=p.right;

        }
        return root;
    }
}
