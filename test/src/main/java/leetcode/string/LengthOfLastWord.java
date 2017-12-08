package leetcode.string;

/**
 * Created by fay on 2017/12/7.
 *
 Given a string s consists of upper/lower-case alphabets and empty space characters' ', return the length of last word in the string.
 If the last word does not exist, return 0.
 Note: A word is defined as a character sequence consists of non-space characters only.
 For example,
 Given s ="Hello World",
 return5.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
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

}
