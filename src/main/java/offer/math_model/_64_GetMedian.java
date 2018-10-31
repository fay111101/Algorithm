package offer.math_model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * https://www.cnblogs.com/easonliu/p/4441916.html
 */
public class _64_GetMedian {

    private Heap maxHeap = new Heap(Heap.isMaxHeap);
    private Heap minHeap = new Heap(Heap.isMinHeap);

    /**
     * 原理：用两个堆实现，左边是做大堆，右边是最小堆，当数据总数是偶数的时候，中位数是两个堆首元素和的一半；
     * 当数据是奇数的时候，可以约定取最大堆或者是最小堆的首元素。
     * 思路：中位数是一串数据中大小排在正中间的数，那么排到中位数左边的数都比中位数小，右边的比中位数大，
     * 因此，只需要实时将当前数据分为两堆，左边一堆的最大值比右边最小堆的最小值要小，中位数就有左边堆的最大和右边堆的最小决定。
     * 这样，求中位数只需要实时记录左右两堆数据的最大和最小值即可，那么用最大最小堆即可实现。
     *
     * 最大最小堆需要满足的条件：
     * （1）最大最小堆任何时候元素个数之差不能大于1
     * （2）左边最大堆的元素最大元素不能大于右边最小堆的最小元素，以保证数据的有序性。
     *
     * @param num
     */
    public void Insert(Integer num) {
        //1.规则：当数据的数目是偶数时，将新数据插入到最小堆，当数据的数目是奇数时，将新数据插入到最大堆
        //2.规则：本来应该将数字插入到最大堆，但是这个新来的数字比最小堆的堆顶大（有可能大于最小堆中的一些数据）
        //这样违反了规则2，因此需要调整，将最小堆的栈顶拿出来插入到最大堆，这样保证了左面最大堆的数字小于右边最小堆的数字
        if (((maxHeap.size() + minHeap.size()) & 1) != 0) {
            if (minHeap.size() != 0 && num > minHeap.peek()) {
                minHeap.add(num);
                maxHeap.add(minHeap.pop());
            } else {
                maxHeap.add(num);
            }
        } else {
            if (maxHeap.size() != 0 && num < maxHeap.peek()) {
                maxHeap.add(num);
                minHeap.add(maxHeap.pop());
            } else {
                minHeap.add(num);
            }
        }
    }

    public Double GetMedian() {
        double res = 0.0;
        if (((maxHeap.size() + minHeap.size()) & 1) == 0) {
            res = (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            res = maxHeap.peek();
        }
        return res;
    }



    private int count = 0;
    private PriorityQueue<Integer> minHeap1 = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap1 = new PriorityQueue<Integer>(15,
            new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    //读入字符，放到合适位置

    /***
     * //1. 使用大顶堆+小顶堆的容器.
     * //2. 两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处
     * //3. 大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。平均数就在两个堆顶的数之中。
     * @param num
     */
    public void Insert1(Integer num) {
        /**
         * a. 为了保证两个堆中的数据数目差不能超过1，在Insert（）方法中使用了count来辅助实现。
         * b. 为了保证小顶堆的元素都小于大顶堆的元素，借用优先队列PriorityQueue。其默认维持队列内升序排列。
         * 也可以像上面传入一个比较器，然后使其改变排列顺序。
         * c. 具体的实施方案。当数据总数为偶数时，新加入的元素，应当进入小根堆,注意不是直接进入小根堆，
         * 而是经大根堆筛选后取大根堆中最大元素进入小根堆；当数据总数为奇数时，新加入的元素，应当进入大根堆。
         * 注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆。
         */
        if (count % 2 == 0) {
            maxHeap1.offer(num);
            int filteredMaxNum = maxHeap1.poll();
            minHeap1.offer(filteredMaxNum);
        } else {
            minHeap1.offer(num);
            int filteredMinNum = minHeap1.poll();
            maxHeap1.offer(filteredMinNum);
        }
        count++;
    }

    //求中位数
    public Double GetMedian1() {
        if (count % 2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }
}

//堆类，可直接设置最大堆最小堆
class Heap {

    public List<Integer> list = null;
    public static final boolean isMaxHeap = true;
    public static final boolean isMinHeap = false;
    private boolean flag = true;  //true表示最大堆，false表示最小堆

    public Heap() {
        this.list = new ArrayList<Integer>();
    }

    public Heap(boolean flag) {
        this.list = new ArrayList<Integer>();
        this.flag = flag;
    }

    public int size() {
        return this.list.size();
    }

    public int peek() {
        if (list.size() == 0) return 0;
        return list.get(0);
    }

    public void add(int val) {
        this.list.add(val);
        int i = list.size() - 1, index, parent, cur;
        while (i > 0) {
            index = (i - 1) / 2;
            parent = list.get(index);
            cur = list.get(i);
            if (flag == true && parent < cur) {
                swap(index, i);
            } else if (flag == false && parent > cur) {
                swap(index, i);
            }
            i = index;
        }
    }

    public int pop() {

        if (list.size() == 0) return -1;
        int res = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        int len = list.size() - 1, i = 0;
        int left, right;
        while (i < len) {
            left = (i << 1) + 1;
            right = (i << 1) + 2;
            int maxIndex = i;
            if (flag == true) {
                if (left < len && list.get(left) > list.get(maxIndex)) maxIndex = left;
                if (right < len && list.get(right) > list.get(maxIndex)) maxIndex = right;
            } else {
                if (left < len && list.get(left) < list.get(maxIndex)) maxIndex = left;
                if (right < len && list.get(right) < list.get(maxIndex)) maxIndex = right;
            }
            if (maxIndex != i) {
                swap(maxIndex, i);
                i = maxIndex;
            } else break;
        }
        return res;
    }

    public void swap(int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}

