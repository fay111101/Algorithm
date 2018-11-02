package leetcode.string;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class _43_MultiplyStrings {

    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        StringBuilder result = new StringBuilder();
        int[] tmp = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                tmp[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int carry = 0;
        for (int i = n1 + n2 - 1; i >= 0; i--) {
            tmp[i] += carry;
            carry = tmp[i] / 10;
            tmp[i] = tmp[i] % 10;
        }
        int i = 0;
        while (i < n1 + n2 - 1 && tmp[i] == 0) {
            i++;
        }
        while (i < n1 + n2) {
            result.append(tmp[i++]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String n1 = "289";
        String n3 = "0";
        String n2 = "758";
        String n4 = "0";
        _43_MultiplyStrings test = new _43_MultiplyStrings();
        System.out.println(test.multiply(n1, n2));
        System.out.println(test.multiply(n3, n4));
    }
}
