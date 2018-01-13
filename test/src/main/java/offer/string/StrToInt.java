package offer.string;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 输入描述:
 输入一个字符串,包括数字字母符号,可以为空
 输出描述:
 如果是合法的数值表达则返回该数字，否则返回0
 示例1
 输入

 +2147483647
 1a33
 输出

 2147483647
 0
 */
public class StrToInt {
    public int StrToInt(String str) {
        if(str == null || str.length() == 0)return 0;
        int start;
        int tag ;
        if(str.charAt(0)=='+'){
            tag = 1;
            start = 1;
        }else if (str.charAt(0)=='-') {
            tag = 0;
            start =1;
        }else{
            tag = 1;
            start = 0;
        }
        long result = 0;
        for(int i=start;i<str.length();i++){
            char tmp = str.charAt(i);
            if(tmp >= '0'&& tmp<='9'){
                result = result*10 +(tmp-'0');
                if(tag == 1 && result>Integer.MAX_VALUE)
                    throw new RuntimeException("上溢出");
                if(tag == 0 && result<Integer.MIN_VALUE)
                    throw new RuntimeException("下溢出");
            }else {
                return 0;
            }
        }
        if(tag == 0)
            return (int) (-1*result);
        else{
            return (int) result;
        }
    }
}
