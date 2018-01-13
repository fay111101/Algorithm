package offer.string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 输入描述:
 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res=new ArrayList<String>();
        if(str==null||str.length()==0){
            return res;
        }
        Permutation(str.toCharArray(),0,res);
        Collections.sort(res);
        return res;
    }
    public void Permutation(char[] arr,int i,ArrayList<String> res){
        if(i==arr.length-1){
            res.add(String.valueOf(arr));
        }else{
            for(int j=i;j<arr.length;j++){
                if((arr[j]==arr[i])&&(j!=i)){
                    continue;
                }else{
                    swap(arr,i,j);
                    Permutation(arr,i+1,res);
                    swap(arr,i,j);
                }
            }
        }
    }
    public void swap(char[]arr,int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }
}
