package leetcode.timelimmit;
/*Given an array of integers, every element appears twice except for one.
Find that single one.
Note:
Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?
提示：任何一个数字异或它自己都等于0;0异或这个数等于这个数本身*/
public class SingleNumber {
    public static int singleNumber(int[] A) {
        int num=0;
        for(int i=0;i<A.length;i++){
            num=num^A[i];
        }
        return num;
    }
    public static void  main(String[] args){
        int[] arr={1,2,2,1,4,5,5};
        System.out.println(singleNumber(arr));
    }
}
