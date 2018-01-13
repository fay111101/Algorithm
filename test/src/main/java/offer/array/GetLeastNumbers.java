package offer.array;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        if(input==null||k<1||k>input.length){
            return new ArrayList<Integer>();
        }
        create_heap(input,k);
        for(int i=k;i<input.length;i++){
            if(input[i]<input[0]){
                input[0]=input[i];
                percolate_down(input,0,k);
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }
    public  void create_heap(int[] arr,int heapSize){
        for(int i=heapSize/2-1;i>=0;i--){
            percolate_down(arr,i,heapSize);
        }
    }
    public void percolate_down(int[] arr,int r,int heapSize){
        int s=2*r+1;
        while(s<heapSize){
            if(s<(heapSize-1)&&arr[s]<arr[s+1]){
                s++;
            }
            if(arr[s]>arr[r]){
                int temp=arr[s];
                arr[s]=arr[r];
                arr[r]=temp;
                r=s;
                s=2*r+1;
            }else{
                break;
            }

        }
    }
}
