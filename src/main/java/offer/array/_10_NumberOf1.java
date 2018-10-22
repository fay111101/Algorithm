package offer.array;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class _10_NumberOf1 {

    public int  NumberOf1(int n) {

        int count=0;
        int flag=1;
        while(flag!=0){
            if((flag&n)!=0){
                count++;
            }
            flag=flag<<1;
        }
        return count;
    }

    /**
     * n&(n-1)
     * 该位运算去除 n 的位级表示中最低的那一位。
     *
     * n       : 10110100
     * n-1     : 10110011
     * n&(n-1) : 10110000
     * 时间复杂度：O(M)，其中 M 表示 1 的个数。
     * @param n
     * @return
     */
    public int NumberOf1_1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }

    public int NumberOf1_2(int n) {
        return Integer.bitCount(n);
    }
}
