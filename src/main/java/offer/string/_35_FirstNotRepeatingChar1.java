package offer.string;

import java.util.BitSet;
import java.util.HashMap;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class _35_FirstNotRepeatingChar1 {



    /**
     * 使用 HashMap 对出现次数进行统计，但是考虑到要统计的字符范围有限，因此可以使用整型数组代替 HashMap。
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        int[] cnts = new int[256];
        for (int i = 0; i < str.length(); i++)
            cnts[str.charAt(i)]++;
        for (int i = 0; i < str.length(); i++)
            if (cnts[str.charAt(i)] == 1)
                return i;
        return -1;
    }


    /**
     * BitSet
     *应用场景：
     * 1.     统计一组大数据中没有出现过的数；
     *
     *         将这组数据映射到BitSet，然后遍历BitSet，对应位为0的数表示没有出现过的数据。
     *
     * 2.     对大数据进行排序；
     *
     *         将数据映射到BitSet，遍历BitSet得到的就是有序数据。
     *
     * 3.     在内存对大数据进行压缩存储等等。
     *
     *         一个GB的内存空间可以存储85亿多个数，可以有效实现数据的压缩存储，节省内存空间开销。
     * }
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar2(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c))
                bs1.set(c);     // 0 0 -> 0 1
            else if (bs1.get(c) && !bs2.get(c))
                bs2.set(c);     // 0 1 -> 1 1
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (bs1.get(c) && !bs2.get(c))  // 0 1
                return i;
        }
        return -1;
    }


    public int FirstNotRepeatingChar3(String str) {
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
