package leetcode.dfsbfsbacktracing;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class _126_WordLadder {
    /**
     * bfs层次遍历的思想
     *
     * @param start
     * @param end
     * @param dict
     * @return
     */
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start == null || end == null || start.length() == 0 || end.length() == 0 || start.length() != end.length())
            return 0;

        LinkedList<String> wordQueue = new LinkedList<String>();
        int level = 1; //the start string already count for 1
        int curnum = 1;//the candidate num on current level
        int nextnum = 0;//counter for next level

        wordQueue.add(start);

        while (!wordQueue.isEmpty()) {
            String word = wordQueue.poll();
            curnum--;

            for (int i = 0; i < word.length(); i++) {
                char[] wordunit = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordunit[i] = j;
                    String temp = new String(wordunit);

                    if (temp.equals(end))
                        return level + 1;
                    if (dict.contains(temp)) {
                        wordQueue.add(temp);
                        nextnum++;
                        dict.remove(temp);
                    }
                }
            }

            if (curnum == 0) {
                curnum = nextnum;
                nextnum = 0;
                level++;
            }
        }

        return 0;
    }

    /**
     * 无向图搜索的思想 https://www.jianshu.com/p/753bd585d57e
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int dist = 1;

        while (!visited.contains(endWord)) {
            Set<String> temp = new HashSet<>();
            for (String word : visited) {
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (int j = (int) 'a'; j < (int) 'z' + 1; j++) {
                        chars[i] = (char) j;
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord)) {
                            temp.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
            dist += 1;
            if (temp.size() == 0) { // it nevert get to the endWord
                return 0;
            }

            visited = temp;
        }

        return dist;
    }

}
