package leetcode.sort;

public class MedianOfTWOSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        double mid = 0.0;
        int m = A.length;
        int n = B.length;
        if (A == null || B == null || m + n == 0) {
            return mid;
        }
        int[] C = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                C[k] = A[i];
                k++;
                i++;
            } else {
                C[k] = B[j];
                k++;
                j++;
            }
        }
        while (j < n) {
            C[k] = B[j];
            k++;
            j++;
        }

        while (i < m) {
            C[k] = A[i];
            k++;
            i++;
        }
        int midIndex = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            mid = (C[midIndex - 1] + C[midIndex]) * 0.5;
        } else {
            mid = C[midIndex] * 1.0;
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] a = {};
        int[] a1 = {10000};
        int[] a3 = {1};
        int[] b = {1};
        int[] b1 = {2, 3};
        int[] b2 = {10001};
        int[] b3 = {1};
        MedianOfTWOSortedArrays test = new MedianOfTWOSortedArrays();
        System.out.println(test.findMedianSortedArrays(a, b));
        System.out.println(test.findMedianSortedArrays(a1, b2));
        System.out.println(test.findMedianSortedArrays(a3, b3));
    }

}
