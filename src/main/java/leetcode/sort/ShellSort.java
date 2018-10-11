package leetcode.sort;

public class ShellSort {

    /**
     * 希尔按增量d的插入排序
     *
     * @param arrays 无序数组
     */
    public static void shellSort(int[] arrays) {
        if (arrays == null || arrays.length <= 1) {
            return;
        }
        //增量
        int incrementNum = arrays.length / 2;
        while (incrementNum >= 1) {
            for (int i = 0; i < arrays.length; i++) {
                //进行插入排序
                for (int j = i; j < arrays.length - incrementNum; j = j + incrementNum) {
                    if (arrays[j] > arrays[j + incrementNum]) {
                        int temple = arrays[j];
                        arrays[j] = arrays[j + incrementNum];
                        arrays[j + incrementNum] = temple;
                    }
                }
            }
            //设置新的增量
            incrementNum = incrementNum / 2;
        }
    }

    public static void main(String[] args) {
        int[] data = {0, 1, 2, 7, 45, 8, 21, 81, -1, 0, 9, 41, 98, 26, 17, 67, 89, 34, 23, 12, 20};
        ShellSort.shellSort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }


}
