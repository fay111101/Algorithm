package leetcode.string;

/*Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. If you want a challenge,
please do not see below and ask yourself what are the possible input cases.
Notes: It is intended for this problem to be specified vaguely (ie, no given
input specs). You are responsible to gather all the input requirements up front.
spoilers alert... click to show requirements for atoi.
Requirements for atoi:
The function first discards as many whitespace characters as necessary until the
 first non-whitespace character is found. Then, starting from this character,
takes an optional initial plus or minus sign followed by as many numerical
digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral
number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid
integral number, or if no such sequence exists because either str is empty
or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned. If the
correct value is out of the range of representable values, INT_MAX (2147483647)
or INT_MIN (-2147483648) is returned.*/
/*注意：主要考虑正负号，中间出现字母，溢出问题*/
public class _8_AtoI {


    public static int atoi(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        str = str.trim();
        if(str.equals("")){
            return 0;
        }
        char flag = '+';
        int i = 0;
        if (str.charAt(i) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        double result = 0;
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
        if (flag == '-') {

            result = -result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int res = atoi("-2147483649");
        int res1 = atoi("2147483649");
        int res2 = atoi("214");
        int res3 = atoi("+1");
        int res4 = atoi("1");
        int res5 = atoi("-2147483647");
        int res6 = atoi("1a");
        int res87 = atoi("10a");
        int res7 = atoi("   ");
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
        System.out.println(res6);
        System.out.println(res7);
    }
}
