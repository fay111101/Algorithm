package leetcode.sort;

public class QuikSort {
    /**
     * 原始算法
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
     * 改进算法
     * @param arr
     * @param low
     * @param high
     * @return
     */
    int partition1(int[] arr, int low, int high) {
        int r0 = arr[low];
        int base = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= base) {
                high--;
            }
            arr[low]=arr[high];
            while (low < high && arr[low] <= base) {
                low++;
            }
            arr[high]=arr[low];
        }
        arr[low]=r0;
        return low;
    }

    int[] quickSort(int[] arr, int low, int high) {
        if (low <high) {
            int base = partition1(arr, low, high);
            quickSort(arr, 0, base - 1);
            quickSort(arr, base + 1, high);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27,49};
        QuikSort qs = new QuikSort();
        arr = qs.quickSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.println(num);

        }

    }

}
