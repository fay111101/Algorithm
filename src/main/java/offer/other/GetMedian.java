package offer.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class GetMedian {
    private Heap maxHeap = new Heap(Heap.isMaxHeap);
    private Heap minHeap = new Heap(Heap.isMinHeap);
    public void Insert(Integer num) {
        if(((maxHeap.size()+minHeap.size()) & 1) == 0){
            if(minHeap.size() != 0 && num > minHeap.peek()){
                minHeap.add(num);
                maxHeap.add(minHeap.pop());
            }else{
                maxHeap.add(num);
            }
        }else{
            if(maxHeap.size() != 0 && num < maxHeap.peek()){
                maxHeap.add(num);
                minHeap.add(maxHeap.pop());
            }else{
                minHeap.add(num);
            }
        }
    }
    public Double GetMedian() {
        double res = 0.0;
        if(((maxHeap.size()+minHeap.size()) & 1) == 0){
            res = (maxHeap.peek() + minHeap.peek()) / 2.0;
        }else{
            res = maxHeap.peek();
        }
        return res;
    }
}
//堆类，可直接设置最大堆最小堆
class Heap {
    public List<Integer> list = null;
    public static final boolean isMaxHeap = true;
    public static final boolean isMinHeap = false;
    private boolean flag = true;  //true表示最大堆，false表示最小堆
    public Heap(){
        this.list = new ArrayList<Integer>();
    }
    public Heap(boolean flag){
        this.list = new ArrayList<Integer>();
        this.flag = flag;
    }
    public int size(){
        return this.list.size();
    }
    public int peek(){
        if(list.size() == 0) return 0;
        return list.get(0);
    }
    public void add(int val){
        this.list.add(val);
        int i = list.size() - 1, index, parent, cur;
        while(i > 0){
            index = (i - 1) / 2;
            parent = list.get(index);
            cur = list.get(i);
            if(flag == true && parent < cur){
                swap(index, i);
            }else if(flag == false && parent > cur){
                swap(index, i);
            }
            i = index;
        }
    }
    public int pop(){
        if(list.size() == 0) return -1;
        int res = list.get(0);
        list.set(0,list.get(list.size() - 1));
        list.remove(list.size()-1);
        int len = list.size() - 1 , i = 0;
        int left , right;
        while(i < len){
            left = (i << 1) + 1;
            right= (i << 1) + 2;
            int maxIndex = i;
            if(flag == true){
                if(left < len && list.get(left) > list.get(maxIndex)) maxIndex = left;
                if(right< len && list.get(right)> list.get(maxIndex)) maxIndex = right;
            }else{
                if(left < len && list.get(left) < list.get(maxIndex)) maxIndex = left;
                if(right< len && list.get(right)< list.get(maxIndex)) maxIndex = right;
            }
            if(maxIndex != i){
                swap(maxIndex,i);
                i = maxIndex;
            }else break;
        }
        return res;
    }
    public void swap(int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j,temp);
    }
}

