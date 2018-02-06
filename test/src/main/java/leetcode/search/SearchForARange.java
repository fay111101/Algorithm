package leetcode.search;
/* Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return[-1, -1].

For example,
Given[5, 7, 7, 8, 8, 10]and target value 8,
return[3, 4]. */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int[] result={-1,-1};
        /*int[] result1=new int[2];
        result1={-1,-1};*/
        if(A==null||A.length==0){
            return result;
        }
        int left=0,right=A.length-1;
        int temp=-1;
        while(left<=right){
            int mid=(left+right)>>1;
            if(A[mid]==target){
                temp=mid;
                break;
            }else if(A[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        int i=temp-1,j=temp+1;

        while(i>=0){
            if(A[i]!=target){
                break;
            }
            i--;
        }
        while(j<A.length){
            if(A[j]!=target){
                break;
            }
            j++;
        }
        result[0]=i+1;
        result[1]=j-1;
        return result;
    }
    public static void main(String[] args){
        int[] arr={5, 7, 7, 8, 8, 10};
        SearchForARange test=new SearchForARange();
        int[] res=test.searchRange(arr,8);
        for(int i:res){
            System.out.println(i);
        }
    }
}

