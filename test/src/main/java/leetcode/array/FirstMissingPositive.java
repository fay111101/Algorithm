package leetcode.array;

/**
 * Created by fay on 2017/12/8.
 * Given an unsorted integer array, find the first missing positive integer.
 For example,
 Given[1,2,0]return3,
 and[3,4,-1,1]return2.
 Your algorithm should run in O(n) time and uses constant space.

 */
public class FirstMissingPositive {
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
        FirstMissingPositive test=new FirstMissingPositive();
        int[] a={3,4,-1,1};
        test.firstMissingPositive(a);
    }
}
