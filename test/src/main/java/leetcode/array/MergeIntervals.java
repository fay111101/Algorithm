package main.java.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval t1) {
                return interval.start-t1.start;
            }
        });
        for(int i=1;i<intervals.size();i++){
            int preStart=intervals.get(i-1).start;
            int preEnd=intervals.get(i-1).end;
            int curStart=intervals.get(i).start;
            int curEnd=intervals.get(i).start;
            if(curStart<=preEnd){
                intervals.set(i,new Interval(preStart,Math.max(preEnd, curEnd)));
                intervals.set(i-1,null);
            }
        }
        while(intervals.remove(null));
        return intervals;

    }
}
