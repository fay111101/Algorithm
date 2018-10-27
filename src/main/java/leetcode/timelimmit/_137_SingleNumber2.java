package leetcode.timelimmit;

import java.util.Arrays;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 */
public class _137_SingleNumber2 {

    public int singleNumber(int[] A) {
        //1、肯定是排序
        Arrays.sort(A);
        //2、肯定是每三个数一组
        for (int i = 0; i < A.length - 3; i += 3) {
        //3、只需要比较每组的第一和第二个数是否相等
            if ((A[i] != A[i + 1])){
                return A[i];
            }
        }
        return A[A.length - 1];//每三个一组，最后的一个是single one
    }


}
