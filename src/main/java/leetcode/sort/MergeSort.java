package leetcode.sort;

public class MergeSort {
    public void merge(int[] arr,int[] temp,int i,int l1,int l2){
        int k,j;
        for(k=i, j=l1+1;i<=l1&&j<=l2; k++){
            if(arr[i]<=arr[j]){
                temp[k]=arr[i++];
            }else{
                temp[k]=arr[j++];
            }
        }
        if(i<=l1){
            temp[k++]=arr[i++];
        }
        if(j<=l2){
            temp[k++]=arr[j++];
        }
    }
    public void mergeSort(int[] arr,int[] result,int start,int end){
        if(start<end){
            int m=(start+end)/2;
            mergeSort(arr,result,start,m);
            mergeSort(arr,result,m+1,end);
            merge(arr,result,start,m,end);
        }
    }

    public static void mergeSort1(int[] arr,int p,int r){
        if(p<r){
            int q=(p+r)/2;
            mergeSort1(arr,p,q);
            mergeSort1(arr,q+1,r);
            merge1(arr,p,q,r);


        }
    }

    public static void merge1(int[] arr,int p,int q,int r){
        int n1=q-p+1;
        int n2=r-q;
        int [] arr1=new int [n1+1];
        int [] arr2=new int [n2+1];

        for(int i=0;i<n1;i++){
            arr1[i]=arr[p+i];
        }
        for(int j=0;j<n2;j++){
            arr2[j]=arr[q+1+j];
        }
        arr1[n1]=Integer.MAX_VALUE;
        arr2[n2]=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        for(int k=p;k<=r;k++){
            if(arr1[i]<arr2[j]){
                arr[k]=arr1[i];
                i++;
            }else{
                arr[k]=arr2[j];
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49};
        int[] result=new int[arr.length];
        MergeSort qs = new MergeSort();
        qs.mergeSort1(arr, 0, arr.length-1 );
        qs.mergeSort(arr, result,0, arr.length-1 );
        for (int num : arr) {
            System.out.println(num);

        }
        for (int num : result) {
            System.out.print(num);
            System.out.print("\t");

        }
    }

}
