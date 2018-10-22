package offer.math_model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class _65_MaxInWindows {
    /**
     * 借助一个辅助队列，从头遍历数组，根据如下规则进行入队列或出队列操作：
     * 0. 如果队列为空，则当前数字入队列
     * 1. 如果当前数字大于队列尾，则删除队列尾，直到当前数字小于等于队列尾，或者队列空，然后当前数字入队列
     * 2. 如果当前数字小于队列尾，则当前数字入队列
     * 3. 如果队列头超出滑动窗口范围，则删除队列头
     * 这样能始终保证队列头为当前的最大值
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if(num == null || num.length == 0 || size == 0 || size > num.length) {
            return result;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < num.length; i++) {
            if(!queue.isEmpty()){
                // 如果队列头元素不在滑动窗口中了，就删除头元素
                if(i >= queue.peek() + size) {
                    queue.pop();
                }
                // 如果当前数字大于队列尾，则删除队列尾，直到当前数字小于等于队列尾，或者队列空
                while(!queue.isEmpty() && num[i] >= num[queue.getLast()]) {
                    queue.removeLast();
                }
            }
            queue.offer(i); // 入队列
            // 滑动窗口经过三个元素，获取当前的最大值，也就是队列的头元素
            if(i + 1 >= size) {
                result.add(num[queue.peek()]);
            }
        }
        return result;
    }

    /**
     * 用双端队列deque保存可能成为滑动窗口中最大元素的下标，进出队列规则如下：
     *
     * 如果deque为空，直接将下标i放入deque中。
     * 如果当前下标i-队头元素==w,弹出队头元素。
     * 如果deque不为空，取出deque队尾的下标j，如果arr[j]>=arr[i],将下标i放入deque队尾。否则依次弹出队尾元素，直到arr[j]<arr[i]或者deque为空，再将i压入队尾。
     * 1和2都比较好理解，这里解释一下3:
     *
     * 如果arr[j]>=arr[i],将下标i放入deque队尾。否则依次弹出队尾元素，直到arr[j]<arr[i]或者deque为空，再将i压入队尾.
     *
     * arr[j]>=arr[i],为什么要放在队尾呢，arr[i]虽然此时比arr[j]小，但是arr[j]会在一定时间后失效(即脱出滑动窗口范围),arr[i]可能会成为最大值。
     * 而当arr[j]<arr[i],说明arr[j]永远不能成为当前窗口及以后窗口的最大值了，因为arr[j]不仅比arr[i]小，而且一定比arr[j]先失效。所以将其弹出即可。
     *
     * 当初始队列构造完成后，依次读入数组元素，队列的头元素的下标所代表的数字就是此时窗口中的最大值。
     *
     */

    public int[] slide(int[] arr, int n, int w) {

        int[]result=new int[n-w+1];
        Deque<Integer> window=new ArrayDeque<>();
        //初始化宽度为w的滑动窗口
        int i=0;
        for(;i<w;i++){
            if(!window.isEmpty()&&arr[i]>arr[window.getLast()]){
                while(!window.isEmpty()&&arr[window.getLast()]<arr[i]){
                    window.removeLast();
                }
            }
            window.addLast(i);
        }
        int size=0;
        result[size]=arr[window.getFirst()];

        //依次进行滑动
        for(;i<n;i++){
            if(i-window.getFirst()==w){
                window.removeFirst();
            }

            if(!window.isEmpty()&&arr[i]>arr[window.getLast()]){
                while(!window.isEmpty()&&arr[window.getLast()]<arr[i]){
                    window.removeLast();
                }
            }
            window.addLast(i);
            result[++size]=arr[window.getFirst()];
        }
        return result;
    }


}
