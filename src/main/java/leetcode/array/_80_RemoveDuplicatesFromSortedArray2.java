package leetcode.array;

/**
 * Created by fay on 2017/12/8.
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?
 For example,
 Given sorted array A =[1,1,1,2,2,3],
 Your function should return length =5, and A is now[1,1,2,2,3].

 */
public class _80_RemoveDuplicatesFromSortedArray2 {

    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        if(nums.length<=2) return nums.length;
        int curIndex=2;
        for(int i=2;i<nums.length;i++){
            if(nums[i]!=nums[curIndex-2]){
                nums[curIndex++]=nums[i];
            }
        }
        return curIndex;
    }

    public int removeDuplicates1(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(i>0&&i<nums.length-1&&nums[i]==nums[i-1]&&nums[i]==nums[i+1]){
                continue;
            }
            nums[index++]=nums[i];
        }
        return index;
    }
    public static void main(String[] args){
        int[] A={1,1,1,2,2,2,3};
        int[] A1={1};
        _80_RemoveDuplicatesFromSortedArray2 t=new _80_RemoveDuplicatesFromSortedArray2();
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
