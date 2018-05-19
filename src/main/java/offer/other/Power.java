package offer.other;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {
    public double Power(double base, int exponent) {
        long p = Math.abs((long)exponent);
        double r = 1.0;
        while(p!=0){
            if((p & 1)==1) r *= base;
            base *= base;
            p >>= 1;
        }
        return exponent < 0 ? 1/ r : r;
    }
}
