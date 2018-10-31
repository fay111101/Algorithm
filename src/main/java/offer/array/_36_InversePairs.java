package offer.array;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * 示例1
 * 输入
 *
 * 1,2,3,4,5,6,7,0
 * 输出
 *
 * 7
 */
public class _36_InversePairs {


    long count = 0;

    public int InversePairs(int[] array) {
        if (array == null || array.length < 2) return 0;
        int len = array.length;
        mergeSort(array, 0, len - 1);
        return (int) (count % 1000000007);
    }

    void mergeSort(int[] array, int i, int j) {
        if (i >= j) return;
        int mid = (j - i) / 2 + i;
        mergeSort(array, i, mid);
        mergeSort(array, mid + 1, j);
        merge(array, i, mid, j);

    }

    public void merge(int[] array, int start, int mid, int end) {
        if (start == end) return;
        int after = mid + 1;
        int before = mid;
        int a[] = new int[end - start + 1];
        int m = end - start;//辅助数组中最后那个下标
        while (before >= start && after <= end ) {
            if (array[end] < array[before]) {
                a[m] = array[before];
                count += (end-mid);//当后半段的值最后一个值比前半段的最后一个值，则此时逆序对的总数等于后半段最末下标-分开的中间位置
                before--;
            } else {
                a[m] = array[end];//后半段的值比前半段的值大，不存在逆序对
                end--;
            }
            m--;
        }

        while (before >= start) {
            a[m--] = array[before--];
        }

        while (after <= end)
            a[m--] = array[end--];

        for (int n = 0; n < a.length; n++) {
            array[start++] = a[n];
        }


    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49};

        _36_InversePairs test=new _36_InversePairs();
        test.InversePairs(arr);
        Arrays.sort(arr);
    }


}
