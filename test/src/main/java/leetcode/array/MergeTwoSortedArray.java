package leetcode.array;

/**
 * Created by fay on 2017/12/8.
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 Note:
 You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 */
public class MergeTwoSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int count = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            A[count--] = A[m] > B[n] ? A[m--] : B[n--];
        }
        while (n >= 0) {
            A[count--] = B[n--];
        }
    }

    void merge1(int A[], int m, int B[], int n) {
        int[] temp = new int[m + n];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < m && j < n) {
            if (A[i] >= B[j]) {
                temp[index++] = B[j++];
            } else {
                temp[index++] = A[i++];
            }
        }
        while (i < m) {
            temp[index++] = A[i++];
        }
        while (j < n) {
            temp[index++] = B[j++];
        }
        for (i =0;i<index ; i++){
            A[i] = temp[i];
        }
    }
}
