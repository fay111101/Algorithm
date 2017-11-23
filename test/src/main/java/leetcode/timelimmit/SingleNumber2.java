package leetcode.timelimmit;

import java.util.Arrays;

/*Given an array of integers, every element appears three times except for one.
 Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it
without using extra memory?*/
public class SingleNumber2 {
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
