package leetcode.sort;

public class HeapSort {

    public static void percolate_down(int data[], int r, int n) {
        int c = 2 * r + 1;

        while (c < n) {
            if (c < n - 1 && data[c] < data[c + 1]) {//c变为较大的孩子节点
                c++;
            }
            if (data[r] < data[c]) {
                int temp = data[c];
                data[c] = data[r];
                data[r] = temp;
                r = c;
                c = 2 * c + 1;
            } else {
                break;
            }
        }
    }

    public static void create_heap(int data[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {

            percolate_down(data, i, n);
        }
    }

    //较好理解的建堆的算法
    public static void heap_sort(int data[], int n) {
        create_heap(data, n);
        for (int i = n - 1; i >= 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            percolate_down(data, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 7, 45, 8, 21, 81, -1, 0, 9, 41, 98, 26, 17, 67, 89, 34, 23, 12, 20};
        heap_sort(data, 20);
        for (int i = 0; i < 20; i++) {
            System.out.println(data[i]);
        }

    }

}
