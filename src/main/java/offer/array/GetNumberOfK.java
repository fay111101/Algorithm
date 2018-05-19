package offer.array;

/**
 *
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    public static int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int start = getFirstK(array, k, 0, array.length - 1);
        int end = getLastK(array, k, 0, array.length - 1);
        if (end>-1&&start>-1) {
            return end - start + 1;
        }else{
            return 0;
        }
    }

    public static int getFirstK(int[] arr, int k, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) >> 1;
        if (arr[mid] > k) {
            return getFirstK(arr, k, low, mid - 1);
        } else if (arr[mid] < k) {
            return getFirstK(arr, k, mid + 1, high);
        } else {
            if ((mid > 0 && arr[mid - 1] != k)||mid==0) {
                return mid;
            } else {

                return getFirstK(arr, k, low, mid - 1);

            }
        }

    }

    public static int getLastK(int[] arr, int k, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) >> 1;
        if (arr[mid] > k) {
            return getLastK(arr, k, low, mid - 1);
        } else if (arr[mid] < k) {
            return getLastK(arr, k, mid + 1, high);
        } else {
            if ((mid < arr.length-1 && arr[mid + 1] != k)||mid==arr.length-1) {
                return mid;
            } else {

                return getLastK(arr, k, mid + 1, high);

            }
        }

    }
}
