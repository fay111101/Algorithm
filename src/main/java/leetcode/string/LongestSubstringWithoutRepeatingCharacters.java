package leetcode.string;

import java.util.HashMap;

/*Given a string, find the length of the longest substring
without repeating characters. For example, the longest substring
 without repeating letters for "abcabcbb" is "abc", which the
 length is 3. For "bbbbb" the longest substring is "b", with the
 length of 1. */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        //记录字符上一次出现的位置的后一个位置
        int[] map=new int[256];
        int max=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            //想不通 map[s.charAt(i)]<left
            if(map[s.charAt(i)]==0||map[s.charAt(i)]<left){
                max=Math.max(max,i-left+1);
            }else{

                left=map[s.charAt(i)];
            }
            map[s.charAt(i)]=i+1;
        }
        return max;
    }
    public int lengthOfLongestSubstring1(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        //记录字符上一次出现的位置的后一个位置,该位置有可能成为下一个left的值
        int[] map=new int[256];
        int max=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            left=Math.max(left,map[s.charAt(i)]);
            System.out.println("left:"+left);
            max=Math.max(max,i-left+1);
            map[s.charAt(i)]=i+1;
        }
        return max;
    }
    public int lengthOfLongestSubstring2(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            //map.get(s.charAt(i))
            //Exception in thread "main" java.lang.NullPointerException
            left=Math.max(left,map.containsKey(s.charAt(i))?map.get(s.charAt
                    (i)):0);
            System.out.println("left:"+left);
            max=Math.max(max,i-left+1);
            map.put(s.charAt(i),i+1);

        }
        return max;
    }
    public static void main(String[] args){
        String s="abcabcdb";
        String
        s1="wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorell" +
                "nmpapqfwkhopkmco";
        LongestSubstringWithoutRepeatingCharacters test=new
                LongestSubstringWithoutRepeatingCharacters();
        /*System.out.println(test.lengthOfLongestSubstring(s));
        System.out.println(test.lengthOfLongestSubstring1(s1));
        System.out.println(test.lengthOfLongestSubstring1(s));
        System.out.println(test.lengthOfLongestSubstring2(s));*/
        System.out.println(test.lengthOfLongestSubstring2(s1));
    }
}
