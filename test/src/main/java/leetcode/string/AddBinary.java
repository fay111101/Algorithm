package leetcode.string;

/**
 * Created by fay on 2017/12/7.
 * Given two binary strings, return their sum (also a binary string).
 For example,
 a ="11"
 b ="1"
 Return"100".

 */
public class AddBinary {
    public String addBinary(String a, String b) {
        String res=new String();
        int m=a.length()-1,n=b.length()-1;
        int carry=0;
        while(m>=0||n>=0){
            int p=m>=0?a.charAt(m--)-'0':0;
            int q=n>=0?b.charAt(n--)-'0':0;
            int sum=q+p+carry;
            res=String.valueOf(sum%2)+res;
            carry=sum/2;
        }
        return carry==1?"1"+res:res;
    }
    public static void main(String[] args){
        AddBinary test=new AddBinary();
        System.out.print(test.addBinary("0","1"));
    }
}
