package leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void bucketSort(int[] A) {
        //1. 构造桶
        //1.1 确定桶的个数n
        int n = A.length;
        //1.2 声明并初始化一个List，存放链表；
        List<ArrayList<Integer>> Blist = new ArrayList<>(n);
        for(int i = 0; i < n; i++)
            Blist.add(new ArrayList<Integer>(5));
        //2.将数组中的元素放到桶中
        //2.1 确定元素的最值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int a : A){
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        //2.2 确定每个元素放入桶的编号并放进去
        for(int i : A){
            //2.2.1 确定桶的编号
            int len = A.length;
            //加1是为了保证inde< A.length，防止程序抛出IndexOutofBoundsEx;
            int index = (int)((i-min) / (max-min+1.0) * A.length);
            //2.2.2 放入对应的桶中
            Blist.get(index).add(i);
        }
        //3.桶内排序
        for(int i = 0; i < Blist.size(); i++){
            java.util.Collections.sort(Blist.get(i));
        }
        //4.合并数据
        int j = 0;
        for(ArrayList<Integer> arr : Blist){
            for(int i : arr){
                A[j++] = i;
            }
        }
    }

    public static void bucketSort2(int[] arr){

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        //对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }

        System.out.println(bucketArr.toString());

    }
}
