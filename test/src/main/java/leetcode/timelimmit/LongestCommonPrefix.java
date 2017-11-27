package leetcode.timelimmit;
/*Write a function to find the longest common prefix string amongst an array of strings.*/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        String res=new String();
        for(int i=0;i<strs[0].length();i++){
            char ch=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()<=i||strs[j].charAt(i)!=ch){
                    return res;
                }
            }
            res+=Character.toString(ch);
        }
        return res;
    }
    public static void main(String[] args){
        String[] strs={"aa","a"};
        LongestCommonPrefix test=new LongestCommonPrefix();
        test.longestCommonPrefix(strs);
    }

}
