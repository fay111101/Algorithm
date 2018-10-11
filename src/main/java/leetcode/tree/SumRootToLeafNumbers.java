package leetcode.tree;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum=0;
        return preOrderSum(root,sum);

    }
    public  int preOrderSum(TreeNode root,int sum){

        if(root==null){
            return  0;
        }
        sum=root.val+sum*10;
        if(root.left==null&&root.right==null){
            return sum;
        }
        int left=preOrderSum(root.left,sum);
        int right=preOrderSum(root.right,sum);
        return left+right;
//        return preOrderSum(root.left,sum)+ preOrderSum(root.right,sum);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 0, 0, 5, 0, 0, 3, 0, 0};
        int[] arr1 = {1, 2, 0, 0, 3, 4, 0, 0, 5, 0, 0};
        TreeCommon common = new TreeCommon();
        TreeNode root = null;
        root = common.createTrees(arr);
        SumRootToLeafNumbers test=new SumRootToLeafNumbers();
        System.out.println(test.sumNumbers(root));


    }
}
