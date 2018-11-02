package leetcode.string;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 */
public class _58_LastWordLength {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sLen = s.length();
        int i = 0;
        int count = 0;
        while (sLen>0&&s.charAt(sLen-1) == ' ') {
            sLen--;
        }
        for (i = sLen - 1; i >= 0; i--) {
            if(s.charAt(i)==' '){
                break;
            }
            count++;
        }
        return count;
    }

    public int lengthOfLastWord1(String s) {
        int right=s.length()-1,res=0;
        while(right>=0&&s.charAt(right)==' '){
            right--;
        }
        while(right>=0&&s.charAt(right)!=' '){
            right--;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s=" ";
        lengthOfLastWord(s);
    }
}
