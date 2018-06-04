package leetcode.sort;

public class BubbleSort {
    public int[] bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49};
        BubbleSort qs = new BubbleSort();
        arr = qs.bubbleSort(arr);
        for (int num : arr) {
            System.out.println(num);

        }
    }
}
