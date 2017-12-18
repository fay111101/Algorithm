package leetcode.string;
/* Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null
if needle is not part of haystack.strstr(str1,str2)
函数用于判断字符串str2是否是str1的子串。如果是，则该函数返回str2在str1中首次出现的地址；
否则，返回NULL。
*/
public class ImplementStrstr {
    public String strStr(String haystack,String needle){
        if(haystack==null||needle==null){
            return null;
        }
        int m=haystack.length();
        int n=needle.length();
        if(n==0){
            return haystack.substring(0);
        }
        if(n>m){
            return null;
        }
        for(int i=0;i<=m-n;i++){
            int j=0;
            for(;j<n;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
                if(j==n-1){
                    return haystack.substring(i);
                }
            }
        }
        return null;
    }
    public static void main(String[] args){
        String a="ababcb";
        String b="abc";
        ImplementStrstr test=new ImplementStrstr();
        System.out.println(test.strStr(a,b));

    }
}
