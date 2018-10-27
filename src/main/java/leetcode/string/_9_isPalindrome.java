package leetcode.string;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一
 */
public class _9_isPalindrome {

    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        } else if (x < 0) {
            return false;
        }
        int tmp = x;
        int constrast = 0;
        while (tmp > 0) {
            constrast = constrast * 10 + tmp % 10;
            tmp /= 10;

        }
        return constrast == x;
    }

    public boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int reversedHalf = 0;
        while (x > reversedHalf) {
//            int rest =  x%10;
//            reversedHalf = reversedHalf*10 + rest;
            reversedHalf = reversedHalf * 10 + x % 10;
            x = x / 10;
        }
        return reversedHalf == x || x == reversedHalf / 10;
    }

}
