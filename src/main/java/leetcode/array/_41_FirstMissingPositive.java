package leetcode.array;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

 示例 1:

 输入: [1,2,0]
 输出: 3
 示例 2:

 输入: [3,4,-1,1]
 输出: 2
 示例 3:

 输入: [7,8,9,11,12]
 输出: 1
 说明:

 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class _41_FirstMissingPositive {

    public int firstMissingPositive(int[] A) {
        if(A.length==0){
            return 1;
        }
        int n=A.length,i=0;
        while(i<n){
            if(A[i]!=i+1&&(A[i]>0&&A[i]<=n)&&A[i]!=A[A[i]-1]){
                int temp=A[A[i]-1];
                A[A[i]-1]=A[i];
                A[i]=temp;
            }else{
                i++;
            }

        }
        for(i=0;i<n;i++){
            if(A[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
    public static void main(String[] args){
        _41_FirstMissingPositive test=new _41_FirstMissingPositive();
        int[] a={3,4,-1,1};
        test.firstMissingPositive(a);
    }
}
