package leetcode.sort;

public class SelectSort {

    public static void selectSort(int[] arr) {
        int i, j;
        int minValue = Integer.MAX_VALUE;
        int indexMin = Integer.MAX_VALUE;
        int temp;
        int index = arr.length;
        //每次在无序区(0—n-1 1—n-1 2—n-1 ...)选择最小的数与当前要扩进去的值做交换
        for (i = 0; i < index - 1; i++) {
            for (j = i; j < index; j++) {
                if (arr[j] < minValue) {
                    minValue = arr[j];
                    indexMin = j;
                }
            }
            temp = arr[indexMin];
            arr[indexMin] = arr[i];
            arr[i] = temp;
            minValue = arr[i + 1];
            indexMin = i + 1;

        }

    }

    public static void main(String[] args) {
        int[] data = {0, 1, 2, 7, 45, 8, 21, 81, -1, 0, 9, 41, 98, 26, 17, 67, 89, 34, 23, 12, 20};
        SelectSort.selectSort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}
