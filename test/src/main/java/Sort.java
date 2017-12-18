import java.util.Random;

public class Sort {
    public static void maxHeapify(int[] arr, int root, int heapSize) {
        int l = 2 * root + 1;
        int r = 2 * root + 2;
        int largest = 0;
        if (l <= heapSize && arr[l] > arr[root]) {
            largest = l;
        } else {
            largest = root;
        }
        if (r <= heapSize && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != root) {
            swap(arr, root, largest);
            maxHeapify(arr, largest, heapSize);
        }
    }

    public static void maxHeapify1(int arr[], int root, int n) {
        int c = 2 * root + 1;

        while (c <= n) {
            if (c <= n - 1 && arr[c] < arr[c + 1]) {
                c++;
            }
            if (arr[root] < arr[c]) {
                swap(arr, root, c);
                root = c;
                c = 2 * c + 1;
            } else {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void buildMaxHeap(int[] arr) {
        int heapSize = arr.length - 1;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapify1(arr, i, heapSize);
        }
        for (int i : arr) {

//            System.out.println(i);

        }

    }

    public static void heapSort(int[] arr) {
        int heapSize = arr.length - 1;
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i >= 1; i--) {
            swap(arr, 0, i);
            heapSize = heapSize - 1;
            maxHeapify1(arr, 0, heapSize);
        }
    }


    public static int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (arr[j] < x) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }
    public static int partition3(int arr[], int start, int end)
    {


        int pivot = arr[end];
        int i = start;
        //这个循环比一般的写法简洁高效，呵呵维基百科上看到的
        for(int j = start; j < end; ++j) {
            if(arr[j] < pivot) {
                swap(arr,j, i);
                ++i;
            }
        }
        swap(arr,i, end);
        return i;
    }
    public static void quickSort3(int[] arr, int p, int r) {
        if (p < r) {
            //int x=partition(arr,p,r);
            int x = partition3(arr, p, r);
            quickSort3(arr, p, x-1);
            quickSort3(arr, x + 1, r);
        }
    }

    public static int randomizedPartition(int[] arr, int p, int r) {
//        int x = new Random().nextInt(r - p) + p;
        int x=(int) (Math.random() * ((r - p) + 1)) + p;
        swap(arr, x, r);
        return partition(arr, p, r);
    }


    public static void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            //int x=partition(arr,p,r);
            int x = randomizedPartition(arr, p, r);
            quickSort(arr, p, x - 1);
            quickSort(arr, x + 1, r);
        }
    }


    public static int hoare_partition(int arr[], int p, int r) {
        int x = arr[p];
        int i = p - 1;
        int j = r +1;

        while (true) {

            do j--;
            while (arr[j] > x);

            do i++;
            while (arr[i] < x);

            if (i < j)
                swap(arr, i, j);
            else
                return j;
        }
    }

    public static void quickSort1(int[] arr, int p, int r) {
        if (p < r) {
            int x = hoare_partition(arr, p, r);
            quickSort1(arr, p, x);
            quickSort1(arr, x + 1, r);
        }
    }

    public static int hoarePartition(int arr[], int p, int r) {
//        int x = arr[p];
//        int i = p;
//        int j = r;
//        while (true) {
//            while (arr[j] > x) {
//                j--;
//            }
//            while (arr[i] < x) {
//                i++;
//            }
//            if (i < j) {
//                swap(arr, i, j);
//            } else {
//                return j;
//            }
//        }
        int x=arr[p];
        int i=p-1;
        int j=r+1;
        while(true){
            do {
                j--;
            }
            while(arr[j]>x);
            do {
                i++;
            }
            while(arr[i]<x);
            if(i<j){
                swap(arr,i,j);
            }else{
                return j;
            }
        }


    }

    public static void quickSort2(int[] arr, int p, int r) {
        if (p < r) {
            int x = hoarePartition(arr, p, r);
            quickSort2(arr, p, x);
            quickSort2(arr, x + 1, r);
        }
    }

    public static void mergeSort(int[] arr,int p,int r){
        if(p<r){
            int q=(p+r)/2;
            mergeSort(arr,p,q);
            mergeSort(arr,q+1,r);
            merge(arr,p,q,r);


        }
    }

    public static void merge(int[] arr,int p,int q,int r){
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


    public static int randomlized_partition(int[] arr,int p,int r){
        int q=(int) (Math.random() * ((r- p) + 1)) + p;
//        int q=new Random().nextInt(r - p) + p;

        swap(arr,q,r);
        int x=arr[r];
        int i=p-1;
        for(int j=p;j<r;j++){
            if(arr[j]<x){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,r);
        return i+1;

    }
    public static int randomlized_Select(int []arr,int p,int r,int i){
        if(p==r){
            return arr[p];
        }
        int q=randomlized_partition(arr,p,r);
        int k=q-p+1;
        if(i==k){
            return arr[q];
        }else if(i<k){
            return randomlized_Select(arr,p,q-1,i);
        }else{
            return randomlized_Select(arr,q+1,r,i-k);
        }
    }
    public static int[] bubbleSort(int[] A, int n) {
        // write code here
        int temp;
        for(int i=0;i<n;i++){
            boolean exchange=false;
            for(int j=i+1;j<n;j++){
                if(A[j]<A[i]){
                    temp=A[i];
                    A[i]=A[j];
                    A[j]=temp;
                    exchange=true;

                }

            }
            if(!exchange){
                break;
            }
            System.out.println("-----");
            System.out.println(A[i]);
        }
        return A;
    }
    public static void display(int[] A){
        for (int i : A) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        int[] arr = {7, 3, 45, 21, 67, 12, 2, -1, 0, -2, 3, 100};
//        heapSort(arr);
//        quickSort1(arr, 0, arr.length - 1);
//        quickSort3(arr,0,arr.length-1);
//        mergeSort(arr,0,arr.length-1);
        bubbleSort(arr,12);
        System.out.println("====");
        display(arr);
//        int num=randomlized_Select(arr,0,arr.length-1,5);

//        System.out.println(num);
    }
}