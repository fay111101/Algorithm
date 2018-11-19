package leetcode.sort;

import java.util.Arrays;

public class AgeSort {
    public static void main(String[] args) {

        int[] ages = new int[] { 23, 45, 32, 43, 21, 24, 25, 23, 22, 22, 21 };
        System.out.println("原数组为：" + Arrays.toString(ages));
        AgeSort as = new AgeSort();
        as.sortAge(ages);
        System.out.println("排序后的数组为：" + Arrays.toString(ages));
    }

    private void sortAge(int[] ages) {

        if (ages == null || ages.length < 1) {
            return;
        }
        int oldAge = 80;
        int youngAge = 20;

        // 初始化一个odlAge+1的数组
        int[] timeOfAge = new int[oldAge -youngAge];
        // 将数组元素都置为0
        for (int i = 0; i < timeOfAge.length; i++) {
            timeOfAge[i] = 0;
        }
        // 某个年龄出现了多少次，就在timeOfAge数组对应年龄的位置设置多少次
        for (int j = 0; j < ages.length; j++) {
            int a = ages[j];
            timeOfAge[a]++;
        }

        int index = 0;
        for (int i = youngAge; i <= oldAge; i++) {// 按照年龄从小到达依次遍历timeOfAge
            for (int j = 0; j < timeOfAge[i]; j++) {// 在timeOfAge中取得各个年龄位置记录的出现次数
                ages[index] = i;// 将新数组从头设置出现的年龄，已经排好序
                index++;
            }
        }
    }
}
