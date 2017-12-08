package leetcode.array;

/**
 * Created by fay on 2017/12/8.
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?
 For example,
 Given sorted array A =[1,1,1,2,2,3],
 Your function should return length =5, and A is now[1,1,2,2,3].

 */
public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        if(A.length<=2){
            return A.length;
        }
        int index=2;
        for(int i=2;i<A.length;i++){
            if(A[i]!=A[index-2]){
                A[index++]=A[i];
            }
        }
        return index;
    }
    public int removeDuplicates1(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        int index=0;
        for(int i=0;i<A.length;i++){
            if(i>0&&i<A.length-1&&A[i]==A[i-1]&&A[i]==A[i+1]){
                continue;
            }
            A[index++]=A[i];
        }
        return index;
    }
    public static void main(String[] args){
        int[] A={1,1,1,2,2,2,3};
        int[] A1={1};
        RemoveDuplicatesFromSortedArray2 t=new RemoveDuplicatesFromSortedArray2();
        System.out.println(t.removeDuplicates1(A));
        for(int i:A){
            System.out.print(i);
        }
        //System.out.println(t.removeDuplicates(A1));

        /*System.out.println("==============");
        for(int i:A1){
            System.out.println(i);
        }*/
    }
}
