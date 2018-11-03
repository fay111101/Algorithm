package leetcode.dfsbfsbacktracing;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class _93_RestoreIpAddress {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() > 12) {
            return result;
        }
        String res = new String();
        dfs(s, res, result, 4);
        return result;
    }

    private void dfs(String s, String res, List<String> result, int k) {
        if (k == 0 && s.isEmpty()) {
            result.add(res);
            return;
        } else {
            for (int i = 1; i <= 3; i++) {
                if (s.length() >= i && isValid(s.substring(0, i))) {
                    if (k == 1) {
                        dfs(s.substring(i), res + s.substring(0, i), result, k - 1);
                    } else {
                        dfs(s.substring(i), res + s.substring(0, i) + ".", result, k - 1);
                    }
                }
            }
        }

    }

    private boolean isValid(String s) {
        if (s.isEmpty() || s.length() > 3 || (s.length() > 1 && s.charAt(0) == '0')) {
            return false;
        }
        int num = Integer.parseInt(s);
        if (0 <= num && num <= 255) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        _93_RestoreIpAddress test = new _93_RestoreIpAddress();
        List<String> result = test.restoreIpAddresses("25525511135");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
