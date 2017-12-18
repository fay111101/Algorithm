package leetcode.search;
/* Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e.,0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
旋转数组求最小数
*/
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if(A==null||A.length==0){
            return -1;
        }
        int left=0,right=A.length-1;
        while(left<=right){
            int mid=(left+right)>>1;
            if(A[mid]==target){
                return mid;
            }else if(A[mid]<A[right]){
                if(target<=A[right]&&target>A[mid]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{
                if(target>=A[left]&&target<A[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return -1;
    }
}
