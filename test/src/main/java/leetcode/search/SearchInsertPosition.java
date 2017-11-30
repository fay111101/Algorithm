package leetcode.search;

/* Given a sorted array and a target value, return the index if the target is
 found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0, right = A.length - 1;
        int mid = (left + right) >> 1;
        while (left <= right) {
            if (target < A[mid]) {
                right = mid - 1;
            } else if (target > A[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
            mid = (left + right) >> 1;
        }
        return mid + 1;
    }

    public int binarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            //要查找的x大于数组的中间
            if (a[mid] < x) {
                low = mid + 1;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int binarySearchRecursive(int[] a, int x, int low, int high) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (a[mid] < x) {
            return binarySearchRecursive(a, x, mid + 1, high);
        } else if (a[mid] > x) {
            return binarySearchRecursive(a, x, 0, mid - 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        SearchInsertPosition test = new SearchInsertPosition();
        int[] A = {1, 3, 5, 6};
        int[] A1 = {1, 3, 4,5};
        System.out.println(test.searchInsert(A, 5));
        System.out.println(test.searchInsert(A, 2));
        System.out.println(test.searchInsert(A, 7));
        System.out.println(test.searchInsert(A, 0));
        System.out.println(test.searchInsert(A, -1));
        System.out.println(test.searchInsert(A, 3));
        System.out.println(test.binarySearch(A1, 5));
        System.out.println(test.binarySearchRecursive(A1, 5, 0, 3));

    }
}
