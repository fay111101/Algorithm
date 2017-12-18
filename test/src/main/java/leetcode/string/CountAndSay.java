package leetcode.string;
/* The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1is read off as"one 1"or11.
11is read off as"two 1s"or21.
21is read off as"one 2, thenone 1"or1211.

Given an integer n, generate the n th sequence.

Note: The sequence of integers will be represented as a string. */
public class CountAndSay {
    public String countAndSay(int n) {
        if(n<=0){
            return "";
        }
        String res=new String();
        res="1";
        while(--n>0){
            String cur=new String();
            for(int i=0;i<res.length();i++){
                int count=1;
                while(i+1<res.length()&&res.charAt(i)==res.charAt(i+1)){
                    count++;
                    i++;
                }
                cur=cur+String.valueOf(count)+res.charAt(i);
            }
            res=cur;
        }
        return res;
    }
    public  static void main(String[] args){
        CountAndSay test=new CountAndSay();
        //"312211"
        System.out.println(test.countAndSay(6));
    }
}
