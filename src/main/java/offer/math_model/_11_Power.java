package offer.math_model;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class _11_Power {

    public double power1(double base, int exponent) {
        long p = Math.abs((long) exponent);
        double r = 1.0;
        while (p != 0) {
            //奇数偶数的判断，公式
            if ((p & 1) == 1) r *= base;
            base *= base;
            p >>= 1;
        }
        return exponent < 0 ? 1 / r : r;
    }


    boolean g_InvalidInput = false;

    double absExponentPower(double base, int exponent) {
        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    boolean equalcase(double num1, double num2) {
        if (num1 - num2 < 0.000000001 && num1 - num2 > -0.000000001)
            return true;
        else
            return false;

    }

    double power(double base, int exponent) {
        double result = 0.0;
        g_InvalidInput = false;
        if (equalcase(base, 0.0) && exponent < 0) {
            g_InvalidInput = true;
            return 0.0;
        }
        int absExponent = (int) (exponent);
        if (exponent < 0) {
            absExponent = -exponent;
            result = absExponentPower(base, absExponent);
            result = 1.0 / result;
        } else
            result = absExponentPower(base, exponent);
        return result;
    }

    public static void main(String[] args) {
        Math.pow(1, 2);
    }
}
