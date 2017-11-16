package leetcode.array;

/*
Given an unsorted array of integers, find the length of the longest
consecutive elements sequence.
For example,
Given[100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
Your algorithm should run in O(n) complexity.
*/
import java.util.*;
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<>();

        int max = Integer.MIN_VALUE;
        for (int i : num) {
            set.add(i);
        }
        for (int i = 0; i < num.length; i++) {
            int temp = num[i];
            int len = 1;
            while (set.contains(--temp)) {
                len++;
                set.remove(temp);
            }
            temp=num[i];
            while (set.contains(++temp)) {
                len++;
                set.remove(temp);
            }
            if(len>max){
                max=len;
            }

        }
        return max;
    }
    public static void main(String[] args){
        int[] num={100,4,200,1,3,2,5,6,7,101,102,103,104,105,106,107,108,109,
                110,8,9,10,
                11,12,13};
        LongestConsecutiveSequence test=new LongestConsecutiveSequence();
        System.out.println(test.longestConsecutive(num));
    }
}
