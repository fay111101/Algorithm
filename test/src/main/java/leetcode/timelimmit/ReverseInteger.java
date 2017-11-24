package leetcode.timelimmit;

import com.sun.org.apache.regexp.internal.RE;

/*

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.
Have you thought about this?

Here are some good questions to ask before coding. Bonus points for you if you
have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as
10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a
 32-bit integer, then the reverse of 1000000003 overflows. How should you handle
  such cases?

Throw an exception? Good, but what if throwing an exception is not an option?
You would then have to re-design the function (ie, add an extra parameter).
*/
public class ReverseInteger {
    public int reverse(int x) {
        long newNum=0;
        int temp=0;
        while(x!=0){
            temp=x%10;
            newNum=newNum*10+temp;
            if(newNum>Integer.MAX_VALUE){
                return 0;
            }
            x=x/10;
        }
        return (int)newNum;
    }
    public static void main(String[] args){
        int x=123;
        int x1=-123;
        int x2=1233897879;
        ReverseInteger test=new ReverseInteger();
        System.out.println(test.reverse(x));
        System.out.println(test.reverse(x1));
        System.out.println(test.reverse(x2));
        System.out.println(Integer.MAX_VALUE+" "+Integer.MIN_VALUE);
    }

}
