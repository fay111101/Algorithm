package offer.string;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        if(str==null){
            return  null;
        }
        StringBuffer newstr=new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                newstr.append('%');
                newstr.append('2');
                newstr.append('0');
            }else{
                newstr.append(str.charAt(i));
            }
        }
        return newstr.toString();
    }
}
