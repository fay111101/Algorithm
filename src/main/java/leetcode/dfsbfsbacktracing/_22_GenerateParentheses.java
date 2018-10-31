package leetcode.dfsbfsbacktracing;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class _22_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        StringBuffer res = new StringBuffer();
        String resstr = new String();
        dfs(n, n, resstr, result);
//        dfs1(n, n, res, result);
        return result;
    }

    public void dfs(int left, int right, String res, List<String> result) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(res);
            return;
        }
        dfs(left - 1, right, res + '(', result);
        System.out.println(res);
        dfs(left, right - 1, res + ')', result);
        System.out.println(res);
    }

    //TODO 有错误没有删除上一步的缓存
    public void dfs1(int left, int right, StringBuffer res, List<String> result) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(res.toString());
            return;
        }
        dfs1(left - 1, right, res.append('('), result);
        dfs1(left, right - 1, res.append(')'), result);
    }

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        _22_GenerateParentheses t = new _22_GenerateParentheses();
        res = t.generateParenthesis(2);
        for (String str : res) {
            System.out.println(str);
        }
    }
}
