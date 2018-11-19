package leetcode.sort;

public class QuikSort {


    int partition0(int[] arr,int low,int high){
        int base=arr[(low+high)/2];
        int temp;

        while(low<=high){
            while(arr[low]<base){
                low++;
            }
            while(arr[high]>base){
                high--;
            }

            if(low<=high){
                temp=arr[low];
                arr[low]=arr[high];
                arr[high]=temp;
                low++;
                high--;
            }
        }
        return low;
    }
    void quickSort0(int[] array, int start, int end){
        int index=partition0(array,start,end);
        if(start<index-1){
            quickSort0(array,start,index-1);
        }
        if(index<end){
            quickSort0(array,index,end);
        }
    }

    /**
     * 原始算法 Hoare
     * 先把选定为pivot的元素放到最开始，然后设定指针low和指针high，high指针右移，low指针左移，
     * 当两个指针相撞后停止移动。期间如果符合交换条件，两元素交换。最后把pivot元素放到中间。
     * @param arr
     * @param low
     * @param high
     * @return
     */
    int partition(int[] arr, int low, int high) {
        int base = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= base) {
                high--;
            }
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            while (low < high && arr[low] <= base) {
                low++;
            }
            temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;
        }
        return low;
    }


    /**
     * 改进算法 让基准位置最后入位！
     * 记住
     * @param arr
     * @param low
     * @param high
     * @return
     */
    int partition1(int[] arr, int low, int high) {
        int base = arr[low];

        while (low < high) {
            while (low < high && arr[high] <= base) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] >= base) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = base;
        return low;
    }

    int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int base = partition1(arr, low, high);
//            int base = partition(arr, low, high);
            quickSort(arr, 0, base - 1);
            quickSort(arr, base + 1, high);
        }

        return arr;
    }

    /**
     * 不记！
     *  设置两个指针 low和high
     * 先把选定为pivot的元素放到最后，然后设定指针low和指针high，low指针左移，
     * high指针右移，当两个指针相撞后停止移动。期间如果符合交换条件，两元素交换。最后把pivot元素放到中间。
     * @arr 待排序的数组
     * @begin 需要partition的起始下标
     * @end 需要partition的末尾下标
     * @return 返回pivot所在位置下标
     */
    int partition3(int arr[], int begin, int end) {
        int pivotIndex = begin;
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, end);

        int low = begin;
        int high = end;

        while (low < high) {
            // 因为把pivot放在了最后，所以low指针先走
            while (low < high && arr[low] < pivot) low++;
            while (low < high && arr[high] > pivot) high--;
            if(low < high) swap(arr, low, high);
        }

        swap(arr, low, end);
        return low;
    }

    /**
     * 类似冒泡排序的思路，把比pivot大的元素“往下沉”，把比pivot小的元素“往上浮”。剑指offer
     * @return 返回pivot所在位置下标
     * @arr 待排序的数组
     * @begin 需要partition的起始下标
     * @end 需要partition的末尾下标
     */
    public int  partition2(int arr[], int begin, int end) {
        int pivotIndex = begin;
        int pivot = arr[pivotIndex];
        //将基准放到最后
        swap(arr, pivotIndex, end);

        int small = begin - 1; // index of smaller element
        for (int i= begin; i <= end - 1; i++) {
            // 遇到一个元素小于pivot
            if (arr[i] < arr[end]) {
                small++;
                if(small!=i){
                    swap(arr, small, i);
                }
            }
        }
        //将基准放到最后指定位置
        swap(arr, small + 1, end);
        return small + 1;
    }

    /**
     * 快速排序
     *
     * @param array 待排序数组
     * @param start 待排序子数组的起始索引
     * @param end   待排序子数组的结束索引
     */
    public  void quickSort2(int[] array, int start, int end) {
        if (start < end) {
            int position = partition2(array, start, end);
            quickSort2(array, start, position - 1);
            quickSort2(array, position + 1, end);
        }
    }



    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    /**
     * 打印数组
     *
     * @param array
     */
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + "");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49,-1,-3};
        QuikSort qs = new QuikSort();

        qs.quickSort(arr, 0, arr.length - 1);
//        qs.quickSort2(arr, 0, arr.length - 1);
//        qs.quickSort0(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.println(num);

        }

    }

}
