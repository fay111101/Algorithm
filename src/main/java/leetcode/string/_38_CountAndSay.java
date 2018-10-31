package leetcode.string;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 *
 * 题目解读：
 * 数数并说序列是一个整数序列，第二项起每一项的值为对前一项的计数，
 */
public class _38_CountAndSay {

    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String res = new String();
        res = "1";
        while (--n > 0) {
            String cur = new String();
            for (int i = 0; i < res.length(); i++) {
                int count = 1;
                while (i + 1 < res.length() && res.charAt(i) == res.charAt(i + 1)) {
                    count++;
                    i++;
                }
                cur = cur + String.valueOf(count) + res.charAt(i);
            }
            res = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        _38_CountAndSay test = new _38_CountAndSay();
        //"312211"
        System.out.println(test.countAndSay(6));
    }
}
