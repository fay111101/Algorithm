package leetcode.array;
/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

public class _56_MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval t1) {
                return interval.start - t1.start;
            }
        });
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.size() < 1)
            return result;
        Interval p = intervals.get(0), tmp;
        int i = 1;
        while (i < intervals.size()) {
            tmp = intervals.get(i);
            if (p.end >= tmp.start) {
                p.end = Math.max(p.end, tmp.end);
            } else {
                result.add(p);
                p = tmp;
            }
            i++;
        }
        //加上最后一个区间
        result.add(p);
        return result;
    }
}
