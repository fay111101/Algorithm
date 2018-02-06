package leetcode.list;
/*
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 The overall run time complexity should be O(log (m+n)).
* */
public class findMedianSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        double mid=0.0;
        int m=A.length;
        int n=B.length;
        if(A==null||B==null||m+n==0){
            return mid;
        }
        int[] C=new int[m+n];
        int i=0,j=0,k=0;
        while(i<m&&j<n){
            if(A[i]<B[j]){
                C[k]=A[i];
                k++;
                i++;
            }else{
                C[k]=B[j];
                k++;
                j++;
            }
        }
        while(j<n){
            C[k]=B[j];
            k++;
            j++;
        }
        while(i<m){
            C[k]=A[i];
            k++;
            i++;
        }
        int midIndex=(m+n)/2;
        if((m+n)%2==0){
            mid=(C[midIndex-1]+C[midIndex])*0.5;
        }else{
            mid=C[midIndex]*1.0;
        }
        return mid;
    }
}
