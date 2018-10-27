package leetcode.string;
/*Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. If you want a challenge,
please do not see below and ask yourself what are the possible input cases.
Notes: It is intended for this problem to be specified vaguely (ie, no given
input specs). You are responsible to gather all the input requirements up front.
spoilers alert... click to show requirements for atoi.
Requirements for atoi:
The function first discards as many whitespace characters as necessary until the
 first non-whitespace character is found. Then, starting from this character,
takes an optional initial plus or minus sign followed by as many numerical
digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral
number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid
integral number, or if no such sequence exists because either str is empty
or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned. If the
correct value is out of the range of representable values, INT_MAX (2147483647)
or INT_MIN (-2147483648) is returned.*/
/*注意：主要考虑正负号，中间出现字母，溢出问题*/
public class _8_AtoI {
    public static int atoi(String str) {
       if(str==null||str.length()==0){
           return 0;
       }
       str=str.trim();
       char flag='+';
       int i=0;
       if(str.charAt(i)=='-'){
           flag='-';
           i++;
       }else if(str.charAt(i)=='+'){
           i++;
       }
       double result=0;
       while(str.length()>i&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
           result=result*10+(str.charAt(i)-'0');
           i++;
       }
        if (flag == '-') {

           result=-result;
        }
        if(result>Integer.MAX_VALUE){
           return Integer.MAX_VALUE;
        }
        if(result<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)result;
       /* if(str==null||str.length()==0){
            return 0;
        }
        boolean minus=false;
        int index=0;
        int result=0;
        boolean flag=false;
        char[] strArr=str.trim().toCharArray();
        if (strArr[0] == '-') {
            minus=true;

        }else if(strArr[0] == '+'){
            minus=false;
        }else if(strArr[0]>='0'&&strArr[0]<='9'){
            flag=true;
        }else{
            return 0;
        }
        int len=strArr.length;
        for(int i=1;i<len;i++){
            if(strArr[i]>='0'&&strArr[i]<='9'){
                if(result>Integer.MAX_VALUE/10||(result==Integer
                        .MAX_VALUE/10&&strArr[i]-'7'>0)){
                    return minus==false?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                result=(strArr[i]-'0')+result*10;
                index++;
            }else{
                return minus==false?result:-result;
            }


        }
        int temp=strArr[0]-'0';
        while(index>0){
            temp*=10;
            index--;
        }
        if(result>=Integer.MAX_VALUE/100&&minus==false){
            return minus==false?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }

        if(flag){
            result=result+temp;
        }
        result=minus==false?result:-result;


        return result;*/

    }
    public static void main(String[] args){
        int res=atoi("-2147483649");
        int res1=atoi("2147483649");
        int res2=atoi("214");
        int res3=atoi("+1");
        int res4=atoi("1");
        int res5=atoi("-2147483647");
        int res6=atoi("1a");
        int res7=atoi("10a");
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
        System.out.println(res6);
        System.out.println(res7);
    }
}
