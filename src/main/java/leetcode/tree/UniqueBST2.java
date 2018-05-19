package leetcode.tree;

import java.util.ArrayList;

/**
 *  * Created by fay on 2017/12/6.
 */
public class UniqueBST2 {

    public ArrayList<TreeNode> generateTrees(int n) {
        return createTree(1, n);
    }

    public ArrayList<TreeNode> createTree(int low, int high) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if (low > high) {
            result.add(null);
            return result;
        }
        for (int i = low; i <= high; i++) {
            // 求根结点i的左右子树集合
            ArrayList<TreeNode> left = createTree(low, i - 1);
            ArrayList<TreeNode> right = createTree(i + 1, high);
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    // 将左右子树相互配对，每一个左子树都与所有右子树匹配，每一个右子树都与所有的左子树匹配
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = left.get(j);
                    newNode.right = right.get(k);
                    result.add(newNode);
                }
            }
        }
        return result;
    }
    void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.getVal());
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args){
        UniqueBST2 test=new UniqueBST2();
        ArrayList<TreeNode> list=test.generateTrees(3);
        for(TreeNode t:list){
            TreeNode root=t;
            test.preOrder(root);
            System.out.println();
        }
    }
}
