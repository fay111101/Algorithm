package leetcode.search;
/*Given two words (start and end), and a dictionary, find the length of shortest
 transformation sequence from start to end, such that:
Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,
Given:
start ="hit"
end ="cog"
dict =["hot","dot","dog","lot","log"]
As one shortest transformation is"hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length5.
Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {
    //bfs
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (dict == null) {
            return 0;
        }
        int level=1;
        int current=1;
        int next=0;
        Queue<String> queue = new LinkedList();
        queue.offer(start);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            current--;
            for (int i = 0; i < str.length(); i++) {
                char[] strArr = str.toCharArray();
                for (int j = 0; j < 26; j++) {
                    char ch = (char) ('a' + j);
                    strArr[i] = ch;
                    String newStr = new String(strArr);
                    if (newStr.equals(end)) {
                        return level + 1;
                    }
                    if (dict.contains(newStr)) {
                        queue.offer(newStr);
                        next++;
                        dict.remove(newStr);
                    }
                }
            }
            if(current==0){
                current=next;
                next=0;
                level++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder test = new WordLadder();
        String start = "hit";
        String end = "cog";
        HashSet<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(test.ladderLength(start, end, dict));
    }
}
