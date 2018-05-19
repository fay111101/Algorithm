package leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fay on 2017/12/11.
 * https://segmentfault.com/a/1190000009525540
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 For example, given:
 S:"barfoothefoobarman"
 L:["foo", "bar"]
 You should return the indices:[0,9].
 (order does not matter).
 */
public class SubstringWithConcatenationOfAllWords {
    //words字符串存在重复值时不可用
    public ArrayList<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(words.length == 0){
            return result;
        }
        int wordLength = words[0].length();
        int allWordsLength = words.length;
        Map<String, Integer> wordMap = new HashMap<String, Integer>();

        for(int j = 0 ; j<words.length ; j++){
            wordMap.put(words[j], -1);
        }

        int start = 0;
        for(int i = 0 ; i<s.length()-wordLength ;){
            String current = s.substring(i, i+wordLength);
            if(wordMap.containsKey(current)){
                int key = wordMap.get(current);
                //出现重复情况
                if(key>=start){
                    start = key + wordLength;
                    //长度等于所有长度
                }else if(i-start == wordLength*(allWordsLength-1)){
                    result.add(start);
                    start+=wordLength;
                }
                wordMap.replace(current, i);
                i+=wordLength;
                continue;
            }
            i++;
            start = i;
        }
        return result;
    }
    public ArrayList<Integer> findSubstring1(String s, String[] words) {
        HashMap<String,Integer> map=new HashMap<>();
        ArrayList<Integer> result=new ArrayList<>();
        if(words.length==0){
            return result;
        }
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.containsKey(words[i])?map.get(words[i])+1:1);
        }
        int wordLen=words[0].length();
        for(int start=0;start<=s.length()-wordLen*words.length;start++){
            Map<String,Integer> copy=new HashMap<String, Integer>(map);
            for(int i=start;i<start+wordLen*words.length;i=i+wordLen){
                String tmp=s.substring(i,i+wordLen);
                if(copy.containsKey(tmp)){
                    int count=copy.get(tmp);
                    if(count==1){
                        copy.remove(tmp);
                    }else{
                        //copy.put(tmp,count--);
                        copy.put(tmp,count-1);
                    }
                    if(copy.isEmpty()){
                        result.add(start);
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        return  result;
    }
    public static void main(String[] args){
        SubstringWithConcatenationOfAllWords test=new SubstringWithConcatenationOfAllWords();
        String s="a";
        String[] words={"a"};
        ArrayList<Integer> poss=test.findSubstring1(s,words);
        for(int i:poss){
            System.out.print(i);
        }
    }
}
