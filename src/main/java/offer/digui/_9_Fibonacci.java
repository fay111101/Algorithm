package offer.digui;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 n<=39
 */
public class _9_Fibonacci {
    public int Fibonacci(int n) {
        if(n<=0){
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        int f1 = 0;
        int f2 = 1;
        int res = 0;
        int i = 2;
        while (i <= n) {
            res = f1+f2;
            f1=f2;
            f2=res;
            i++;
        }
        return res;

    }
}
