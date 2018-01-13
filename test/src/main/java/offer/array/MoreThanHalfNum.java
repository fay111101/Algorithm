package offer.array;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
    public  int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int len=array.length;
        int index=partition(array,0,len-1);
        int mid=len>>1;
        //用二分查找加速
        if(index>mid){
            index=partition(array,0,index-1);

        }else{
            index=partition(array,index+1,len-1);
        }
        if(checkMoreThanHalf(array,array[mid])){
            return array[mid];
        }else{
            return 0;
        }

    }
    public  boolean checkMoreThanHalf(int[] arr,int num){
        int len=arr.length;
        int times=0;
        for(int i=0;i<len;i++){
            if(arr[i]==num){
                times++;
            }
        }
        if(times>(len>>1)){
            return true;
        }else{
            return false;
        }
    }
    public  int partition(int[] arr,int left,int right){
        int pivot=arr[(left+right)/2];
        while(left<=right){
            if(arr[left]<pivot){
                left++;
            }
            if(arr[right]>pivot){
                right--;
            }
            if(left<=right){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
