package offer.tree;

/**
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
public class _63_KthNode {

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null||k<=0){
            return null;
        }
        int arr[]=new int[1];
        arr[0]=0;
        TreeNode res[]=new TreeNode [1];
        KthNodeCore(pRoot,k,arr,res);
        return res[0];
    }
    //java传值与传引用TreeNode res
    void KthNodeCore(TreeNode pRoot,int k,int[] arr,TreeNode[] res){
        if(pRoot==null||res[0]!=null){
            return;
        }
        KthNodeCore(pRoot.left,k,arr,res);
        arr[0]++;
        if(arr[0]==k){
            res[0]=pRoot;
            return;
        }
        KthNodeCore(pRoot.right,k,arr,res);

    }


}
