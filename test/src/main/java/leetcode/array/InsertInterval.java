package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fay on 2017/12/11.
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 You may assume that the intervals were initially sorted according to their start times.
 Example 1:
 Given intervals[1,3],[6,9], insert and merge[2,5]in as[1,5],[6,9].
 Example 2:
 Given[1,2],[3,5],[6,7],[8,10],[12,16], insert and merge[4,9]in as[1,2],[3,10],[12,16].
 This is because the new interval[4,9]overlaps with[3,5],[6,7],[8,10].
 https://www.cnblogs.com/splash/p/4249510.html
 */
public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> list = new ArrayList<Interval>();
        //边界情况
        if(intervals.size() == 0){
            list.add(newInterval);
            return list;
        }
        //循环判断
        for(int i = 0; i < intervals.size();i++){
            //如果新的区间结束值小于原来间隙的开始值，则直接插入前面，后面依次插入即可
            if(newInterval.end < intervals.get(i).start){
                list.add(newInterval);
                for(int j = i; j < intervals.size(); j++){
                    list.add(intervals.get(j));
                }
                break;
            }
            //新的区间开始点大于原来间隙的结束点，则当前点直接添加到结果集
            else if(newInterval.start > intervals.get(i).end){
                list.add(intervals.get(i));
            }
            //需要合并的情况
            else{
                //合并区间
                newInterval.start = Math.min(newInterval.start,intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
            }
            if(i == intervals.size() - 1){//如果是最后一个数据。也添加结果集中
                list.add(newInterval);
            }
        }
        return list;
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int start = newInterval.start;
        int end = newInterval.end;
        List<Interval> re = new ArrayList<Interval>(intervals);
        for(int i=0;i<re.size();i++) {
            Interval temp = re.get(i);
            if(end<temp.start) {
                re.add(i, new Interval(start, end));
                return re;
            }
            if(temp.end<start)
                continue;
            else {
                start = Math.min(temp.start, start);
                end = Math.max(temp.end, end);
                re.remove(i);
                i--;
            }
        }
        re.add(new Interval(start, end));
        return re;
    }
}
