package main.java.leetcode.string;

import java.util.ArrayList;

/* Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces' 'when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words:["This", "is", "an", "example", "of", "text", "justification."]
L:16.

Return the formatted lines as:

[
   "This is an",
   "example of text",
   "justification.  "
]
*/
public class TextJustify {
    public ArrayList<String> fullJustify(String[] words, int L) {
        
        ArrayList<String> result=new ArrayList<>();
        if(words==null||words.length==0){
            return result;
        }
        int n=words.length;
        int i=0;
        while(i<n){
            int len=words[i].length();
            String line=words[i];
            int j=i+1;
            for(;j<n&&len+1+words[j].length()<=L;j++){
                len+=1+words[j].length();
            }
            if(j==n){//
                for(int k=i+1;k<n;k++){
                    line+=" "+words[k];
                }
                while(line.length()<L){
                    line+=" ";
                }
            }else{
                //处理普通的行
                int white = L-len;//多余的空格
                int slot = j-i-1;//单词之间的槽数
                if(slot==0){//处理行中只有一个单词的情况
                    while(line.length()<L){
                        line+=" ";
                    }
                }else{
                    for(int k=i+1;k<j;k++){
                        line+=" ";
                        for(int m=0;m<white/slot;m++){//计算每个空槽应该有几个空格
                            line+=" ";
                        }
                        if(k-i<=white%slot){//多余的空格加到前几个空槽里
                            line+=" ";
                        }
                        line+=words[k];
                    }
                }

            }
            result.add(line);
        }
        return result;
    }
}
