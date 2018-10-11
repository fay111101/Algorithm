package offer.string;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 */
public class _4_ReplaceSpace {

    public String replaceSpace(String str) {
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

    public String replaceSpace1(String s){
        if(s==null||s.length()==0) return null;
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ')
                count++;
        }
        int oldLen=s.length();
        int newLen=oldLen+2*count;
        char[] newC=new char[newLen];
        System.arraycopy(s.toCharArray(),0,newC,0,s.length());
        int i=oldLen-1,j=newLen-1;
        while(i>=0&&i<j){
            if(newC[i]==' '){
                newC[j--]='0';
                newC[j--]='2';
                newC[j--]='%';

            }else{
                newC[j--]=newC[i];
            }
            i--;
        }
        String newStr=new String(newC);
        return newStr;
    }



}
