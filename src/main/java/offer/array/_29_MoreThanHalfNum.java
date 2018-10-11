package offer.array;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class _29_MoreThanHalfNum {

    public int MoreThanHalfNum_Solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) return nums[0];
        int len = nums.length;
        int index = partition(nums, 0, len - 1);
        int mid = len >> 1;
        //用二分查找加速
        while (index != mid) {
            if (index > mid) {
                index = partition(nums, 0, index - 1);

            } else {
                index = partition(nums, index + 1, len - 1);
            }
        }

        return nums[mid];
    }

    public boolean checkMoreThanHalf(int[] arr, int num) {
        int len = arr.length;
        int times = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == num) {
                times++;
            }
        }
        if (times > (len >> 1)) {
            return true;
        } else {
            return false;
        }
    }

    int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else {
                if (nums[i] == candidate)
                    count++;
                else
                    count--;
            }
        }
        return candidate;
    }


    public int partition(int[] arr, int low, int high) {
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

}
