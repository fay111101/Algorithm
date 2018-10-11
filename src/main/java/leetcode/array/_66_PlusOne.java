package leetcode.array;

/**
 * Created by fay on 2017/12/7.
 * Given a number represented as an array of digits, plus one to the number.
 * 大数加法
 * 当每个位都是9时，给数组加一位，返回
 */
public class _66_PlusOne {

    public int[] plusOne(int[] digits) {
        int n=digits.length;
        for(int i=n-1;i>=0;i--){
            if(digits[i]<9){
                ++digits[i];
                return digits;
            }
            digits[i]=0;
        }
        int[] res=new int[n+1];
        res[0]=1;
        return res;
    }
}
