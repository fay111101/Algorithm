package leetcode.other;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class _29_DivideTwoIntergers {

    /**
     * 不能用乘法，我们可以移位啊，移p位就相当于乘了2p
     * <p>
     * 举例说明我的方法：
     * <p>
     * f(24,5)=24/5=20/5+4/5=4+0=4
     * <p>
     * 5左移2位就是20，而左移3位就是40超过了24，因此第一部分商为2+2=4.
     * <p>
     * 对余数4再进行分析，发现5不需要移位就比4大，因此第二部分商为0.
     * <p>
     * 加和可得，商为4.
     * <p>
     * 注意：先提升为long long int，再对结果判断是否溢出会简化很多。
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        int result = 0;
        if (divisor == 0) //除数为0，返回最大值
            return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return ~dividend;
        }
        long dividend1 = Math.abs((long) dividend);
        long divisor1 = Math.abs((long) divisor);

        //当被除数大于除数时，进行位移操作
        while (dividend1 >= divisor1) {
            int shiftnum = 0;
            while (dividend1 >= divisor1 << shiftnum) {
                //记录左移次数（比实际次数多1）
                shiftnum++;
            }
            result += 1 << (shiftnum - 1);
            //更新被除数的值
            dividend1 -= divisor1 << (shiftnum - 1);
        }

        //计算正负数
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            return result;
        else
            return -result;
    }

    public static int divide1(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int num = 0;
        long sum;
        while (b <= a) {
            sum = b;
            int count = 1;
            //加速运算
            while (sum + sum <= a) {
                count += count;
                sum += sum;
            }
            a = a - sum;
            num = num + count;
        }
        if ((dividend < 0 && divisor > 0) || dividend > 0 && divisor < 0) {
            num = -num;
        }
        return num;
    }

    public static void main(String[] args) {
        int a = 10, b = 3;
        System.out.println(divide(10, 3));
    }
}
