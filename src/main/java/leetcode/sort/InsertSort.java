package leetcode.sort;

public class InsertSort {

    public static void insertSort(int[] arr) {
        int i = 0, j = 0;
        //欲插入数据变量
        int insertNode;
        int index = arr.length;
        //依次插入数据
        for (i = 1; i < index; i++) {
            //设定欲插入的数值
            insertNode = arr[i];
            j = i - 1;
            while (j >= 0 && insertNode < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            //将数值插入
            arr[j + 1] = insertNode;
        }

    }

    public static void main(String[] args) {
        int[] data = {0, 1, 2, 7, 45, 8, 21, 81, -1, 0, 9, 41, 98, 26, 17, 67, 89, 34, 23, 12, 20};
        InsertSort.insertSort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}
