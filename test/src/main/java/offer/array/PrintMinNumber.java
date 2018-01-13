package offer.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if(numbers==null||numbers.length==0){
            return "";
        }
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<numbers.length;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list,new Comparator<Integer>(){
            public int compare(Integer n1,Integer n2){
                String str1=n1+""+n2;
                String str2=n2+""+n1;
                return str1.compareTo(str2);
            }

        });
        String res="";
        for(int j=0;j<list.size();j++){
            res+=list.get(j);
        }
        return res;

    }
}
