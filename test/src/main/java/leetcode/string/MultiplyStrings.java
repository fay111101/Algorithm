package leetcode.string;

/**
 * Created by fay on 2017/12/11.
 *
 Given two numbers represented as strings, return multiplication of the numbers as a string.
 Note: The numbers can be arbitrarily large and are non-negative.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int n1=num1.length();
        int n2=num2.length();
        StringBuilder result=new StringBuilder();
        int[] tmp=new int[n1+n2];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                tmp[i+j+1]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        int carry=0;
        for(int i=n1+n2-1;i>=0;i--){
            tmp[i]+=carry;
            carry=tmp[i]/10;
            tmp[i]=tmp[i]%10;
        }
        int i=0;
        while(i<n1+n2-1&&tmp[i]==0){
            i++;
        }
        while(i<n1+n2){
            result.append(tmp[i++]);
        }
        return result.toString();
    }
    public static void main(String[] args){
        String n1="289";
        String n3="0";
        String n2="758";
        String n4="0";
        MultiplyStrings test=new MultiplyStrings();
        System.out.println(test.multiply(n1,n2));
        System.out.println(test.multiply(n3,n4));
    }
}
