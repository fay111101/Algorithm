package leetcode.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
public class _295_MedianFinder {

    /** initialize your data structure here. */
    /** initialize your data structure here. */
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    /** initialize your data structure here. */
    public _295_MedianFinder() {
        //
        queue1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }

        });
        queue2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }

        });
    }

    public void addNum(int num) {
        if(queue1.isEmpty()){
            queue1.offer(num);
        }else if(num>=queue1.peek()){//q1的都比q2大
            queue1.offer(num);
            if(queue1.size()>queue2.size()+1){
                queue2.offer(queue1.poll());
            }
        }else{
            queue2.offer(num);
            if(queue2.size()>queue1.size()+1){
                queue1.offer(queue2.poll());
            }
        }

    }

    public double findMedian() {
        if(queue1.size()>queue2.size()){
            return queue1.peek();
        }else if(queue1.size()<queue2.size()){
            return queue2.peek();
        }
        return (double)(queue1.peek()+queue2.peek())/2;
    }
}
