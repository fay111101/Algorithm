package leetcode.string;
/*Validate if a given string is numeric.
Some examples:
"0"=>true
" 0.1 "=>true
"abc"=>false
"1 a"=>false
"2e10"=>true
Note: It is intended for the problem statement to be ambiguous. You should gather
all requirements up front before implementing one.*/
public class isNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s == null || s.length() == 0)
            return false;
// 记录是否出现过数字
        boolean numberSeen = false;
// 是否出现过小数点
        boolean pointSeen = false;
// 是否出现过指数标志e
        boolean eSeen = false;
// e后是否出现过数字
        boolean numberAfterE = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
// 如果是数字
            if (c >= '0' && c <= '9') {
                numberSeen = true;
                numberAfterE = true;
// 如果是小数点
            } else if (c == '.') {
                if (pointSeen || eSeen)
                    return false;
                pointSeen = true;
// 如果是e，必须没有出现过且出现过数字
            } else if (c == 'e') {
                if (eSeen || !numberSeen)
                    return false;
                eSeen = true;
                numberAfterE = false;
// 如果出现正负号，必须是首位，或者前一位是e
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e')
                    return false;
            } else
                return false;
        }
        return numberSeen && numberAfterE;
    }
}
