package leetcode.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/* Merge k sorted linked lists and return it as one sorted list. Analyze and
describe its complexity.

*/
public class MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        ListNode p = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            p = mergeTwoSortedList(p, lists.get(i));
        }
        return p;
    }

    public ListNode mergeKLists1(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        int n = lists.size();
        while (n > 1) {
            int k = (n + 1) / 2;
            for (int i = 0; i < n / 2; i++) {
                lists.set(i, mergeTwoSortedList(lists.get(i), lists.get(i + k)));
            }
            n = k;
        }
        return lists.get(0);
    }

    private ListNode mergeTwoSortedList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
                curr = curr.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
                curr = curr.next;
            }
        }
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        return dummy.next;
    }

    public ListNode mergeKLists2(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        //1. ListNode实现Comparable借口的compareTo方法
        PriorityQueue<ListNode> q = new PriorityQueue();
        //2. 自定义Comparator比较器
        PriorityQueue<ListNode> q1 = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                q1.offer(lists.get(i));
            }
        }
        ListNode head = new ListNode(-1), temp;
        ListNode pre = head;
        while (!q1.isEmpty()) {
            temp = q1.poll();
            pre.next = temp;
            pre = pre.next;
            if (temp.next != null) {
                q1.offer(temp.next);
            }
        }
        return head.next;

    }

}
