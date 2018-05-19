package leetcode.tree;

public class isBalanced {
    public boolean isBalanced(TreeNode root){
        if(root==null){
            return true;
        }
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        if(Math.abs(left-right)>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        return Math.max(left,right)+1;
    }
    public static void main(String[] args) {
        int[] arr={1,2,4,0,0,5,0,0,3,0,0};
        int[] arr1={1,2,0,0,3,4,0,0,5,0,0};
        //按照方法run1这种情况最小深度等于2,按照方法run2这种情况最小深度为1;
        int[] arr2={1,2,0,0,0,0};
        TreeCommon common=new TreeCommon();
        TreeNode root = null;
        root = common.createTrees(arr1);
        isBalanced test=new isBalanced();
        int high = test.getHeight(root);
//        int high = min.run2(root);
        System.out.println(high);

    }
}
