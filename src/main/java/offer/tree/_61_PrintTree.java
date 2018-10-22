package offer.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class _61_PrintTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(pRoot==null){
            return res;
        }
        Stack<TreeNode> s1=new Stack<TreeNode>();
        s1.add(pRoot);
        Stack<TreeNode> s2=new Stack<TreeNode>();
        while(!s1.isEmpty()||!s2.isEmpty()){
            if(!s1.isEmpty()){
                ArrayList<Integer> list=new ArrayList<Integer>();
                while(!s1.isEmpty()){
                    TreeNode p=s1.pop();
                    list.add(p.val);
                    if(p.left!=null)
                        s2.add(p.left);
                    if(p.right!=null)
                        s2.add(p.right);
                }
                res.add(list);
            }else {
                ArrayList<Integer> list=new ArrayList<Integer>();
                while(!s2.isEmpty()){
                    TreeNode p=s2.pop();
                    if(p.right!=null)
                        s1.add(p.right);
                    if(p.left!=null)
                        s1.add(p.left);
                    list.add(p.val);
                }
                res.add(list);
            }
        }
        return res;
    }
}
