package leetcode.sort;
/*************************************************************************
	> File Name: CountSort.java
	> Author: 
	> Mail: 
	> Created Time: 2018年11月15日 星期四 18时48分31秒
 ************************************************************************/
/**
 *对于一个输入数组中的一个元素x，只要我们知道了这个数组中比x小的元素的个数，那么我们就可以直接把x放到（x+1）的位置上。这就是计数排序的基本思想。 
基于这个思想，计数排序的一个主要问题就是如何统计数组中元素的个数。再加上输入数组中的元素都是0-k区间的一个整数这个条件，那么就可以通过另外一个数组的地址表示输入元素的值，数组的值表示元素个数的方法来进行统计。
 *
 *
 */

public class CountSort{

    public static void countSort(int[] arr,int k){
        int[] count=new int[k];
        for(int i:arr){
            count[i]++;
        }
        for(int i=1;i<k;i++){
            count[i]=count[i]+count[i-1];
        }
        int[] arrNew=new int[arr.length];
        for(int j=arr.length-1;j>=0;j--){
            arrNew[count[arr[j]]-1]=arr[j];
            count[arr[j]]--;
        }
        System.arraycopy(arrNew,0,arr,0,arr.length);
    }
    public static void main(String args[]){
        int k=10;
        int[] test={1,5,6,7,8,9,0,4,5,6,7,8,2,2,4,5};
        countSort(test,k);
        for(int i:test){
            System.out.println(i);
        }
    }
}

