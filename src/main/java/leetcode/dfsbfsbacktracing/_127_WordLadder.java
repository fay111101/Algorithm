package leetcode.dfsbfsbacktracing;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

<<<<<<< HEAD:src/main/java/leetcode/dfsbfsbacktracing/_126_WordLadder.java
public class _126_WordLadder {
    /**
     * bfs层次遍历的思想
     *
     * @param start
     * @param end
     * @param dict
     * @return
     */
=======
/**
 *给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class _127_WordLadder {

>>>>>>> 8d9fd232620a92e2f658ded073d959eb094bcaa1:src/main/java/leetcode/dfsbfsbacktracing/_127_WordLadder.java
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
