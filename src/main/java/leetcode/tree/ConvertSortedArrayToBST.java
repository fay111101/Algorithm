package leetcode.tree;

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num){
        if(num==null||num.length==0){
            return null;
        }
        return BST(num,0,num.length-1);
    }
    public TreeNode BST(int[] num,int left,int right){
        if(right<left){
            return null;
        }
        if(left==right){
            return new TreeNode(num[left]);

        }
        int mid=(left+right+1)>>1;
        TreeNode root=new TreeNode(num[mid]);

        root.left=BST(num,left,mid-1);
        root.right=BST(num,mid+1,right);
        return root;

    }
    public static void main(String[] args){
        int[] nums={2,4,6,8,9,10};
        ConvertSortedArrayToBST test=new ConvertSortedArrayToBST();
        TreeNode root=test.sortedArrayToBST(nums);

    }
}
