package leetcode.other;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class _20_ValidCom {

    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }
        boolean result = false;
        Stack stack = new Stack();

        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char ch1 = getChar(s.charAt(i));
            if (!stack.isEmpty()) {
                if (stack.peek().equals(ch1)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }

        }
        if (stack.isEmpty()) {
            result = true;
        }
        return result;
    }

    public char getChar(char ch) {
        switch (ch) {
            case '[':
                return ']';
            case ']':
                return '[';
            case '(':
                return ')';
            case ')':
                return '(';
            case '{':
                return '}';
            case '}':
                return '{';
            default:
                return ' ';
        }
    }
}
