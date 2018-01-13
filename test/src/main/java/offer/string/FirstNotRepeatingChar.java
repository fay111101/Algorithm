package offer.string;

import java.util.HashMap;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if(str==null||str.length()==0){
            return -1;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if(map.containsKey(c))
            {
                int time=map.get(c);
                time++;
                map.put(c,time);

            }
            else
            {
                map.put(c,1);
            }
        }
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if(map.get(c)==1)
                return i;
        }
        return -1;
    }
}
