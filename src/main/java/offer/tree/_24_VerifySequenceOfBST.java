package offer.tree;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class _24_VerifySequenceOfBST {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0){
            return false;
        }
        return isBST(sequence,0,sequence.length-1);
    }
    public boolean isBST(int[] s,int start,int end){
        int i=start,j;
        if(end<=start){
            return true;
        }
        //判断左子树中的结点是否小于根结点
        for(;i<end;i++){
            if(s[i]>s[end]){
                break;
            }
        }

        //判断右子树中的结点是否大于根节点
        for(j=i;j<end;j++){
            if(s[j]<s[end]){
                return false;
            }
        }
        //递归的判断左子树和右子树
        return isBST(s,start,i-1)&&isBST(s,i,end-1);

    }
}
